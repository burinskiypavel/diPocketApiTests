package com.cs.dipocketback.pojo.riskscoring;

//import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

public class RiskScoringInfo {

    //@JsonProperty("result")
    private List<Result> result = new LinkedList<>();

    //@JsonProperty("success")
    private Boolean success;

    //@JsonProperty("errors")
    private List<String> errors = new LinkedList<>();

    //@JsonProperty("messages")
    private List<String> messages = new LinkedList<>();

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public static class Result {
        //@JsonProperty("ip")
        private String ip;

        //@JsonProperty("belongs_to_ref")
        private BelongsToRef belongsToRef;



        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public BelongsToRef getBelongsToRef() {
            return belongsToRef;
        }

        public void setBelongsToRef(BelongsToRef belongsToRef) {
            this.belongsToRef = belongsToRef;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "ip='" + ip + '\'' +
                    ", belongsToRef=" + belongsToRef +
                    '}';
        }
    }

    public static class BelongsToRef {
        //@JsonProperty("ip")
        private String id;
        //@JsonProperty("value")
        private Long value;
        //@JsonProperty("type")
        private String type;
        //@JsonProperty("country")
        private String country;
        //@JsonProperty("description")
        private String description;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "BelongsToRef{" +
                    "id='" + id + '\'' +
                    ", value=" + value +
                    ", type='" + type + '\'' +
                    ", country='" + country + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RiskScoringInfo{" +
                "result=" + result +
                ", success=" + success +
                ", errors=" + errors +
                ", messages=" + messages +
                '}';
    }
}
