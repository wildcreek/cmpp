package com.killxdcj.cmpp.utils;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/18
 * Time: 17:04
 */
public class PacketUtil {
    public static byte[] fixedBytes(byte[] source, int length, boolean fixedLeft, boolean cutLeft) {
        if (source.length == length) {
            return source;
        }

        if (source.length < length) {
            int fixed = length - source.length;
            ByteBuffer buffer = ByteBuffer.allocate(length);
            if (fixedLeft) {
                buffer.put(new byte[fixed]);
                buffer.put(source);
            } else {
                buffer.put(source);
                buffer.put(new byte[fixed]);
            }
            return buffer.array();
        }

        if (source.length > length) {
            int fixed = source.length - length;
            ByteBuffer buffer = ByteBuffer.allocate(length);
            if (cutLeft) {
                buffer.put(source, fixed, length);
            } else {
                buffer.put(source, 0, length);
            }
            return buffer.array();
        }

        return source;
    }
}
