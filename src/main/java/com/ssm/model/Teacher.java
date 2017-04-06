package com.ssm.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by yang on 28/03/2017.
 */
@JsonAutoDetect
public class Teacher {

    private int id;
    private String name;
    private String rate;
    private String skype;
    private String qq;
    private String pmobile;
    private String skills;
    private int cdate;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPmobile() {
        return pmobile;
    }

    public void setPmobile(String pmobile) {
        this.pmobile = pmobile;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getCdate() {
        return cdate;
    }

    public void setCdate(int cdate) {
        this.cdate = cdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
