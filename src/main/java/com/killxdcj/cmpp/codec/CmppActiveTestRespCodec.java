package com.killxdcj.cmpp.codec;

import com.killxdcj.cmpp.meta.CmppActiveTestRespMeta;
import com.killxdcj.cmpp.packet.CmppActiveTestResp;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 19:26
 */
public class CmppActiveTestRespCodec implements CmppPacketCodec<CmppActiveTestRespMeta, CmppActiveTestResp>{
    public byte[] code(CmppActiveTestRespMeta packet) {
        return new byte[0];
    }

    public CmppActiveTestResp decode(byte[] data) {
        CmppActiveTestResp activeTestResp = new CmppActiveTestResp();
        //ByteBuffer buffer = ByteBuffer.wrap(data);
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(data);
        long totalLength = buf.readUnsignedInt();
        if (totalLength != data.length) {
            return null;
        }

        activeTestResp.setTotalLength(totalLength);
        activeTestResp.setCommandId(buf.readUnsignedInt());
        activeTestResp.setSequenceId(buf.readUnsignedInt());
        activeTestResp.setReserved(buf.readByte());

        return activeTestResp;
    }
}
