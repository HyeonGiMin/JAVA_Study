public class lesson {
    private String subject;
    private String time;
    private String date;
    private String type;
    private int point;

    public lesson(){

    }

    public lesson(String subject,String time,String date,String type,int point){
        this.subject=subject;
        this.time=time;
        this.date=date;
        this.type=type;
        this.point=point;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
