package com.wildcreek.cmpp.codec;

import com.wildcreek.cmpp.meta.CmppActiveTestRespMeta;
import com.wildcreek.cmpp.packet.CmppActiveTestResp;

import java.nio.ByteBuffer;

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
        ByteBuffer buffer = ByteBuffer.wrap(data);
        int totalLength = buffer.getInt();
        if (totalLength != data.length) {
            return null;
        }

        activeTestResp.setTotalLength(totalLength);
        activeTestResp.setCommandId(buffer.getInt());
        activeTestResp.setSequenceId(buffer.getInt());
        activeTestResp.setReserved(buffer.get());

        return activeTestResp;
    }
}
