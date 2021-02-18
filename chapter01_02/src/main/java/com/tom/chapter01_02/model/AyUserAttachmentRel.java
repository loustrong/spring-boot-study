package com.tom.chapter01_02.model;

import javax.persistence.Id;

/**
 * AyUserAttachmentRel
 *
 * @author Tom on 2021/2/18
 */
public class AyUserAttachmentRel {

    @Id
    private String id;
    private String userId;
    private String fileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}