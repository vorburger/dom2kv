/*
 * Copyright (c) 2018 Red Hat, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package ch.vorburger.dom2kv.test;

import static com.google.common.truth.Truth.assertThat;

import ch.vorburger.dom2kv.KeyValue;
import ch.vorburger.dom2kv.Transformer;
import ch.vorburger.dom2kv.Tree;
import ch.vorburger.dom2kv.impl.KeyValueImpl;
import ch.vorburger.dom2kv.impl.TransformerImpl;
import ch.vorburger.dom2kv.impl.TreeImpl;
import java.util.Collections;
import org.junit.Test;

/**
 * Unit test for {@link Transformer} implementations.
 *
 * @author Michael Vorburger.ch
 */
public class TransformerTest {

    ListConsumer<KeyValue<String, String>> kvs = new ListConsumer<>();
    Transformer<String, String, String> transformer = new TransformerImpl<>();

    @Test public void empty() {
        assertThat(transformer.kv2tree(Collections.emptyList()).root().isPresent()).isFalse();

        Tree<String, String> emptyTree = new TreeImpl<>();
        transformer.tree2kv(emptyTree, kvs);
        assertThat(kvs).isEmpty();

        assertThat(transformer.kv2tree(kvs)).isEqualTo(emptyTree);
    }

    @Test public void root() {
        Tree<String, String> tree = new TreeImpl<>(new TreeImpl.NodeImpl<>("groot"));
        transformer.tree2kv(tree, kvs);
        assertThat(kvs).containsExactly(new KeyValueImpl<>("groot"));
        assertThat(transformer.kv2tree(kvs)).isEqualTo(tree);
    }

}
