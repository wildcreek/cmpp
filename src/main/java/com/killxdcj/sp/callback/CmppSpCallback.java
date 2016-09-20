package com.killxdcj.sp.callback;

import com.killxdcj.cmpp.packet.CmppConnectResp;
import com.killxdcj.cmpp.packet.CmppPacket;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/18
 * Time: 17:47
 */
public interface CmppSpCallback {
    public void onPacket(CmppPacket packet);
}
