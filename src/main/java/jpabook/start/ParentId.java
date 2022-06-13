package jpabook.start;

import java.io.Serializable;
import java.util.Objects;

public class ParentId implements Serializable {
    private String id1;
    private String id2;
    public ParentId(){}
    public ParentId(String id1,String id2){
        this.id1=id1;
        this.id2=id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentId parentId = (ParentId) o;
        return Objects.equals(id1, parentId.id1) &&
                Objects.equals(id2, parentId.id2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2);
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
}

// 복합키를 사용하는 경우 반드시 @Id로 지정된 컬럼과 이름이 같아야 함
// Serializable을 구현해야 하며 기본생성자가 있어야 하고 equals,hashCode를 오버라이딩 해야하고 클래스가 public 이여야 한다
// 참고로 복합 키에는 GenerateValue를 사용할 수 없다