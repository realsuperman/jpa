package jpabook.start;

import javax.persistence.*;

@Entity
public class Board3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

/*
    키 전략을 AUTO로 하면 JPA가 데이터베이스 방언에 따라 IDENTITY,SEQUENCE,TABLE 전략 중 하나를 자동으로 선택해준다.
    오라클이면 SEQUENCE를 MYSQL이면 IDENTITY를 사용한다
    참고로 전략의 기본 값은 AUTO다 위의 코드에서 strategy부분을 지우더라도 똑같이 작동한다.
 */