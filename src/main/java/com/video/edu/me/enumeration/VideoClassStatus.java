package com.video.edu.me.enumeration;

import com.video.edu.me.utils.ByteUtil;

import java.util.HashMap;
import java.util.Map;

public enum VideoClassStatus {

    NORMAL(ByteUtil.intToByte(1), "正常"),
    PAUSE(ByteUtil.intToByte(2), "停用"),
    REMOVED(ByteUtil.intToByte(3), "删除");

    private byte id;
    private String desc;
    private static Map<Byte, VideoClassStatus> idMap;

    static {
        idMap = new HashMap<>();
        for (VideoClassStatus videoStatus : VideoClassStatus.values()) {
            idMap.put(videoStatus.getId(), videoStatus);
        }
    }


    VideoClassStatus(byte id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static VideoClassStatus getById(byte id) {
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
        return "VideoClassStatus{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}