package com.qbt.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by ALKL on 2017/1/3.
 */

/*
* name 是jpa中存储过程的名字
* procedureName 是存储过程的名字
* did是存储过程中输入参数
* 描述：实现查询功能
*
* */
@Entity
@Table(name = "user")
//@StoredProcedureParameter(mode = ParameterMode.OUT, name = "dout", type = String.class)
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "user_jpa", procedureName = "test",parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "din", type = Integer.class)})
         })

public class DevMonthData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;//记录ID 自增,主键
    @NotNull
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /*@NotNull
    private String userNo;//水表对应用户编号

    private Integer deviceId;//水表Id 水表唯一标识

    private String userAddr;//水表所属用户的地址

    private String readTime;//抄表日期

    private String fetchTime;//拉取数据的日期

    private BigDecimal showValue;//水表读数


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public String getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(String fetchTime) {
        this.fetchTime = fetchTime;
    }

    public BigDecimal getShowValue() {
        return showValue;
    }

    public void setShowValue(BigDecimal showValue) {
        this.showValue = showValue;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }*/
}
