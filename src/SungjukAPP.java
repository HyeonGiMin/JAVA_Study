import java.util.ArrayList;

public class SungjukAPP {
	public ArrayList<Student> students= new ArrayList<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	SungjukAPP app=new SungjukAPP();
        app.printSungjuk();
    }

    public SungjukAPP() {
        Student s1=new Student();
        s1.setNumber("201701");
        s1.setName("홍길동");
        ArrayList<Sungjuk> sungjuk=s1.getSungjuk();
        Sungjuk sj=new Sungjuk();
        sj.setSubject("java");
        sj.setScore(91);
        sungjuk.add(sj);


        students.add(s1);
    }

    public void printSungjuk() {
        for(Student s:students) {
            System.out.printf("# %s,%s\n", s.getNumber(),s.getName());
            for(Sungjuk j:s.getSungjuk()) {
                System.out.printf("%s:%d\t\n",j.getSubject(),j.getScore());
            }
            System.out.println("--------------------------");
        }
    }
}
