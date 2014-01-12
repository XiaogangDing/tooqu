/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.ArticleCommentDao;
import com.tooqu.dao.ArticleDao;
import com.tooqu.dao.UserDao;
import com.tooqu.entity.Article;
import com.tooqu.entity.ArticleComment;
import com.tooqu.entity.User;
import com.tooqu.service.ArticleCommentService;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dxg
 */
public class ArticleCommentServiceImpl implements ArticleCommentService{
      private ArticleCommentDao articleCommentDao;
      private ArticleDao articleDao;
      private UserDao userDao;

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public ArticleCommentDao getArticleCommentDao() {
        return articleCommentDao;
    }

    public void setArticleCommentDao(ArticleCommentDao articleCommentDao) {
        this.articleCommentDao = articleCommentDao;
    }
       
    @Override
    public void addComment(long Uid, long atcId, String content) {
        Date date = new Date(System.currentTimeMillis());
        Article article = articleDao.getArticleByIdInitialArticleCommentList(atcId);
        User user = userDao.getUserByIdInitialArticleCommentList(Uid);
        ArticleComment articlecomment = new ArticleComment();
        articlecomment.setArticle(article);
        articlecomment.setCreateTime(date);
        articlecomment.setIsread(false);
        articlecomment.setUser(user);
        articlecomment.setContent(content);
        articleCommentDao.insertArticleComment(articlecomment);
        article.getArticlecommentlist().add(articlecomment);
        user.getArticlecommentlist().add(articlecomment);
        articleDao.update(article);
        userDao.updateUser(user);
    }

    @Override
    public boolean deleteComment(long atcCmtId) {
        ArticleComment articleComment = articleCommentDao.getArticleCommentById(atcCmtId);
        User user = userDao.getUserByIdInitialArticleCommentList(articleComment.getUser().getUserId());
        Article article = articleDao.getArticleByIdInitialArticleCommentList(articleComment.getArticle().getAid());
        user.getArticlecommentlist().remove(articleComment);
        article.getArticlecommentlist().remove(articleComment);
        if(articleCommentDao.deleteArticleComment(articleComment) && userDao.updateUser(user) && articleDao.update(article))
            return true;
        else 
            return false;
    }

    @Override
    public List<ArticleComment> getArticleCmtListById(long atcId, PageContext pageContext) {
        return articleCommentDao.getArticleCmtListByArticleId(atcId, pageContext.getStart(), pageContext.getLength());
    }
    
    @Override
    public int getArticleCommentNumber(long atcId) {
        return articleCommentDao.getArticleCommentNumber(atcId);
    }
}
