package com.dorzhi.content;

import javax.persistence.*;

@Entity(name="music_track")
public class Music extends Content {
    private int bitRate;

    public int getBitRate() {
        return bitRate;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }
}
