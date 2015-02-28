package com.mingdao.web.support;


import com.mingdao.common.UserInfo;
import com.mingdao.common.UserSession;
import net.sf.json.JSONObject;
import ognl.NoSuchPropertyException;
import org.guiceside.commons.Page;
import org.guiceside.commons.lang.BeanUtils;
import org.guiceside.commons.lang.DateFormatUtil;
import org.guiceside.commons.lang.StringUtils;
import org.guiceside.persistence.entity.Tracker;
import org.guiceside.web.action.BaseAction;
import org.guiceside.web.annotation.ReqGet;
import org.guiceside.web.annotation.ReqSet;


public abstract class ActionSupport<T> extends BaseAction {

    @ReqSet
    protected Page<T> pageObj;

    @ReqGet
    @ReqSet
    protected String attToken;

    @ReqGet
    @ReqSet
    protected String attKey;

    @ReqSet
    protected String script = "parent.reload();";

    protected String mdURI = "https://api.mingdao.com/auth2/authorize";

    private final String CORP_ID = "wx853769e334ead822";

    private final String CORP_SECRET = "17ab4955fe78a806a1a778c7adbd93d8";





    protected T copy(T fromEntity, T entity) throws Exception {
        BeanUtils.copyProperties(entity, fromEntity);
        fromEntity = null;
        return entity;
    }

    public static Object staticCopy(Object fromEntity, Object entity) throws Exception {
        BeanUtils.copyProperties(entity, fromEntity);
        fromEntity = null;
        return entity;
    }


    public static void staticBind(Object entity) throws Exception {
        if (entity instanceof Tracker) {
            BeanUtils.setValue(entity, "created", DateFormatUtil.getCurrentDate(true));
            BeanUtils.setValue(entity, "updated", DateFormatUtil.getCurrentDate(true));
        }
        try {
            String useYn = BeanUtils.getValue(entity, "useYn", String.class);
            if (StringUtils.isBlank(useYn)) {
                BeanUtils.setValue(entity, "useYn", "N");
            }
        } catch (NoSuchPropertyException e) {
            BeanUtils.setValue(entity, "useYn", "N");
        }

    }

    protected void bind(Object entity) throws Exception {
        if (entity instanceof Tracker) {
            if (BeanUtils.getValue(entity, "id") == null) {
                BeanUtils.setValue(entity, "created", DateFormatUtil.getCurrentDate(true));
            }
            UserInfo userInfo = UserSession.getUserInfo(this.getHttpServletRequest());
            BeanUtils.setValue(entity, "updated", DateFormatUtil.getCurrentDate(true));
            if (userInfo != null) {
                BeanUtils.setValue(entity, "createdBy", userInfo.getUserId());
                BeanUtils.setValue(entity, "updatedBy", userInfo.getUserId());
            }
        }
        try {
            String useYn = BeanUtils.getValue(entity, "useYn", String.class);
            if (StringUtils.isBlank(useYn)) {
                BeanUtils.setValue(entity, "useYn", "N");
            }
        } catch (NoSuchPropertyException e) {
            BeanUtils.setValue(entity, "useYn", "N");
        }
    }
    protected String getLanguagePrefernce() {
        return UserSession.getLanguagePrefernce(this.getHttpServletRequest());
    }

    protected String getJsonStr(JSONObject jsonObject,String key) {
        String result;
        if(jsonObject.containsKey(key)){
            result=jsonObject.getString(key);
        }else{
            result=null;
        }
        return result;
    }
    protected int getJsonInt(JSONObject jsonObject,String key) {
        int result;
        if(jsonObject.containsKey(key)){
            result=jsonObject.getInt(key);
        }else{
            result=-1;
        }
        return result;
    }
    protected double getJsonDouble(JSONObject jsonObject,String key) {
        double result;
        if(jsonObject.containsKey(key)){
            result=jsonObject.getDouble(key);
        }else{
            result=-1.00;
        }
        return result;
    }
}