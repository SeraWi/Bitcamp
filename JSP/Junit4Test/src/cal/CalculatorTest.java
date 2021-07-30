package cal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	//Calculator cal = new Calculator();
	Calculator cal;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@beforeClass");
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@afterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before");
		//초기화하고 사용 - 인스턴스 생성
		cal = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after");
	}

	@Test
	public void testAdd() {
		System.out.println("testAdd() ");
		
		//기대하는 값과 비교해서 성공실패
		assertEquals("add()메소드 테스트",12,cal.add(10,2));
		//System.out.println(cal.add(10, 2));
		//fail("Not yet implemented");

	}

	@Test
	public void testSubstract() {
		System.out.println("testSubstract()");
		assertEquals("substract()메소드 테스트", 8, cal.substract(10,2));
		//fail("Not yet implemented");

	}

	@Test
	public void testMultiply() {
		System.out.println("testMultiply()");
		assertEquals("multiply메소드 테스트",20, cal.multiply(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		System.out.println("testDivide()");
		//fail("Not yet implemented");

	}
	//예외 타입을 비교해서 테스트
	@Test(expected = RuntimeException.class)
	public void test1() {
		System.out.println("@Test 실행 중 예외타입을 테스트");
		throw new RuntimeException();
	}
	
	@Test(timeout = 1) //1/1000초
	public void test2() {
		System.out.println("@Test 테스트 중 허용 시간 ms 안에 실행이 완료 되는지 테스트합니다.");
		cal.add(100, 200); // 1/1000초안에 실행이 완료되면 성공, 시간 넘어가면 false
	}
	
	@Test
	public void test3() {
		//아직 테스트 하지 않으면 뜨는 메세지
		//fail("테스트 미실행");
		//assertTrue("메소드의 반환값이 boolean인 경우 사용", true);
		
		//null이면 true
		//assertNull("메소드의 실행값이 null인 예상되는 경우",null);//성공
		//assertNull("메소드의 실행값이 null인 예상되는 경우",new Object()); 
		//assertNotNull("메소드의 실행값이  not null이 예상되는 경우",new Object());
		
		//assertSame("같은 값일 경우", 1, 1); //성공
		//assertNotSame("다른 값일 경우",1,2); //성공
		
		//assertTrue("메서드의 반환값이 True를 예상할 때",true);
		assertFalse("메서드의 반환값이 False를 예상할 때", false);
	
	}
}
