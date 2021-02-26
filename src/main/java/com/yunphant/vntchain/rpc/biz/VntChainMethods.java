package com.yunphant.vntchain.rpc.biz;

import com.googlecode.jsonrpc4j.JsonRpcClientException;
import com.yunphant.vntchain.rpc.entity.EthTransaction;

import java.util.ArrayList;

/**
 * 以太坊接口eth_mining eth_hashrate eth_getUncleCountByBlockHash eth_getUncleCountByBlockNumber eth_signTransaction
 *
 * 这些没有对应的VNT CHAIN的接口
 */
public interface VntChainMethods {
    String vnt_clientVersion() throws Throwable;
    String vnt_sha3(String data) throws Throwable;
    String net_version() throws Throwable;
    Boolean net_listening() throws Throwable;
    String net_peerCount() throws Throwable;
    String core_protocolVersion() throws Throwable;
    Object core_syncing() throws Throwable;
    String core_coinbase() throws Throwable;
    String core_gasPrice() throws Throwable;
    ArrayList<String> core_accounts() throws Throwable;
    String core_blockNumber() throws Throwable;
    String core_getBalance(String addr, String tag) throws Throwable;
    String core_getStorageAt(String addr, String pos, String tag) throws Throwable;
    String core_getTransactionCount(String addr, String tag) throws Throwable;
    String core_getBlockTransactionCountByHash(String hash) throws Throwable;
    String core_getBlockTransactionCountByNumber(String blockNum) throws Throwable;
    String core_getCode(String addr, String tag) throws Throwable;
    String core_sign(String addr, String data) throws Throwable;
    String core_sendTransaction(EthTransaction ethTransaction) throws Throwable;
}
