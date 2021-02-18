package com.tom.chapter01_02.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AyRole
 *
 * @author Tom on 2021/2/18
 */
@Entity
@Table(name = "ay_role")
public class AyRole {

    @Id
    private String id;
    private String name;

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
}
