package com.killxdcj.test;

import io.netty.buffer.UnpooledHeapByteBuf;
import sun.jvm.hotspot.runtime.Bytes;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/**
 * Created by caojianhua on 16/9/7.
 */
public class Test {
    public static void main(String args[]) {
//        String sec = "xxx" + "000000000" + "0907161200";
//        System.out.println(sec.getBytes().length);
//        ByteBuffer buffer = new HeapByteBuffer();
//        byte xx = (byte)0xFF;
//        ByteBuffer buffer = ByteBuffer.allocate(10);
//        //buffer.putInt(xx);
//        buffer.put(xx);
//        xx = (byte)0x0F;
//        buffer.put(xx);
//        xx = (byte)0xF0;
//        buffer.put(xx);
//        xx = (byte)511;
//        buffer.put(xx);
//
////        Byte xx2 = 0X71;
////        int version = ((0x1 << 4) | 3);
//        System.out.println(buffer.array()[0] & 0xFF);
//        System.out.println(buffer.array()[1] & 0xFF);
//        System.out.println(buffer.array()[2] & 0xFF);
//        System.out.println(buffer.array()[3] & 0xFF);

//        ByteBuffer buffer = ByteBuffer.allocate(39);
//        buffer.putInt(39);
//        buffer.putInt(100);
//        buffer.putInt(1);
//        buffer.put("999059".getBytes());
//        buffer.put("0123456789ABCDEF".getBytes());
//        buffer.put((byte) 0x20);
//        buffer.putInt(908143700);
//
//        buffer.position(0);
//        System.out.println(buffer.getInt());
//        System.out.println(buffer.getInt());
//        System.out.println(buffer.getInt());
//        byte[] addr = new byte[6];
//        buffer.get(addr, 0, 6);
//        System.out.println(new String(addr));
//        byte[] source = new byte[16];
//        buffer.get(source, 0, 16);
//        System.out.println(new String(source));
//
//        System.out.println(buffer.get());
//        System.out.println(buffer.getInt());
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = digest.digest("xxxx".getBytes());
            System.out.println(md5Bytes.length + " : " + new String(md5Bytes));
            StringBuffer hexValue = new StringBuffer();
            for (byte xx :
                    md5Bytes) {
                int val = ((int) xx) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            System.out.println(hexValue);
            System.out.println(hexValue.substring(8, 24));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public byte[] buildCmppConnect() {
        ByteBuffer buffer = ByteBuffer.allocate(39);
        buffer.putInt(39);
        buffer.putInt(1);
        buffer.putInt(5779803);
        buffer.put("999059".getBytes());
//        ByteBuffer source = ByteBuffer.allocate(35);
//        source.put("999059".getBytes());
//        source.put(new byte[9]);
//        source.put("PGLTJMCNF5".getBytes());
//        source.put("0908174200".getBytes());
//        buffer.put(calcMd5(source.array()));
        buffer.put(calcMd5("999059\0\0\0\0\0\0\0\0\0PGLTJMCNF50908174200".getBytes()));
        buffer.put((byte) 0x20);
        buffer.putInt(908174200);

        return buffer.array();
    }

    public byte[] calcMd5(byte[] source) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = digest.digest(source);
            return md5Bytes;
//            System.out.println(md5Bytes.length + " : " + new String(md5Bytes));
//            StringBuffer hexValue = new StringBuffer();
//            for (byte xx :
//                    md5Bytes) {
//                int val = ((int) xx) & 0xff;
//                if (val < 16)
//                    hexValue.append("0");
//                hexValue.append(Integer.toHexString(val));
//            }
////            System.out.println(hexValue);
////            System.out.println(hexValue.substring(8, 24));
//            return hexValue.substring(8, 24).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
