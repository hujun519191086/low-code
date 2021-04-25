package com.github.houbb.low.code.dal.entity.po;

import com.github.houbb.low.code.dal.entity.User;

/**
 * <p>
 * 用户表-分页查询对象
 * </p>
 *
 * @author Administrator
 * @since 2021-04-25
 */
public class UserPagePo extends User {

    /**
    * 分页大小
    */
    private Integer pageSize;

    /**
    * 当前页码
    */
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "UserPagePo{" +
        "pageSize=" + pageSize +
        ", pageNum=" + pageNum +
        "} " + super.toString();
    }

}