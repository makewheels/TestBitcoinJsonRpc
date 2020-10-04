package com.eg.testbitcoinjsonrpc;

import com.alibaba.fastjson.JSON;
import com.eg.testbitcoinjsonrpc.util.HttpUtil;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BitcoinRpcClient {
    //bitcoind -testnet -datadir="../" -rpcuser="rpcuser" -rpcpassword="rpcpassword" -rpcport=18332

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
    }

    @Test
    public void getaddressinfo() throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization",
                "Basic " + new String(new Base64().encode("rpcuser:rpcpassword".getBytes())));
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url), headers);

        Object result = client.invoke("getaddressinfo",
                new Object[]{"tb1qxuckp65500r5guzcfljses3plrzchmhltpql3t"}, Object.class);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void dumpprivkey() throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization",
                "Basic " + new String(new Base64().encode("rpcuser:rpcpassword".getBytes())));
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url), headers);

        String result = client.invoke("dumpprivkey",
                new Object[]{"tb1qxuckp65500r5guzcfljses3plrzchmhltpql3t"}, String.class);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void listtransactions() throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization",
                "Basic " + new String(new Base64().encode("rpcuser:rpcpassword".getBytes())));
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url), headers);

        Object result = client.invoke("listtransactions",
                new Object[]{"7eeb668c-beb3-4c31-bdc9-a7a38668b5a9"}, Object.class);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void gettransaction() throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization",
                "Basic " + new String(new Base64().encode("rpcuser:rpcpassword".getBytes())));
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url), headers);

        Object result = client.invoke("gettransaction",
                new Object[]{"3d83c21565be79cbf3bd5eb03eb0427626be28fe7ea46a0c1bc673f80c90d9df"}, Object.class);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void decoderawtransaction() throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization",
                "Basic " + new String(new Base64().encode("rpcuser:rpcpassword".getBytes())));
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url), headers);

        Object result = client.invoke("decoderawtransaction",
                new Object[]{"02000000000101e24e6b1764ffb5df32adc07fd16911854f34baa3a38f0b3ef4b654eae1454a120000000017160014260df0078c007d4616d2573359fa390d34ea4c74feffffff029fbb0d0000000000160014373160ea947bc74470584fe50cc221f8c58beeff91564f00000000001600145361eb448cf80385bdebd0a9824727f860bcf41c0247304402207bee03e75820cafdd77cace213efbf081c38733aac35bd6a02d77a6b5fe9e22802205886aa617a5849c6fac5d52dccf8a4d6cb5bfadc295f7fe14b3f051f6dd1739d0121022b996cf69ea2ced184a71cbcdb4c7d8eedd70d0a735c98e0c48d583eeae9acbe35091c00"},
                Object.class);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void getBtcPrice() {
        String url = "https://api.huobi.com/market/trade?symbol=btcusdt";
        String s = HttpUtil.getProxy(url);
        System.out.println(s);
    }
}
