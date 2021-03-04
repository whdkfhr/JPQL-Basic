## JPQL 타입 표현과 기타식

### JPQL 타입 표현
- 문자 : 'HELLO', 'She''s'
- 숫자 : 10L(Long), 10D(Double), 10F(Float)
- Boolean : TRUE, FALSE
- ENUM : jpql.MemberType.ADMIN(패키지명 포함)
- 엔티티 타입 : TYPE(m) = Member(상속 관계에서 사용)

### JPQL 기타
- SQL과 문법이 같은 식
- EXISTS, IN
- AND, OR, NOT
- =, >, >=, <=, <>
- BETWEEN, LIKE, __IS NULL__

### 조건시