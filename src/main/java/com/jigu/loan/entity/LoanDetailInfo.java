package com.jigu.loan.entity;

import java.io.Serializable;

public class LoanDetailInfo implements Serializable {
    private Long id;

    /**
     * loan_info.id
     */
    private Long loanInfoId;

    /**
     * 资料名称
     */
    private String infoName;

    /**
     * 对应资料图片
     */
    private String imgs;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoanInfoId() {
        return loanInfoId;
    }

    public void setLoanInfoId(Long loanInfoId) {
        this.loanInfoId = loanInfoId;
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName == null ? null : infoName.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loanInfoId=").append(loanInfoId);
        sb.append(", infoName=").append(infoName);
        sb.append(", imgs=").append(imgs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}