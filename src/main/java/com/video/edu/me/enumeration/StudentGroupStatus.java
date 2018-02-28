package com.video.edu.me.enumeration;

import com.video.edu.me.utils.ByteUtil;

import java.util.HashMap;
import java.util.Map;

public enum StudentGroupStatus {

    NORMAL(ByteUtil.intToByte(1), "正常"),
    PAUSE(ByteUtil.intToByte(2), "停用"),
    REMOVED(ByteUtil.intToByte(3), "删除");

    private byte id;
    private String desc;
    private static Map<Byte, StudentGroupStatus> idMap;
    private static Map<String, StudentGroupStatus> descMap;

    static {
        idMap = new HashMap<>();
        descMap = new HashMap<>();
        for (StudentGroupStatus studentGroupStatus : StudentGroupStatus.values()) {
            idMap.put(studentGroupStatus.getId(), studentGroupStatus);
        }
        for (StudentGroupStatus studentGroupStatus : StudentGroupStatus.values()) {
            descMap.put(studentGroupStatus.getDesc(), studentGroupStatus);
        }
    }


    StudentGroupStatus(byte id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static StudentGroupStatus getById(byte id) {
        return idMap.get(id);
    }
    public static StudentGroupStatus getByDesc(String desc) {
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
        return "StudentGroupStatus{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}