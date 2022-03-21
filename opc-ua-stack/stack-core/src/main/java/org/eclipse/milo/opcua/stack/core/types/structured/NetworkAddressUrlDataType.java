/*
 * Copyright (c) 2021 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types.structured;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.eclipse.milo.opcua.stack.core.serialization.SerializationContext;
import org.eclipse.milo.opcua.stack.core.serialization.UaDecoder;
import org.eclipse.milo.opcua.stack.core.serialization.UaEncoder;
import org.eclipse.milo.opcua.stack.core.serialization.UaStructure;
import org.eclipse.milo.opcua.stack.core.serialization.codecs.GenericDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;

@EqualsAndHashCode(
    callSuper = true
)
@SuperBuilder(
    toBuilder = true
)
@ToString
public class NetworkAddressUrlDataType extends NetworkAddressDataType implements UaStructure {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("nsu=http://opcfoundation.org/UA/;i=15510");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("nsu=http://opcfoundation.org/UA/;i=21152");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("nsu=http://opcfoundation.org/UA/;i=21176");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("nsu=http://opcfoundation.org/UA/;i=21200");

    private final String url;

    public NetworkAddressUrlDataType(String networkInterface, String url) {
        super(networkInterface);
        this.url = url;
    }

    @Override
    public ExpandedNodeId getTypeId() {
        return TYPE_ID;
    }

    @Override
    public ExpandedNodeId getBinaryEncodingId() {
        return BINARY_ENCODING_ID;
    }

    @Override
    public ExpandedNodeId getXmlEncodingId() {
        return XML_ENCODING_ID;
    }

    @Override
    public ExpandedNodeId getJsonEncodingId() {
        return JSON_ENCODING_ID;
    }

    public String getUrl() {
        return url;
    }

    public static final class Codec extends GenericDataTypeCodec<NetworkAddressUrlDataType> {
        @Override
        public Class<NetworkAddressUrlDataType> getType() {
            return NetworkAddressUrlDataType.class;
        }

        @Override
        public NetworkAddressUrlDataType decode(SerializationContext context, UaDecoder decoder) {
            String networkInterface = decoder.readString("NetworkInterface");
            String url = decoder.readString("Url");
            return new NetworkAddressUrlDataType(networkInterface, url);
        }

        @Override
        public void encode(SerializationContext context, UaEncoder encoder,
                           NetworkAddressUrlDataType value) {
            encoder.writeString("NetworkInterface", value.getNetworkInterface());
            encoder.writeString("Url", value.getUrl());
        }
    }
}