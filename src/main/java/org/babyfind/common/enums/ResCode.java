package org.babyfind.common.enums;

public enum ResCode {

    OK(200, "成功"),
    SERVER_ERROR(500, "服务器发生未知错误"),

    __(999999, "");
    private Integer retCode;
    private String desc;

    ResCode(Integer retCode, String desc) {
        this.retCode = retCode;
        this.desc = desc;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public String getDesc() {
        return desc;
    }

}
