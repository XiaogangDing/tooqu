/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.ArticleComment;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface ArticleCommentService {

    public void addComment(long Uid, long atcId, String content);

    public boolean deleteComment(long atcCmtId);

    public List<ArticleComment> getArticleCmtListById(long atcId, PageContext pageContext);
    
    public int getArticleCommentNumber(long atcId);
}
