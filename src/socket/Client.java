package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;


public class Client {
	
	public static void main(String[] args) {
		
		try {
			if(args.length != 2 ) throw new IllegalArgumentException("인자 갯수가 안맞음");
			
			String ip = args[0];
			int port = Integer.parseInt(args[1]);
			
			System.out.println("Server Information : " + ip + " : " + port);
			
			// 서버 소켓 접속 (서버가 작동되고있어야함)
			Socket socket = new Socket(ip, port);
			
			// 직렬화를 위한 ObjectOutputStream 객체 생성
			// socket 통신을 하기 때문에 socket의 stream을 가져옵니다.
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			
			// Server로부터의 응답을 받기 위한 부분
            // socket 통신을 하기 때문에 socket의 stream을 가져옵니다.
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			Order order = Order.builder()
					.name("소켓테스트")
					.orderNum((int)(Math.random()*100))
					.menu("바사삭")
					.build();
			// 소켓으로 보낼 스트림객체에 order 객체 직렬화 
			objectOutputStream.writeObject(order);
			objectOutputStream.flush(); // 전달
			
			// 서버로부터 응답
			String returnMessage = bufferedReader.readLine();
			System.out.println(returnMessage);
			
			objectOutputStream.close();
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print("Usage : Java Client <hostname> <port:4000>" );
			e.printStackTrace();
		}

		
	}

}
