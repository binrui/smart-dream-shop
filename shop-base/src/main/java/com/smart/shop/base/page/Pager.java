package com.smart.shop.base.page;

public class Pager{
    private int currentPage = 1;
    private int totalItem;
    private int pageSize = 5;

    public int getTotalPage(){
        if (totalItem % pageSize > 0){
            return (totalItem / pageSize) + 1;
        }else{
            return (totalItem / pageSize);
        }
    }

    public int getStartItem(){
        return (currentPage - 1) * pageSize ;
    }

    public int getEndItem(){
        // if (currentPage * pageSize < totalItem)
        // {
        return currentPage * pageSize + 1;
        // }
        // else
        // {
        // return totalItem;
        // }
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
