package com.video.edu.me.enumeration;

import com.video.edu.me.utils.ByteUtil;

import java.util.HashMap;
import java.util.Map;

public enum VideoStatus {

    UPLOADING(ByteUtil.intToByte(1), "上传中"),
    NORMAL(ByteUtil.intToByte(2), "正常"),
    PAUSE(ByteUtil.intToByte(3), "停用"),
    FAILED(ByteUtil.intToByte(4), "上传失败"),
    REMOVED(ByteUtil.intToByte(5), "删除");

    private byte id;
    private String desc;
    private static Map<Byte, VideoStatus> idMap;

    static {
        idMap = new HashMap<>();
        for (VideoStatus videoStatus : VideoStatus.values()) {
            idMap.put(videoStatus.getId(), videoStatus);
        }
    }


    VideoStatus(byte id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static VideoStatus getById(byte id) {
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
        return "VideoStatus{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}