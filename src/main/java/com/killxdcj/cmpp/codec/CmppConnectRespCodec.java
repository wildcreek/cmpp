package com.killxdcj.cmpp.codec;

import com.killxdcj.cmpp.meta.CmppConnectRespMeta;
import com.killxdcj.cmpp.packet.CmppConnectResp;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

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
        //ByteBuffer buffer = ByteBuffer.wrap(data);
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeBytes(data);
        long totalLength = buffer.readUnsignedInt();
        if (totalLength != data.length) {
            return null;
        }

        connectResp.setTotalLength(totalLength);
        connectResp.setCommandId(buffer.readUnsignedInt());
        connectResp.setSequenceId(buffer.readUnsignedInt());
        connectResp.setStatus(buffer.readUnsignedInt());
        byte[] auth = new byte[16];
        buffer.readBytes(auth, 0, 16);
        connectResp.setAuthenticatorISMG(new String(auth));
        connectResp.setVersion(buffer.readByte());

        return connectResp;
    }
}
