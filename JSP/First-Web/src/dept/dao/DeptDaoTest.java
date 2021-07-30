package dept.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {
	
	Connection conn = null;
	DeptDao dao;
	List<Dept> depts = new ArrayList<Dept>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//시작할 때 초기화
		conn= ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		depts.add(new Dept(50,"HR","Seoul"));
		depts.add(new Dept(50,"Design","New York")); //pk같으면 에러발생, pk = deptno
		depts.add(new Dept(60,"Data","London"));
		depts.add(new Dept(70,"CS","Barcelona"));
		depts.add(new Dept(80,"Sales","Paris"));
		depts.add(new Dept(90,"Finance","Berlin"));
		depts.add(new Dept(100,"Engineer","Toronto"));
		
		
		//update용 dept
		depts.add(new Dept(80,"Finance","Busan"));
		depts.add(new Dept(90,"Web-Design","Berlin"));
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetDeptList() throws SQLException {
		
		//List<dept>반환하는지 확인
		assertNotNull("List<dept>반환하는지 확인",dao.getDeptList(conn)); //deptno=100
		
	}

	@Test
	public void testInsertDept() {
		
		//insert되었을 때 값은 1 = true
		assertTrue("insert되었는지 확인", dao.insertDept(conn, depts.get(0))>0); //deptno = 50
		//assertTrue("insert되었는지 확인", dao.insertDept(conn, depts.get(1))>0); //deptno = 50 ->pk같아서 에러 발생
		assertTrue("insert되었는지 확인", dao.insertDept(conn, depts.get(2))>0); //60
		assertTrue("insert되었는지 확인", dao.insertDept(conn, depts.get(3))>0); //70
		assertTrue("insert되었는지 확인", dao.insertDept(conn, depts.get(4))>0); //80
		assertTrue("insert되었는지 확인", dao.insertDept(conn, depts.get(5))>0); //90
		assertTrue("insert되었는지 확인", dao.insertDept(conn, depts.get(6))>0); //100
		
		
	}

	@Test
	public void testDeleteDept() {
		
//		//delete 되었을 때 반환 값1 = true
		assertTrue("delete 되었는지 확인", dao.deleteDept(conn, depts.get(0).getDeptno())>0); //50삭제
		assertTrue("delete 되었는지 확인", dao.deleteDept(conn, depts.get(2).getDeptno())>0); //60삭제
		
	}

	@Test
	public void testSelectByDeptno() {
		
		//select한 dept가 not null인지 확인
		// not null이면 성공 
		assertNotNull("부서번호에 해당하는 dept반환하는지",dao.selectByDeptno(conn, depts.get(6).getDeptno())); //deptno=100
		
	}

	@Test
	public void testUpdateDept() {
		
		//update되었을 때 반환값 1= true
		assertTrue("update되었는지 확인", dao.updateDept(conn, depts.get(7))>0); //70 수정
		assertTrue("update 되었는지 확인", dao.updateDept(conn, depts.get(8))>0); //80 수정
		
	}

}
