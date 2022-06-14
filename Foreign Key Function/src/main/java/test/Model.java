package test;

public class Model {
	private int ID;
	private String Name;
	private int DepID;

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Model(int iD, String name, int depID) {
		super();
		ID = iD;
		Name = name;
		DepID = depID;
	}

	public Model(String name, int depID) {
		super();
		Name = name;
		DepID = depID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getDepID() {
		return DepID;
	}

	public void setDepID(int depID) {
		DepID = depID;
	}
}
