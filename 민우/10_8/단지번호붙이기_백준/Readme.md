## 도전 풀이(30분 풀이 완료)

bfs 또는 dfs를 활용하여 2차원 배열 연속된 영역 및 영역 별 요소 개수를 구하는 문제
 1. `boolean visited[][]` 활용
 2. 모든 좌표들에 대해 루프를 돌면서 최초 방문시 BFS
  -  최초 방문마다 영역 개수 +1
  -  BFS를 통해 영역에 속한 원소 개수 카운팅

### 막혔던 점
- 영역 외 지점은 방문하면 안됨 

## 풀이
- BFS로 풀이
- `int[] dx`, `int[] dy` 활용

---
문제
https://www.acmicpc.net/problem/2667
