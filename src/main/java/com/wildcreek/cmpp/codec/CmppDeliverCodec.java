package com.wildcreek.cmpp.codec;

import com.wildcreek.cmpp.packet.CmppDeliver;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 *  ISMG->SP 处理ISMG向SP发送的消息，重写decode
 */
public class CmppDeliverCodec implements CmppPacketCodec<CmppDeliver, CmppDeliver> {
    public byte[] code(CmppDeliver packet) {
        return new byte[0];
    }

    public CmppDeliver decode(byte[] data) {
        CmppDeliver deliver = new CmppDeliver();
        ByteBuffer buffer = ByteBuffer.wrap(data);

        int totalLength = buffer.getInt();
        if (totalLength != data.length) {
            return null;
        }
        deliver.setTotalLength(totalLength);
        deliver.setCommandId(buffer.getInt());
        deliver.setSequenceId(buffer.getInt());
        deliver.setMsgId(buffer.getLong());

        byte[] dest_id = new byte[21];
        buffer.get(dest_id, 0, 21);
        deliver.setDestId(new String(dest_id));

        byte[] service_id = new byte[10];
        buffer.get(service_id, 0, 10);
        deliver.setServiceId(new String(service_id));

        deliver.setTp_pid(buffer.get());
        deliver.setTp_udhi(buffer.get());
        deliver.setMsgFmt(buffer.get());

        byte[] src_terminal_id = new byte[32];
        buffer.get(src_terminal_id, 0, 32);
        deliver.setSrcTerminalId(new String(src_terminal_id));

        deliver.setSrcTerminalType(buffer.get());
        deliver.setRegisteredDelivery(buffer.get());
        byte msg_length = buffer.get();
        deliver.setMsgLength(msg_length);

        byte[] msg_content = new byte[msg_length];
        buffer.get(msg_content,0,msg_length);
        deliver.setMsgContent(msg_content);

        byte[] linkid = new byte[20];
        buffer.get(linkid,0,20);
        deliver.setLinkId(new String(linkid));

        return deliver;
    }
    private String fetchStringFromByteBuffer(ByteBuffer buffer,int len) throws UnsupportedEncodingException {
        byte[] result = new byte[len];
        buffer.get(result, 0, len);
        return new String(result, "US-ASCII");
    }
}
