
package com.united.core;

import com.united.auth.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jenny
 */

@Entity
@Table(name="COURSES")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)  // unique is implied
    protected String id;
    @Column(nullable = false)
    protected String name;
    
//    @OneToMany 
//    @JoinColumn(name = "IN_COURSE") 
//    private List<Moment> containedMoments;
    
    @OneToMany 
    @JoinColumn(name = "IN_COURSE") 
    private List<Moment> containedMoments;
    
    //    @OneToMany 
//    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(name = "COURSES_MOMENTS", 
//            joinColumns = @JoinColumn(name = "id"))
//    private List<Moment> containedMoments;
    
  

    public Course() {
    }

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        containedMoments = new ArrayList<>();
        System.out.println("------course created with: " + getContainedMoments());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addMoment(Moment moment) {
        containedMoments.add(moment);
    }

    public void removeMoment(Moment moment) {
        containedMoments.remove(moment);
    }
    
    public List<Moment> getContainedMoments() {
        return containedMoments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        return Objects.equals(this.id, other.id);
    }

}