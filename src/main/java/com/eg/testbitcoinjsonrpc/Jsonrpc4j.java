package com.eg.testbitcoinjsonrpc;

import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;

import java.net.MalformedURLException;

public class Jsonrpc4j {
    public static void main(String[] args) throws MalformedURLException {
//        String url = "http://rpcuser:rpcpassword@127.0.0.1:18332/";
        String url = "http://rpcuser:rpcpassword@39.96.78.70:18332/";

        BitcoinJSONRPCClient bitcoinJSONRPCClient = new BitcoinJSONRPCClient(url);

        String newAddress = bitcoinJSONRPCClient.getNewAddress();
        System.out.println(newAddress);
        String privateKey = bitcoinJSONRPCClient.dumpPrivKey(newAddress);
        System.out.println(privateKey);

    }
}
