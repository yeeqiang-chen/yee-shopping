package com.yiqiang.shopping.usermanage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/15 0015 1:41
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别：
     *      1男性,2女性
     */
    private Integer sex;

    /**
     * 出生日期(yyyy-MM-dd)
     */
    private Date birthday;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * @Transient 注解可以忽略字段,添加该注解的字段不会作为表字段使用
     *//*
    @Transient
    private String testIgnore;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name
                + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday + ", created=" + created
                + ", updated=" + updated + "]";
    }

}