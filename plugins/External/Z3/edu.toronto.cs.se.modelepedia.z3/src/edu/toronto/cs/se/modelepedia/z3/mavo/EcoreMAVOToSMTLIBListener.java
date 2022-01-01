/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.z3.mavo;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.acceleo.engine.event.AcceleoTextGenerationEvent;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mavo.MAVOElement;

public class EcoreMAVOToSMTLIBListener implements IAcceleoTextGenerationListener {

	private static final @NonNull String NODE_MARKER = "Node";
	private static final @NonNull String EDGE_MARKER = "Edge";
	private static final @NonNull String MODEL_START_MARKER = ";Model";
	private static final @NonNull String MODEL_END_MARKER = ";End Model";
	private static final int MODEL_NUM_TOKENS = 4;
	private static final @NonNull String MACROS_START_MARKER = ";Macros";
	private static final @NonNull String MACROS_END_MARKER = ";End Macros";

	private Map<String, MAVOElement> mavoModelObjs;
	private boolean isMayOnly;
	private StringBuilder smtEncoding;
	private Map<Integer, String> smtNodes;
	private Map<Integer, String> smtEdges;
	private Map<Integer, String> smtCurrentElems;
	private boolean checkModel;
	private String[] smtTokens;
	private int smtTokenCounter;
	private boolean checkMacros;
	private StringBuilder smtMacros;
	private String smtEncodingUri;
	private Z3MAVOModelParser z3ModelParser;

	public EcoreMAVOToSMTLIBListener(@NonNull Map<String, MAVOElement> mavoModelObjs, boolean isMayOnly) {

		this.mavoModelObjs = mavoModelObjs;
		this.isMayOnly = isMayOnly;
		smtEncoding = new StringBuilder();
		smtNodes = new HashMap<>();
		smtEdges = new HashMap<>();
		checkModel = false;
		smtTokens = new String[MODEL_NUM_TOKENS];
		smtTokenCounter = MODEL_NUM_TOKENS;
		checkMacros = false;
		smtMacros = new StringBuilder();
	}

	@Override
	public void textGenerated(AcceleoTextGenerationEvent event) {

		String smtText = event.getText();
		smtEncoding.append(smtText);

		if (smtText.trim().endsWith(MODEL_START_MARKER)) {
			checkModel = true;
			return;
		}
		else if (smtText.trim().endsWith(MACROS_START_MARKER)) {
			checkMacros = true;
			return;
		}
		if (!checkModel && !checkMacros) {
			return;
		}
		if (smtText.trim().endsWith(MODEL_END_MARKER)) {
			checkModel = false;
			return;
		}
		else if (smtText.trim().endsWith(MACROS_END_MARKER)) {
			checkMacros = false;
			return;
		}

		if (checkModel) {
			if (smtTokenCounter < MODEL_NUM_TOKENS) {
				smtTokens[smtTokenCounter] = smtText;
				smtTokenCounter++;
				if (smtTokenCounter == (MODEL_NUM_TOKENS)) {
					smtCurrentElems.put(new Integer(smtTokens[MODEL_NUM_TOKENS-1]), smtTokens[MODEL_NUM_TOKENS-3]);
				}
			}
			else if (smtText.equals(NODE_MARKER) || smtText.equals(EDGE_MARKER)) {
				smtTokenCounter = 0;
				smtCurrentElems = (smtText.equals(NODE_MARKER)) ? smtNodes : smtEdges;
			}
		}
		else if (checkMacros) {
			smtMacros.append(smtText);
		}
	}

	@Override
	public void filePathComputed(AcceleoTextGenerationEvent event) {

		smtEncodingUri = event.getText();
	}

	@Override
	public void fileGenerated(AcceleoTextGenerationEvent event) {

		z3ModelParser = new Z3MAVOModelParser(smtEncoding.toString(), smtEncodingUri, smtNodes, smtEdges, smtMacros.toString(), mavoModelObjs, isMayOnly);
	}

	@Override
	public void generationEnd(AcceleoTextGenerationEvent event) {

		// do nothing
	}

	@Override
	public boolean listensToGenerationEnd() {

		return false;
	}

	public @NonNull Z3MAVOModelParser getZ3MAVOModelParser() {

		return z3ModelParser;
	}

}
