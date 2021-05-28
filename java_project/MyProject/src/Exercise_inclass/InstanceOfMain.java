package Exercise_inclass;

public class InstanceOfMain {

	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();

		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
	}
	public static void wrapBox(Box box) {
//		//형변환 여부 확인,instanceof
//		if(box instanceof GoldPaperBox) {
//			((GoldPaperBox)box).goldPaperWrap();
//		}else if(box instanceof PaperBox) {
//			((PaperBox)box).paparWrap();
//		}else {
//			box.simpleWrap();
//		}
		box.wrap();
	}
}
class Box{
	public void simpleWrap() {
		System.out.println("Simple Wrap");
	}
	public void wrap() {
		System.out.println("Simple Wrap");
	}
}

class PaperBox extends Box{
	public void paparWrap() {
		System.out.println("Paper Wrap");
	}
	@Override 
	public void wrap() {
		System.out.println("Paper Wrap");
	}
}

class GoldPaperBox extends PaperBox{
	public void goldPaperWrap() {
		System.out.println("GoldPaper Wrap");
	}
	@Override
	public void wrap() {
		System.out.println("GoldPaper Wrap");
	}
}