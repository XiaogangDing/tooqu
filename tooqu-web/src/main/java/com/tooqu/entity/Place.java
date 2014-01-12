/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.hibernate.annotations.Cascade;

import java.util.List;

/**
 *
 * @author Dxg
 */
@Entity
@Table(name="place")
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long pid;
    private String country;
    private String province;
    private String city;
    private String county;
    private String picture_path;
    private boolean iscapital;
    @OneToMany(mappedBy="destination")
    @OrderBy(value="aid ASC")
    private List<Article> articlelist;
    @OneToMany(mappedBy="location")
    @OrderBy(value="userId ASC")
    private List<User> userlist;
    
    @OneToMany(mappedBy="destination")
    @OrderBy(value="aid ASC")
    private List<Accompany> accompany_tolist;    
    
    @OneToMany(mappedBy="departure")
    @OrderBy(value="aid ASC")
    private List<Accompany> accompany_fromlist;    
    
    
    /**
     * @return the pid
     */
    public long getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(long pid) {
        this.pid = pid;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }


    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the articlelist
     */
    public List<Article> getArticlelist() {
        return articlelist;
    }

    /**
     * @param articlelist the articlelist to set
     */
    public void setArticlelist(List<Article> articlelist) {
        this.articlelist = articlelist;
    }

    /**
     * @return the userlist
     */
    public List<User> getUserlist() {
        return userlist;
    }

    /**
     * @param userlist the userlist to set
     */
    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    /**
     * @return the accompany_tolist
     */
    public List<Accompany> getAccompany_tolist() {
        return accompany_tolist;
    }

    /**
     * @param accompany_tolist the accompany_tolist to set
     */
    public void setAccompany_tolist(List<Accompany> accompany_tolist) {
        this.accompany_tolist = accompany_tolist;
    }

    /**
     * @return the accompany_fromlist
     */
    public List<Accompany> getAccompany_fromlist() {
        return accompany_fromlist;
    }

    /**
     * @param accompany_fromlist the accompany_fromlist to set
     */
    public void setAccompany_fromlist(List<Accompany> accompany_fromlist) {
        this.accompany_fromlist = accompany_fromlist;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return the iscapital
     */
    public boolean isIscapital() {
        return iscapital;
    }

    /**
     * @param iscapital the iscapital to set
     */
    public void setIscapital(boolean iscapital) {
        this.iscapital = iscapital;
    }

    /**
     * @return the picture_path
     */
    public String getPicture_path() {
        return picture_path;
    }

    /**
     * @param picture_path the picture_path to set
     */
    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }


}
