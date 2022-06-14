package test;

public class loginmodel {
	private int ID;
	private String studentname;

	public loginmodel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public loginmodel(int iD, String studentname) {
		super();
		ID = iD;
		this.studentname = studentname;
	}

	public loginmodel(String studentname) {
		super();
		this.studentname = studentname;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

}
