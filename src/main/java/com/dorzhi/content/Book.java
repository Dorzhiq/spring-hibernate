package com.dorzhi.content;

import javax.persistence.*;

@Entity
public class Book extends Content {
    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
