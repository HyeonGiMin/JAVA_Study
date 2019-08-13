package Example;

public class Culture extends Lesson {
	String carrier;
	
	public Culture(String pname,int price,int credit,String carrier)
	{
		this.pname=pname;
		this.price=price;
		this.credit=credit;
		this.carrier=carrier;
	}
	
	@Override
	public void printExtra() {
		System.out.println("수업 분류: "+carrier);
	}

}
