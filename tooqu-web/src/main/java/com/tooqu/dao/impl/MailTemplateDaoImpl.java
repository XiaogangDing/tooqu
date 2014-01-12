/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.MailTemplate;
import com.tooqu.dao.MailTemplateDao;
import java.util.List;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author guo
 */
public class MailTemplateDaoImpl extends HibernateDaoSupport implements MailTemplateDao{
    
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void createTemplate(String name, String subject, String template, List<String> requiredFields, String creator) {
    }

    @Override
    public void updateTemplate(String name, String subject, String template, List<String> requiredFields) {
    }

    @Override
    public void deleteTemplate(String name) {
    }

    @Override
    public MailTemplate getTemplate(String name) {
        return null;
    }

    @Override
    public List<MailTemplate> listTemplates(PageContext page) {
        return null;
    }
    
}
