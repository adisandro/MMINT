/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mavo.library;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.acceleo.engine.event.AcceleoTextGenerationEvent;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;

public class EcoreMAVOToSMTLIBListener implements IAcceleoTextGenerationListener {

	private static final String NODE_MARKER = ";Node";
	private static final String NODES_END_MARKER = ";End Nodes\n";
	private static final int NUM_NODE_TOKENS = 4;

	private StringBuilder textGeneration;
	private String smtEncoding;
	private String smtEncodingUri;
	private Map<Integer, String> smtNodes;
	private boolean checkTokens;
	private String[] smtTokens;
	int smtTokenCounter;

	public EcoreMAVOToSMTLIBListener() {

		textGeneration = new StringBuilder();
		smtNodes = new HashMap<Integer, String>();
		checkTokens = true;
		smtTokens = new String[NUM_NODE_TOKENS];
		smtTokenCounter = NUM_NODE_TOKENS;
	}

	@Override
	public void textGenerated(AcceleoTextGenerationEvent event) {

		String text = event.getText();
		textGeneration.append(text);
		if (!checkTokens) {
			return;
		}

		if (text.endsWith(NODES_END_MARKER)) {
			checkTokens = false;
			return;
		}
		if (smtTokenCounter < NUM_NODE_TOKENS) {
			smtTokens[smtTokenCounter] = text;
			smtTokenCounter++;
			if (smtTokenCounter == (NUM_NODE_TOKENS)) {
				smtNodes.put(new Integer(smtTokens[NUM_NODE_TOKENS-1]), smtTokens[NUM_NODE_TOKENS-3]);
			}
		}
		else if (text.endsWith(NODE_MARKER)) {
			smtTokenCounter = 0;
		}
	}

	@Override
	public void filePathComputed(AcceleoTextGenerationEvent event) {

		smtEncodingUri = event.getText();
	}

	@Override
	public void fileGenerated(AcceleoTextGenerationEvent event) {

		smtEncoding = textGeneration.toString();
	}

	@Override
	public void generationEnd(AcceleoTextGenerationEvent event) {

		// do nothing
	}

	@Override
	public boolean listensToGenerationEnd() {

		return false;
	}

	public String getSMTEncoding() {

		return smtEncoding;
	}

	public String getSMTEncodingUri() {

		return smtEncodingUri;
	}

	public Map<Integer, String> getSMTNodes() {

		return smtNodes;
	}

}
