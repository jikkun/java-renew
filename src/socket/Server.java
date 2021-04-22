package socket;

import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static final int SERVER_PORT = 4000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket; // Client의 접속을 기다리는 역할
		Socket socket; // Client와 데이터 송수신 역할
		
		ObjectInputStream objectInputStream; // Class 객체 읽어올때 사용
		PrintWriter printWriter; // 값 전달시 사용
		
		try {
			// 서버 소켓 생성
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server Running");
			
			while(true) {
				System.out.println("before socket connect");
				// 클라이언트 접속시 까지 대기
				socket = serverSocket.accept();
				
				System.out.println("after socket connect");
				// client로 보낼 객체 생성
				printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
				
				//client로부터 객체를 읽어오는 역할을 하는 객체 생성
				objectInputStream = new ObjectInputStream(socket.getInputStream());
				// 담겨온 order 객체 생성
				Order order = (Order) objectInputStream.readObject();
				System.out.println(order.toString());
				
				printWriter.write("ok");
				printWriter.close(); // close() or flush()를 해줘야지 전해진다
                socket.close(); // 여기서 socket 접속이 끊어져야 클라이언트가 종료가 됩니다.
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
