package algorithmTest.baekjoon.방탈출;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution solution = new Solution();
        bw.write(String.valueOf(solution.solution(N, M, board)));

        br.close();
        bw.close();
    }
}

class Solution {
    int N, M, answer;
    int[][] board;
    boolean[][] visited;
    int len = Integer.MIN_VALUE;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    public int solution(int N, int M, int[][] board) {
        this.N = N;
        this.M = M;
        this.board = board;
        len = 0;
        answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0)
                    bfs(j, i);
            }
        }

        return answer;
    }

    public void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});

        visited = new boolean[N][M];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (isPoint(nx, ny) && !visited[ny][nx]) {
                    if (board[ny][nx] != 0) {
                        flag = true;
                        visited[ny][nx] = true;
                        q.add(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }

            if (!flag && now[2] >= len) {
                if (now[2] > len) {
                    answer = board[y][x] + board[now[1]][now[0]];
                } else {
                    answer = Math.max(answer, board[y][x] + board[now[1]][now[0]]);
                }
                len = now[2];
            }

        }
    }

    public boolean isPoint(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
}