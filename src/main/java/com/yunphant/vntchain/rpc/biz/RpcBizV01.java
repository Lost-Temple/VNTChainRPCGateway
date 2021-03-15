package com.yunphant.vntchain.rpc.biz;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.yunphant.vntchain.rpc.common.Constants;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class RpcBizV01 {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RpcBizV01.class);

    public RpcBizV01(@Value("${vntchain.rpc.url}") String rpcUrl, @Value("${vntchain.chainid}")BigInteger chainId) throws MalformedURLException {
        Map<String, String> headers = new HashMap<String, String>(1);
        headers.put("Content-Type", "application/json");

        client = new JsonRpcHttpClient(new URL(rpcUrl), headers);
        vntChainMethods = ProxyUtil.createClientProxy(getClass().getClassLoader(), VntChainMethods.class, client);

        this.chainId = chainId;
    }

    private JsonRpcHttpClient client;
    VntChainMethods vntChainMethods;
    BigInteger chainId;

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

    public String core_sendTransaction(JsonNode obj) throws Throwable {
        return vntChainMethods.core_sendTransaction(obj);
    }

    public String core_sendRawTransaction(String data) throws Throwable {
        return vntChainMethods.core_sendRawTransaction(data);
    }

    public String core_call(JsonNode obj, String tag) throws Throwable {
        String to = obj.get("to").textValue();
        String data = obj.get("data").textValue();
        String methodId = data.substring(0, 10);
        switch (methodId) {
            case Constants.ETH_BALANCE_CHECKER_METHODID_BALANCE_OF:
                //调用智能合约内部的balanceOf(address)方法,但代币的智能合约好像是不符合
                LOGGER.debug("*****************代币智能合约内部的balanceOf(address)了****************");
                LOGGER.debug("to:" + to);
                data = data.replace(Constants.ETH_BALANCE_CHECKER_METHODID_BALANCE_OF, Constants.TOKEN_METHODID_GET_AMOUNT);
                ObjectNode objectNode = (ObjectNode) obj;
                objectNode.put("data",data);
                return vntChainMethods.core_call(objectNode, tag);
            case Constants.ETH_BALANCE_CHECKER_METHODID_BALANCES:
                break;
        }
        return vntChainMethods.core_call(obj, tag);
    }

    public String core_estimateGas(JsonNode obj) throws Throwable {
        return vntChainMethods.core_estimateGas(obj);
    }

    public JsonNode core_getBlockByHash(String hash, Boolean full) throws Throwable {
        return vntChainMethods.core_getBlockByHash(hash, full);
    }

    public JsonNode core_getBlockByNumber(String number, Boolean full) throws Throwable {
        return vntChainMethods.core_getBlockByNumber(number, full);
    }

    public JsonNode core_getTransactionByHash(String hash) throws Throwable {
        return vntChainMethods.core_getTransactionByHash(hash);
    }

    public JsonNode core_getTransactionByBlockHashAndIndex(String hash, String index) throws Throwable {
        return vntChainMethods.core_getTransactionByBlockHashAndIndex(hash, index);
    }

    public JsonNode core_getTransactionByBlockNumberAndIndex(String number, String index) throws Throwable {
        return vntChainMethods.core_getTransactionByBlockNumberAndIndex(number, index);
    }

    public JsonNode core_getTransactionReceipt(String hash) throws Throwable {
        return vntChainMethods.core_getTransactionReceipt(hash);
    }

    public String core_newFilter(JsonNode obj) throws Throwable {
        return vntChainMethods.core_newFilter(obj);
    }

    public String core_newBlockFilter() throws Throwable {
        return vntChainMethods.core_newBlockFilter();
    }

    public String core_newPendingTransactionFilter() throws Throwable {
        return vntChainMethods.core_newPendingTransactionFilter();
    }

    public Boolean core_uninstallFilter(String id) throws Throwable {
        return vntChainMethods.core_uninstallFilter(id);
    }

    public JsonNode core_getFilterChanges(String id) throws Throwable {
        return vntChainMethods.core_getFilterChanges(id);
    }

    public JsonNode core_getFilterLogs(String id) throws Throwable {
        return vntChainMethods.core_getFilterLogs(id);
    }

    public JsonNode core_getLogs(JsonNode obj) throws Throwable {
        return vntChainMethods.core_getLogs(obj);
    }

    public String shh_version() throws Throwable {
        return vntChainMethods.shh_version();
    }

    public Boolean shh_post(JsonNode obj) throws Throwable {
        return vntChainMethods.shh_post(obj);
    }

    public ArrayList<JsonNode> core_getAllCandidates() throws Throwable {
        return vntChainMethods.core_getAllCandidates();
    }

    public JsonNode core_getStake(String addr) throws Throwable {
        return vntChainMethods.core_getStake(addr);
    }

    public JsonNode core_getVoter(String addr) throws Throwable {
        return vntChainMethods.core_getVoter(addr);
    }

    public BigInteger core_getRestVNTBounty() throws Throwable {
        return vntChainMethods.core_getRestVNTBounty();
    }

    public BigInteger eth_chainId() {
        return this.chainId;
    }
}
