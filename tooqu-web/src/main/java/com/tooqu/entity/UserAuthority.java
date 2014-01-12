/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;



import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade; 
import org.hibernate.annotations.CascadeType; 
/**
 *
 * @author Dxg
 */
@Entity
@Table(name="user_authority")
public class UserAuthority implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long uid;
    private int type;//0个人主页(联系方式) ,1私信
    private int permission;
    
      @OneToOne()  
      @Cascade(value={CascadeType.SAVE_UPDATE})
   @JoinColumn(name = "user_id") 
    private User user;

    /** 
     * @return the uid
     */
    public long getUid() {
        return uid;          
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(long uid) {
        this.uid = uid;
    }

    /**
     * @return the type 0 个人主页 1私信
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the permission
     */
    public int getPermission() {
        return permission;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermission(int permission) {
        this.permission = permission;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
}
