/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.ArticleDao;
import com.tooqu.entity.Article;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface ArticleService {
    
    public ArticleDao getArticleDao();

    public List<Article> getArticleListByPage(long theUserId, PageContext pageContext);

    public boolean createArticle(long userId, String title, String content, int authority);

    public Article findArticleById(long atcId);

    public boolean deleteArticle(Article atc);

    public boolean modifyArticle(long atcId, String title, String content, int authority);
    
    public boolean releaseArticle(long atcId);
}
