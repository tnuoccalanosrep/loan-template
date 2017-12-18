package com.jigu.loan.entity;

import java.io.Serializable;
import java.util.Date;

public class LoanInfo implements Serializable {
    private Long id;

    private String summary;

    /**
     * 贷款类型
     */
    private Byte loanTypeId;

    private Date createTime;

    private Integer followerId;

    /**
     * 身份证
     */
    private String creditCard;

    /**
     * 驾照
     */
    private String drivingLicense;

    /**
     * 收入证明
     */
    private String incomeCertificate;

    /**
     * 手机在网证明
     */
    private String mobileCertificate;

    /**
     * 流水
     */
    private String cashFlow;

    /**
     * 房产证明
     */
    private String propertyCertificate;

    /**
     * 申请表
     */
    private String application;

    /**
     * 购车合同
     */
    private String carContract;

    /**
     * 车辆委托
     */
    private String vehicleDisposal;

    /**
     * 共同赔偿协议
     */
    private String indemnityAgreement;

    /**
     * 二手车行驶证
     */
    private String drivingPermit;

    /**
     * 二手车评估证明
     */
    private String evaluate;

    /**
     * 其他详情ID
     */
    private Long otherDetailId;

    /**
     * 服务委托合同
     */
    private String serviceContract;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Byte getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(Byte loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard == null ? null : creditCard.trim();
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense == null ? null : drivingLicense.trim();
    }

    public String getIncomeCertificate() {
        return incomeCertificate;
    }

    public void setIncomeCertificate(String incomeCertificate) {
        this.incomeCertificate = incomeCertificate == null ? null : incomeCertificate.trim();
    }

    public String getMobileCertificate() {
        return mobileCertificate;
    }

    public void setMobileCertificate(String mobileCertificate) {
        this.mobileCertificate = mobileCertificate == null ? null : mobileCertificate.trim();
    }

    public String getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(String cashFlow) {
        this.cashFlow = cashFlow == null ? null : cashFlow.trim();
    }

    public String getPropertyCertificate() {
        return propertyCertificate;
    }

    public void setPropertyCertificate(String propertyCertificate) {
        this.propertyCertificate = propertyCertificate == null ? null : propertyCertificate.trim();
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getCarContract() {
        return carContract;
    }

    public void setCarContract(String carContract) {
        this.carContract = carContract == null ? null : carContract.trim();
    }

    public String getVehicleDisposal() {
        return vehicleDisposal;
    }

    public void setVehicleDisposal(String vehicleDisposal) {
        this.vehicleDisposal = vehicleDisposal == null ? null : vehicleDisposal.trim();
    }

    public String getIndemnityAgreement() {
        return indemnityAgreement;
    }

    public void setIndemnityAgreement(String indemnityAgreement) {
        this.indemnityAgreement = indemnityAgreement == null ? null : indemnityAgreement.trim();
    }

    public String getDrivingPermit() {
        return drivingPermit;
    }

    public void setDrivingPermit(String drivingPermit) {
        this.drivingPermit = drivingPermit == null ? null : drivingPermit.trim();
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    public Long getOtherDetailId() {
        return otherDetailId;
    }

    public void setOtherDetailId(Long otherDetailId) {
        this.otherDetailId = otherDetailId;
    }

    public String getServiceContract() {
        return serviceContract;
    }

    public void setServiceContract(String serviceContract) {
        this.serviceContract = serviceContract == null ? null : serviceContract.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", summary=").append(summary);
        sb.append(", loanTypeId=").append(loanTypeId);
        sb.append(", createTime=").append(createTime);
        sb.append(", followerId=").append(followerId);
        sb.append(", creditCard=").append(creditCard);
        sb.append(", drivingLicense=").append(drivingLicense);
        sb.append(", incomeCertificate=").append(incomeCertificate);
        sb.append(", mobileCertificate=").append(mobileCertificate);
        sb.append(", cashFlow=").append(cashFlow);
        sb.append(", propertyCertificate=").append(propertyCertificate);
        sb.append(", application=").append(application);
        sb.append(", carContract=").append(carContract);
        sb.append(", vehicleDisposal=").append(vehicleDisposal);
        sb.append(", indemnityAgreement=").append(indemnityAgreement);
        sb.append(", drivingPermit=").append(drivingPermit);
        sb.append(", evaluate=").append(evaluate);
        sb.append(", otherDetailId=").append(otherDetailId);
        sb.append(", serviceContract=").append(serviceContract);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}