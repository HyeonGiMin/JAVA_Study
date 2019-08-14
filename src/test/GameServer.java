package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class GameServer {
    public static void main(String[] args) {


        try {
            ServerSocket ssc=new ServerSocket(5005);
            System.out.println("## 서버 실행: " +ssc.getInetAddress().getLocalHost());


            while(true) {

                Socket s=ssc.accept();
                BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter wr=new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
                BufferedWriter writer=new BufferedWriter(new FileWriter("/Users/hyeon/Documents/Temp/Serverlog.txt")); //로그 기록


                System.out.println("## 클라이언트 연결됨!!");
                System.out.println("## 클라이언트 연결됨!!");

                String notice="<공지>게임 세상에 오신것을 환영합니다\n";
                System.out.println("## 클라이언트 연결됨!!");

                wr.println(notice);




                String msg= br.readLine();
                if(msg=="exit"){
                    br.close();
                    s.close();
                    System.exit(0);
                }
                System.out.println(msg);
                writer.write(msg);



            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
