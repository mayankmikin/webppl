package com.studybro.model;

public enum AccessType {
	FREE("FREE"),
    PREMIUM("PREMIUM"),
    ADMIN("ADMIN");
     
    String useraccessType;
     
    private AccessType(String useraccessType){
        this.useraccessType = useraccessType;
    }
     
    public String getuseraccessType(){
        return useraccessType;
    }
}
