package Example;

public class User {
	private String name;
	private PayType payType;
	private String grade;
	
	User(String name,String grade,PayType payType)
	{
		this.name=name;
		this.payType=payType;
		this.grade=grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
}
