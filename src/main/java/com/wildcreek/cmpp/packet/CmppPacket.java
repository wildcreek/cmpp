package com.wildcreek.cmpp.packet;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/9
 * Time: 11:46
 */
public class CmppPacket {
    protected int totalLength;
    protected int commandId;
    protected int sequenceId;

    public int getTotalLength() {
        return totalLength;
    }

    public int getCommandId() {
        return commandId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setTotalLength(int totalLength) {
        this.totalLength = totalLength;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Override
    public String toString() {
        return "CmppPacket{" +
                ", totalLength=" + totalLength +
                ", commandId=" + commandId +
                ", sequenceId=" + sequenceId +
                '}';
    }
}
