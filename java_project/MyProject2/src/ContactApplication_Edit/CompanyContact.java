package ContactApplication_Edit;

public class CompanyContact extends Contact {
	// contact 상속
	
	// 회사, 거래처의 정보를 저장하는 하위 클래스 정의
	// 회사이름, 부서이름, 직급 변수 추가
	// 정보를 출력하는 메소드를 오버라이딩해서 추가된 정보를 추가해서 출력
	
	String comName;
	String deptName;
	String position;
	
	// 생성자
	public CompanyContact(String name, 
			String phoneNum, 
			String email, 
			String address, 
			String birthday, 
			String group,
			String comName,
			String deptName,
			String position) {
		super(name, phoneNum, email, address, birthday, group);
		this.comName = comName;
		this.deptName = deptName;
		this.position = position;
	}

	
	// 정보를 출력하는 메소드를 오버라이딩해서 추가된 정보를 추가해서 출력
	@Override
	public void showData() {
		super.showData();
		System.out.println("회사이름:" +comName);
		System.out.println("부서이름:"+deptName);
		System.out.println("직급:"+position);
	}
	
	
	

}
