/*
 * Copyright (c) 2022 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core;

import org.eclipse.milo.opcua.stack.core.util.Namespaces;

/**
 * A {@link UriArray} intended to contain Namespace URI entries.
 */
public class NamespaceTable extends UriArray {

    /**
     * Create a {@link NamespaceTable} seeded with {@link Namespaces#OPC_UA} at index 0.
     */
    public NamespaceTable() {
        add(Namespaces.OPC_UA);
    }

    /**
     * Create a {@link NamespaceTable} seeded with {@link Namespaces#OPC_UA} at index 0 followed
     * by {@code uris} at subsequent indices.
     *
     * @param uris additional URIs to seed the table with.
     */
    public NamespaceTable(String... uris) {
        add(Namespaces.OPC_UA);

        for (String uri : uris) {add(uri);}
    }

}
