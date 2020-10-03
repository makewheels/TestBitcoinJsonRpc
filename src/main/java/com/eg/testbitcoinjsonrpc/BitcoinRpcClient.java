package com.eg.testbitcoinjsonrpc;

import com.alibaba.fastjson.JSON;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BitcoinRpcClient {
    //bitcoind -testnet -datadir="../" -rpcuser="rpcuser" -rpcpassword="rpcpassword" -rpcport=18332
    public static void main(String[] args) throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization",
                "Basic " + new String(new Base64().encode("rpcuser:rpcpassword".getBytes())));
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url), headers);

        Object result = client.invoke("listtransactions",
                new Object[]{"0fbf7597-752d-4d8b-bd1c-b0c59a3461f3"}, Object.class);
        System.out.println(JSON.toJSONString(result));


    }

    @Test
    public void getnewaddress() throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization",
                "Basic " + new String(new Base64().encode("rpcuser:rpcpassword".getBytes())));
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url), headers);

        String label = UUID.randomUUID().toString();
        System.out.println(label);
        String result = client.invoke("getnewaddress",
                new Object[]{label}, String.class);
        System.out.println(JSON.toJSONString(result));
        //tb1q668zgkcfjph2h3f2chph2787w4efqckswk5gdv
    }

    @Test
    public void getaddressinfo() throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization",
                "Basic " + new String(new Base64().encode("rpcuser:rpcpassword".getBytes())));
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url), headers);

        Object result = client.invoke("getaddressinfo",
                new Object[]{"tb1q668zgkcfjph2h3f2chph2787w4efqckswk5gdv"}, Object.class);
        System.out.println(JSON.toJSONString(result));
    }

}
