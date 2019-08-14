package test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

// IShop 인터페이스를 구현한 MyShop 클래스
public class MyGame implements pGame {
	// 등록 회원 정보 배열
	User[] users = new User[3];
	
	// 등록 상품 정보 배열
	Product[] products = new Product[4];
	
	// 상품 추가를 위한 장바구니
	ArrayList<Product> cart = new ArrayList<Product>();
		
	// 키보드 입력으로 문자열 입력받기 위한 Scanner 객체 생성
	Scanner scan = new Scanner(System.in);
	
	// 선택된 사용자 index 보관
	int selUser;

	//서버와의 연결을 위한 소켓 객체
	Socket sc;

	//서버로 데이터 전송을 위한 스트림
	BufferedWriter bw;

	//서버로 부터 공지를 읽기위한 스트림
	BufferedReader br;

	// 개임 이름
	String title;

	//선택한 사용자
	User player;

	//서버와 주고 받는 메시지
	String msg=null;

	//임의의 난수 생성;
	Random rm= new Random();

	//로그 기록
	BufferedWriter writer;

	//현재 시간
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	// ;

	int total=0;
	int i=0;
	int totalhp=0;


	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 프로그램 메인 시작 메서드
	 */
	public void start() {
		//서버와 소켓 연결
		try {
			sc=new Socket("127.0.0.1",5005);
			br=new BufferedReader(new InputStreamReader(sc.getInputStream()));
			System.out.println(("게임 실행"));
			msg=br.readLine();
			System.out.println(msg);

			if((msg=br.readLine())!=null){
				System.out.println("공지!!");
				System.out.println(msg);
			}

			writer=new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));

			System.out.println(title+" : 메인화면 - 계정 선택");
			System.out.println("========================");
			int i=1;

			// 등록된 사용자 정보 출력
			for(User u : users) {
				System.out.printf("[%d]%s(%s)\n",i,u.getName(),u.getUserType());
				i++;
			}

			System.out.println("[x]종 료");
			System.out.print("선택 : ");
			String sel = scan.next();
			System.out.println("## "+sel+"선택 ##");

			// 선택된 메뉴에 따라 처리
			switch(sel) {
				case "x":
					sc.close();
					System.exit(0);break;
				default:
					selUser = Integer.parseInt(sel)-1;
					showMenu();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void startGame(){
		System.out.println("사냥을 시작합니다");
		int getMoney=rm.nextInt(101)+100; //100~200 사이의 골드 획드
		int getDamage=rm.nextInt(101);  //0~100 사이의 데미지 획득

		System.out.println(getMoney+"골드를 획득했습니다");
		player.setMoney(player.getMoney()+getMoney);
		System.out.println(getDamage+"만큼의 데미지를 받았습니다.\n\n");
		player.setHp(player.getHp()-getDamage);
		showMenu();
	}

	public void showMenu(){
		player=users[selUser];
		try {
			writer.write(format1.format (System.currentTimeMillis())+"사용자 "+player.getName()+"로그인\n");

			if(player.getHp()<=0){
				System.out.println("HP가 0이하로 떨어졌습니다. 게임을 종료합니다");

				writer.write(format1.format (System.currentTimeMillis())+"사용자 "+player.getName()+"죽음\n");
				System.exit(0);
			}
			System.out.println("\n\n"+player.getName()+"님 환영합니다");
			player.showStatus();
			System.out.println("        행동 선택         ");
			System.out.println("=========================");
			System.out.println("[1]: 사냥");
			System.out.println("[2]: 상점");
			System.out.println("[x]: 종료");
			System.out.print("선택 : ");
			String sel = scan.next();
			System.out.println("## "+sel+"선택 ##");

			switch (sel){
				case "1":
					startGame();
					break;
				case "2":
					productList();
					break;
				case "x":
					System.out.println("게임을 종료합니다");
					System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sendData(String data){

	}




	/**
	 * 물약 목록을 보고 구매하기 위한 메서드
	 */
	public void productList() {


		System.out.println("상점");
		System.out.println("=========================");
		int i=0;
		
		// 등록된 상품 정보 출력
		for(Product p : products) {
			System.out.print("["+i+"]");
			p.printDetail();
			i++;
		}
		System.out.println("[h]메인화면");
		System.out.println("[c]결제");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "h":
				cart.clear();
				showMenu();
				break;
			case "c":
				checkOut();
				break;
			default:
				int psel = Integer.parseInt(sel);
				cart.add(products[psel]);
				productList();
		}
	}

	public void showCart(){


		int random=rm.nextInt(51)+50;  // 50~100 사이의 난수 생성
		int lucky=rm.nextInt(2); //0: 회복 1: 악화
		// 장바구니에 등록된 상품 정보 출력
		for(Product p : cart) {
			System.out.printf("[%d]%s(%s)\n",i++,p.pname,p.price);


			if(p.pname=="알수 없는 물약"){
				if(lucky==0){
					p.point=random;
				}else{
					p.point=random*(-1);
				}
			}
			total = total + p.price;
			totalhp =totalhp+p.point;
		}
	}
	/**
	 * 결제 진행을 위한 체크아웃 처리 메서드
	 */
	public void checkOut() {
		System.out.println("\n장바구니");
		System.out.println("=========================");

		showCart();


		System.out.println("=========================");


		// 합계 출력
		System.out.println("합계: "+total+" 골드 입니다.");
		System.out.println("[p]이전 , [q]결제");
		System.out.print("선택 : ");
		String sel = scan.next();

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "q":
					player.setMoney(total+player.getMoney()); //사용자 금액 변경
					player.setHp(totalhp+player.getHp()); // 사용자의 상태 변경
					for(Product p:cart){
						p.printExtra();
					}
					System.out.println("## 결제가 완료 되었습니다. ##");
					//카트 초기화 작업
					cart.clear();
					total=0;
					totalhp=0;
					showMenu();

			case "p":productList();break;
			default: checkOut();
		}		
	}
	
	/**
	 *  프로그램에서 사용하기 위한 예제 사용자 등록 메서드
	 */
	public void genUser() {
		User user = new User("홍길동",2100,UserType.HEALER);
		users[0] = user;
		user = new User("블로거",1000,UserType.TANKER);
		users[1] = user;
		user = new User("강호동",100,UserType.DEALER);
		users[2] = user;
	}
	
	/**
	 *  프로그램에서 사용하기 위한 예제 상품 등록 메서드
	 */
	public void genProduct() {
		Portion cp = new Portion("빨간 물약",500,+30);
		products[0] = cp;
		cp = new Portion("노란 물약",700,+50);
		products[1] = cp;
		Poison st =new Poison("뱀 독",400,-50);
		products[2] = st;
		RandomDrink st2 = new RandomDrink(100);
		products[3] = st2;
	}
}