package com.killxdcj.cmpp.packet;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 19:29
 */
public class CmppSubmitResp extends CmppPacket {
    private long msg_id;
    private int result;

    public long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(long msg_id) {
        this.msg_id = msg_id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CmppSubmitResp{" +
                "msg_id=" + msg_id +
                ", result=" + result +
                '}';
    }
}
