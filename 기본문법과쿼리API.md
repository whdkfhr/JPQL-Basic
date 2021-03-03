## 기본 문법과 쿼리 API 

### JPQL 문법
- select m from __Member__ as m where __m.age__ > 18
- 엔티티와 속성은 대소문자 구분 O(Member, age_)
- JPQL 키워드는 대소문자 구분 X(SELECT, FROM, where)
- 엔티티 이름 사용, 테이블 이름이 아님(Member)
- __별칭은 필수(m)__ (as는 생략가능)

### 집합과 정렬
```
select
    COUNT(m),       // 회원수
    SUM(m.age),     // 나이 합
    AVG(m.age),     // 평균 나이
    MAX(m.age),     // 최대 나이
    MIN(m.age),     // 최소 나이
form Member m
```
- GROUP BY, HAVING
- ORDER BY

### TypeQuery, Query
- TypeQuery : 반환 타입이 명확할 때
- Query : 반환 타입이 명확하지 않을 때
```java
TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);

Query query = em.createQuery("SELECT m.username, m.age from Member m");
```

### 결과 조회 API
- query.getResultList() : __결과가 하나 이상일 때__ , 리스트 반환
    - 결과가 없으면 빈 리스트 반환
    
- query.getSingleResult() : __결과가 정확히 하나__ , 단일 객체 반환
    - 결과가 없으면 : javax.persistence.NoResultException
    - 둘 이상이면 : javax.persistence.NonUniqueResultException
    
### 파라미터 바인딩 - 이름 기준, 위치 기준(비)
```
SELECT m FROM Member m where m.username = :username
query.setParameter("username", usernameParam);
```
```
SELECT m FROM Member m where m.username = ?1
query.setParameter(1, usernameParam);
```