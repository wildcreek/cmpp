package com.killxdcj.cmpp.codec;

import com.killxdcj.cmpp.meta.CmppActiveTestMeta;
import com.killxdcj.cmpp.packet.CmppActiveTest;
import com.killxdcj.cmpp.packet.CmppPacketType;
import com.killxdcj.cmpp.utils.CmppCommon;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 19:25
 */
public class CmppActiveTestCodec implements CmppPacketCodec<CmppActiveTestMeta, CmppActiveTest>{
    public byte[] code(CmppActiveTestMeta packet) {
        ByteBuffer buffer = ByteBuffer.allocate(12);
        buffer.putInt(12);
        buffer.putInt(CmppPacketType.CMPP_ACTIVE_TEST.getCommandId());
        buffer.putInt(CmppCommon.genSequence());
        return buffer.array();
    }

    public CmppActiveTest decode(byte[] data) {
        CmppActiveTest test = new CmppActiveTest();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        int length = buffer.getInt();
        if (length != data.length) {
            return null;
        }

        test.setTotalLength(length);
        test.setCommandId(buffer.getInt());
        test.setSequenceId(buffer.getInt());
        return test;
    }
}
