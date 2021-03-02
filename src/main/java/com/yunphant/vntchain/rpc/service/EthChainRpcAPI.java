package com.yunphant.vntchain.rpc.service;

import com.fasterxml.jackson.databind.JsonNode;

import java.math.BigInteger;
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
    String eth_sendTransaction(JsonNode obj) throws Throwable;                                          // Returns DATA, 32 Bytes - the transaction hash, or the zero hash if the transaction is not yet available.
    String eth_sendRawTransaction(String data) throws Throwable;                                        // Creates new message call transaction or a contract creation for signed transactions.
    String eth_call(JsonNode obj, String tag) throws Throwable;                                         // Executes a new message call immediately without creating a transaction on the block chain.
    String eth_estimateGas(JsonNode obj) throws Throwable;                                              // Returns QUANTITY - the amount of gas used.
    JsonNode eth_getBlockByHash(String hash, Boolean full) throws Throwable;                            // Returns information about a block by hash.
    JsonNode eth_getBlockByNumber(String number, Boolean full) throws Throwable;                        // Returns information about a block by block number.
    JsonNode eth_getTransactionByHash(String hash) throws Throwable;                                    // Returns the information about a transaction requested by transaction hash.
    JsonNode eth_getTransactionByBlockHashAndIndex(String hash, String index) throws Throwable;         // Returns information about a transaction by block hash and transaction index position.
    JsonNode eth_getTransactionByBlockNumberAndIndex(String number, String index) throws Throwable;     // Returns information about a transaction by block number and transaction index position.
    JsonNode eth_getTransactionReceipt(String hash) throws Throwable;                                   // Returns the receipt of a transaction by transaction hash.
    String eth_newFilter(JsonNode obj) throws Throwable;                                                // Returns QUANTITY - A filter id.
    String eth_newBlockFilter() throws Throwable;                                                       // Returns QUANTITY - A filter id.
    String eth_newPendingTransactionFilter() throws Throwable;                                          // Returns QUANTITY - A filter id.
    Boolean eth_uninstallFilter(String id) throws Throwable;                                            // Returns Boolean - true if the filter was successfully uninstalled, otherwise false.
    JsonNode eth_getFilterChanges(String id) throws Throwable;                                          // Returns Array - Array of log objects, or an empty array if nothing has changed since last poll.
    JsonNode eth_getFilterLogs(String id) throws Throwable;                                             // Returns an array of all logs matching filter with given id.
    JsonNode eth_getLogs(JsonNode obj) throws Throwable;                                                // See core_getFilterChanges
    String shh_version() throws Throwable;                                                              // Returns String - The current whisper protocol version
    Boolean shh_post(JsonNode obj) throws Throwable;                                                    // Returns Boolean - returns true if the message was send, otherwise false.
    ArrayList<JsonNode> core_getAllCandidates() throws Throwable;                                       // Returns a list of all the witness candidates.
    JsonNode core_getStake(String addr) throws Throwable;                                               // Returns stake information of a user.
    JsonNode core_getVoter(String addr) throws Throwable;                                               // Returns a voter's information.
    BigInteger core_getRestVNTBounty() throws Throwable;                                                // Returns a value of the left VNT bounty.
    String eth_chainId() throws Throwable;                                                              // Returns a value of chain id. hex. exp: 0x1
}
