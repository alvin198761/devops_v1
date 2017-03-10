package org.alvin.opsdev.cmdb.domain.enums;

import org.springframework.util.Assert;

/**
 * Created by Administrator on 2016/11/20.
 */
public enum DeviceType {

    COMPUTER, DATABASE, SWITCH;

    public static DeviceType getValue(int index) {
        for (DeviceType type : values()) {
            if (type.ordinal() == index) {
                return type;
            }
        }
     return null;
    }
}
