package com.eg.testbitcoinjsonrpc;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.apache.commons.codec.binary.Base64;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitcoinRpcClient {
    //bitcoind -testnet -datadir="../" -rpcuser="rpcuser" -rpcpassword="rpcpassword" -rpcport=18332
    public static void main(String[] args) throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";

        String cred = new String(new Base64().encode("rpcuser:rpcpassword".getBytes()));
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization", "Basic " + cred);
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://localhost:18332"), headers);

        BigDecimal bigDecimal = client.invoke("getbalance", null, BigDecimal.class);
        System.out.println(bigDecimal);


    }
}
