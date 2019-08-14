import java.util.ArrayList;

public class User {

    public ArrayList<lesson> timetable = new ArrayList<>();  // 시간표 확인
    private String name;
    private String number;



    public User(){
      lesson aa=new lesson("C++","6-7","Mon","major",3);
     // timetable.add(aa);
      aa=new lesson("JAVA","1-4","Wen","major",3);
     // timetable.add(aa);
    }

    public void putLesson(){

    }

    public void pullLesson(){

    }

    public void showLesson(){
        int i=1;
        for(lesson s : timetable){
            System.out.println("-----------"+i+"--------------");
            System.out.println("강의명: "+s.getSubject());
            System.out.println("전공/교양: "+s.getType());
            System.out.println("시간"+s.getDate()+"/"+s.getTime());
            System.out.println("학점: "+s.getPoint());
            System.out.println("학점: "+s.getPoint());
            System.out.println();
            i++;
        }
    }

    private int checkLesson(String time){


        return 0;
    }






}
