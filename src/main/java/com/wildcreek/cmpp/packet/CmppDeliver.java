package com.wildcreek.cmpp.packet;

import com.wildcreek.cmpp.deliver.CmppReport;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 19:29
 */
public class CmppDeliver extends CmppPacket{
    long msgId;

    String destId;// 21

    String serviceId = "0101WZXX";// 10

    byte tp_pid = 0;

    byte tp_udhi = 0;

    byte msgFmt = 0;

    String srcTerminalId;// 21

    byte srcTerminalType = 0;

    byte registeredDelivery = 1;

    byte msgLength;

    byte[] msgContent;// msgLength

    String linkId = "";// 8

    private CmppReport report;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getDestId() {
        return destId;
    }

    public void setDestId(String destId) {
        this.destId = destId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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

    public String getSrcTerminalId() {
        return srcTerminalId;
    }

    public void setSrcTerminalId(String srcTerminalId) {
        this.srcTerminalId = srcTerminalId;
    }

    public byte getSrcTerminalType() {
        return srcTerminalType;
    }

    public void setSrcTerminalType(byte srcTerminalType) {
        this.srcTerminalType = srcTerminalType;
    }

    public byte getRegisteredDelivery() {
        return registeredDelivery;
    }

    public void setRegisteredDelivery(byte registeredDelivery) {
        this.registeredDelivery = registeredDelivery;
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

    public CmppReport getReport() {
        return report;
    }

    public void setReport(CmppReport report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "CmppDeliver{" +
                "msgId=" + msgId +
                ", destId='" + destId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", tp_pid=" + tp_pid +
                ", tp_udhi=" + tp_udhi +
                ", msgFmt=" + msgFmt +
                ", srcTerminalId='" + srcTerminalId + '\'' +
                ", srcTerminalType=" + srcTerminalType +
                ", registeredDelivery=" + registeredDelivery +
                ", msgLength=" + msgLength +
                ", msgContent=" + Arrays.toString(msgContent) +
                ", linkId='" + linkId + '\'' +
                ", report=" + report +
                '}';
    }
}
