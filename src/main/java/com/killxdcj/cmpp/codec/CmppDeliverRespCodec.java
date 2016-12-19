package com.killxdcj.cmpp.codec;


import com.killxdcj.cmpp.packet.CmppDeliverResp;
import com.killxdcj.cmpp.packet.CmppPacketType;
import com.killxdcj.cmpp.utils.CmppCommon;

import java.nio.ByteBuffer;

/**
 *  SP接收到ISMG的deliver消息后回复的消息
 */
public class CmppDeliverRespCodec implements CmppPacketCodec<CmppDeliverResp, CmppDeliverResp> {
    public byte[] code(CmppDeliverResp packet) {
        ByteBuffer buffer = ByteBuffer.allocate(24);
        buffer.putInt(24);
        buffer.putInt(CmppPacketType.CMPP_DELIVER_RESP.getCommandId());
        buffer.putInt(CmppCommon.genSequence());
        buffer.putLong(packet.getMsg_id());
        buffer.putInt(packet.getResult());

        return buffer.array();
    }

    public CmppDeliverResp decode(byte[] data) {
        return  null;
    }
}
