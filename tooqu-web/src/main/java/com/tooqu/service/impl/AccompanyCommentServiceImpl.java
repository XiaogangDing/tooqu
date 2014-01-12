/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.AccompanyCommentDao;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyComment;
import com.tooqu.service.AccompanyCommentService;
import java.util.List;

/**
 *
 * @author Dxg
 */
public class AccompanyCommentServiceImpl implements AccompanyCommentService{
    private AccompanyCommentDao accompanyCommentDao;

    public AccompanyCommentDao getAccompanyCommentDao() {
        return accompanyCommentDao;
    }

    public void setAccompanyCommentDao(AccompanyCommentDao accompanyCommentDao) {
        this.accompanyCommentDao = accompanyCommentDao;
    }

    @Override
    public void addComment(AccompanyComment act) {
        accompanyCommentDao.insertAccompanyComment(act);
    }

    @Override
    public AccompanyComment findAccompanyCmtById(long id) {
        return accompanyCommentDao.findAccompanyCmtById(id);
    }

    @Override
    public boolean deleteComment(AccompanyComment act) {
       return accompanyCommentDao.deleteAccompanyComment(act);
    }

    @Override
    public List<AccompanyComment> getAccCmtListByAcc(Accompany ac) {
       return accompanyCommentDao.getAccCmtListByAcc(ac);
    }

    @Override
    public List<AccompanyComment> getAccCmtListByAcc(Accompany acc, PageContext pagecontext) {
        return accompanyCommentDao.getAccCmtListByAcc(acc,pagecontext.getStart(),pagecontext.getLength());
    }
    
}
