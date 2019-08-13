package Example;
import java.util.ArrayList;
import java.util.Scanner;

public class MyCredit implements Management {

	User[] users=new User[4];
	
	Lesson[] lessons =new Lesson[8];
	
	ArrayList<Lesson> cart=new ArrayList<Lesson>();
	
	Scanner scan=new Scanner(System.in);
	
	int selUser;
	
	int totalCredit=0;
	
	String title;
	
	@Override
	public void setTitle(String title) {
		this.title=title;

	}

	@Override
	public void genUser() {
		User user=new User("홍길동","1학년",PayType.CARD);
		users[0]=user;
		user= new User("김나라","3학년",PayType.CASH);
		users[1]=user;
		user= new User("김수현","2학년",PayType.CARD);
		users[2]=user;
		user= new User("박수현","1학년",PayType.CASH);
		users[3]=user;
		
	}


	public void genProduct() {
		Culture cp=new Culture("Speaking Pcatice",20000,2,"교선");
		lessons[0]=cp;
		cp=new Culture("과학 기술 글쓰기",25000,2,"교필");
		lessons[1]=cp;
		cp=new Culture("인성 세미나",15000,1,"교필");
		lessons[2]=cp;
		cp=new Culture("사고와 표현",20000,2,"교필");
		lessons[3]=cp;
		Major st=new Major("C++",40000,"전필");
		lessons[4]=st;
		st=new Major("Linux",35000,"전선");
		lessons[5]=st;
		st=new Major("JAVA",40000,"전필");
		lessons[6]=st;
		st=new Major("응용SW설계",20000,"전선");
		lessons[7]=st;
		
		
		

	}

	@Override
	public void start() {
		System.out.println(title+":메인 화면 - 계정 선택");
		System.out.println("===============================");
		int i=1;
		
		for(User u:users) {
			System.out.printf("[%d]%s(%s)\n",i++,u.getName(),u.getPayType());
		}
		
		System.out.println("[x]종 료");
		System.out.print("선택:");
		String sel=scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		if(Integer.parseInt(sel)>5)
		{
			System.out.println("등록되지 않은 사용자 입니다.");
			System.out.println("");
			start();
		}
		
		switch(sel) {
			case "x": System.exit(0); break;
			default:
				selUser=(Integer.parseInt(sel)-1);
				ClassList();
		}

	}
	
	public void	ClassList()
	{
		System.out.println(title+ "수업 목록- 수업 선택");
		System.out.println("=========================");
		System.out.println("수강 가능 학점은 6학점 입니다.");
		System.out.println("현재 학점: " +totalCredit);
		
		int i=0;
		
		for(Lesson p : lessons) {
			System.out.print("["+(i+1)+"]");
			p.printDetail();
			i++;
		}
		System.out.println("[h]메인화면");
		System.out.println("[c]신청");
		System.out.println("[d]삭제");
		System.out.print("선택 :");
		String sel=scan.next();
		System.out.println("## "+sel+"선택 ##");
		System.out.println("");
		
		switch(sel) {
		case "h":start();break;
		case "c":checkOut();break;
		case "d":delete();break;
		default:
			int psel=Integer.parseInt(sel);
			if(cart.contains(lessons[psel-1]))
			{
				System.out.println("이미 선택된 과목 입니다.");
				System.out.println("");
				ClassList();
			}
			else
			{
			cart.add(lessons[psel-1]);
			totalCredit=totalCredit+(lessons[psel-1].credit);
			
			if(totalCredit>6) {
				System.out.println("6학점을 초과하였습니다  삭제 후 다시 신청해주세요");
				System.out.println("");
				System.out.println("");
				
				delete();
				
				}
			System.out.println("");
			System.out.println("");
			ClassList();
			}
		}
	}
	

	public void checkOut() {
		System.out.println(title+ "신청");
		System.out.println("=========================");
		int total=0;
		int i=1;
		
		for(Lesson p : cart) {
			System.out.printf("[%d]%s(%s)\n",i++,p.pname,p.price);
			total=total+p.price;
			
			
		}
		
		
		System.out.println("=============수강신청============");
		System.out.println("사용자: "+users[selUser].getName());
		System.out.println("총 학점 : "+totalCredit);
		System.out.println("결제 방법 "+users[selUser].getPayType());
		System.out.println("합계: "+total+" 원 입니다.");
		System.out.println("[p]이전, [q]결제 완료");
		System.out.print("선택 :");
		String sel=scan.next();
		
			switch(sel) {
				case"q":
					System.out.println("## 수강친청이 완료 되었습니다. 종료합니다 ##");
					System.exit(0);break;
				case "p":ClassList();break;
				default:
					checkOut();
			}
	}
		


	public void delete()
	{
		
		int i=1;
	
	
		System.out.println(title+ "삭제");
		System.out.println("===========장바구니=============");
		for(Lesson p : cart) {
			System.out.printf("[%d]%s(%s),(%d1학점)\n",i++,p.pname,p.price,p.credit);
			
		}
		System.out.println("");
		System.out.println("현재 학점: " +totalCredit);
		System.out.println("[h]메인화면");
		System.out.print("삭제할 과목의 번호를 입력하세요.:");
		String sel=scan.next();
		
		switch(sel) {
			case "h": ClassList();break;
			default:
				int psel=Integer.parseInt(sel);
				
				if(psel-1>cart.size()) {
					System.out.println("잘못된 값을 입력하셨습니다.");
					delete();
				}
				else {
					totalCredit=totalCredit-(cart.get(psel-1).credit);
					cart.remove(psel-1);
					System.out.println("선택한 과목이 삭제 되었습니다.");
					System.out.println("현재 학점: "+totalCredit);
					System.out.println("");
					delete();
				}
			}	
		}
	}
