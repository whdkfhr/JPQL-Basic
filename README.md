# JPQL - 기본 문법과 기능

### 환경
- Java 8 이상
- H2 데이터베이스(1.4.200)
- 메이븐
- jpa hibernate(5.4.27.final)

### 학습목표
- JPQL 기본 문법과 기능
- 페치 조인
- 경로 표현식
- 다형성 쿼리
- 엔티티 직접 사용
- Named 쿼리
- 벌크 연산

***

### JPQL 소개
- JPQL은 객체지향 쿼리 언어다. 따라서 테이블을 대상으로 쿼리하는 것이 아니라 __엔티티 객체를 대상으로 쿼리__ 한다.
- JPQL은 SQL을 추상화해서 특정 데이터베이스 SQL에 의존하지 않는다.
- JPQL은 결국 SQL로 변환된다.

***

### JPQL 문법
```
select_문 :: =
    select_절
    from_절
    [where_절]
    [groupby_절]
    [having_절]
    [orderby_절]
   
update_문 :: = update_절 [where_절]
delete_문 :: = delete_절 [where_절]
```
