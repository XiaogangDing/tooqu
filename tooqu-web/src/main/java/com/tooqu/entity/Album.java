/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;


import java.io.Serializable;
import java.util.LinkedList;
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
@Table(name="album")
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue
    private long aid;
    private String imgpath;
    private String content;
    private String title;
    private int authority;
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="albumowner")
    private User user;
    
    @OneToMany(mappedBy="album", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="pid ASC")
    private List<Picture> picturelist;  

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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the authority
     */
    public int getAuthority() {
        return authority;
    }

    /**
     * @param authority the authority to set
     */
    public void setAuthority(int authority) {
        this.authority = authority;
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
     * @return the picturelist
     */
    public List<Picture> getPicturelist() {
        if(picturelist==null)
            return new LinkedList<Picture>();
        return picturelist;
    }

    /**
     * @param picturelist the picturelist to set
     */
    public void setPicturelist(List<Picture> picturelist) {
        this.picturelist = picturelist;
    }
}
