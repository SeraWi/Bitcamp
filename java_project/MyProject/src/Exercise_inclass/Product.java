package Exercise_inclass;

public class Product {
	final int price; //가격 변하지 않도록 final로 고정
	int bonusPoint;
	
	Product(int price){
		this.price = price; //price 초기화 후에는 금액이 바뀌지 않는다.
		bonusPoint = (int) (price / 10.0);
	}
}
