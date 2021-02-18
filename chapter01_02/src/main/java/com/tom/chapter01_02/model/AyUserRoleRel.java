package com.tom.chapter01_02.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AyUserRoleRel
 *
 * @author Tom on 2021/2/18
 */
@Entity
@Table(name = "ay_user_role_rel")
public class AyUserRoleRel {
    @Id
    private String userId;
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

