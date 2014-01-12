/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import org.hibernate.annotations.Cascade;
/**
 *
 * @author Dxg
 */
@Entity
@Table(name="user_info")
public class UserInfo implements Serializable {
        private static final long serialVersionUID = 1L;
    @Id    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long uid;
    
    private String education;
    private double height;
    private String hometown;

    private String intro;
    private String qq;
    private String phonenum;
    

    private String job;
    private Date birthday;
    //Json
    private String user_language;
    private String passport;
    private String license;
    
   @OneToOne()  
   @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
   @JoinColumn(name = "user_id") 
    private User user;

    /**
     * @return the uid
     */
    public long getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(long uid) {
        this.uid = uid;
    }

    /**
     * @return the education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the hometown
     */
    public String getHometown() {
        return hometown;
    }

    /**
     * @param hometown the hometown to set
     */
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    /**
     * @return the intro
     */
    public String getIntro() {
        return intro;
    }

    /**
     * @param intro the intro to set
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * @return the qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq the qq to set
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return the phonenum
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * @param phonenum the phonenum to set
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }



    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the user_language
     */
    public String getUser_language() {
        return user_language;
    }

    /**
     * @param user_language the user_language to set
     */
    public void setUser_language(String user_language) {
        this.user_language = user_language;
    }

    /**
     * @return the passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport the passport to set
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return the license
     */
    public String getLicense() {
        return license;
    }

    /**
     * @param license the license to set
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
