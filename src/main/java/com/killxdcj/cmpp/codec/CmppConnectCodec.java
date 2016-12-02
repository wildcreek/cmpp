package com.killxdcj.cmpp.codec;

import com.killxdcj.cmpp.meta.CmppConnectMeta;
import com.killxdcj.cmpp.packet.CmppConnect;
import com.killxdcj.cmpp.packet.CmppPacketType;
import com.killxdcj.cmpp.utils.CmppCommon;
import com.killxdcj.cmpp.utils.TimeUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/13
 * Time: 11:29
 */
public class CmppConnectCodec implements CmppPacketCodec<CmppConnectMeta, CmppConnect> {
    public byte[] code(CmppConnectMeta packet) {
        String timeStamp = TimeUtil.genTimestampMdHms();
//        ByteBuffer buffer = ByteBuffer.allocate(39);
//        buffer.putInt(39);
//        buffer.putInt(CmppPacketType.CMPP_CONNECT.getCommandId());
//        buffer.putInt(CmppCommon.genSequence());
//        buffer.put(PacketUtil.fixedBytes(packet.getSourceAddr().getBytes(), 6, true, true));
//        buffer.put(getAuthenticatorSource(packet.getSourceAddr(), packet.getSharedSecret(), timeStamp));
//        buffer.put((byte) packet.getVersion());
//        buffer.putInt(Integer.parseInt(timeStamp));
        ByteBuf buf = Unpooled.buffer(39);
        buf.writeBytes(CmppCommon.int2ByteArray(39));
        buf.writeBytes(CmppCommon.long2ByteArray(CmppPacketType.CMPP_CONNECT.getCommandId()));
        buf.writeBytes(CmppCommon.int2ByteArray(CmppCommon.genSequence()));
        return buf.array();
    }

    public CmppConnect decode(byte[] data) {
        CmppConnect connect = new CmppConnect();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        int length = buffer.getInt();
        if (length != data.length) {
            return null;
        }

        connect.setTotalLength(length);
        connect.setCommandId(buffer.getInt());
        connect.setSequenceId(buffer.getInt());
        byte[] sourceByte = new byte[6];
        buffer.get(sourceByte, 0, 6);
        connect.setSoureAddr(new String(sourceByte));
        byte[] authByte = new byte[16];
        buffer.get(authByte, 0, 16);
        connect.setAuthenticatorSource(new String(authByte));
        connect.setVersion(buffer.get());
        connect.setTimestamp(buffer.getInt());
        return connect;
    }

    private byte[] getAuthenticatorSource(String sourceAddr, String sharedSecret, String timestamp) {
        try {
            String source = String.format("%s\0\0\0\0\0\0\0\0\0%s%s", sourceAddr, sharedSecret, timestamp);
            MessageDigest digest = MessageDigest.getInstance("MD5");
            return digest.digest(source.getBytes());
        } catch (NoSuchAlgorithmException e) {
            return new byte[16];
        }

    }
}
