package com.yunphant.vntchain.rpc.service;

import com.yunphant.vntchain.rpc.entity.EthTransaction;

import java.util.ArrayList;

public interface EthChainRpcAPI {
    String web3_clientVersion() throws Throwable;                                                       // The current client version
    String web3_sha3(String data) throws Throwable;                                                     // Returns Keccak-256 (not the standardized SHA3-256) of the given data.
    String net_version() throws Throwable;                                                              // Returns the current network id.
    Boolean net_listening() throws Throwable;                                                           // Returns true if client is actively listening for network connections.
    String net_peerCount() throws Throwable;                                                            // Returns number of peers currently connected to the client.
    String eth_protocolVersion() throws Throwable;                                                      // Returns the current ethereum protocol version.
    Object eth_syncing() throws Throwable;                                                              // Returns an object with data about the sync status or false.
    String eth_coinbase() throws Throwable;                                                             // DATA, 20 bytes - the current coinbase address.
    String eth_gasPrice() throws Throwable;                                                             // Returns the current price per gas in wei.
    ArrayList<String> eth_accounts() throws Throwable;                                                  // Returns a list of addresses owned by client.
    String eth_blockNumber() throws Throwable;                                                          // Returns the number of most recent block.
    String eth_getBalance(String addr, String tag) throws Throwable;                                    // Returns the balance of the account of given address.
    String eth_getStorageAt(String addr, String pos, String tag) throws Throwable;                      // Returns the value from a storage position at a given address.
    String eth_getTransactionCount(String addr, String tag) throws Throwable;                           // Returns the number of transactions sent from an address.
    String eth_getBlockTransactionCountByHash(String hash) throws Throwable;                            // Returns the number of transactions in a block from a block matching the given block hash.
    String eth_getBlockTransactionCountByNumber(String hash) throws Throwable;                          // Returns the number of transactions in a block from a block matching the given block hash.
    String eth_getCode(String addr, String tag) throws Throwable;                                       // Returns code at a given address.
    String eth_sign(String addr, String data) throws Throwable;                                         // Returns DATA: Signature
    String eth_sendTransaction(EthTransaction ethTransaction) throws Throwable;                         // Returns DATA, 32 Bytes - the transaction hash, or the zero hash if the transaction is not yet available.
}
