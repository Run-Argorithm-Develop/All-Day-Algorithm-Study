## 도전 풀이(30분 안에 못함)

N개의 원소를 조건에 맞게 더하거나 빼서 최댓값을 구하는 문제
 1. `0 <= p + v[i] <= m`
 2. `0 <= p - v[i] <= m`
 3. 원소의 개수가 50이하라 백트래킹을 사용함

### 막혔던 점
- 백트래킹시 시간 초과 발생
- 메모리제이션을 활용하려 했으나 떠오르지 않음

## 풀이
- 백트래킹 + 메모리제이션을 활용한 문제
- DP 문제의 경우 도저히 일반식이 떠오르지 않으면 메모리제이션을 사용해도 좋음을 알려주는 문제

---
문제
https://www.acmicpc.net/problem/1495
