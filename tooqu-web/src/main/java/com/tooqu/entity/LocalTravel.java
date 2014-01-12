/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.entity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.hibernate.annotations.Cascade;
/**
 *
 * @author hao
 */
@Entity
@Table(name="local_travel")
public class LocalTravel {
    @Id
    @GeneratedValue
    private long id;
    
    private String notice;
    private String bookrule;
    private int vehicletype;
    private int maxpeople;
    private String arrangement;
    private String title;
    private double money;
    private int feetype;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="place")
    
    private Place place;
    
    @ManyToOne()
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="creator")
    
    private User  creator;
    
    @OneToMany(mappedBy="localtravel", fetch=FetchType.LAZY)
    @Cascade(value={org.hibernate.annotations.CascadeType.DELETE})
    @OrderBy(value="id ASC")
    private List<LocalTravelParticipateRecord> recordlist;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the notice
     */
    public String getNotice() {
        return notice;
    }

    /**
     * @param notice the notice to set
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * @return the bookrule
     */
    public String getBookrule() {
        return bookrule;
    }

    /**
     * @param bookrule the bookrule to set
     */
    public void setBookrule(String bookrule) {
        this.bookrule = bookrule;
    }

    /**
     * @return the vehicletype
     */
    public int getVehicletype() {
        return vehicletype;
    }

    /**
     * @param vehicletype the vehicletype to set
     */
    public void setVehicletype(int vehicletype) {
        this.vehicletype = vehicletype;
    }

    /**
     * @return the maxpeople
     */
    public int getMaxpeople() {
        return maxpeople;
    }

    /**
     * @param maxpeople the maxpeople to set
     */
    public void setMaxpeople(int maxpeople) {
        this.maxpeople = maxpeople;
    }

    /**
     * @return the arrangement
     */
    public String getArrangement() {
        return arrangement;
    }

    /**
     * @param arrangement the arrangement to set
     */
    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the money
     */
    public double getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * @return the feetype
     */
    public int getFeetype() {
        return feetype;
    }

    /**
     * @param feetype the feetype to set
     */
    public void setFeetype(int feetype) {
        this.feetype = feetype;
    }

    /**
     * @return the place
     */
    public Place getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * @return the creator
     */
    public User getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * @return the recordlist
     */
    public List<LocalTravelParticipateRecord> getRecordlist() {
        return recordlist;
    }

    /**
     * @param recordlist the recordlist to set
     */
    public void setRecordlist(List<LocalTravelParticipateRecord> recordlist) {
        this.recordlist = recordlist;
    }
    
    
    
    
}
