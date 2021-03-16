package com.yunphant.vntchain.rpc.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.yunphant.vntchain.rpc.biz.RpcBizV01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;

@JsonRpcService(value = "vnt/v01")
@Service
@AutoJsonRpcServiceImpl
public class VntChainRpcAPIImplV01 implements VntChainRpcAPI {
    @Autowired
    RpcBizV01 rpcBizV01;

    @Override
    public String vnt_clientVersion() throws Throwable {
        return rpcBizV01.vnt_clientVersion();
    }

    @Override
    public String vnt_sha3(String data) throws Throwable {
        return rpcBizV01.vnt_sha3(data);
    }

    @Override
    public String net_version() throws Throwable {
        return rpcBizV01.net_version();
    }

    @Override
    public Boolean net_listening() throws Throwable {
        return rpcBizV01.net_listening();
    }

    @Override
    public String net_peerCount() throws Throwable {
        return rpcBizV01.net_peerCount();
    }

    @Override
    public String core_protocolVersion() throws Throwable {
        return rpcBizV01.core_protocolVersion();
    }

    @Override
    public Object core_syncing() throws Throwable {
        return rpcBizV01.core_syncing();
    }

    @Override
    public String core_coinbase() throws Throwable {
        return rpcBizV01.core_coinbase();
    }

    @Override
    public String core_gasPrice() throws Throwable {
        return rpcBizV01.core_gasPrice();
    }

    @Override
    public ArrayList<String> core_accounts() throws Throwable {
        return rpcBizV01.core_accounts();
    }

    @Override
    public String core_blockNumber() throws Throwable {
        return rpcBizV01.core_blockNumber();
    }

    @Override
    public String core_getBalance(String addr, String tag) throws Throwable {
        return rpcBizV01.core_getBalance(addr, tag);
    }

    @Override
    public String core_getStorageAt(String addr, String pos, String tag) throws Throwable {
        return rpcBizV01.core_getStorageAt(addr, pos, tag);
    }

    @Override
    public String core_getTransactionCount(String addr, String tag) throws Throwable {
        return rpcBizV01.core_getTransactionCount(addr, tag);
    }

    @Override
    public String core_getBlockTransactionCountByHash(String hash) throws Throwable {
        return rpcBizV01.core_getBlockTransactionCountByHash(hash);
    }

    @Override
    public String core_getBlockTransactionCountByNumber(String blockNum) throws Throwable {
        return rpcBizV01.core_getBlockTransactionCountByNumber(blockNum);
    }

    @Override
    public String core_getCode(String addr, String tag) throws Throwable {
        return rpcBizV01.core_getCode(addr, tag);
    }

    @Override
    public String core_sign(String addr, String data) throws Throwable {
        return rpcBizV01.core_sign(addr, data);
    }

    @Override
    public String core_sendTransaction(JsonNode obj) throws Throwable {
        return rpcBizV01.core_sendTransaction(obj);
    }

    @Override
    public String core_sendRawTransaction(String data) throws Throwable {
        return rpcBizV01.core_sendRawTransaction(data);
    }

    @Override
    public String core_call(JsonNode obj, String tag) throws Throwable {
        return rpcBizV01.core_call(obj, tag);
    }

    @Override
    public String core_estimateGas(JsonNode obj) throws Throwable {
        return rpcBizV01.core_estimateGas(obj);
    }

    @Override
    public JsonNode core_getBlockByHash(String hash, Boolean full) throws Throwable {
        return rpcBizV01.core_getBlockByHash(hash, full);
    }

    @Override
    public JsonNode core_getBlockByNumber(String number, Boolean full) throws Throwable {
        return rpcBizV01.core_getBlockByNumber(number, full);
    }

    @Override
    public JsonNode core_getTransactionByHash(String hash) throws Throwable {
        return rpcBizV01.core_getTransactionByHash(hash);
    }

    @Override
    public JsonNode core_getTransactionByBlockHashAndIndex(String hash, String index) throws Throwable {
        return rpcBizV01.core_getTransactionByBlockHashAndIndex(hash, index);
    }

    @Override
    public JsonNode core_getTransactionByBlockNumberAndIndex(String number, String index) throws Throwable {
        return rpcBizV01.core_getTransactionByBlockNumberAndIndex(number, index);
    }

    @Override
    public JsonNode core_getTransactionReceipt(String hash) throws Throwable {
        return rpcBizV01.core_getTransactionReceipt(hash);
    }

    @Override
    public String core_newFilter(JsonNode obj) throws Throwable {
        return rpcBizV01.core_newFilter(obj);
    }

    @Override
    public String core_newBlockFilter() throws Throwable {
        return rpcBizV01.core_newBlockFilter();
    }

    @Override
    public String core_newPendingTransactionFilter() throws Throwable {
        return rpcBizV01.core_newPendingTransactionFilter();
    }

    @Override
    public Boolean core_uninstallFilter(String id) throws Throwable {
        return rpcBizV01.core_uninstallFilter(id);
    }

    @Override
    public JsonNode core_getFilterChanges(String id) throws Throwable {
        return rpcBizV01.core_getFilterChanges(id);
    }

    @Override
    public JsonNode core_getFilterLogs(String id) throws Throwable {
        return rpcBizV01.core_getFilterLogs(id);
    }

    @Override
    public JsonNode core_getLogs(JsonNode obj) throws Throwable {
        return rpcBizV01.core_getLogs(obj);
    }

    @Override
    public String shh_version() throws Throwable {
        return rpcBizV01.shh_version();
    }

    @Override
    public Boolean shh_post(JsonNode obj) throws Throwable {
        return rpcBizV01.shh_post(obj);
    }

    @Override
    public ArrayList<JsonNode> core_getAllCandidates() throws Throwable {
        return rpcBizV01.core_getAllCandidates();
    }

    @Override
    public JsonNode core_getStake(String addr) throws Throwable {
        return rpcBizV01.core_getStake(addr);
    }

    @Override
    public JsonNode core_getVoter(String addr) throws Throwable {
        return rpcBizV01.core_getVoter(addr);
    }

    @Override
    public BigInteger core_getRestVNTBounty() throws Throwable {
        return rpcBizV01.core_getRestVNTBounty();
    }

    @Override
    public String core_chainId() {
        return "0x" + rpcBizV01.eth_chainId().toString(16);
    }
}
