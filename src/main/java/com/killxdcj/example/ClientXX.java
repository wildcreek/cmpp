package com.killxdcj.example;

import com.killxdcj.cmpp.packet.*;
import com.killxdcj.sp.Client;
import com.killxdcj.sp.callback.GenericCmppSpCallback;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 15:17
 */
public class ClientXX extends GenericCmppSpCallback {
    Client client = null;

    public static void main(String[] args) {
        Client client = new Client("210.75.5.253", 7891, "sd162a", "sd162");
        //Client client = new Client("115.231.168.137", 8855, "999059", "PGLTJMCNF5");
        ClientXX xx = new ClientXX();
        xx.client = client;
        client.registCallback(CmppPacketType.CMPP_CONNECT_RESP, xx);
        client.registCallback(CmppPacketType.CMPP_CONNECT,xx);
        client.registCallback(CmppPacketType.CMPP_ACTIVE_TEST_RESP,xx);
        client.registCallback(CmppPacketType.CMPP_ACTIVE_TEST,xx);
        client.start();

        client.sendMessage();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCmppConnectResp(CmppConnectResp connectResp) {
        System.out.println("onCmppConnectResp:" + connectResp.toString());
    }

    @Override
    protected void onCmppActiveTest(CmppActiveTest activeTest) {
        super.onCmppActiveTest(activeTest);
        System.out.println("onCmppActiveTest:" + activeTest.toString());
    }

    @Override
    protected void onCmppActiveTestResp(CmppActiveTestResp activeTestResp) {
        super.onCmppActiveTestResp(activeTestResp);
        System.out.println("onCmppActiveTestResp:" + activeTestResp.toString());
    }

    @Override
    protected void onDefaultPacket(CmppPacket packet) {
        super.onDefaultPacket(packet);
        System.out.println("onDefaultPacket:" + packet.toString());
    }
}
