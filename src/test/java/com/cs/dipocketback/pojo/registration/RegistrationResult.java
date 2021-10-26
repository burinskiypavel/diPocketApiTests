package com.cs.dipocketback.pojo.registration;


public class RegistrationResult {

    public static final RegistrationResult NO_ERRORS = new RegistrationResult(0L, null, null);

    public static final long IDENTITY_CHECK_ERROR = -1;
    public static final long ERROR_WHEN_SENDING_EMAIL = -2;

    private Long resultCode;
    private String message;
    private RegInfoAnalytics regInfoAnalytics;

    public void setResultCode(Long resultCode) {
        this.resultCode = resultCode;
    }

    public Long getResultCode() {
        return resultCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public RegistrationResult() {
    }

    public void setRegInfoAnalytics(RegInfoAnalytics regInfoAnalytics) {
        this.regInfoAnalytics = regInfoAnalytics;
    }

    public RegInfoAnalytics getRegInfoAnalytics() {
        return regInfoAnalytics;
    }
    
    public RegistrationResult(Long resultCode, String message) {
        this();
        this.resultCode = resultCode;
        this.message = message;
    }

    public RegistrationResult(Long resultCode, String message, RegInfoAnalytics regInfoAnalytics) {
        this();
        this.resultCode = resultCode;
        this.message = message;
        this.regInfoAnalytics = regInfoAnalytics;
    }
}
