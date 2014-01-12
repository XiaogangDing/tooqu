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
import com.tooqu.service.ArticleService;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dxg
 */
public class ArticleServiceImpl implements ArticleService{
    private ArticleDao articleDao;
    private UserDao userDao;
    private ArticleCommentDao articleCommentDao;

    public ArticleCommentDao getArticleCommentDao() {
        return articleCommentDao;
    }

    public void setArticleCommentDao(ArticleCommentDao articleCommentDao) {
        this.articleCommentDao = articleCommentDao;
    }
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
    @Override
    public List<Article> getArticleListByPage(long theUserId, PageContext pageContext) {
       return articleDao.getArticleListByUserId(theUserId,pageContext.getStart(),pageContext.getLength());
    }

    @Override
    public boolean createArticle(long userId, String title, String content, int authority) {
        Article article=new Article();
        User user=userDao.getUserById(userId);
        article.setUser(user);
        article.setTitle(title);
        article.setContent(content);
        article.setAuthority(authority);
        Date date=new Date(System.currentTimeMillis());
       System.out.println("+++++"+date);
        article.setCreatetime(date);
        return articleDao.insertArticle(article);
    }

    @Override
    public Article findArticleById(long atcId) {
        //是否需要inital comment?
        //初始化文章评论和用户
      return articleDao.getArticleByIdInitialArticleCommentList(atcId);
    }

    @Override
    public boolean deleteArticle(Article atc) {
        //删除文章中的所有图片
        
        //
        List<ArticleComment> list=atc.getArticlecommentlist();
        for(int i=0;i<list.size();++i)
        {
           
            User user=userDao.getUserByIdInitialArticleCommentList(list.get(i).getUser().getUserId());
            user.getArticlecommentlist().remove(list.get(i));
            articleCommentDao.deleteArticleComment(list.get(i));
            userDao.updateUser(user);
        }
        atc.getArticlecommentlist().clear();
        User user=userDao.getUserByIdInitialArticleList(atc.getUser().getUserId());
        user.getArticlelist().remove(atc);
        userDao.updateUser(user);
        return articleDao.delete(atc);
    }

    @Override
    public boolean modifyArticle(long atcId, String title, String content, int authority) {
        Article article=articleDao.getArticleById(atcId);
        article.setAuthority(authority);
        article.setTitle(title);
        article.setContent(content);
        article.setCreatetime(new Date(System.currentTimeMillis()));
        return articleDao.update(article);
    }

    @Override
    public boolean releaseArticle(long atcId) {
        Article article = articleDao.getArticleById(atcId);
        article.setIsRelease(true);
        return articleDao.update(article);
    }
}
