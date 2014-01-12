/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.mailer;

import java.util.Properties;
import javax.mail.Session;

/**
 *
 * @author guo
 */
public class LocalMailSender extends MailSender {

    @Override
    protected Session createSession() {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "localhost");
        Session mailSession = Session.getInstance(props);
        return mailSession;
    }
}
