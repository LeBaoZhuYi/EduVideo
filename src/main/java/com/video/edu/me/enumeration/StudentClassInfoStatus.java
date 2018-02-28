package com.video.edu.me.enumeration;

import com.video.edu.me.utils.ByteUtil;

import java.util.HashMap;
import java.util.Map;

public enum StudentClassInfoStatus {

    BEGIN(ByteUtil.intToByte(0), "开始"),
    END(ByteUtil.intToByte(1), "完成"),
    ERROR(ByteUtil.intToByte(3), "异常");

    private byte id;
    private String desc;
    private static Map<Byte, StudentClassInfoStatus> idMap;

    static {
        idMap = new HashMap<>();
        for (StudentClassInfoStatus studentClassInfoStatusStatus : StudentClassInfoStatus.values()) {
            idMap.put(studentClassInfoStatusStatus.getId(), studentClassInfoStatusStatus);
        }
    }


    StudentClassInfoStatus(byte id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static StudentClassInfoStatus getById(byte id) {
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
        return "StudentClassInfoStatusStatus{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}