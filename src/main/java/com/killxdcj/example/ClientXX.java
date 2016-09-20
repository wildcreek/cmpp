package com.killxdcj.example;

import com.killxdcj.cmpp.packet.CmppConnectResp;
import com.killxdcj.cmpp.packet.CmppPacketType;
import com.killxdcj.sp.Client;
import com.killxdcj.sp.callback.CmppSpCallback;
import com.killxdcj.sp.callback.GenericCmppSpCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 15:17
 */
public class ClientXX extends GenericCmppSpCallback{
    Client client = null;
    public static void main(String[] args) {
        Client client = new Client("testhost", 8855, "account", "passwd");
        ClientXX xx = new ClientXX();
        xx.client = client;
        client.registCallback(CmppPacketType.CMPP_CONNECT_RESP, xx);
        client.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCmppConnectResp(CmppConnectResp connectResp) {
        System.out.println(connectResp.toString());
    }
}
