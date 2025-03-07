package dto;

public class DeptDTO {
	private int deptno;
	private String dname;
	private String loc;
	
	public DeptDTO(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public DeptDTO() {
		super();
	}

	public int getDeptno() { return deptno; } 
	public String getDname() { return dname; } 
	public String getLoc() { return loc; } 
	
	public void setDeptno(int deptno) { this.deptno = deptno; }
	public void setDname(String dname) { this.dname = dname; }
	public void setLoc(String loc) { this.loc = loc; }

}