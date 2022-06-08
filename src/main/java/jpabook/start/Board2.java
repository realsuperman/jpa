package jpabook.start;

import javax.persistence.*;

@Entity
@TableGenerator(
        name="BOARD_SEQ_GENERATOR",
        table="MY_SEQUENCES", // 테이블 명
        pkColumnValue = "BOARD_SEQ", // MY_SEQUENCES 테이블의 컬럼 값이 BOARD_SEQ인걸 택함
        allocationSize = 1
)
public class Board2 {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
                    generator = "BOARD_SEQ_GENERATOR")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

/*
    참고로 Table을 사용하는 전략의 경우 @TableGenerator의 속성에는 pkColumnName이라던지 valueColumnName 등의 속성이 있다 하지만 하이버네이트에서는
    pkColumnName의 기본 값은 sequence_name이고 valueColumnName의 기본값은 next_val이라는 컬럼을 지칭한다. 지금은 그거에 맞게 테이블을 설계 했으므로 생략한 것

    시퀀스 방식과 거의 유사하지만 해당 방식은 테이블에서 시퀀스 값을 가지고 온 후 테이블을 업데이트 해야하는 문제가 있다.
 */