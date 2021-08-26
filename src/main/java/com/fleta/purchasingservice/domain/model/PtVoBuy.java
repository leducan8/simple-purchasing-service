package com.fleta.purchasingservice.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A PtVoBuy.
 */

@Entity()
@javax.persistence.Table(name = "pt_vo_buy", schema = "voduser")
public class PtVoBuy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "must not be null")
    @Column(name = "sa_id")
    private String saId;

    @NotNull(message = "must not be null")
    @Column(name = "mac_addr")
    private String macAddr;

    @NotNull(message = "must not be null")
    @Column(name = "buy_date")
    private String buyDate;

    @NotNull(message = "must not be null")
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "pkg_yn")
    private String pkgYn;

    @Column(name = "genre_name")
    private String genreName;

    @Column(name="buy_amt")
    private String buyAmt;

    @Column(name="cp_use_yn")
    private String cpUseYn;

    @Column(name="pvs_trans_yn")
    private String pvsTransYn;

    @Column(name="refund_yn")
    private String refundYn;

    @Column(name="pvs_trans_no")
    private String pvsTransNo;

    @Column(name="expired_date")
    private String expiredDate;

    @Column(name="alwnce_charge")
    private String alwnceCharge;

    @Column(name="balace")
    private String balace;

    @Column(name="offer_cd")
    private String offerCd;

    @Column(name="ofr_seq")
    private String ofrSeq;

    @Column(name="error_msg")
    private String errorMsg;

    @Column(name="appl_type")
    private String applType;
    private Long id;

    public String getSaId() {
        return this.saId;
    }

    public PtVoBuy saId(String saId) {
        this.saId = saId;
        return this;
    }

    public void setSaId(String saId) {
        this.saId = saId;
    }

    public String getMacAddr() {
        return this.macAddr;
    }

    public PtVoBuy macAddr(String macAddr) {
        this.macAddr = macAddr;
        return this;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getBuyDate() {
        return this.buyDate;
    }

    public PtVoBuy buyDate(String buyDate) {
        this.buyDate = buyDate;
        return this;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getProductId() {
        return this.productId;
    }

    public PtVoBuy productId(String productId) {
        this.productId = productId;
        return this;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public PtVoBuy productName(String productName) {
        this.productName = productName;
        return this;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPkgYn() {
        return this.pkgYn;
    }

    public PtVoBuy pkgYn(String pkgYn) {
        this.pkgYn = pkgYn;
        return this;
    }

    public void setPkgYn(String pkgYn) {
        this.pkgYn = pkgYn;
    }

    public String getGenreName() {
        return this.genreName;
    }

    public PtVoBuy genreName(String genreName) {
        this.genreName = genreName;
        return this;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getBuyAmt() {
        return this.buyAmt;
    }

    public PtVoBuy buyAmt(String buyAmt) {
        this.buyAmt = buyAmt;
        return this;
    }

    public void setBuyAmt(String buyAmt) {
        this.buyAmt = buyAmt;
    }

    public String getCpUseYn() {
        return this.cpUseYn;
    }

    public PtVoBuy cpUseYn(String cpUseYn) {
        this.cpUseYn = cpUseYn;
        return this;
    }

    public void setCpUseYn(String cpUseYn) {
        this.cpUseYn = cpUseYn;
    }

    public String getPvsTransYn() {
        return this.pvsTransYn;
    }

    public PtVoBuy pvsTransYn(String pvsTransYn) {
        this.pvsTransYn = pvsTransYn;
        return this;
    }

    public void setPvsTransYn(String pvsTransYn) {
        this.pvsTransYn = pvsTransYn;
    }

    public String getRefundYn() {
        return this.refundYn;
    }

    public PtVoBuy refundYn(String refundYn) {
        this.refundYn = refundYn;
        return this;
    }

    public void setRefundYn(String refundYn) {
        this.refundYn = refundYn;
    }

    public String getPvsTransNo() {
        return this.pvsTransNo;
    }

    public PtVoBuy pvsTransNo(String pvsTransNo) {
        this.pvsTransNo = pvsTransNo;
        return this;
    }

    public void setPvsTransNo(String pvsTransNo) {
        this.pvsTransNo = pvsTransNo;
    }

    public String getExpiredDate() {
        return this.expiredDate;
    }

    public PtVoBuy expiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
        return this;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getAlwnceCharge() {
        return this.alwnceCharge;
    }

    public PtVoBuy alwnceCharge(String alwnceCharge) {
        this.alwnceCharge = alwnceCharge;
        return this;
    }

    public void setAlwnceCharge(String alwnceCharge) {
        this.alwnceCharge = alwnceCharge;
    }

    public String getBalace() {
        return this.balace;
    }

    public PtVoBuy balace(String balace) {
        this.balace = balace;
        return this;
    }

    public void setBalace(String balace) {
        this.balace = balace;
    }

    public String getOfferCd() {
        return this.offerCd;
    }

    public PtVoBuy offerCd(String offerCd) {
        this.offerCd = offerCd;
        return this;
    }

    public void setOfferCd(String offerCd) {
        this.offerCd = offerCd;
    }

    public String getOfrSeq() {
        return this.ofrSeq;
    }

    public PtVoBuy ofrSeq(String ofrSeq) {
        this.ofrSeq = ofrSeq;
        return this;
    }

    public void setOfrSeq(String ofrSeq) {
        this.ofrSeq = ofrSeq;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public PtVoBuy errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getApplType() {
        return this.applType;
    }

    public PtVoBuy applType(String applType) {
        this.applType = applType;
        return this;
    }

    public void setApplType(String applType) {
        this.applType = applType;
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PtVoBuy{" +
            " saId='" + getSaId() + "'" +
            ", macAddr='" + getMacAddr() + "'" +
            ", buyDate='" + getBuyDate() + "'" +
            ", productId='" + getProductId() + "'" +
            ", productName='" + getProductName() + "'" +
            ", pkgYn='" + getPkgYn() + "'" +
            ", genreName='" + getGenreName() + "'" +
            ", buyAmt='" + getBuyAmt() + "'" +
            ", cpUseYn='" + getCpUseYn() + "'" +
            ", pvsTransYn='" + getPvsTransYn() + "'" +
            ", refundYn='" + getRefundYn() + "'" +
            ", pvsTransNo='" + getPvsTransNo() + "'" +
            ", expiredDate='" + getExpiredDate() + "'" +
            ", alwnceCharge='" + getAlwnceCharge() + "'" +
            ", balace='" + getBalace() + "'" +
            ", offerCd='" + getOfferCd() + "'" +
            ", ofrSeq='" + getOfrSeq() + "'" +
            ", errorMsg='" + getErrorMsg() + "'" +
            ", applType='" + getApplType() + "'" +
            "}";
    }

    public void setId(Long id) {
        this.id = id;
    }

    @javax.persistence.Id
    public Long getId() {
        return id;
    }
}
