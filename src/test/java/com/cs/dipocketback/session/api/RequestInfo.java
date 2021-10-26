package com.cs.dipocketback.session.api;

import com.cs.dipocketback.base.data.ClientPlatform;

import java.util.List;
import java.util.Map;

public abstract class RequestInfo {

    public static final String REQUEST_INFO = "REQUEST_INFO";

    protected String description;
    protected String clientLogin;

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public String getDescription() {
        return description;
    }
    
    public abstract Map<String, List<String>> getHeaders();
    
    public abstract String getMethod();

    public abstract void setSessionId(Long sessionId);

    public abstract Long getSessionId();

    public abstract void setRequestId(Long requestId);

    public abstract Long getRequestId();

    public abstract void setSecretAnswer(String answer);

    public abstract String getSecretAnswer();

    public abstract void setAnswerType(String answerType);

    public abstract String getSite();

    public abstract String getUserName();

    public abstract String getAnswerType();

    public abstract String getCookie();

    public abstract String getUserAgent();

    public abstract String getDeviceUuid();

    public abstract String getDeviceType();

    public abstract ClientPlatform getClientPlatform();

    public abstract String getPushToken();

    public abstract String getGcmSenderId();

    public abstract String getAppVersion();

    public abstract String getIpAddress();

    public abstract String getRequestUri();

    public abstract String getScaPassword();

    public abstract String getScaSmsCode();
    
}
