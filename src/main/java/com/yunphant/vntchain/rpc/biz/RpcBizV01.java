package com.yunphant.vntchain.rpc.biz;

import com.googlecode.jsonrpc4j.JsonRpcClientException;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.yunphant.vntchain.rpc.entity.EthTransaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class RpcBizV01 {
    public RpcBizV01(@Value("${vntchain.rpc.url}") String rpcUrl) throws MalformedURLException {
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Content-Type", "application/json");

        client = new JsonRpcHttpClient(new URL(rpcUrl), headers);
        vntChainMethods = ProxyUtil.createClientProxy(getClass().getClassLoader(), VntChainMethods.class, client);
    }

    private JsonRpcHttpClient client;
    VntChainMethods vntChainMethods;

    public String vnt_clientVersion() throws Throwable {
        return vntChainMethods.vnt_clientVersion();
    }

    public String vnt_sha3(String data) throws Throwable {
        return vntChainMethods.vnt_sha3(data);
    }

    public String net_version() throws Throwable {
        return vntChainMethods.net_version();
    }

    public Boolean net_listening() throws Throwable {
        return vntChainMethods.net_listening();
    }

    public String net_peerCount() throws Throwable {
        return vntChainMethods.net_peerCount();
    }

    public String core_protocolVersion() throws Throwable {
        return vntChainMethods.core_protocolVersion();
    }

    public Object core_syncing() throws Throwable {
        return vntChainMethods.core_syncing();
    }

    public String core_coinbase() throws Throwable {
        return vntChainMethods.core_coinbase();
    }

    public String core_gasPrice() throws Throwable {
        return vntChainMethods.core_gasPrice();
    }

    public ArrayList<String> core_accounts() throws Throwable {
        return vntChainMethods.core_accounts();
    }

    public String core_blockNumber() throws Throwable {
        return vntChainMethods.core_blockNumber();
    }

    public String core_getBalance(String addr, String tag) throws Throwable {
        return vntChainMethods.core_getBalance(addr, tag);
    }

    public String core_getStorageAt(String addr, String pos, String tag) throws Throwable {
        return vntChainMethods.core_getStorageAt(addr, pos, tag);
    }

    public String core_getTransactionCount(String addr, String tag) throws Throwable {
        return vntChainMethods.core_getTransactionCount(addr, tag);
    }

    public String core_getBlockTransactionCountByHash(String hash) throws Throwable {
        return vntChainMethods.core_getBlockTransactionCountByHash(hash);
    }

    public String core_getBlockTransactionCountByNumber(String blockNum) throws Throwable {
        return vntChainMethods.core_getBlockTransactionCountByNumber(blockNum);
    }

    public String core_getCode(String addr, String tag) throws Throwable {
        return vntChainMethods.core_getCode(addr, tag);
    }

    public String core_sign(String addr, String data) throws Throwable {
        return vntChainMethods.core_sign(addr, data);
    }

    public String core_sendTransaction(EthTransaction ethTransaction) throws Throwable {
            return vntChainMethods.core_sendTransaction(ethTransaction);
    }
}
