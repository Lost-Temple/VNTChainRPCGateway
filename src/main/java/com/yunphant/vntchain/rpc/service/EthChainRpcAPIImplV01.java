package com.yunphant.vntchain.rpc.service;

import com.googlecode.jsonrpc4j.JsonRpcClientException;
import com.googlecode.jsonrpc4j.JsonRpcError;
import com.googlecode.jsonrpc4j.JsonRpcErrors;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.yunphant.vntchain.rpc.biz.RpcBizV01;
import com.yunphant.vntchain.rpc.entity.EthTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@JsonRpcService(value = "v01")
@Service
@AutoJsonRpcServiceImpl
public class EthChainRpcAPIImplV01 implements EthChainRpcAPI {
    private static final Logger LOGGER = LoggerFactory.getLogger(EthChainRpcAPIImplV01.class);

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
//    @JsonRpcErrors({
//            @JsonRpcError(exception=JsonRpcClientException.class, code=-32000), @JsonRpcError(exception=Throwable.class,code=-32000),
//    })
    public String eth_sendTransaction(EthTransaction ethTransaction) throws Throwable {
        try {
            return rpcBizV01.core_sendTransaction(ethTransaction);
        } catch (JsonRpcClientException e) {
            LOGGER.error("message:" + e.getMessage() + ", code:" + e.getCode());
            throw e;
        }
    }
}
