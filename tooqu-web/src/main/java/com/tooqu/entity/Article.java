/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="article")
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long aid;
    private String title;
    private String content;
    private int authority;
    private boolean isReview;
    private boolean isRelease;
    private Date createtime;
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="article_destination")
    private Place destination;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="article_ower")
    private User user;

    @OneToMany(mappedBy="article", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="article_comment_id ASC")
    private List<ArticleComment> articlecommentlist;    
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
     * @return the isRelease
     */
    public boolean isIsRelease() {
        return isRelease;
    }

    /**
     * @param isRelease the isRelease to set
     */
    public void setIsRelease(boolean isRelease) {
        this.isRelease = isRelease;
    }

    /**
     * @return the createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime the createtime to set
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
    
    
    
}
