package com.cs.dipocketback.pojo.mail;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Mail {

    private Locale locale = new Locale("en");
    private String from;
    private String to;
    private String copy;
    private String blindCopy;
    private String subject;
    private String pathToTemplate;
    private Map<String, Object> model;
    private Map<String, File> attachments;
    private Map<String, InputStream> attachmentsStream;

    public Mail() {
    }

    public Mail(String to, String subject) {
        this.to = to;
        this.subject = subject;
    }

    public Mail(String to, String subject, Map<String, Object> model) {
        this.to = to;
        this.subject = subject;
        this.model = model;
    }

    public Mail(String from, String to, String subject, Map<String, Object> model) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.model = model;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getBlindCopy() {
        return blindCopy;
    }

    public void setBlindCopy(String blindCopy) {
        this.blindCopy = blindCopy;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPathToTemplate() {
        return pathToTemplate;
    }

    public void setPathToTemplate(String pathToTemplate) {
        this.pathToTemplate = pathToTemplate;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public Map<String, File> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, File> attachments) {
        this.attachments = attachments;
    }

    public Map<String, InputStream> getAttachmentsStream() {
        return attachmentsStream;
    }

    public void addAttachment(File attachment) {
        if (attachments == null) {
            attachments = new HashMap();
        }
        attachments.put(attachment.getName(), attachment);
    }

    public void addAttachment(String nameInEmail, File attachment) {
        if (attachments == null) {
            attachments = new HashMap();
        }
        attachments.put(nameInEmail, attachment);
    }

    public void addAttachment(String nameInEmail, InputStream is) {
        if (attachmentsStream == null) {
            attachmentsStream = new HashMap();
        }
        attachmentsStream.put(nameInEmail, is);
    }

}
