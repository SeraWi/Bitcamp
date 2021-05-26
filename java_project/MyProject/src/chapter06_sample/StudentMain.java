package chapter06_sample;

public class StudentMain {

	public static void main(String[] args) {
		//		① Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
		//		② Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		//		③ 배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		Student[] students = new Student[10];
		students[0]= new Student("홍길동1", 50, 40, 90);
		students[1]= new Student("홍길동2", 40, 60, 30);
		students[2]= new Student("홍길동3", 10, 70, 20);
		students[3]= new Student("홍길동4", 20, 80, 90);
		students[4]= new Student("홍길동5", 30, 90, 80);
		students[5]= new Student("홍길동6", 50, 20, 70);
		students[6]= new Student("홍길동7", 60, 10, 60);
		students[7]= new Student("홍길동8", 70, 60, 50);
		students[8]= new Student("홍길동9", 80, 50, 40);
		students[9]= new Student("홍길동10", 90, 100, 20);

		System.out.println("이름 \t\t 국어 \t 영어\t 수학\t 총점\t 평균\t");
		System.out.println("=========================================================");
		for(int i = 0; i < students.length; i++) {
			System.out.print(students[i].getName());
			System.out.print("\t\t");
			System.out.print(students[i].getKor()+ "\t"+students[i].getEng()+"\t"
					+ students[i].getMath()+"\t");
			System.out.print(students[i].getSum());
			System.out.print("\t");
			System.out.println(students[i].getAvg());
		}
	}
}

