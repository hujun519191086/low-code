package com.github.houbb.low.code.dal.entity;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Administrator
 * @since 2021-04-25
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelField(headName = "自增主键")
    private Integer id;

    /**
     * 用户标识
     */
    @TableField("user_id")
    @ExcelField(headName = "用户标识")
    private String userId;

    /**
     * 用户名称
     */
    @TableField("user_name")
    @ExcelField(headName = "用户名称")
    private String userName;

    /**
     * 用户描述
     */
    @TableField("remark")
    @ExcelField(headName = "用户描述")
    private String remark;

    /**
     * 应用名称
     */
    @TableField("app_name")
    @ExcelField(headName = "应用名称")
    private String appName;

    /**
     * 操作员名称
     */
    @TableField("operator_name")
    @ExcelField(headName = "操作员名称")
    private String operatorName;

    /**
     * 创建时间戳
     */
    @TableField("create_time")
    @ExcelField(headName = "创建时间戳")
    private Date createTime;

    /**
     * 更新时间戳
     */
    @TableField("update_time")
    @ExcelField(headName = "更新时间戳")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", userId=" + userId +
        ", userName=" + userName +
        ", remark=" + remark +
        ", appName=" + appName +
        ", operatorName=" + operatorName +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
