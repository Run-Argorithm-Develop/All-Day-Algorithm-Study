package 하림.oct_01.빙고;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution solution = new Solution();
        bw.write(String.valueOf(solution.solution(board)));

        br.close();
        bw.close();
    }
}

class Solution {

    int[][] board;
    int count =0;
    public int solution(int[][] board) {

        Scanner sc = new Scanner(System.in);
        this.board = board;
        count = 0;

        // 빙고판 입력
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for(int k = 1; k <= 25; k++) {
            int num = sc.nextInt();

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(board[i][j] == num) // 사회자가 부른 숫자와 같다면 0으로 바꾸기
                        board[i][j] = 0;
                }
            }

            rCheck();
            cCheck();
            lrCheck();
            rlCheck();

            if(count >= 3) { // 3줄 이상 빙고이면 몇 번째 숫자인지 출력하고 종료
                return k;
            }
            count = 0;
        }
        return 0;
    }

    //가로 체크
    public void rCheck() {
        for(int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for(int j = 0; j < 5; j++) {
                if(board[i][j] == 0)
                    zeroCount++;
            }
            if(zeroCount == 5)
                count++;
        }
    }

    // 세로 체크
    public void cCheck() {
        for(int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for(int j = 0; j < 5; j++) {
                if(board[j][i] == 0)
                    zeroCount++;
            }
            if(zeroCount == 5)
                count++;
        }
    }

    // 왼쪽에서 오른쪽으로 그어지는 대각선 체크
    public void lrCheck() {
        int zeroCount = 0;
        for(int i = 0; i < 5; i++) {
            if(board[i][i] == 0)
                zeroCount++;
        }
        if(zeroCount == 5)
            count++;
    }

    // 오른쪽에서 왼쪽으로 그어지는 대각선 체크
    public void rlCheck() {
        int zeroCount = 0;
        for(int i = 0; i < 5; i++) {
            if(board[i][4-i] == 0)
                zeroCount++;
        }
        if(zeroCount == 5)
            count++;
    }
}