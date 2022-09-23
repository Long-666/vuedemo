package com.pojo;

import java.util.List;

/**
 * @author Long-666
 * @create 2022-09-17 14:34
 */
public class PageBean<T>{
    private int totalCount;
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
