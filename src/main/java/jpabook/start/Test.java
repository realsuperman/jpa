package jpabook.start;

import javax.persistence.*;

@Entity
//@Convert(converter = BooleanToYNConverter.class,attributeName = "vip") // 클래스 전역에 걸 수 있다 단 이때는 해당 컬럼명을 지칭해야 한다
public class Test {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    //@Convert(converter = BooleanToYNConverter.class)
    private boolean vip;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
