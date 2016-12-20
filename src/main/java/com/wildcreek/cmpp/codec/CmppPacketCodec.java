package com.wildcreek.cmpp.codec;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/13
 * Time: 11:26
 */
public interface CmppPacketCodec<META_TYPE, PACKET_TYPE> {
    public byte[] code(META_TYPE packet);
    public PACKET_TYPE decode(byte[] data);
}
