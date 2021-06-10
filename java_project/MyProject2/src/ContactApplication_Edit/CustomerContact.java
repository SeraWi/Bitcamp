package ContactApplication_Edit;

public class CustomerContact extends Contact {
	
	// 거래처의 정보를 저장하는 하위클래스를 정의
	// 거래처회사이름, 거래품목, 직급 변수 추구
	// 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
	
	String comName;
	String product;
	String position;
	
	// 생성자
	public CustomerContact(String name, 
			String phoneNum, 
			String email, 
			String address, 
			String birthday, 
			String group,
			String comName,
			String product,
			String position) {
		super(name, phoneNum, email, address, birthday, group);
		this.comName = comName;
		this.product = product;
		this.position = position;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("거래처 회사 이름:"+comName);
		System.out.println("거래품목:"+ product);
		System.out.println("직급:"+ position);
	}
	
	
	
}
