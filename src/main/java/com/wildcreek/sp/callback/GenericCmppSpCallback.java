package com.wildcreek.sp.callback;

import com.wildcreek.cmpp.packet.*;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/20
 * Time: 18:00
 */
public abstract  class GenericCmppSpCallback implements CmppSpCallback {

    public void onPacket(CmppPacket packet) {
        switch (CmppPacketType.fromInt(packet.getCommandId())) {
            case CMPP_CONNECT_RESP:
                onCmppConnectResp((CmppConnectResp)packet);
                break;
            case CMPP_ACTIVE_TEST:
                onCmppActiveTest((CmppActiveTest)packet);
                break;
            case CMPP_ACTIVE_TEST_RESP:
                onCmppActiveTestResp((CmppActiveTestResp)packet);
                break;
            case CMPP_SUBMIT_RESP:
                onCmppSubmitResp((CmppSubmitResp)packet);
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

    protected void onCmppSubmitResp(final CmppSubmitResp submitResp) {

    }

    protected void onDefaultPacket(final CmppPacket packet) {

    }
}
