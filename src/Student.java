import java.util.ArrayList;

public class Student  {

	 private String number;
	    private String name;
	    private ArrayList<Sungjuk> sungjuk=new ArrayList<>();



	    public String getNumber() {
	        return number;
	    }

	    public ArrayList<Sungjuk> getSungjuk() {
	        return sungjuk;
	    }

	    public void setNumber(String number) {
	        this.number = number;
	    }


	    public String getName() {
	        return name;
	    }


	    public void setName(String name) {
	        this.name = name;
	    }



}
