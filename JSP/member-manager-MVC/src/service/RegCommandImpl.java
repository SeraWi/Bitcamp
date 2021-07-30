package service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import member.dao.MemberDao;
import member.domain.Member;
import member.util.ConnectionProvider;


public class RegCommandImpl implements Command {
	//회원가입처리하기
	//db에 insert하기
	//view 지정!
	
	public void register(HttpServletRequest request) {

		int resultCnt = 0;
		Member member =  new Member(); //dao처리할 때 필요한 member객체
		Connection conn = null; //Connection 객체
		MemberDao dao = null;
		File newFile = null;
		try {
			//1. multipart여부 확인한다
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			if(isMultipart){
				// 2. 파일을 저장할 factory객체를 생성
				DiskFileItemFactory factory = new DiskFileItemFactory();

				//3. 요청 처리를(form안에 있는 input들을 분리) 위해서 ServletFileUpload를 생성한다
				ServletFileUpload upload = new ServletFileUpload(factory);

				//4. 사용자 요청을 분리(parsing) == 원하는 형태로 분리
				//각각의 input을 FileItem으로 만든다.
				//FileItem ->input데이털르 저장하고 있는 객체

				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> itr = items.iterator();

				while(itr.hasNext()){
					FileItem item = itr.next(); //text, checkbox, hidden, password, file

					if(item.isFormField()){
						//회원아이디, 회원 이름, 비밀번호
						String paramName = item.getFieldName();
						if(paramName.equals("memberid")) {
							String value = item.getString("utf-8");
							//member객체에 세팅
							member.setMemberid(value);
						}else if(paramName.equals("password")){
							member.setPassword(item.getString("utf-8"));

						}else if(paramName.equals("membername")) {
							member.setMembername(item.getString("utf-8"));
						}

					}else{
						//사진 데이터 처리
						String uploadUri ="upload";
						String dir = request.getSession().getServletContext().getRealPath(uploadUri);

						//파일 클래스
						File saveDir = new File(dir);
						if(!saveDir.exists()) {
							//dir존재하지 않으면
							//디렉토리 생성
							saveDir.mkdir();

						}

						//name가져오기
						String paramName = item.getFieldName();

						if(paramName.equals("photo")) {
							//파일이름이 존재(getName())하고 사이즈 확인
							if(item.getName() !=null && item.getSize() >0) {
								//저장
								newFile = new File(saveDir, item.getName()); //디렉토리이름 + 파일이름 ->경로로저장된다.
								item.write(newFile); 
								System.out.println("파일 저장!");

								//member객체에 저장할 파일 이름 ->DB에도 저장할 파일의 이름
								member.setMemberphoto(item.getName());

							}
						}
					}
				}//while end

			}else {
				throw new Exception("mutlipart타입이 아닙니다.");
			}

			////////////
			//db에 insert
			//Connection, MemberDao 필요

			conn = ConnectionProvider.getConnection();
			dao= MemberDao.getInstance();

			//db 갔다온뒤 결과 반환
			resultCnt = dao.insertMember(conn, member);


		}catch(SQLException e){
			e.printStackTrace();
			//파일이 upload 디렉토리에 
			//저장된뒤 sql예외 발생시(동일한 아이디 존재 등..) db에는 저장되지 않는다.
			//현재 저장된 파일(==쓰레기)을 삭제해야 한다

			//DB입력시 오류라면 파일을 삭제!!
			if(newFile !=null && newFile.exists()) {
				//파일을 삭제
				newFile.delete();
				System.out.println("파일 삭제!");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("result", resultCnt);
	}

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse reponse) {
		register(request);
		return "/WEB-INF/views/regView.jsp";
	}

}
