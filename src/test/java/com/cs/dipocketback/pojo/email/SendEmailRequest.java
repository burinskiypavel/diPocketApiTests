package com.cs.dipocketback.pojo.email;

import java.util.List;

public class SendEmailRequest {

    private Email email;
    private List<EmailParam> emailParams;
    private List<Attachment> attachments;

    public SendEmailRequest() {
    }

    public SendEmailRequest(Email email, List<EmailParam> emailParams) {
        this.email = email;
        this.emailParams = emailParams;
    }

    public SendEmailRequest(Email email, List<EmailParam> emailParams, List<Attachment> attachments) {
        this.email = email;
        this.emailParams = emailParams;
        this.attachments = attachments;
    }

    public Email getEmailAsync() {
        return email;
    }

    public void setEmailAsync(Email email) {
        this.email = email;
    }

    public List<EmailParam> getEmailAsyncParams() {
        return emailParams;
    }

    public void setEmailAsyncParams(List<EmailParam> emailParams) {
        this.emailParams = emailParams;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

}
