package com.killxdcj.cmpp.codec;

import com.killxdcj.cmpp.meta.CmppConnectRespMeta;
import com.killxdcj.cmpp.packet.CmppConnectResp;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/18
 * Time: 17:51
 */
public class CmppConnectRespCodec implements CmppPacketCodec<CmppConnectRespMeta, CmppConnectResp> {

    public byte[] code(CmppConnectRespMeta packet) {
        return new byte[0];
    }

    public CmppConnectResp decode(byte[] data) {
        CmppConnectResp connectResp = new CmppConnectResp();
        ByteBuffer buffer = ByteBuffer.wrap(data);

        int totalLength = buffer.getInt();
        if (totalLength != data.length) {
            return null;
        }

        connectResp.setTotalLength(totalLength);
        connectResp.setCommandId(buffer.getInt());
        connectResp.setSequenceId(buffer.getInt());
        connectResp.setStatus(buffer.get());
        byte[] auth = new byte[16];
        buffer.get(auth, 0, 16);
        connectResp.setAuthenticatorISMG(new String(auth));
        connectResp.setVersion(buffer.get());

        return connectResp;
    }
}
