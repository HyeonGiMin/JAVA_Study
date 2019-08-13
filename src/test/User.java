package test;


public class User {
	private String name;
	private UserType userType;
	private String grade;
	private int hp;
	
	User(String name, String grade, UserType userType)
	{
		this.name=name;
		this.userType=userType;
		this.grade=grade;

		switch(userType){
			case HEALER:
				this.hp=100;
				break;
			case DEALER:
				this.hp=50;
				break;
			case TANKER:
				this.hp=200;
				break;
		}
	}

	public String getName() {
		return name;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
}
