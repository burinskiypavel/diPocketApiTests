
package model.telenor.registration.mailsac;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mailsacc {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("from")
    @Expose
    private List<From> from = null;
    @SerializedName("to")
    @Expose
    private List<To> to = null;
    @SerializedName("cc")
    @Expose
    private List<Object> cc = null;
    @SerializedName("bcc")
    @Expose
    private List<Object> bcc = null;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("savedBy")
    @Expose
    private Object savedBy;
    @SerializedName("inbox")
    @Expose
    private String inbox;
    @SerializedName("originalInbox")
    @Expose
    private String originalInbox;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("received")
    @Expose
    private String received;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("attachments")
    @Expose
    private List<String> attachments = null;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("via")
    @Expose
    private String via;
    @SerializedName("folder")
    @Expose
    private String folder;
    @SerializedName("labels")
    @Expose
    private List<Object> labels = null;
    @SerializedName("read")
    @Expose
    private Object read;
    @SerializedName("rtls")
    @Expose
    private Boolean rtls;
    @SerializedName("links")
    @Expose
    private List<String> links = null;
    @SerializedName("spam")
    @Expose
    private Integer spam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<From> getFrom() {
        return from;
    }

    public void setFrom(List<From> from) {
        this.from = from;
    }

    public List<To> getTo() {
        return to;
    }

    public void setTo(List<To> to) {
        this.to = to;
    }

    public List<Object> getCc() {
        return cc;
    }

    public void setCc(List<Object> cc) {
        this.cc = cc;
    }

    public List<Object> getBcc() {
        return bcc;
    }

    public void setBcc(List<Object> bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Object getSavedBy() {
        return savedBy;
    }

    public void setSavedBy(Object savedBy) {
        this.savedBy = savedBy;
    }

    public String getInbox() {
        return inbox;
    }

    public void setInbox(String inbox) {
        this.inbox = inbox;
    }

    public String getOriginalInbox() {
        return originalInbox;
    }

    public void setOriginalInbox(String originalInbox) {
        this.originalInbox = originalInbox;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public List<Object> getLabels() {
        return labels;
    }

    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }

    public Object getRead() {
        return read;
    }

    public void setRead(Object read) {
        this.read = read;
    }

    public Boolean getRtls() {
        return rtls;
    }

    public void setRtls(Boolean rtls) {
        this.rtls = rtls;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public Integer getSpam() {
        return spam;
    }

    public void setSpam(Integer spam) {
        this.spam = spam;
    }

}
