package com.cs.dipocketback.pojo.portal;

import java.util.List;

public class PortalReport {
    
    private StatementFormatType formatType;
    private StatementType statementType;
    private String userName;
    private Long corpClientId;
    private String companyName;
    private String email;
    private String startDate;
    private String endDate;
    private String language = "en";
    
    private List<Long> accountsList;

    public PortalReport() {
    }

    public PortalReport(StatementFormatType formatType,
                        StatementType statementType,
                        String userName,
                        Long corpClientId,
                        String companyName,
                        String email,
                        String startDate,
                        String endDate,
                        String language,
                        List<Long> accountsList) {
        this.formatType = formatType;
        this.statementType = statementType;
        this.userName = userName;
        this.corpClientId = corpClientId;
        this.companyName = companyName;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        this.language = language;
        this.accountsList = accountsList;
    }

    public void setFormatType(StatementFormatType formatType) {
        this.formatType = formatType;
    }

    public StatementFormatType getFormatType() {
        return formatType;
    }

    public void setStatementType(StatementType statementType) {
        this.statementType = statementType;
    }

    public StatementType getStatementType() {
        return statementType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setCorpClientId(Long corpClientId) {
        this.corpClientId = corpClientId;
    }

    public Long getCorpClientId() {
        return corpClientId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setAccountsList(List<Long> accountsList) {
        this.accountsList = accountsList;
    }

    public List<Long> getAccountsList() {
        return accountsList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PortalReport {");
        sb.append("\n\tformatType = '").append(formatType).append('\'');
        sb.append(",\n\tstatementType = '").append(statementType).append('\'');
        sb.append(",\n\tuserName = '").append(userName).append('\'');
        sb.append(",\n\tcorpClientId = '").append(corpClientId).append('\'');
        sb.append(",\n\tcompanyName = '").append(companyName).append('\'');
        sb.append(",\n\temail = '").append(email).append('\'');
        sb.append(",\n\tstartDate = '").append(startDate).append('\'');
        sb.append(",\n\tendDate = '").append(endDate).append('\'');
        sb.append(",\n\tlanguage = '").append(language).append('\'');

        if (accountsList != null) {
            sb.append(",\n\taccountsList = [");
            for (Long l : accountsList) {
                sb.append("\t\t");
                sb.append(l);
                sb.append("\n");
            }
            sb.append("]");
        } else {
            sb.append(",\n\taccountsList = null");
        }

        sb.append("\n}");
        return sb.toString();
    }

}
