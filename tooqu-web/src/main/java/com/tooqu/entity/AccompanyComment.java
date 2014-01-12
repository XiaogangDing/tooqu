/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name="accompany_comment")
public class AccompanyComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long ac_id;
    private String content;
    private Timestamp createTime;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="from_user")   
    private User from;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="accomment")   
    private Accompany accompany;
    /**
     * @return the ac_id
     */
    public long getAc_id() {
        return ac_id;
    }

    /**
     * @param ac_id the ac_id to set
     */
    public void setAc_id(long ac_id) {
        this.ac_id = ac_id;
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
     * @return the createTime
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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
     * @return the accompany
     */
    public Accompany getAccompany() {
        return accompany;
    }

    /**
     * @param accompany the accompany to set
     */
    public void setAccompany(Accompany accompany) {
        this.accompany = accompany;
    }
    
}
