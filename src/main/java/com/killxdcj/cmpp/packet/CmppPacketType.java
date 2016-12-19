package com.killxdcj.cmpp.packet;

import com.killxdcj.cmpp.codec.*;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/13
 * Time: 11:23
 */
public enum CmppPacketType {
    CMPP_CONNECT(0x00000001, CmppConnect.class, CmppConnectCodec.class),
    CMPP_CONNECT_RESP(0x80000001, CmppConnectResp.class, CmppConnectRespCodec.class),
    CMPP_ACTIVE_TEST(0x00000008, CmppActiveTest.class, CmppActiveTestCodec.class),
    CMPP_ACTIVE_TEST_RESP(0x80000008, CmppActiveTestResp.class, CmppActiveTestRespCodec.class),
    CMPP_SUBMIT(0x00000004, CmppSubmit.class, CmppSubmitCodec.class),
    CMPP_SUBMIT_RESP(0x80000004,CmppSubmitResp.class, CmppSubmitRespCodec.class),
    CMPP_DELIVER(0x00000005, CmppDeliver.class, CmppDeliverCodec.class),
    CMPP_DELIVER_RESP(0x80000005,CmppDeliverResp.class, CmppDeliverRespCodec.class);

    private int commandId;
    private Class<? extends CmppPacket> packetStructure;
    private Class<? extends CmppPacketCodec> codec;

    CmppPacketType(int commandId, Class<? extends CmppPacket> packetStructure, Class<? extends CmppPacketCodec> codec) {
        this.commandId = commandId;
        this.packetStructure = packetStructure;
        this.codec = codec;
    }

    public int getCommandId() {
        return commandId;
    }

    public CmppPacketCodec getCodec() {
        try {
            return codec.newInstance();
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public static CmppPacketType fromInt(int cmd) {
        switch (cmd) {
            case 0x00000001:
                return CMPP_CONNECT;
            case 0x80000001:
                return CMPP_CONNECT_RESP;
            case 0x00000008:
                return CMPP_ACTIVE_TEST;
            case 0x80000008:
                return CMPP_ACTIVE_TEST_RESP;
            case 0x00000004:
                return CMPP_SUBMIT;
            case 0x80000004:
                return CMPP_SUBMIT_RESP;
            case 0x00000005:
                return CMPP_DELIVER;
            case 0x80000005:
                return CMPP_DELIVER_RESP;
        }
        return null;
    }

    @Override
    public String toString() {
        return "CmppPacketType{" +
                "commandId=" + commandId +
                ", packetStructure=" + packetStructure.getSimpleName() +
                ", codec=" + codec.getSimpleName() +
                '}';
    }
}
