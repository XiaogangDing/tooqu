/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
/**
 *
 * @author Dxg
 */
@Entity
@Table(name="gift")
public class Gift implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long gid;
    
    private String name;
    private double price;
    private String imgpath;
    private String description;
    private String pingming;
    
    @OneToMany(mappedBy="gift")
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
     private List<SendGift> sendgiftlist; 

    /**
     * @return the gid
     */
    public long getGid() {
        return gid;
    }

    /**
     * @param gid the gid to set
     */
    public void setGid(long gid) {
        this.gid = gid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the imgpath
     */
    public String getImgpath() {
        return imgpath;
    }

    /**
     * @param imgpath the imgpath to set
     */
    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the pingming
     */
    public String getPingming() {
        return pingming;
    }

    /**
     * @param pingming the pingming to set
     */
    public void setPingming(String pingming) {
        this.pingming = pingming;
    }

    /**
     * @return the sendgiftlist
     */
    public List<SendGift> getSendgiftlist() {
        return sendgiftlist;
    }

    /**
     * @param sendgiftlist the sendgiftlist to set
     */
    public void setSendgiftlist(List<SendGift> sendgiftlist) {
        this.sendgiftlist = sendgiftlist;
    }


    
}
