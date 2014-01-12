/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.mailer.MailSender;
import com.tooqu.entity.MailTemplate;
import com.tooqu.dao.MailTemplateDao;
import com.tooqu.service.MailSenderService;
import com.tooqu.exception.SendMailException;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;

/**
 *
 * @author guo
 */
public class MailSenderServiceImpl implements MailSenderService {

    private MailTemplateDao mailTemplateDao;
    
    private MailSender mailSender;

    public MailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public MailTemplateDao getMailTemplateDao() {
        return mailTemplateDao;
    }

    public void setMailTemplateDao(MailTemplateDao mailTemplateDao) {
        this.mailTemplateDao = mailTemplateDao;
    }
    private Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);

    @Override
    public void sendMail(String receiver, String mailName, Map<String, String> args) throws SendMailException {
        if (receiver == null || receiver.isEmpty() || mailName == null || mailName.isEmpty() || args == null) {
            throw new SendMailException("Illegal arguments", new IllegalArgumentException());
        }
        if (!emailPattern.matcher(receiver).matches()) {
            throw new SendMailException("Invalid email address", new IllegalArgumentException());
        }
        try {
            MailTemplate template = mailTemplateDao.getTemplate(mailName);
            if (template == null) {
                throw new SendMailException("Mail name not exists!");
            }
            // check requried fields
            JSONArray requiredFields = new JSONArray(template.getRequiredFields());
            for (int i = 0; i < requiredFields.length(); i++) {
                if (!args.containsKey(requiredFields.getString(i))) {
                    String errmsg = "Missing required field " + requiredFields.getString(i) + " for " + mailName;
                    throw new SendMailException(errmsg);
                }
            }
            String content = compose(template.getTemplate(), args);
            String subject = compose(template.getSubject(), args);
            mailSender.send("noreply@tooqu.com", receiver, subject, content);
        } catch (Exception ex) {
            throw new SendMailException("Service unavailable", ex);
        }

    }

    private String compose(String template, Map<String, String> args) {
        if (template == null) {
            return null;
        }
        if (args == null) {
            return template;
        }
        for (Map.Entry<String, String> entry : args.entrySet()) {
            if (entry.getValue() == null) {
            }
            template = template.replace(String.format("${%s}", entry.getKey()), entry.getValue() == null ? "" : entry.getValue());
        }
        template = template.replaceAll("\\$\\{(.+)\\}", "");
        return template;
    }
}
