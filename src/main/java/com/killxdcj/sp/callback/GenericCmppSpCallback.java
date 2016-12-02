package com.killxdcj.sp.callback;

import com.killxdcj.cmpp.packet.*;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/20
 * Time: 18:00
 */
public abstract  class GenericCmppSpCallback implements CmppSpCallback {

    public void onPacket(CmppPacket packet) {
        switch (CmppPacketType.parseCommand(packet.getCommandId())) {
            case CMPP_CONNECT_RESP:
                onCmppConnectResp((CmppConnectResp)packet);
                break;
            case CMPP_ACTIVE_TEST:
                onCmppActiveTest((CmppActiveTest)packet);
                break;
            case CMPP_ACTIVE_TEST_RESP:
                onCmppActiveTestResp((CmppActiveTestResp)packet);
                break;
            default:
                onDefaultPacket(packet);
                break;
        }
    }

    protected void onCmppConnectResp(final CmppConnectResp connectResp) {

    }

    protected void onCmppActiveTest(final CmppActiveTest activeTest) {

    }

    protected void onCmppActiveTestResp(final CmppActiveTestResp activeTestResp) {

    }

    protected void onDefaultPacket(final CmppPacket packet) {

    }
}
