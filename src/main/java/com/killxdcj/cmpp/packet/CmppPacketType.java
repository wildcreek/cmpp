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
    CMPP_ACTIVE_TEST_RESP(0x80000008, CmppActiveTestResp.class, CmppActiveTestRespCodec.class);

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
        }
        return null;
    }

    @Override
    public String toString() {
        return "CmppPacketType{" +
                "commandId=" + commandId +
                ", packetStructure=" + packetStructure +
                ", codec=" + codec +
                '}';
    }
}
