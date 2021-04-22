package backjunAlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_main {
    static int S, MIN = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        BFS();
    }

    static void BFS(){
        Queue<A> Q = new LinkedList();
        Q.add(new A(1, 0));
        visited[1][0] = true;

        while(!Q.isEmpty()) {
            A now = Q.poll();

            if(now.M < S) {
                // 1번 연산 : 현재 화면의 갯수를 클립보드에 저장
                if(1 <= S) {
                    if(now.M != now.C && !visited[now.M][now.M]) {
                        Q.add(new A(now.M, now.M));
                        visited[now.M][now.M] = true;
                    }

                    // 2번 연산 : 클립보드의 갯수를 모니터에 더해
                    if (now.C != 0 && now.M+now.C <= S && !visited[now.M+now.C][now.C]) { // 클립보드가 비어있지 않을때 붙여넣기 가능
                        Q.add(new A(now.M+now.C, now.C));
                        visited[now.M+now.C][now.C] = true;
                    }

                    // 3번 연산 : 화면값을 감소시켜
                    if (now.M-1 >= 1 && !visited[now.M-1][now.C]) {
                        Q.add(new A(now.M-1, now.C));
                        visited[now.M-1][now.C] = true;
                    }
                }
            }
            else {
                if(1 <= S) {
                    // 3번 연산 : 화면값을 감소시켜
                    if (now.M-1 >= 1 && 1 < MIN && !visited[now.M-1][now.C]) {
                        Q.add(new A(now.M-1, now.C));
                        visited[now.M-1][now.C]= true;
                    }
                }
            }
        }
        System.out.println(MIN);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[S+1][S+1];
    }

    static class A {
        int M, C;
        public A(int M, int C) { this.M = M; this.C = C; }
    }
}