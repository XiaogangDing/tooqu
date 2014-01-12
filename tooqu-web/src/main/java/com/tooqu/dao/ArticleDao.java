/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Article;
import com.tooqu.entity.User;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface ArticleDao {
   
    public Article getArticleByIdInitialArticleCommentList(long aid);
    public Article getArticleById(long aid);
    public boolean update(Article article);
    public boolean insertArticle(Article article);
    public boolean delete(Article article);
    public List<Article> getArticleListByUserId(long uid,int start,int length);
    public long getArticleId(long user_id, String title, String content);
}
