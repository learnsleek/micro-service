package com.learnsleek.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public abstract class RequestDTO {

    @NotNull
    @NotBlank
    private String entityType;
    @NotNull
    @NotBlank
    private String entityVal;
    @NotNull
    @NotBlank
    private String requestType;
    @NotNull
    @NotBlank
    private String requestVal;

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityVal() {
        return entityVal;
    }

    public void setEntityVal(String entityVal) {
        this.entityVal = entityVal;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestVal() {
        return requestVal;
    }

    public void setRequestVal(String requestVal) {
        this.requestVal = requestVal;
    }
}
