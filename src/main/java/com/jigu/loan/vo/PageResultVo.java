package com.jigu.loan.vo;

import lombok.Data;

@Data
public class PageResultVo<T> extends PageVo {

    private T content;

    private int total;


    public PageResultVo(int pageNum, int pageSize, T content, int total){
        this.content = content;
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
        this.total = total;
    }
}
