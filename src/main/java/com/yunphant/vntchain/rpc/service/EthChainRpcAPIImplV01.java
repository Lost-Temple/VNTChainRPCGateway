package com.yunphant.vntchain.rpc.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.yunphant.vntchain.rpc.biz.RpcBizV01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@JsonRpcService(value = "v01")
@Service
@AutoJsonRpcServiceImpl
public class EthChainRpcAPIImplV01 implements EthChainRpcAPI {
    @Autowired
    RpcBizV01 rpcBizV01;

    @Override
    public String web3_clientVersion() throws Throwable {
        return rpcBizV01.vnt_clientVersion();
    }

    @Override
    public String web3_sha3(String data) throws Throwable {
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
    public String eth_protocolVersion() throws Throwable {
        return rpcBizV01.core_protocolVersion();
    }

    @Override
    public Object eth_syncing() throws Throwable {
        return rpcBizV01.core_syncing();
    }

    @Override
    public String eth_coinbase() throws Throwable {
        return rpcBizV01.core_coinbase();
    }

    @Override
    public String eth_gasPrice() throws Throwable {
        return rpcBizV01.core_gasPrice();
    }

    @Override
    public ArrayList<String> eth_accounts() throws Throwable {
        return rpcBizV01.core_accounts();
    }

    @Override
    public String eth_blockNumber() throws Throwable {
        return rpcBizV01.core_blockNumber();
    }

    @Override
    public String eth_getBalance(String addr, String tag) throws Throwable {
        return rpcBizV01.core_getBalance(addr, tag);
    }

    @Override
    public String eth_getStorageAt(String addr, String pos, String tag) throws Throwable {
        return rpcBizV01.core_getStorageAt(addr, pos, tag);
    }

    @Override
    public String eth_getTransactionCount(String addr, String tag) throws Throwable {
        return rpcBizV01.core_getTransactionCount(addr, tag);
    }

    @Override
    public String eth_getBlockTransactionCountByHash(String hash) throws Throwable {
        return rpcBizV01.core_getBlockTransactionCountByHash(hash);
    }

    @Override
    public String eth_getBlockTransactionCountByNumber(String blockNum) throws Throwable {
        return rpcBizV01.core_getBlockTransactionCountByNumber(blockNum);
    }

    @Override
    public String eth_getCode(String addr, String tag) throws Throwable {
        return rpcBizV01.core_getCode(addr, tag);
    }

    @Override
    public String eth_sign(String addr, String data) throws Throwable {
        return rpcBizV01.core_sign(addr, data);
    }

    @Override
    public String eth_sendTransaction(JsonNode obj) throws Throwable {
        return rpcBizV01.core_sendTransaction(obj);
    }

    @Override
    public String eth_sendRawTransaction(String data) throws Throwable {
        return rpcBizV01.core_sendRawTransaction(data);
    }

    @Override
    public String eth_call(JsonNode obj, String tag) throws Throwable {
        return rpcBizV01.core_call(obj, tag);
    }

    @Override
    public String eth_estimateGas(JsonNode obj) throws Throwable {
        return rpcBizV01.core_estimateGas(obj);
    }

    @Override
    public JsonNode eth_getBlockByHash(String hash, Boolean full) throws Throwable {
        return rpcBizV01.core_getBlockByHash(hash, full);
    }

    @Override
    public JsonNode eth_getBlockByNumber(String number, Boolean full) throws Throwable {
        return rpcBizV01.core_getBlockByNumber(number, full);
    }

    @Override
    public JsonNode eth_getTransactionByHash(String hash) throws Throwable {
        return rpcBizV01.core_getTransactionByHash(hash);
    }

    @Override
    public JsonNode eth_getTransactionByBlockHashAndIndex(String hash, String index) throws Throwable {
        return rpcBizV01.core_getTransactionByBlockHashAndIndex(hash, index);
    }

    @Override
    public JsonNode eth_getTransactionByBlockNumberAndIndex(String number, String index) throws Throwable {
        return rpcBizV01.core_getTransactionByBlockNumberAndIndex(number, index);
    }

    @Override
    public JsonNode eth_getTransactionReceipt(String hash) throws Throwable {
        return rpcBizV01.core_getTransactionReceipt(hash);
    }
}
