/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="local_travel_record")
public class LocalTravelParticipateRecord {
    @Id
    @GeneratedValue
    private long id;
    private String orderinfo;
    private int number;
    private boolean isSuccess;
    private int feetype;
    private Timestamp createTime;
    private Timestamp startTime;
    private Timestamp endTime;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="participator")
    
    private User  participator;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="localtravel")
    
    private LocalTravel  localtravel;

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

    /**
     * @return the orderinfo
     */
    public String getOrderinfo() {
        return orderinfo;
    }

    /**
     * @param orderinfo the orderinfo to set
     */
    public void setOrderinfo(String orderinfo) {
        this.orderinfo = orderinfo;
    }

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
     * @return the isSuccess
     */
    public boolean isIsSuccess() {
        return isSuccess;
    }

    /**
     * @param isSuccess the isSuccess to set
     */
    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * @return the feetype
     */
    public int getFeetype() {
        return feetype;
    }

    /**
     * @param feetype the feetype to set
     */
    public void setFeetype(int feetype) {
        this.feetype = feetype;
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
     * @return the startTime
     */
    public Timestamp getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Timestamp getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the participator
     */
    public User getParticipator() {
        return participator;
    }

    /**
     * @param participator the participator to set
     */
    public void setParticipator(User participator) {
        this.participator = participator;
    }

    /**
     * @return the localtravel
     */
    public LocalTravel getLocaltravel() {
        return localtravel;
    }

    /**
     * @param localtravel the localtravel to set
     */
    public void setLocaltravel(LocalTravel localtravel) {
        this.localtravel = localtravel;
    }
    
    
    
}
