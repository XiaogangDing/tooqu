/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyComment;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface AccompanyCommentService {
    public void addComment(AccompanyComment act);
    public AccompanyComment findAccompanyCmtById(long id);
    public boolean deleteComment(AccompanyComment act);
    public List<AccompanyComment> getAccCmtListByAcc(Accompany ac);
    public   List<AccompanyComment> getAccCmtListByAcc(Accompany acc,PageContext pagecontext);
}
