/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.exception;

/**
 *
 * @author guo
 */
public class SendMailException extends Exception {

    public SendMailException(String message) {
        super(message);
    }

    public SendMailException(String message, Throwable cause) {
        super(message, cause);
    }
}
