package com.tooqu.common.dao;

import com.tooqu.common.enums.OrderBy;
import java.io.Serializable;


/**
 *
 * @author Guo
 */
public class PageContext implements Serializable {

    private int start;
    private int length;
    private int total;
    private int totalPage;
    private String orderByAttr;
    private OrderBy orderMethod;

    public PageContext() {
    }

    public PageContext(int start, int length) {
        this.start = start;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        this.length = length;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        if (start < 0) {
            throw new IllegalArgumentException();
        }
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        totalPage = total % length == 0 ? (total / length) : ((total - total % length) / length + 1);
    }

    public String getConditionString() {
        return "start" + start + "length" + length;
    }

    public String getOrderByAttr() {
        return orderByAttr;
    }

    public void setOrderByAttr(String orderByAttr) {
        this.orderByAttr = orderByAttr;
    }

    public OrderBy getOrderMethod() {
        return orderMethod;
    }

    public void setOrderMethod(OrderBy orderMethod) {
        this.orderMethod = orderMethod;
    }

    public int getTotalPage() {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        total = (totalPage - 1) * length + 1;
    }

    public int getCurrentPage() {
        return start / length + 1;
    }
}
