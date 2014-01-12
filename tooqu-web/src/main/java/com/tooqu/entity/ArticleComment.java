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
@Table(name="article_comment")
public class ArticleComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long article_comment_id;
    private Date createTime;
    private String content;
    private boolean isread;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="article")
    private Article article;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="comment_owner")
    private User user;

    /**
     * @return the article_comment_id
     */
    public long getArticle_comment_id() {
        return article_comment_id;
    }

    /**
     * @param article_comment_id the article_comment_id to set
     */
    public void setArticle_comment_id(long article_comment_id) {
        this.article_comment_id = article_comment_id;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * @return the article
     */
    public Article getArticle() {
        return article;
    }

    /**
     * @param article the article to set
     */
    public void setArticle(Article article) {
        this.article = article;
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
    
}
