package com.tooqu.mailer;

import java.util.List;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Guo
 */
public abstract class MailSender {

    abstract protected Session createSession();

    public void send(final String from, final String to,
            final String subject, final String body) throws NoSuchProviderException, MessagingException {
        Session mailSession = createSession();
        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void sendHtml(final String from, final String to,
            final String subject, final String htmlBody)
            throws NoSuchProviderException, MessagingException {
        Session mailSession = createSession();
        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(subject);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            MimeMultipart multipart = new MimeMultipart("related");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(htmlBody, "text/html; charset=utf-8");
            messageBodyPart.setHeader("Content-Transfer-Encoding", "quoted-printable");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void send(final String from, final List<String> to,
            final List<String> cc, final String subject, final String body)
            throws NoSuchProviderException, MessagingException {
        Session mailSession = createSession();
        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from));
            for (String addr : to) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(addr));
            }
            for (String addr : cc) {
                message.addRecipient(Message.RecipientType.CC, new InternetAddress(addr));
            }
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void sendHtml(final String from, final List<String> to,
            final List<String> cc, final String subject, final String htmlBody)
            throws NoSuchProviderException, MessagingException {
        Session mailSession = createSession();
        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(subject);
            message.setFrom(new InternetAddress(from));
            for (String addr : to) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(addr));
            }
            for (String addr : cc) {
                message.addRecipient(Message.RecipientType.CC, new InternetAddress(addr));
            }
            MimeMultipart multipart = new MimeMultipart("related");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(htmlBody, "text/html; charset=utf-8");
            messageBodyPart.setHeader("Content-Transfer-Encoding", "quoted-printable");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
