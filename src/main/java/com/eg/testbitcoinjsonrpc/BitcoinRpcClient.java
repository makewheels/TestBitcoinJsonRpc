package com.eg.testbitcoinjsonrpc;

import com.alibaba.fastjson.JSON;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.apache.commons.codec.binary.Base64;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BitcoinRpcClient {
    //bitcoind -testnet -datadir="../" -rpcuser="rpcuser" -rpcpassword="rpcpassword" -rpcport=18332
    public static void main(String[] args) throws Throwable {
        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Authorization",
                "Basic " + new String(new Base64().encode("rpcuser:rpcpassword".getBytes())));
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url), headers);

        Object result = client.invoke("listreceivedbyaddress",
                new Object[]{"tb1qdzpqmv0sqcygcckle7ez3gu942uz29unpx9tq2", 0, true}, Object.class);
        System.out.println(JSON.toJSONString(result));


    }
}
