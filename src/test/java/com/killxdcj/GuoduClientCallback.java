package com.killxdcj;

import com.killxdcj.cmpp.packet.CmppConnectResp;
import com.killxdcj.cmpp.packet.CmppPacket;
import com.killxdcj.sp.callback.CmppSpCallback;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/18
 * Time: 18:01
 */
public class GuoduClientCallback implements CmppSpCallback {
    public void onConnectResp(CmppConnectResp connectResp) {
        System.out.println(connectResp.toString());
    }

    public void onPacket(CmppPacket packet) {

    }
}
