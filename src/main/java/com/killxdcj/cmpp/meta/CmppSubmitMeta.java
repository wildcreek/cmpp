package com.killxdcj.cmpp.meta;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/20
 * Time: 11:39
 */
public class CmppSubmitMeta {
    private long msgId = 0;

    private byte pkTotal = 0;

    private byte pkNumber = 0;

    private byte registeredDelivery = 1;

    private byte msgLevel = 0;

    private String serviceId;// 10

    private byte feeUserType = 3;

    private String feeTerminalId;// 32

    private byte feeTerminalType = 0;

    private byte tp_pid = 0;

    private byte tp_udhi = 0;

    private byte msgFmt = 15;

    private String msgSrc;// 6

    private String feeType;// 2

    private String feeCode;// 6

    private String vaildTime = "";// 17

    private String atTime = "";// 17

    private String srcId;// 21

    private byte destUsrTl = 1;

    private String[] destTerminalId;// 21

    private byte destTerminalType = 0;

    private byte msgLength; // 1

    private byte[] msgContent;

    private String linkId = "";// 20

}
