package io.qhh.rpcfx.api;

public interface Filter {

    boolean filter(RpcfxRequest request);

    // Filter next();

}
