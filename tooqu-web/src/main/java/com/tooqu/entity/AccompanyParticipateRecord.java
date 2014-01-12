/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
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
@Table(name="accompany_user")
public class AccompanyParticipateRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private int number;
    private String remark;

    
 
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="participate_user")   
    private User user;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="accompany")   
    private Accompany accompany;



    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
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

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
