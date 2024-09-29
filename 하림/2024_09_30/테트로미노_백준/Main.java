package algorithmTest.baekjoon.테트로미노;

import java.io.*;
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
    int N, M;
    int[][] board;
    boolean[][] visited;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int max = Integer.MIN_VALUE;

    public int solution(int N, int M, int[][] board) {
        this.N = N;
        this.M = M;
        this.board = board;
        this.visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(1, j, i, board[i][j]);
                visited[i][j] = false;
            }
        }

        return max;
    }

    public void dfs(int level, int x, int y, int sum) {

        if (level == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (isPoint(nx, ny) && !visited[ny][nx]) {
                if (level == 2) {
                    visited[ny][nx] = true;
                    dfs(level + 1, x, y, sum + board[ny][nx]);
                    visited[ny][nx] = false;
                }
                visited[ny][nx] = true;
                dfs(level + 1, nx, ny, sum + board[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }

    public boolean isPoint(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
}