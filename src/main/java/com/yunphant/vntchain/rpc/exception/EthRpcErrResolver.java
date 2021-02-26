package com.yunphant.vntchain.rpc.exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.googlecode.jsonrpc4j.ErrorResolver;
import com.googlecode.jsonrpc4j.JsonRpcClientException;

import java.lang.reflect.Method;
import java.util.List;

public class EthRpcErrResolver implements ErrorResolver {
    @Override
    public JsonError resolveError(Throwable t, Method method, List<JsonNode> arguments) {
       if (t instanceof JsonRpcClientException) {
           JsonRpcClientException exception = ((JsonRpcClientException) t);
           return  new JsonError(exception.getCode(), exception.getMessage(), exception.getData());
       } else {
           return new JsonError(0, "unknown err", null);
       }
    }
}
