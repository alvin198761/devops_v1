package org.alvin.opsdev.cmdb.domain.enums;


/**
 * Created by Administrator on 2016/11/20.
 */
public enum OsType {
    WINDOWS ,LINUX;

    public static OsType getValue(int index) {
        for(OsType osType : values()){
            if(osType.ordinal() == index){
                return osType;
            }
        }
        return null;
    }
}
