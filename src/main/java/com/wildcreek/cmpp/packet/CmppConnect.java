package com.wildcreek.cmpp.packet;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/9
 * Time: 17:32
 */
public class CmppConnect extends CmppPacket {
    private String soureAddr;
    private String authenticatorSource;
    private int version;
    private int timestamp;

    public CmppConnect() {
    }

    public CmppConnect(String soureAddr, String authenticatorSource, int version, int timestamp) {
        this.soureAddr = soureAddr;
        this.authenticatorSource = authenticatorSource;
        this.version = version;
        this.timestamp = timestamp;
    }

    public String getSoureAddr() {
        return soureAddr;
    }

    public void setSoureAddr(String soureAddr) {
        this.soureAddr = soureAddr;
    }

    public String getAuthenticatorSource() {
        return authenticatorSource;
    }

    public void setAuthenticatorSource(String authenticatorSource) {
        this.authenticatorSource = authenticatorSource;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CmppConnect{" +
                "soureAddr='" + soureAddr + '\'' +
                ", authenticatorSource='" + authenticatorSource + '\'' +
                ", version=" + version +
                ", timestamp=" + timestamp +
                "} " + super.toString();
    }
}
