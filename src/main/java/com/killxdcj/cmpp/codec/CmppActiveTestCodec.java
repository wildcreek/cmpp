package com.killxdcj.cmpp.codec;

import com.killxdcj.cmpp.meta.CmppActiveTestMeta;
import com.killxdcj.cmpp.packet.CmppActiveTest;
import com.killxdcj.cmpp.packet.CmppPacketType;
import com.killxdcj.cmpp.utils.CmppCommon;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 19:25
 */
public class CmppActiveTestCodec implements CmppPacketCodec<CmppActiveTestMeta, CmppActiveTest>{
    public byte[] code(CmppActiveTestMeta packet) {
 //       ByteBuffer buffer = ByteBuffer.allocate(12);
//        buffer.putInt(12);
//        buffer.putInt(CmppPacketType.CMPP_ACTIVE_TEST.getCommandId());
//        buffer.putInt(CmppCommon.genSequence());
        ByteBuf buf = Unpooled.buffer(12);
        buf.writeBytes(CmppCommon.int2ByteArray(12));
        buf.writeBytes(CmppCommon.long2ByteArray(CmppPacketType.CMPP_ACTIVE_TEST.getCommandId()));
        buf.writeBytes(CmppCommon.int2ByteArray(CmppCommon.genSequence()));
        return buf.array();
    }

    public CmppActiveTest decode(byte[] data) {
        return null;
    }
}
