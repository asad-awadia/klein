/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ofcoder.klein.jepsen.server.rpc;

import com.ofcoder.klein.common.exception.KleinException;
import com.ofcoder.klein.consensus.facade.AbstractRpcProcessor;
import com.ofcoder.klein.core.cache.KleinCache;
import com.ofcoder.klein.rpc.facade.RpcContext;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * cache get request processor.
 *
 * @author 释慧利
 */
public class GetProcessor extends AbstractRpcProcessor<GetReq> {
    private static final Logger LOG = LoggerFactory.getLogger(GetProcessor.class);

    private KleinCache cache;

    public GetProcessor(final KleinCache cache) {
        this.cache = cache;
    }

    @Override
    public void handleRequest(final GetReq request, final RpcContext rpcContext) {
        try {
            LOG.info("get operator, begin, seq: {}", request.getSeq());
            Serializable javaBean = cache.get(request.getKey());
            LOG.info("get operator, end, seq: {}, result: {}", request.getSeq(), javaBean);
            response(new Resp(true, javaBean), rpcContext);
        } catch (KleinException e) {
            LOG.error(e.getMessage());
            LOG.info("get operator, end, seq: {}, result: err", request.getSeq());
            response(new Resp(false, null), rpcContext);
        }

    }

    @Override
    public String service() {
        return GetReq.class.getSimpleName();
    }
}
