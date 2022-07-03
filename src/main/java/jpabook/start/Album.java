package jpabook.start;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item{
    private String artist;
    private String etc;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    @Override
    public String getTitle() {
        return "[작가:"+getArtist()+"배우:"+getEtc()+"]";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
