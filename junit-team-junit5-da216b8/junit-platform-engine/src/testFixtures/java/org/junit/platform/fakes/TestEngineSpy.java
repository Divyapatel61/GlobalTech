/*
 * Copyright 2015-2023 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.platform.fakes;

import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.ExecutionRequest;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestEngine;
import org.junit.platform.engine.UniqueId;

/**
 * @since 1.4
 */
public class TestEngineSpy implements TestEngine {

	public static final String ID = TestEngineSpy.class.getSimpleName();

	public ExecutionRequest requestForExecution;

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public TestDescriptor discover(EngineDiscoveryRequest discoveryRequest, UniqueId uniqueId) {
		var engineUniqueId = UniqueId.forEngine(ID);
		var engineDescriptor = new TestDescriptorStub(engineUniqueId, ID);
		var testDescriptor = new TestDescriptorStub(engineUniqueId.append("test", "test"), "test");
		engineDescriptor.addChild(testDescriptor);
		return engineDescriptor;
	}

	@Override
	public void execute(ExecutionRequest request) {
		this.requestForExecution = request;
	}

}
