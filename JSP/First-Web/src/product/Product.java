package product;

import java.util.Arrays;

//beans 형식의 클래스로 정의 : 상품정보를 저장
public class Product {
	
	// 상품 목록 :배열
	private String [] productList = {"item1","item2","item3","item4","item5"};
	
	// 변수 : el 테스트
	private int price = 100;
	private int amount = 1000;
	
	
	//getter
	public String[] getProductList() {
		return productList;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	
	//${product.display()} el에서는 이렇게 쓸 수 있다!! get 빼고 호출
	public String getDisplay() {
		return "price :" + this.price + ", amount :" + this.amount;
	}
	
	//tostring 오버라이딩
	@Override
	public String toString() {
		return "Product [pList=" + Arrays.toString(productList) + ", price=" + price + ", amount=" + amount + "]";
	}
	
}
