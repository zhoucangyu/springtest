package com.example.springtest.rzl.bean;

import java.util.List;

public class Pager<T> {
    private int page;
    private int size;
    private List<T> rows;
    private long total;

    public int getPage() {return page;}
    public int getSize() {return size;}
    public List<T> getRows() {return rows;}
    public long getTotal() {return total;}

    public void setPage(int page) {this.page = page;}
    public void setSize(int size) {this.size = size;}
    public void setRows(List<T> rows) {this.rows = rows;}
    public void setTotal(long total) {this.total = total;}
}
