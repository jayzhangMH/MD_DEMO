package com.mingdao.common;



import com.mingdao.sys.entity.SysUser;

import java.io.Serializable;
import java.util.Locale;

/**
 * @author zhenjia <a href='mailto:zhenjiaWang@gmail.com'>email</a>
 * @version 1.0 2008-10-30
 * @since JDK1.5
 */
public class UserInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final String DEFAULT_LANGUAGE_PREFERENCE = "zh";

    public static final String DEFAULT_COUNTRY_PREFERENCE = "CN";

    private String languagePreference = DEFAULT_LANGUAGE_PREFERENCE;

    private String countryPreference = DEFAULT_COUNTRY_PREFERENCE;

    public static final Locale DEFAULT_Locale = new Locale(
            DEFAULT_LANGUAGE_PREFERENCE, DEFAULT_COUNTRY_PREFERENCE);

    private boolean authorize = false;

    private boolean loggedIn = false;

    private String appKey;

    private String appSecret;

    private String redirectUri;

    private String sessionId;

    private String userId;

    private Long startupId;

    private String startupName;

    private String companyId;

    private String accessToken;

    private Integer tryDay;

    private Integer authorizeDay;


    private boolean admin;

    private Integer taskUnApprove;

    private Integer manageExecute;

    private Integer reqTip;

    private Integer reqShare;

    private Long diffDay;

    private String pay;

    private String callType;

    private Long callId;

    private SysUser sysUser;


    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Long getDiffDay() {
        return diffDay;
    }

    public void setDiffDay(Long diffDay) {
        this.diffDay = diffDay;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(String languagePreference) {
        this.languagePreference = languagePreference;
    }

    public String getCountryPreference() {
        return countryPreference;
    }

    public void setCountryPreference(String countryPreference) {
        this.countryPreference = countryPreference;
    }

    public static Locale getDEFAULT_Locale() {
        return DEFAULT_Locale;
    }

    public boolean isAuthorize() {
        return authorize;
    }

    public void setAuthorize(boolean authorize) {
        this.authorize = authorize;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Integer getTryDay() {
        return tryDay;
    }

    public void setTryDay(Integer tryDay) {
        this.tryDay = tryDay;
    }

    public Integer getAuthorizeDay() {
        return authorizeDay;
    }

    public void setAuthorizeDay(Integer authorizeDay) {
        this.authorizeDay = authorizeDay;
    }


    public Integer getTaskUnApprove() {
        return taskUnApprove;
    }

    public void setTaskUnApprove(Integer taskUnApprove) {
        this.taskUnApprove = taskUnApprove;
    }

    public Integer getManageExecute() {
        return manageExecute;
    }

    public void setManageExecute(Integer manageExecute) {
        this.manageExecute = manageExecute;
    }


    public Integer getReqTip() {
        return reqTip;
    }

    public void setReqTip(Integer reqTip) {
        this.reqTip = reqTip;
    }

    public Integer getReqShare() {
        return reqShare;
    }

    public void setReqShare(Integer reqShare) {
        this.reqShare = reqShare;
    }


    public Long getStartupId() {
        return startupId;
    }

    public void setStartupId(Long startupId) {
        this.startupId = startupId;
    }

    public String getStartupName() {
        return startupName;
    }

    public void setStartupName(String startupName) {
        this.startupName = startupName;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long callId) {
        this.callId = callId;
    }
}
