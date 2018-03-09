package org.babyfind.common.util;

import java.util.HashMap;
import java.util.Map;

public class AjaxResult {

    private static final String BUSINESS_MSG_SUCCESS = "成功";
    private static final String BUSINESS_MSG_FAILURE = "失败";
    private static final String SERVER_ERROR = "服务器发生未知错误";

    private String msg;
    public static final String DATAS = "datas";

    private Map<String, Object> model;


    public AjaxResult(String msg,Map<String, Object> datas) {
        this.model = new HashMap<>();
        this.msg=msg;
        if (null != datas && 0 < datas.size()) {
            this.model.putAll(datas);
        }
    }

    public AjaxResult(String msg) {
        this.msg = msg;
        this.model = new HashMap<>();
    }

    public AjaxResult() {
    }

//    public AjaxResult addObject(String attributeName, Object attributeValue) {
//        getModel().put(attributeName, attributeValue);
//        return this;
//    }

    public AjaxResult addAllObject(Map<String, Object> datas) {
        if (null != datas) {
            getModel().putAll(datas);
        }
        return this;
    }

    public Map<String, Object> getModel() {
        if (null == model) {
            this.model = new HashMap<>();
        }
        return model;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static final AjaxResult success(String msg, Map<String, Object> data) {
        AjaxResult result = new AjaxResult(BUSINESS_MSG_SUCCESS);
        if (null != msg) {
            result.setMsg(msg);
        }
        if (null != data) {
            result.addAllObject(data);
        }
        return result;
    }

    public static final AjaxResult failure(String msg) {
        AjaxResult result = new AjaxResult(SERVER_ERROR);
        result.setMsg(msg);
        return result;
    }

    public static final AjaxResult failure() {
        AjaxResult result = new AjaxResult(SERVER_ERROR);
        result.setMsg(BUSINESS_MSG_FAILURE);
        return result;
    }

    public static AjaxResult succ() {
        AjaxResult t = new AjaxResult(BUSINESS_MSG_SUCCESS);
        t.setMsg("操作成功");
        return t;
    }

    public static AjaxResult error(String errMsg) {
        AjaxResult t = new AjaxResult(SERVER_ERROR);
        t.setMsg(errMsg);
        return t;
    }

    public static AjaxResult error() {
        AjaxResult t = new AjaxResult(SERVER_ERROR);
        t.setMsg("操作失败");
        return t;
    }


    public static AjaxResult succ(Object data) {
        AjaxResult t = new AjaxResult();
        t.setMsg("操作成功");
        t.getModel().put(DATAS, data);
        return t;
    }

    public static final AjaxResult success() {
        AjaxResult result = new AjaxResult();
        result.setMsg(BUSINESS_MSG_SUCCESS);
        return result;
    }

    public AjaxResult addSingleModel(Object model) {
        getModel().put(DATAS, model);
        return this;
    }

    public AjaxResult addList(Object list) {
        getModel().put(DATAS, list);
        return this;
    }

    public AjaxResult addPageInfo(Object pageInfo) {
        getModel().put(DATAS, pageInfo);
        return this;
    }

    public String getMsg() {
        return msg;
    }
}