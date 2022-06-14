package test;

public class secondvalidate {
	private int DepartID;
	private String DepName;

	public secondvalidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public secondvalidate(int departID, String depName) {
		super();
		DepartID = departID;
		DepName = depName;
	}

	public secondvalidate(String depName) {
		super();
		DepName = depName;
	}

	public int getDepartID() {
		return DepartID;
	}

	public void setDepartID(int departID) {
		DepartID = departID;
	}

	public String getDepName() {
		return DepName;
	}

	public void setDepName(String depName) {
		DepName = depName;
	}

}
