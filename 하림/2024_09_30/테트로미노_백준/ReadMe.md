## 도전 풀이(30분 안에 못함)

N*M 크기의 표에서 4의 개수를 갖고 있는 타일의 모양으로 가장 수가 큰 타일 속의 수의 합을 구하는 문제

### 막혔던 점
- 조건 ㅗ 모양의 특수한 조건을 충족하지 못함
- boolean 방문을 한 루프가 끝날때마다 true -> false로 바꿔줘야함

## 풀이

```java
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
```

에서 level이 2일 때 다시 더하기 전으로 돌아가 ㅗ 조건을 충족하는 분기점을 고려해야함
---
문제
https://wikidocs.net/217631