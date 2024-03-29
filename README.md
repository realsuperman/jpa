## 개요
JPA는 Java Persist API의 약자로서 Java 진영의 ORM 기술 표준이다 JPA를 활용하면 반복적인 쿼리들을 줄일 수 있고 객체와 엔티티를 매핑할 수 있다

## 학습한 내용
1. 영속성 관리
-> 엔티티 매니저 팩토리와 엔티티 매니저에 대해서 학습을 하였고 엔티티들의 생명주기와 해당 엔티티를 등록할 때 사용되는 영속성 컨텍스트에 특징과 활용법에 대해서 학습을 하였습니다
##
2. 엔티티 매핑
-> ORM은 객체와 관계형 데이터베이스의 데이터를 매핑해주는 기술로서 JPA에서 어떻게 ORM을 활용하는지에 대해서 학습을 하였습니다
##
3. 연관관계 매핑
-> 객체와 객체를 어떻게 관계를 맺는지에 대해서 학습을 하였습니다 또한 연관관계의 주인에 대한 내용과 여러가지 단순한 연관관계를 맺는 방법에 대해서 학습을 하였습니다
##
4. 다양한 연관관계 매핑
-> 실무에서는 [one to many, one to one, many to many] 등의 여러 관계를 매핑하게 됩니다. 이러한 매핑을 하는 방법에 대해서 학습을 하였습니다
##
5. 고급 매핑
-> 상속 관계 매핑과 MappedSuperclass과 식별 관계 비 식별관계에 대해서 학습을 하였고 또한 조인 테이블을 활용하여 매핑 하는 방법에 대해서 학습을 하였습니다
##
6. 프록시와 연관관계
-> 프록시에 대한 간단한 개념과 지연로딩과 즉시로딩의 차이점과 활용하는 방법에 대해서 학습을 하였습니다
##
7. JPQL
-> JPA에서도 쿼리는 무조건적으로 사용이 됩니다. JPA에서는 우리가 기존에 알고있던 SQL과 비슷하지만 약간 다른 SQL을 제공해줍니다 그것이 바로 JPQL입니다
JQPL을 활용하여 질의를 하는 방법과 더 나아가서 편하게 JPQL을 활용할 수 있는 QueryDSL에 대해서 학습을 하였습니다
##
8. 웹 애플리케이션과 영속성 관리
-> 스프링과 JPA를 활용하여 프로젝트를 진행하는 경우 일반적으로 트랜잭션의 시작은 서비스부터 입니다(영속성 컨텍스트는 트랜잭션과 생명주기가 같습니다)
그러나 컨트롤러에서도 영속성 컨텍스트를 활용하는 경우가 있을 수 있습니다 그런 경우에는 영속성 컨텍스트의 범위를 늘려주어야 합니다 그것이 바로 OSIV인데 그 OSIV에 
특징과 활용하는 방법에 대해서 학습을 하였습니다
##
9. 성능 최적화
-> JPA에서 즉시로딩을 잘못 활용하는 경우 N+1의 문제가 발생할 수 있습니다 해당 N+1의 문제 원인과 해결하는 방법에 대해서 학습을 하였습니다
