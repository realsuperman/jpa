package jpabook.start;

import javax.persistence.Entity;

@Entity
public class Test extends Common2{
    private int test;

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}
