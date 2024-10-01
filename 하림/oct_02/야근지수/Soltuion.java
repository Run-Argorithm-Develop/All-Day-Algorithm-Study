package 하림.oct_02.야근지수;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);

        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }

        for(int i=0; i<n; i++){
            int num = pq.poll()-1;
            if(0 < num){
                pq.offer(num);
            }else{
                pq.offer(0);
            }

        }

        while(!pq.isEmpty()){
            int num = pq.poll();
            if(num!=0){
                answer += Math.pow(num,2);
            }
        }


        return answer;
    }
}