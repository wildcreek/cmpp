package com.wildcreek.cmpp.packet;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 19:29
 */
public class CmppSubmit extends CmppPacket{

    long msgId = 0;

    byte pkTotal = 1;

    byte pkNumber = 1;

    byte registeredDelivery = 1;

    byte msgLevel = 0;

    String serviceId;// 10

    byte feeUserType = 0;

    String feeTerminalId;// 32

    byte feeTerminalType = 0;

    byte tp_pid = 0;

    byte tp_udhi = 0;

    byte msgFmt = 15;

    String msgSrc = "960000";// 6

    String feeType = "01";// 2

    String feeCode = "0";// 6

    String vaildTime = "";// 17

    String atTime = "";// 17

    String srcId = "10658222";// 21

    byte destUsrTl = 1;

    String[] destTerminalId;// 21

    byte destTerminalType = 0;

    byte msgLength; // 1

    byte[] msgContent;

    String linkId = "";// 20

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public byte getPkTotal() {
        return pkTotal;
    }

    public void setPkTotal(byte pkTotal) {
        this.pkTotal = pkTotal;
    }

    public byte getPkNumber() {
        return pkNumber;
    }

    public void setPkNumber(byte pkNumber) {
        this.pkNumber = pkNumber;
    }

    public byte getRegisteredDelivery() {
        return registeredDelivery;
    }

    public void setRegisteredDelivery(byte registeredDelivery) {
        this.registeredDelivery = registeredDelivery;
    }

    public byte getMsgLevel() {
        return msgLevel;
    }

    public void setMsgLevel(byte msgLevel) {
        this.msgLevel = msgLevel;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public byte getFeeUserType() {
        return feeUserType;
    }

    public void setFeeUserType(byte feeUserType) {
        this.feeUserType = feeUserType;
    }

    public String getFeeTerminalId() {
        return feeTerminalId;
    }

    public void setFeeTerminalId(String feeTerminalId) {
        this.feeTerminalId = feeTerminalId;
    }

    public byte getFeeTerminalType() {
        return feeTerminalType;
    }

    public void setFeeTerminalType(byte feeTerminalType) {
        this.feeTerminalType = feeTerminalType;
    }

    public byte getTp_pid() {
        return tp_pid;
    }

    public void setTp_pid(byte tp_pid) {
        this.tp_pid = tp_pid;
    }

    public byte getTp_udhi() {
        return tp_udhi;
    }

    public void setTp_udhi(byte tp_udhi) {
        this.tp_udhi = tp_udhi;
    }

    public byte getMsgFmt() {
        return msgFmt;
    }

    public void setMsgFmt(byte msgFmt) {
        this.msgFmt = msgFmt;
    }

    public String getMsgSrc() {
        return msgSrc;
    }

    public void setMsgSrc(String msgSrc) {
        this.msgSrc = msgSrc;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getVaildTime() {
        return vaildTime;
    }

    public void setVaildTime(String vaildTime) {
        this.vaildTime = vaildTime;
    }

    public String getAtTime() {
        return atTime;
    }

    public void setAtTime(String atTime) {
        this.atTime = atTime;
    }

    public String getSrcId() {
        return srcId;
    }

    public void setSrcId(String srcId) {
        this.srcId = srcId;
    }

    public byte getDestUsrTl() {
        return destUsrTl;
    }

    public void setDestUsrTl(byte destUsrTl) {
        this.destUsrTl = destUsrTl;
    }

    public String[] getDestTerminalId() {
        return destTerminalId;
    }

    public void setDestTerminalId(String[] destTerminalId) {
        this.destTerminalId = destTerminalId;
    }

    public byte getDestTerminalType() {
        return destTerminalType;
    }

    public void setDestTerminalType(byte destTerminalType) {
        this.destTerminalType = destTerminalType;
    }

    public byte getMsgLength() {
        return msgLength;
    }

    public void setMsgLength(byte msgLength) {
        this.msgLength = msgLength;
    }

    public byte[] getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(byte[] msgContent) {
        this.msgContent = msgContent;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    @Override
    public String toString() {
        return "CmppSubmit{" +
                "msgId=" + msgId +
                ", pkTotal=" + pkTotal +
                ", pkNumber=" + pkNumber +
                ", registeredDelivery=" + registeredDelivery +
                ", msgLevel=" + msgLevel +
                ", serviceId='" + serviceId + '\'' +
                ", feeUserType=" + feeUserType +
                ", feeTerminalId='" + feeTerminalId + '\'' +
                ", feeTerminalType=" + feeTerminalType +
                ", tp_pid=" + tp_pid +
                ", tp_udhi=" + tp_udhi +
                ", msgFmt=" + msgFmt +
                ", msgSrc='" + msgSrc + '\'' +
                ", feeType='" + feeType + '\'' +
                ", feeCode='" + feeCode + '\'' +
                ", vaildTime='" + vaildTime + '\'' +
                ", atTime='" + atTime + '\'' +
                ", srcId='" + srcId + '\'' +
                ", destUsrTl=" + destUsrTl +
                ", destTerminalId=" + Arrays.toString(destTerminalId) +
                ", destTerminalType=" + destTerminalType +
                ", msgLength=" + msgLength +
                ", msgContent=" + Arrays.toString(msgContent) +
                ", linkId='" + linkId + '\'' +
                '}';
    }
}
