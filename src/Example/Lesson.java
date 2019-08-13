package Example;

public abstract class Lesson {
	String pname;
	int price;
	int credit;
	
	public void printDetail() {
		System.out.printf("수업 이름 : %s ,", pname);
		System.out.printf("수업 비용 : %d ,", price);
		System.out.printf("수업 학점: %d학점 ,",credit);
		printExtra();
	}

	public abstract void printExtra() ;
	
}
