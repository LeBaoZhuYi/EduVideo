package com.video.edu.me.enumeration;

import com.video.edu.me.utils.ByteUtil;

import java.util.HashMap;
import java.util.Map;

public enum RoleType {
    ADMIN(ByteUtil.intToByte(1), "admin"),
    TEACHER(ByteUtil.intToByte(2), "teacher"),
    USER(ByteUtil.intToByte(3), "user");

    private byte id;
    private String desc;
    private static Map<Byte, RoleType> idMap = new HashMap<>();

    RoleType(byte id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    static {
        for (RoleType type : RoleType.values()) {
            idMap.put(type.getId(), type);
        }
    }

    public static RoleType getById(byte id) {
        return idMap.get(id);
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
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
