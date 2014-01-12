/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Accompany;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface AccompanyDao {
    public boolean insertAccompany(Accompany acc);//增
    public boolean deleteAccompany(Accompany acc);//删 implement
    public boolean updateAccompany(Accompany acc);//更新
    public Accompany getAccompanyById(long id);//按id查找 implement
    public Accompany getAccompany(Accompany ac);
    public List<Accompany> getAccompanyByName(String ac_name);//已经对accompany.user初始化
    public List<Accompany> listAccompanyByPage(int start,int length);//分页查找（默认当前）
    
    public List<Accompany> listAccompanyByPlace(Place  startPlace,Place desPlace,int start,int length);//出发地,目的地分页查找(默认当前)

   

    
    
}
