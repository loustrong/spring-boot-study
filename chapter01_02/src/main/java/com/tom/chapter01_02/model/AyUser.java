package com.tom.chapter01_02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @descriptions: AyUser
 * @author: Tom
 * @date: 2021/2/17 上午 10:16
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ay_user")
public class AyUser implements Serializable {
    @Id
    private String id;
    private String name;
    private String password;

}
