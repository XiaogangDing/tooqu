/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.Place;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface AccompanyService {
    public List<Accompany> getExistAccompanyList(Place from,Place to);
    public boolean addAccompany(Accompany ac);
    public Accompany findAccompanyByAccompany(Accompany ac);
    public Accompany findAccompanyById(long ac_id);
    public boolean deleteAccompany(Accompany ac);
    public boolean containUser(long accId,long userId);
    
    public List<Accompany> getSearchAccompanyByPage(Place from,Place to,PageContext page);
     public List<Accompany> getAccompanyListByPage(PageContext page);//所有的分页

    public boolean modifyAccompany(Accompany temp);

    public long getAccompanyId(Accompany temp);

}
