package com.wildcreek.cmpp.packet;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 19:29
 */
public class CmppActiveTestResp extends CmppPacket{
    private int Reserved;

    public int getReserved() {
        return Reserved;
    }

    public void setReserved(int reserved) {
        Reserved = reserved;
    }

    @Override
    public String toString() {
        return "CmppActiveTestResp{" +
                "Reserved=" + Reserved +
                "} " + super.toString();
    }
}
