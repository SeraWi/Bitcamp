package dept;

// 부서 정보를 저장하는 기능 클래스
public class Dept {
	// 사용자 입력 Data를 dept에 넣기
	// DB dept에 있는 data 역시 dept class에 넣을 수 있다.
	
	private int deptno; // 부서 번호
	private String dname; //부서 이름
	private String loc; // 부서 위치
	
	//생성자
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	
	//Getter, Setter

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}


	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
		
	
}
