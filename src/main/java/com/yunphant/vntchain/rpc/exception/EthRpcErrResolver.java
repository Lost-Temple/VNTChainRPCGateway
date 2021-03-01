package com.yunphant.vntchain.rpc.exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.googlecode.jsonrpc4j.ErrorResolver;
import com.googlecode.jsonrpc4j.JsonRpcClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;

public class EthRpcErrResolver implements ErrorResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(EthRpcErrResolver.class);
    @Override
    public JsonError resolveError(Throwable t, Method method, List<JsonNode> arguments) {
       if (t instanceof JsonRpcClientException) {
           JsonRpcClientException exception = ((JsonRpcClientException) t);
           LOGGER.error("code:" + exception.getCode() + ", message:" + exception.getMessage());
           return  new JsonError(exception.getCode(), exception.getMessage(), exception.getData());
       } else {
           return new JsonError(0, "unknown err", null);
       }
    }
}
