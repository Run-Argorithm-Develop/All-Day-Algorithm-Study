package 하림.oct_01.강의실배정_백준;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(start, end);
        }
        Arrays.sort(nodes, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(nodes[0].end);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= nodes[i].start) {
                pq.poll();
            }
            pq.offer(nodes[i].end);
        }

        bw.write(String.valueOf(pq.size()));

        br.close();
        bw.close();
    }
}