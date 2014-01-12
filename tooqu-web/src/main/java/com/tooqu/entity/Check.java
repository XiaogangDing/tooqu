/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Dxg
 */
@Entity
@Table(name="check_user")
public class Check implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long cid;
    private boolean isread;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="from_user")
    private User from;
    
        
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="to_user")
    private User to;

    /**
     * @return the cid
     */
    public long getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(long cid) {
        this.cid = cid;
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
