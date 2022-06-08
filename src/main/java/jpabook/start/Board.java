package jpabook.start;

import javax.persistence.*;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "BOARD_SEQ_GENERATOR") // 방금 등록한 시퀀스 생성기 선택
    @SequenceGenerator(
            name="BOARD_SEQ_GENERATOR", // 시퀀스 생성기 이름(식별자 생성기 이름)
            sequenceName = "BOARD_SEQ", // 데이터베이스에 저장될 시퀀스 명(DB에 등록되어 있는 시퀀스 이름)
            initialValue = 1, // 초기값
            allocationSize = 1 //증가값
    ) // 위는 database의 시퀀스를 만들어주는 설정임(mysql에는 없음)
    private Long id; // 이 id라는 값은 BOARD_SEQ_GENERATOR 시퀀스 생성기가 할당한다

    @Column(length = 255)
    private String DATA;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
