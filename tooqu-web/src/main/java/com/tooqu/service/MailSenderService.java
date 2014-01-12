/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.exception.SendMailException;
import java.util.Map;

/**
 *
 * @author guo
 */
public interface MailSenderService {
    void sendMail(String receiver, String mailName, Map<String, String> args) throws SendMailException;
}
