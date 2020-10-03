package com.eg.testbitcoinjsonrpc;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.listeners.WalletCoinsReceivedEventListener;

import java.io.File;

public class BitcoinJ {
    private static WalletAppKit kit;
    private static NetworkParameters params;

    public static void main(String[] args) {
        params = TestNet3Params.get();
        String filePrefix = "forwarding-service-testnet";

        WalletAppKit kit = new WalletAppKit(params,
                new File("D:\\Programming\\Blockchain\\Bitcoin\\data"), filePrefix) {
            @Override
            protected void onSetupCompleted() {
                // This is called in a background thread after startAndWait is called, as setting up various objects
                // can do disk and network IO that may cause UI jank/stuttering in wallet apps if it were to be done
                // on the main thread.
                if (wallet().getKeyChainGroupSize() < 1) {
                    wallet().importKey(new ECKey());
                }
                onStart();
            }
        };
    }

    private static void onStart() {
        kit.wallet().addCoinsReceivedEventListener(new WalletCoinsReceivedEventListener() {
            public void onCoinsReceived(
                    Wallet wallet, Transaction tx, Coin prevBalance, Coin newBalance) {

            }
        });
        kit.connectToLocalHost();

    }
}
