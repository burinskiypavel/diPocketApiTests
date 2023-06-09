package model.aspsp.pis;

public class PaymentsDomesticCreditTransfersRequest {
    private InstructedAmount instructedAmount;
    private String creditorName;
    private String creditorType;
    private CreditorAccount creditorAccount;
    private  String remittanceInformationUnstructured;

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

    public CreditorAccount getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(CreditorAccount creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public String getRemittanceInformationUnstructured() {
        return remittanceInformationUnstructured;
    }

    public void setRemittanceInformationUnstructured(String remittanceInformationUnstructured) {
        this.remittanceInformationUnstructured = remittanceInformationUnstructured;
    }
}