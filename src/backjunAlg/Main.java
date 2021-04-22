package backjunAlg;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// 교수님이 지각할 수 있는 최대 시간 t를 정수로 구해서 출력
		// d >= (s + t) 만 가능

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 궁금한 경우의 수
		if (!(n >= 1 && n <= 100))
			return;
		int d[] = new int[n]; // 수업시간
		for (int i = 0; i < n; i++) {
			d[i] = sc.nextInt();
			if (!(d[i] >= 1 && d[i] <= 10000))
				return;
		}
		for (int i = 0; i < n; i++) {
			// 교수 지각시간 t
			for(int t = 0; t <= 100; t++) {
				int s = t*t; // 일찍 끝나는시간
				if((d[i] - (s + t)) >= 0) {
					continue;
				}else {
					d[i] = (t - 1);
					break;
				}
			}
		}
		for(int i : d) {
			System.out.println(i);
		}
	}
}
