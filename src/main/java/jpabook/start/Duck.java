package jpabook.start;

import javax.persistence.*;

@Entity
@EntityListeners(DuckListener.class)
// 리스너 우선순위는 기본 리스너 -> 부모 클래스 리스너 -> 리스너 -> 엔티티 순임 따라서 아래와 같이 우선순위를 재조정하기 위한 무시 어노테이션이 존재함
@ExcludeDefaultListeners // 기본리스너 무시
@ExcludeSuperclassListeners // 상위 클래스 이벤트 리스너 무시
public class Duck {
    @Id @GeneratedValue
    private Long id;
    private String name;

/*
    @PrePersist
    public void prePersist(){
        System.out.println("Duck.prePersist id="+id);
    }
    @PostPersist
    public void postPersist(){
        System.out.println("Duck.postPersist id="+id);
    }
    @PostLoad
    public void postLoad(){
        System.out.println("Duck.postLoad");
    }
    @PreRemove
    public void preRemove(){
        System.out.println("Duck.preRemove");
    }
    @PostRemove
    public void postRemove(){
        System.out.println("DuckpostRemove");
    }
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
