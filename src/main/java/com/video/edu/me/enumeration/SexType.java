package com.video.edu.me.enumeration;

import com.video.edu.me.utils.ByteUtil;

import java.util.HashMap;
import java.util.Map;

public enum SexType {
    BOY(ByteUtil.intToByte(0), "男孩"),
    GIRL(ByteUtil.intToByte(1), "女孩");

    private byte id;
    private String desc;
    private static Map<Byte, SexType> idMap = new HashMap<>();
    private static Map<String, SexType> descMap = new HashMap<>();

    SexType(byte id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    static {
        for (SexType type : SexType.values()) {
            idMap.put(type.getId(), type);
        }
        for (SexType type : SexType.values()) {
            descMap.put(type.getDesc(), type);
        }
    }

    public static SexType getById(byte id) {
        return idMap.get(id);
    }

    public static SexType getByDesc(String desc) {
        return descMap.get(desc);
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
        return "SexType{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
