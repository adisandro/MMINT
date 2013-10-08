/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.core.resources.ResourcesPlugin;

import edu.toronto.cs.se.mmtf.MMTF;

public class MultiModelUtils {

	public static String getLastSegmentFromUri(String uri) {

		return uri.substring(uri.lastIndexOf(MMTF.URI_SEPARATOR) + 1, uri.length());
	}

	public static String getFileNameFromUri(String uri) {

		String lastSegmentUri = getLastSegmentFromUri(uri);

		return lastSegmentUri.substring(0, lastSegmentUri.lastIndexOf(MultiModelRegistry.MODEL_FILEEXTENSION_SEPARATOR));
	}

	public static String getFileExtensionFromUri(String uri) {

		String lastSegmentUri = getLastSegmentFromUri(uri);

		return lastSegmentUri.substring(lastSegmentUri.lastIndexOf(MultiModelRegistry.MODEL_FILEEXTENSION_SEPARATOR) + 1, lastSegmentUri.length());
	}

	public static String replaceLastSegmentInUri(String uri, String newLastSegmentUri) {

		String lastSegmentUri = getLastSegmentFromUri(uri);

		return uri.replace(lastSegmentUri, newLastSegmentUri);
	}

	public static String replaceFileNameInUri(String uri, String newFileName) {

		String fileName = getFileNameFromUri(uri);

		return uri.replace(fileName, newFileName);
	}

	public static String replaceFileExtensionInUri(String uri, String newFileExtension) {

		String fileExtension = getFileExtensionFromUri(uri);

		return uri.replace(MultiModelRegistry.MODEL_FILEEXTENSION_SEPARATOR + fileExtension, MultiModelRegistry.MODEL_FILEEXTENSION_SEPARATOR + newFileExtension);
	}

	public static String addFileNameSuffixInUri(String uri, String newFileNameSuffix) {

		String fileExtension = getFileExtensionFromUri(uri);

		return uri.replace(MultiModelRegistry.MODEL_FILEEXTENSION_SEPARATOR + fileExtension, newFileNameSuffix + MultiModelRegistry.MODEL_FILEEXTENSION_SEPARATOR + fileExtension);
	}

	public static String prependWorkspaceToUri(String uri) {

		return ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + uri;
	}

	public static void writeTextFile(String fileUri, String text) throws Exception {

		Path filePath = Paths.get(fileUri);
		try (BufferedWriter writer = Files.newBufferedWriter(filePath, Charset.forName("UTF-8"))) {
			writer.write(text);
		}
	}

	public static void copyTextFileAndReplaceText(String oldFileUri, String newFileUri, String oldText, String newText) throws Exception {

		Path oldFilePath = Paths.get(oldFileUri);
		Path newFilePath = Paths.get(newFileUri);
		try (BufferedReader oldBuffer = Files.newBufferedReader(oldFilePath, Charset.forName("UTF-8"))) {
			try (BufferedWriter newBuffer = Files.newBufferedWriter(newFilePath, Charset.forName("UTF-8"))) {
				String oldLine;
				while ((oldLine = oldBuffer.readLine()) != null) {
					newBuffer.write(oldLine.replaceAll(oldText, newText));
					newBuffer.newLine();
				}
			}
		}
	}

}
