package dummy;

import javax.persistence.*;

@Entity
public class BoardDetail {
    @Id
    private Long boardId;
    @MapsId
    @OneToOne
    @JoinColumn(name="BOARD_ID")
    private Board board;
    private String content;

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

/*
    기본키가 부모의 키밖에 없는 경우 이런 경우는 특이하게 MapsId를 써서 매핑한다. 참고로 이런 관계는 1:1만 성립 한다
    또한 @MapsId는 @ID를 사용해서 식별자로 지정한 boardId와 매핑된다
 */