package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChildId2 implements Serializable {
    private String parentId; // @MapsId("parentId")로 매핑

    @Column(name="CHILD_ID")
    private String id;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildId2 childId2 = (ChildId2) o;
        return Objects.equals(parentId, childId2.parentId) &&
                Objects.equals(id, childId2.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId, id);
    }
}
