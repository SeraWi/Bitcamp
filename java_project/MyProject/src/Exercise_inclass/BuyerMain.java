package Exercise_inclass;

public class BuyerMain {

	public static void main(String[] args) {
		//구매자 객체 생성
		Buyer buyer = new Buyer();
		
		//제품 객체 생성
		Tv tv = new Tv(1000); // tv 가격 
		Computer com = new Computer(300); // com 가격
		
		//구매하기
		buyer.buy(tv); 
		buyer.buy(com);
		buyer.buy(tv); 
		buyer.buy(com);
		//결과
//		System.out.println("현재 소지한 금액은: "+ buyer.money);
//		System.out.println("현재 보유한 보너스포인트는: "+buyer.bonusPoint);
		
		//구매지표
		buyer.summary();
	}
}
