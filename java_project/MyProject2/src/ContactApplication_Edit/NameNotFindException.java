package ContactApplication_Edit;

public class NameNotFindException extends Exception{
	
	public NameNotFindException(String msg){
		super(msg);
	}
	//이름 잘못 입력시 에러발생
}

