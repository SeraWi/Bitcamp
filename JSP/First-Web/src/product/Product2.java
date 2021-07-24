package product;

import java.util.Arrays;

//beans형식의 클래스로 정의: 상품정보를 저장
public class Product2 {
	//상품 목록:배열
	private String[] productList = {"item1","item2","item3","item4","item5"};
	
	//변수 : private으로 캡슐화
	private int price =100;
	private int amount= 1000;
	
	//getter :정보를 가져오기만 할 수 있다.
	//setter :정보 바꿀 수 없기 때문에 setter사용하지 않는다.
	public String[] getProductList() {
		return productList;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	
	//%{product.display()}
	public String getDisplay() {
		return "price:"+this.price+",amount:"+ this.amount;
	}
	
	//tostring 오버라이딩
	@Override
	public String toString() {
		return "Product2 [productList=" + Arrays.toString(productList) + ", price=" + price + ", amount=" + amount
				+ "]";
	}
	
	 
	
	
	
}
