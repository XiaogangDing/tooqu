/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
/**
 *
 * @author Dxg
 */
@Entity
@Table(name="send_gift")
public class SendGift implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long sg_id;
    
    private String content;
    private Date time;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="from_user")
    private User from_user;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="to_user")
    private User to_user;
    
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="gift")
    private Gift gift;

    /**
     * @return the sg_id
     */
    public long getSg_id() {
        return sg_id;
    }

    /**
     * @param sg_id the sg_id to set
     */
    public void setSg_id(long sg_id) {
        this.sg_id = sg_id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }

    public User getFrom_user() {
        return from_user;
    }

    public void setFrom_user(User from_user) {
        this.from_user = from_user;
    }

    public User getTo_user() {
        return to_user;
    }

    public void setTo_user(User to_user) {
        this.to_user = to_user;
    }

    /**
     * @return the gift
     */
    public Gift getGift() {
        return gift;
    }

    /**
     * @param gift the gift to set
     */
    public void setGift(Gift gift) {
        this.gift = gift;
    }
    
    

}
