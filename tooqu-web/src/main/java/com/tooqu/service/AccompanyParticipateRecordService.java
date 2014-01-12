/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyParticipateRecord;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface AccompanyParticipateRecordService {
    public boolean addAccompanyParticipateRecord(AccompanyParticipateRecord apr);
    public List<AccompanyParticipateRecord> getAPRListByAcc(Accompany ac);
    public boolean containUser(List<AccompanyParticipateRecord> aprlist,long userId);
}
