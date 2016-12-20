package com.wildcreek.cmpp.codec;

import com.wildcreek.cmpp.meta.CmppSubmitRespMeta;
import com.wildcreek.cmpp.packet.CmppSubmitResp;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/13
 * Time: 11:29
 */
public class CmppSubmitRespCodec implements CmppPacketCodec<CmppSubmitRespMeta, CmppSubmitResp> {
    public byte[] code(CmppSubmitRespMeta packet) {
        return new byte[0];
    }

    public CmppSubmitResp decode(byte[] data) {
        CmppSubmitResp response = new CmppSubmitResp();
        ByteBuffer buffer = ByteBuffer.wrap(data);

        int totalLength = buffer.getInt();
        if (totalLength != data.length) {
            return null;
        }

        response.setTotalLength(totalLength);
        response.setCommandId(buffer.getInt());
        response.setSequenceId(buffer.getInt());
        response.setMsg_id(buffer.getLong());
        response.setResult(buffer.getInt());
        return response;
    }
}
