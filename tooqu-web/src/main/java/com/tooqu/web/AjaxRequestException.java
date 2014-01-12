/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web;

/**
 *
 * @author guo
 */
public class AjaxRequestException extends Exception {

    public AjaxRequestException() {
    }

    public AjaxRequestException(String message) {
        super(message);
    }

    public AjaxRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public AjaxRequestException(Throwable cause) {
        super(cause);
    }
}