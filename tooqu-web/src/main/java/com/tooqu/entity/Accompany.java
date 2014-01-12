/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="accompany")
public class Accompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long aid;
    
    private String name;
    private int type;//自助游、自驾游、登山、徒步、跟团
    private int accType;//需要导游/伴游方式：多日陪同，当日
    private int accSex;
    private Date deadline;
    private Timestamp createTime;
    private Date travelTime;
    private int travelduration;
    private boolean isReview;
    private int accountAmount;
    private String accAge;
    private String accHeight;
    private String accWeight;
    private String accEducation;//大专，本科，硕士，博士，不限
    private String accLanguage;
    private String accPassport;
    private String accLicense;
    private String accPick;//是否需要接机/接站
    private String accCar;//是否需要备车
    private String remark;
    private String feeType;//费用支付时间及方式：网站担保，活动前支付，活动后支付
    private String businessRequirement;//商务公关要求
    private int authority;//0 任何人 1 VIP会员1级可见  2 VIP会员2级可见 3 VIP会员3级可见

   
    
    @OneToMany(mappedBy="accompany", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="ac_id ASC")
    private List<AccompanyComment> aclist; 
     
    @OneToMany(mappedBy="accompany", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="id ASC")
    private List<AccompanyParticipateRecord> recordlist;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="ceator_user")   
    private User creator_user;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="destination")   
    private Place destination;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="departure_place")   
    private Place departure;    

    @ManyToMany()
     @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name="follow_accompany", joinColumns={@JoinColumn(name="ac_id")},  
	 inverseJoinColumns={@JoinColumn(name="user_id")})   
    private List<User> userlist;

    /**
     * @return the aid
     */
    public long getAid() {
        return aid;
    }

    /**
     * @param aid the aid to set
     */
    public void setAid(long aid) {
        this.aid = aid;
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
     * @return the type
     */
    public int getType() {
        return type;
    }
    
    public String getTypeStr(){
        switch(type){
            case 0:
                return "自助游";
            case 1:
                return "自驾游";
            case 2:
                return "登山";
            case 3:
                return "徒步";
            case 4:
                return "跟团";
        }
        return "";
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the accType
     */
    public int getAccType() {
        return accType;
    }
    
    public String getAccTypeStr(){
        switch(accType){
            case 0:
                return "多日陪同";
            case 1:
                return "当日";
        }
        return "";
    }

    /**
     * @param accType the accType to set
     */
    public void setAccType(int accType) {
        this.accType = accType;
    }

    /**
     * @return the accSex
     */
    public int getAccSex() {
        return accSex;
    }
    
    public String getAccSexStr() {
        switch(accSex){
            case 0:
                return "男";
            case 1:
                return "女";
        }
        return "";
    }

    /**
     * @param accSex the accSex to set
     */
    public void setAccSex(int accSex) {
        this.accSex = accSex;
    }

    /**
     * @return the deadline
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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
     * @return the travelTime
     */
    public Date getTravelTime() {
        return travelTime;
    }

    /**
     * @param travelTime the travelTime to set
     */
    public void setTravelTime(Date travelTime) {
        this.travelTime = travelTime;
    }

    /**
     * @return the isReview
     */
    public boolean isIsReview() {
        return isReview;
    }

    /**
     * @param isReview the isReview to set
     */
    public void setIsReview(boolean isReview) {
        this.isReview = isReview;
    }

    /**
     * @return the accountAmount
     */
    public int getAccountAmount() {
        return accountAmount;
    }

    /**
     * @param accountAmount the accountAmount to set
     */
    public void setAccountAmount(int accountAmount) {
        this.accountAmount = accountAmount;
    }

    /**
     * @return the accAge
     */
    public String getAccAge() {
        return accAge;
    }

    /**
     * @param accAge the accAge to set
     */
    public void setAccAge(String accAge) {
        this.accAge = accAge;
    }

    /**
     * @return the accHeight
     */
    public String getAccHeight() {
        return accHeight;
    }

    /**
     * @param accHeight the accHeight to set
     */
    public void setAccHeight(String accHeight) {
        this.accHeight = accHeight;
    }

    /**
     * @return the accWeight
     */
    public String getAccWeight() {
        return accWeight;
    }

    /**
     * @param accWeight the accWeight to set
     */
    public void setAccWeight(String accWeight) {
        this.accWeight = accWeight;
    }

    /**
     * @return the accEducation
     */
    public String getAccEducation() {
        return accEducation;
    }

    /**
     * @param accEducation the accEducation to set
     */
    public void setAccEducation(String accEducation) {
        this.accEducation = accEducation;
    }

    /**
     * @return the accPassport
     */
    public String getAccPassport() {
        return accPassport;
    }

    /**
     * @param accPassport the accPassport to set
     */
    public void setAccPassport(String accPassport) {
        this.accPassport = accPassport;
    }

    /**
     * @return the accLicense
     */
    public String getAccLicense() {
        return accLicense;
    }

    /**
     * @param accLicense the accLicense to set
     */
    public void setAccLicense(String accLicense) {
        this.accLicense = accLicense;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the aclist
     */
    public List<AccompanyComment> getAclist() {
        return aclist;
    }

    /**
     * @param aclist the aclist to set
     */
    public void setAclist(List<AccompanyComment> aclist) {
        this.aclist = aclist;
    }

    /**
     * @return the creator_user
     */
    public User getCreator_user() {
        return creator_user;
    }

    /**
     * @param creator_user the creator_user to set
     */
    public void setCreator_user(User creator_user) {
        this.creator_user = creator_user;
    }

    /**
     * @return the destination
     */
    public Place getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Place destination) {
        this.destination = destination;
    }

    /**
     * @return the departure
     */
    public Place getDeparture() {
        return departure;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(Place departure) {
        this.departure = departure;
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
     * @return the recordlist
     */
    public List<AccompanyParticipateRecord> getRecordlist() {
        return recordlist;
    }

    /**
     * @param recordlist the recordlist to set
     */
    public void setRecordlist(List<AccompanyParticipateRecord> recordlist) {
        this.recordlist = recordlist;
    }

    /**
     * @return the travelduration
     */
    public int getTravelduration() {
        return travelduration;
    }

    /**
     * @param travelduration the travelduration to set
     */
    public void setTravelduration(int travelduration) {
        this.travelduration = travelduration;
    }
    
      public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getBusinessRequirement() {
        return businessRequirement;
    }

    public void setBusinessRequirement(String businessRequirement) {
        this.businessRequirement = businessRequirement;
    }
    public String getAccLanguage() {
        return accLanguage;
    }

    public void setAccLanguage(String accLanguage) {
        this.accLanguage = accLanguage;
    }

    




    
    public String getAccPick() {
        return accPick;
    }

    public void setAccPick(String accPick) {
        this.accPick = accPick;
    }

    public String getAccCar() {
        return accCar;
    }

    public void setAccCar(String accCar) {
        this.accCar = accCar;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }
}
