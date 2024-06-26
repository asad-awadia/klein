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
package com.ofcoder.klein.consensus.paxos.rpc.vo;

import java.util.List;

import com.ofcoder.klein.consensus.facade.Command;

/**
 * Accept Msg Data.
 *
 * @author far.liu
 */
public class AcceptReq extends BaseReq {
    private long instanceId;
    private List<Command> data;
    private String checksum;

    public long getInstanceId() {
        return instanceId;
    }

    public List<Command> getData() {
        return data;
    }

    public String getChecksum() {
        return checksum;
    }

    public static final class Builder {
        private long instanceId;
        private List<Command> data;
        private String nodeId;
        private long proposalNo;
        private int memberConfigurationVersion;
        private String checksum;

        private Builder() {
        }

        /**
         * anAcceptReq.
         *
         * @return Builder
         */
        public static Builder anAcceptReq() {
            return new Builder();
        }

        /**
         * instanceId.
         *
         * @param instanceId instanceId
         * @return Builder
         */
        public Builder instanceId(final long instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        /**
         * data.
         *
         * @param data data
         * @return Builder
         */
        public Builder data(final List<Command> data) {
            this.data = data;
            return this;
        }

        /**
         * nodeId.
         *
         * @param nodeId nodeId
         * @return Builder
         */
        public Builder nodeId(final String nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        /**
         * proposalNo.
         *
         * @param proposalNo proposalNo
         * @return Builder
         */
        public Builder proposalNo(final long proposalNo) {
            this.proposalNo = proposalNo;
            return this;
        }

        /**
         * memberConfigurationVersion.
         *
         * @param memberConfigurationVersion memberConfigurationVersion
         * @return Builder
         */
        public Builder memberConfigurationVersion(final int memberConfigurationVersion) {
            this.memberConfigurationVersion = memberConfigurationVersion;
            return this;
        }

        /**
         * checksum.
         *
         * @param checksum checksum
         * @return Builder
         */
        public Builder checksum(final String checksum) {
            this.checksum = checksum;
            return this;
        }

        /**
         * build.
         *
         * @return AcceptReq
         */
        public AcceptReq build() {
            AcceptReq acceptReq = new AcceptReq();
            acceptReq.setNodeId(nodeId);
            acceptReq.setProposalNo(proposalNo);
            acceptReq.setMemberConfigurationVersion(memberConfigurationVersion);
            acceptReq.instanceId = this.instanceId;
            acceptReq.data = this.data;
            acceptReq.checksum = this.checksum;
            return acceptReq;
        }
    }
}
