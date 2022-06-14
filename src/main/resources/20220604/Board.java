import javax.persistence.*;

@Entity
@Table(name="BOARD")
@SecondaryTable(name="BOARD_DETAIL",
        pkJoinColumns = @PrimaryKeyJoinColumn(name="BOARD_DETAIL_ID"))
public class Board {
    @Id @GeneratedValue
    @Column(name="BOARD_ID")
    private Long id;
    private String title;
    @Column(table="BOARD_DETAIL")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

/*
    하나의 엔티티에서 여러 엔티티를 선언 가능하다 이런 방식으로 하지말고 엔티티 클래스를 개별로 만들자
 */
