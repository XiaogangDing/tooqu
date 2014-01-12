/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author guo
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "userId", nullable = false)
    private long userId;
    @Column(name = "email",nullable=false)
    private String email;
    private String name;
    private String password;
    private int level;//四个会员等级
    private int type;//0游客 1导游
    private int sex;//0男 1女
    private String portrait;
    @Column(nullable=false)
    private double money;
    private int isAdvance;
    private boolean isActive;

    private String UUID;

    
        
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="userlocation")
    
    private Place location;
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="aid ASC")
    private List<Album> albumlist;        
    
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="article_comment_id ASC")
    private List<ArticleComment> articlecommentlist;    
    
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="aid ASC")
    private List<Article> articlelist;    
    
    @OneToMany(mappedBy="from", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="cid ASC")
    private List<Check> fromlist;  
    
    @OneToMany(mappedBy="to", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="cid ASC")
    private List<Check> tolist;  
    
    @OneToMany(mappedBy="from_user", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="sg_id ASC")
    private List<SendGift> sendgift_fromlist;  
    
    @OneToMany(mappedBy="to_user", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="sg_id ASC")
    private List<SendGift> sendgift_tolist;   
    
    @OneToMany(mappedBy="from", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="vid ASC")
    private List<Visit> visit_fromlist;  
    
    @OneToMany(mappedBy="to", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="vid ASC")
    private List<Visit> visit_tolist;   
    
    
    @OneToMany(mappedBy="from", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="mid ASC")
    private List<Message> msg_fromlist;  
    
    @OneToMany(mappedBy="to", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="mid ASC")
    private List<Message> msg_tolist;   
    
    @OneToMany(mappedBy="from", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="id ASC")
    private List<Report> report_fromlist;  
    
    @OneToMany(mappedBy="to", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="id ASC")
    private List<Report> report_tolist;   
    
    @OneToMany(mappedBy="from", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="ac_id ASC")
    private List<AccompanyComment> aclist; 
     
    @OneToMany(mappedBy="creator_user", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="aid ASC")
    private List<Accompany> accompanylist; 

    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="id ASC")
    private List<AccompanyParticipateRecord> recordlist;
    
     @OneToOne(mappedBy="user")
     @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    private UserInfo uinfo;
    
    @OneToOne(mappedBy="user")
     @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    private UserAuthority uauthority;
    
    @ManyToMany(fetch = FetchType.LAZY)   
     @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinTable(name="follow", joinColumns={@JoinColumn(name="follow_uid")},  
	 inverseJoinColumns={@JoinColumn(name="followed_id")})   
    private List<User> followlist;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy="followlist")  
     @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<User> followerlist;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy="userlist")  
     @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Accompany> follow_accompanylist;
    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the level #四个会员等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the type 0游客 1导游
     */
    public int getType() {
        return type;
    }
    
    public String getTypeStr() {
        switch (type) {
            case 0:

                return "游客";
            case 1:

                return "导游";
                
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
     * @return the sex 0男 1女
     */
    public int getSex() {
        return sex;
    }
    
    public String getSexStr() {
        switch(sex){
            case 0:
                return "男";
            case 1:
                return "女";
        }
        return "";
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * @return the portrait
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * @param portrait the portrait to set
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    /**
     * @return the money
     */
    public double getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * @return the isAdvance #0非高端趣有 #1未审 #2已审
     */
    public int getIsAdvance() {
        return isAdvance;
    }

    /**
     * @param isAdvance the isAdvance to set
     */
    public void setIsAdvance(int isAdvance) {
        this.isAdvance = isAdvance;
    }

    /**
     * @return the albumlist
     */
    public List<Album> getAlbumlist() {
        if(albumlist==null)
            return new LinkedList<Album>();
        return albumlist;
    }

    /**
     * @param albumlist the albumlist to set
     */
    public void setAlbumlist(List<Album> albumlist) {
        this.albumlist = albumlist;
    }

    /**
     * @return the uinfo
     */
    public UserInfo getUinfo() {
        return uinfo;
    }

    /**
     * @param uinfo the uinfo to set
     */
    public void setUinfo(UserInfo uinfo) {
        this.uinfo = uinfo;
    }

    /**
     * @return the uauthority
     */
    public UserAuthority getUauthority() {
        return uauthority;
    }

    /**
     * @param uauthority the uauthority to set
     */
    public void setUauthority(UserAuthority uauthority) {
        this.uauthority = uauthority;
    }

    /**
     * @return the followlist
     */
    public List<User> getFollowlist() {
       if(followlist==null)
            return new LinkedList<User>();
        return followlist;
    }

    /**
     * @param followlist the followlist to set
     */
    public void setFollowlist(List<User> followlist) {
        this.followlist = followlist;
    }

    /**
     * @return the followerlist
     */
    public List<User> getFollowerlist() {
        if(followerlist==null)
            return new LinkedList<User>();
        return followerlist;
    }

    /**
     * @param followerlist the followerlist to set
     */
    public void setFollowerlist(List<User> followerlist) {
        this.followerlist = followerlist;
    }

    /**
     * @return the location
     */
    public Place getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Place location) {
        this.location = location;
    }

    /**
     * @return the articlecommentlist
     */
    public List<ArticleComment> getArticlecommentlist() {
        return articlecommentlist;
    }

    /**
     * @param articlecommentlist the articlecommentlist to set
     */
    public void setArticlecommentlist(List<ArticleComment> articlecommentlist) {
        this.articlecommentlist = articlecommentlist;
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
     * @return the fromlist
     */
    public List<Check> getFromlist() {
        return fromlist;
    }

    /**
     * @param fromlist the fromlist to set
     */
    public void setFromlist(List<Check> fromlist) {
        this.fromlist = fromlist;
    }

    /**
     * @return the tolist
     */
    public List<Check> getTolist() {
        return tolist;
    }

    /**
     * @param tolist the tolist to set
     */
    public void setTolist(List<Check> tolist) {
        this.tolist = tolist;
    }

    /**
     * @return the sendgift_fromlist
     */
    public List<SendGift> getSendgift_fromlist() {
        return sendgift_fromlist;
    }

    /**
     * @param sendgift_fromlist the sendgift_fromlist to set
     */
    public void setSendgift_fromlist(List<SendGift> sendgift_fromlist) {
        this.sendgift_fromlist = sendgift_fromlist;
    }

    /**
     * @return the sendgift_tolist
     */
    public List<SendGift> getSendgift_tolist() {
        return sendgift_tolist;
    }

    /**
     * @param sendgift_tolist the sendgift_tolist to set
     */
    public void setSendgift_tolist(List<SendGift> sendgift_tolist) {
        this.sendgift_tolist = sendgift_tolist;
    }

    /**
     * @return the visit_fromlist
     */
    public List<Visit> getVisit_fromlist() {
        return visit_fromlist;
    }

    /**
     * @param visit_fromlist the visit_fromlist to set
     */
    public void setVisit_fromlist(List<Visit> visit_fromlist) {
        this.visit_fromlist = visit_fromlist;
    }

    /**
     * @return the visit_tolist
     */
    public List<Visit> getVisit_tolist() {
        return visit_tolist;
    }

    /**
     * @param visit_tolist the visit_tolist to set
     */
    public void setVisit_tolist(List<Visit> visit_tolist) {
        this.visit_tolist = visit_tolist;
    }

    /**
     * @return the msg_fromlist
     */
    public List<Message> getMsg_fromlist() {
        return msg_fromlist;
    }

    /**
     * @param msg_fromlist the msg_fromlist to set
     */
    public void setMsg_fromlist(List<Message> msg_fromlist) {
        this.msg_fromlist = msg_fromlist;
    }

    /**
     * @return the msg_tolist
     */
    public List<Message> getMsg_tolist() {
        return msg_tolist;
    }

    /**
     * @param msg_tolist the msg_tolist to set
     */
    public void setMsg_tolist(List<Message> msg_tolist) {
        this.msg_tolist = msg_tolist;
    }

    /**
     * @return the report_fromlist
     */
    public List<Report> getReport_fromlist() {
        return report_fromlist;
    }

    /**
     * @param report_fromlist the report_fromlist to set
     */
    public void setReport_fromlist(List<Report> report_fromlist) {
        this.report_fromlist = report_fromlist;
    }

    /**
     * @return the report_tolist
     */
    public List<Report> getReport_tolist() {
        return report_tolist;
    }

    /**
     * @param report_tolist the report_tolist to set
     */
    public void setReport_tolist(List<Report> report_tolist) {
        this.report_tolist = report_tolist;
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
     * @return the accompanylist
     */
    public List<Accompany> getAccompanylist() {
        return accompanylist;
    }

    /**
     * @param accompanylist the accompanylist to set
     */
    public void setAccompanylist(List<Accompany> accompanylist) {
        this.accompanylist = accompanylist;
    }

    /**
     * @return the follow_accompanylist
     */
    public List<Accompany> getFollow_accompanylist() {
        return follow_accompanylist;
    }

    /**
     * @param follow_accompanylist the follow_accompanylist to set
     */
    public void setFollow_accompanylist(List<Accompany> follow_accompanylist) {
        this.follow_accompanylist = follow_accompanylist;
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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
    
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}