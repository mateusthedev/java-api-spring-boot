package com.example.crud.poorganizer.domain.user;

public enum UserPermission {

    ADMIN(1),
    USER(0);

    private Integer permission;

    UserPermission(Integer permission){
        this.permission = permission;
    }

    public Integer getPermission(){
        return permission;
    }
}
