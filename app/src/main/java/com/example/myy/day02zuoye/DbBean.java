package com.example.myy.day02zuoye;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbBean {
    @Id(autoincrement = true)
    private Long id;

    @Override
    public String toString() {
        return "DbBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Property
    private String name;

    @Generated(hash = 1770686585)
    public DbBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1953169116)
    public DbBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
