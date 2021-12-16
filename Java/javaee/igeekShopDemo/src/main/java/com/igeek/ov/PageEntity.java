package main.java.com.igeek.ov;

import java.util.List;

public class PageEntity<T> {
    //当前页码
    private int currentPage;
    //页面显示多少条数据
    private int rows;
    //一共多少页
    private int totalPage;
    //总共多少条
    private int totalRows;
    //数据
    private List<T> list;

    public PageEntity() {
    }

    public PageEntity(int currentPage, int rows, int totalPage, int totalRows, List<T> list) {
        this.currentPage = currentPage;
        this.rows = rows;
        this.totalPage = totalPage;
        this.totalRows = totalRows;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
