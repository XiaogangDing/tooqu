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
@Table(name="visit")
public class Visit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long vid;
    private Date visitTime;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="from_user")
    private User from;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="to_user")
    private User to;

    /**
     * @return the vid
     */
    public long getVid() {
        return vid;
    }

    /**
     * @param vid the vid to set
     */
    public void setVid(long vid) {
        this.vid = vid;
    }

    /**
     * @return the visitTime
     */
    public Date getVisitTime() {
        return visitTime;
    }

    /**
     * @param visitTime the visitTime to set
     */
    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
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
