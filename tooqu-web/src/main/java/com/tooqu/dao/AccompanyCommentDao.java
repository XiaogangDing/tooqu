/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyComment;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface AccompanyCommentDao {
    public void insertAccompanyComment(AccompanyComment comment);//插入评论     implement
    public boolean deleteAccompanyComment(AccompanyComment comment);//删除评论  implement
    public AccompanyComment findAccompanyCmtById(long id);//implement
    public List<AccompanyComment> getAccCmtListByAcc(Accompany ac);//implement
    public List<AccompanyComment> getAccCmtListByAcc(Accompany ac,int start,int length);
}
