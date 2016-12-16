package com.killxdcj.cmpp.codec;

import com.killxdcj.cmpp.submit.CmppSubmit;
import com.killxdcj.cmpp.submit.Constants;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/13
 * Time: 11:29
 */
public class CmppSubmitCodec implements CmppPacketCodec<CmppSubmit, CmppSubmit> {
    public byte[] code(CmppSubmit packet) {
        CmppSubmit submit = new CmppSubmit(Constants.CMPP3_VERSION, "SENDSMS", "13651398480",
                "01", "0", "10690179", "18903769013", "中文안녕하세요", "linkid");
        submit.setMsgId(submit.getSequenceId());
        //ByteBuf buf = Unpooled.buffer();
//        String timeStamp = TimeUtil.genTimestampMdHms();
//        ByteBuffer buffer = ByteBuffer.allocate(39);
//        buffer.putInt(39);
//        buffer.putInt(CmppPacketType.CMPP_SUBMIT.getCommandId());
//        buffer.putInt(submit.getSequenceId());
//        buffer.putLong(packet.getMsgId());
        ByteBuffer buffer = submit.toBuffer();
        return buffer.array();
    }

    public CmppSubmit decode(byte[] data) {
        return  null;
    }
}