/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.MailTemplate;
import java.util.List;

/**
 *
 * @author guo
 */
public interface MailTemplateDao {

    void createTemplate(String name, String subject, String template, List<String> requiredFields, String creator);

    void updateTemplate(String name, String subject, String template, List<String> requiredFields);

    void deleteTemplate(String name);

    MailTemplate getTemplate(String name);

    List<MailTemplate> listTemplates(PageContext page);
}
