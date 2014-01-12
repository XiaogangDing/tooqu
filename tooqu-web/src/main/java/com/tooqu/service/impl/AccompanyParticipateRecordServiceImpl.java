/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.dao.AccompanyParticipateRecordDao;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyParticipateRecord;
import com.tooqu.service.AccompanyParticipateRecordService;
import java.util.List;

/**
 *
 * @author Dxg
 */
public class AccompanyParticipateRecordServiceImpl implements AccompanyParticipateRecordService{
    private AccompanyParticipateRecordDao aprDao;

    public AccompanyParticipateRecordDao getAprDao() {
        return aprDao;
    }

    public void setAprDao(AccompanyParticipateRecordDao aprDao) {
        this.aprDao = aprDao;
    }

    @Override
    public boolean addAccompanyParticipateRecord(AccompanyParticipateRecord apr) {
        boolean result=false;
        if(!aprDao.isExist(apr))
        {
        aprDao.insertAPR(apr);
        result=true;
        }
        return result;
    }
    @Override
    public List<AccompanyParticipateRecord> getAPRListByAcc(Accompany ac) {
        return aprDao.getAPRListByAcc(ac);
    }

    @Override
    public boolean containUser(List<AccompanyParticipateRecord> aprlist, long userId) {
       boolean result=false;
       for(int i=0;i<aprlist.size();++i)
       {
          if(aprlist.get(i).getUser().getUserId()==userId)
              result=true;  
    }
    return result;
    
}
}
