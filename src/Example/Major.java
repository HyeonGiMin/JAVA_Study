package Example;

public class Major extends Lesson {
	String resolution;
	
	public Major(String pname,int price,String resolution)
	{
		this.pname=pname;
		this.price=price;
		this.resolution=resolution;
		credit=3;
	}
	
	@Override
	public void printExtra() {
		System.out.println("수업 분류: "+resolution);
	}

}
