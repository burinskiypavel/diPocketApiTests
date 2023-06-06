package model.aspsp.pis;

public class PaymentsCrossBorderCreditTransfersRequest {
    private InstructedAmount instructedAmount;
    private String creditorName;
    private String creditorType;
    private CreditorAddress creditorAddress;
    private String creditorAgent;
    private CreditorAccount creditorAccount;
    private String remittanceInformationUnstructured;

    public InstructedAmount getInstructedAmount() {
        return instructedAmount;
    }

    public void setInstructedAmount(InstructedAmount instructedAmount) {
        this.instructedAmount = instructedAmount;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    public String getCreditorType() {
        return creditorType;
    }

    public void setCreditorType(String creditorType) {
        this.creditorType = creditorType;
    }

    public CreditorAddress getCreditorAddress() {
        return creditorAddress;
    }

    public void setCreditorAddress(CreditorAddress creditorAddress) {
        this.creditorAddress = creditorAddress;
    }

    public String getCreditorAgent() {
        return creditorAgent;
    }

    public void setCreditorAgent(String creditorAgent) {
        this.creditorAgent = creditorAgent;
    }

    public String getRemittanceInformationUnstructured() {
        return remittanceInformationUnstructured;
    }

    public void setRemittanceInformationUnstructured(String remittanceInformationUnstructured) {
        this.remittanceInformationUnstructured = remittanceInformationUnstructured;
    }

    public CreditorAccount getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(CreditorAccount creditorAccount) {
        this.creditorAccount = creditorAccount;
    }
}