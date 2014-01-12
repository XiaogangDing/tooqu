/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.ArticleComment;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface ArticleCommentDao {
    public boolean insertArticleComment(ArticleComment articlecomment);
    public ArticleComment getArticleCommentById(long id);
    public boolean deleteArticleComment(ArticleComment articlecomment);
    public List<ArticleComment> getArticleCmtListByArticleId(long ArticleId,int start,int lenth);
    public int getArticleCommentNumber(long atcId);
}
