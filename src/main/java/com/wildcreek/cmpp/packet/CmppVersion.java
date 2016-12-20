package com.wildcreek.cmpp.packet;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/9
 * Time: 18:19
 */
public enum CmppVersion {
    CMPP20(0x20),
    CMPP30(0x30);

    private int version;

    public int getVersion() {
        return version;
    }

    CmppVersion(int version) {
        this.version = version;
    }
}
