import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        
        int answer = new Solution().solution(n, s, m, v);
        System.out.println(answer);
    }
}

class Solution {
    Integer[][] memories;    // 초기화 시 null이 들어가는 것을 이용
    public int solution(int n, int s, int m, int[] v) {
        memories = new Integer[n + 1][m + 1];
        return backtracking(n, m, v, 0, s);
    }
    
    private int backtracking(int n, int m, int[] v, int i, int p) {
        if (i == n) {
            return p;
        }
        
        if (memories[i][p] != null) {
            return memories[i][p];
        }
        
        int max = -1;
        if (p + v[i] <= m) {
            max = Math.max(max, backtracking(n, m, v, i + 1, p + v[i]));
        }
        
        if (p - v[i] >= 0) {
            max = Math.max(max, backtracking(n, m, v, i + 1, p - v[i]));
        }
        
        memories[i][p] = max;
        return max;
    }
}
