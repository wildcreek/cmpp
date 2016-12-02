package com.killxdcj.cmpp.packet;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/18
 * Time: 17:48
 */
public class CmppConnectResp extends CmppPacket {
    private long status;
    private String AuthenticatorISMG;
    private int version;

    public CmppConnectResp() {

    }

    public CmppConnectResp(long status, String authenticatorISMG, int version) {
        this.status = status;
        AuthenticatorISMG = authenticatorISMG;
        this.version = version;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getAuthenticatorISMG() {
        return AuthenticatorISMG;
    }

    public void setAuthenticatorISMG(String authenticatorISMG) {
        AuthenticatorISMG = authenticatorISMG;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "CmppConnectResp{" +
                "status=" + status +
                ", AuthenticatorISMG='" + AuthenticatorISMG + '\'' +
                ", version=" + version +
                "} " + super.toString();
    }
}
