package com.wyx.learn.entity;

import java.util.Date;
import java.util.List;

public class User {

    private Integer id;
    private String userName;
    private String password;
    private String deptment;
    private String phone;
    private String email;
    private Integer status;
    private Date createDate;
    private String remark;

    private List<UserSalary> salaryList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeptment() {
        return deptment;
    }

    public void setDeptment(String deptment) {
        this.deptment = deptment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

  public List<UserSalary> getSalaryList() {
    return salaryList;
  }

  public void setSalaryList(List<UserSalary> salaryList) {
    this.salaryList = salaryList;
  }
}
