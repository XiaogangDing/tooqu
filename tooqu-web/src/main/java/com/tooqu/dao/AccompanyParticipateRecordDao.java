/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyParticipateRecord;
import java.util.List;

/**
 *
 * @author hao
 */
public interface AccompanyParticipateRecordDao {
    public boolean isExist(AccompanyParticipateRecord apr);
    public void insertAPR(AccompanyParticipateRecord apr);//implement
    public List<AccompanyParticipateRecord> getAPRListByAcc(Accompany ac);//implement
}
