package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {
	
	
	//Dao dao = new Dao();  ->의존성이 높다!! -> 유지보수 어렵다
	//new가 업더라도 컴파일 되고 실행되도록 만들자!
	private Dao dao;
	private int num;
	
	//프로퍼티 방식의 주입 :setter메서드를 이용, 기본 생성자가 필요
	public void setDao(Dao doa) {
		this.dao= dao;
	}
	
	//default생성자 필요하다
	public MemberRegService() {
		System.out.println("memberRegService 인스턴스 생성");
	}
	
	//생성자 방식의 주입-------------------------------------------
	//정수데이터를 받는 생성자
	public MemberRegService(int num) {
		System.out.println("memberRegService 인스턴스 생성");
	}
	
	//정수데이터와 참조형 데이터를 받는 생성자
	public MemberRegService(Dao dao, int num) {
		this.dao= dao;
		this.num= num;
		System.out.println("memberRegService 인스턴스 생성");
	}
	
	//참조형 데이터를 받는 생성자
	public MemberRegService(Dao dao) {
		//생성자를 통해 주입하기
		this.dao = dao;
		System.out.println("memberRegService 인스턴스 생성");
	}
	
	public void regMember(RegRequest request) throws Exception {
		//중복 이메일 체크
		Member oldMember = dao.selectByEmail(request.getEmail());
		if(oldMember !=null) {
			throw new Exception("중복이메일!");
		}
		
		Member  newMember = new Member(
				0,
				request.getEmail(),
				request.getPassword(),
				request.getName(),
				new Date()
				);
		
		dao.insert(newMember);
	}
}
