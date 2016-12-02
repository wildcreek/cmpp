package com.killxdcj.cmpp.packet;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/9
 * Time: 11:46
 */
public class CmppPacket {
    protected long totalLength;
    protected long commandId;
    protected long sequenceId;

    public long getTotalLength() {
        return totalLength;
    }

    public long getCommandId() {
        return commandId;
    }

    public long getSequenceId() {
        return sequenceId;
    }

    public void setTotalLength(long totalLength) {
        this.totalLength = totalLength;
    }

    public void setCommandId(long commandId) {
        this.commandId = commandId;
    }

    public void setSequenceId(long sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Override
    public String toString() {
        return "CmppPacket{" +
                "totalLength=" + totalLength +
                ", commandId=" + commandId +
                ", sequenceId=" + sequenceId +
                '}';
    }
}
