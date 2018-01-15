package com.video.edu.me.utils;

import java.util.HashMap;
import java.util.Map;

public enum RoleType {
    ADMIN(1, "admin"),
    TEACHER(2, "teacher"),
    USER(3, "user");

    private int id;
    private String desc;
    private static Map<Integer, RoleType> idMap = new HashMap<>();

    RoleType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    static {
        for (RoleType type : RoleType.values()) {
            idMap.put(type.getId(), type);
        }
    }

    public static RoleType getById(int id) {
        return idMap.get(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "RoleType{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
