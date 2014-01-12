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
@Table(name="message")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long mid;
    private String content; 
    private boolean isread;
    private Date sendtime;

        
     @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="from_user")
    private User from;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="to_user")
    private User to;

    /**
     * @return the mid
     */
    public long getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(long mid) {
        this.mid = mid;
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
     * @return the isread
     */
    public boolean isIsread() {
        return isread;
    }

    /**
     * @param isread the isread to set
     */
    public void setIsread(boolean isread) {
        this.isread = isread;
    }

    /**
     * @return the sendtime
     */
    public Date getSendtime() {
        return sendtime;
    }

    /**
     * @param sendtime the sendtime to set
     */
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    /**
     * @return the from
     */
    public User getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(User from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public User getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(User to) {
        this.to = to;
    }
    
}
