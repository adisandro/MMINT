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
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFActivator;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;

public class MultiModelUtils {

	private static String getFirstSegmentFromUri(String uri) {

		return uri.substring(0, uri.indexOf(MMTF.URI_SEPARATOR));
	}

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

		String projectName = getFirstSegmentFromUri(uri);
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = workspace.getProject(projectName);
		//TODO MMTF[GIT] detect project location

		return ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + uri;
	}

	public static void createTextFile(String fileUri, String text) throws Exception {

		Path filePath = Paths.get(fileUri);
		try (BufferedWriter writer = Files.newBufferedWriter(filePath, Charset.forName("UTF-8"))) {
			writer.write(text);
		}
	}

	public static void createTextFileInState(String text, String relativeFileUri) throws Exception {

		String fileUri = MMTFActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + relativeFileUri;
		createTextFile(fileUri, text);
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

	public static String isFileOrDirectory(String uri, boolean isWorkspaceRelative) {

		if (isWorkspaceRelative) {
			uri = prependWorkspaceToUri(uri);
		}
		Path filePath = Paths.get(uri);

		return (Files.exists(filePath)) ? uri : null;
	}

	public static String isFileOrDirectoryInState(String relativeUri) {

		String fileUri = MMTFActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + relativeUri;

		return isFileOrDirectory(fileUri, false);
	}

	/**
	 * Writes the root of an ECore model into an ECore model file.
	 * 
	 * @param root
	 *            The ECore model root.
	 * @param fileUri
	 *            The uri of the ECore model file.
	 * @param isWorkspaceRelative
	 *            True if the uri is relative to the Eclipse workspace, false if
	 *            it's absolute.
	 * @throws Exception
	 *             If the ECore model file could not be created or overwritten.
	 */
	public static void createModelFile(EObject root, String fileUri, boolean isWorkspaceRelative) throws Exception {
	
		URI emfUri = (isWorkspaceRelative) ?
			URI.createPlatformResourceURI(fileUri, true) :
			URI.createFileURI(fileUri);
		MultiModelTypeIntrospection.writeRoot(root, emfUri);
	}

	public static void createModelFileInState(EObject root, String relativeFileUri) throws Exception {

		String fileUri = MMTFActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + relativeFileUri;
		createModelFile(root, fileUri, false);
	}

	public static EObject getModelFile(String fileUri, boolean isWorkspaceRelative) throws Exception {
	
		URI emfUri = (isWorkspaceRelative) ?
			URI.createPlatformResourceURI(fileUri, true) :
			URI.createFileURI(fileUri);
	
		return MultiModelTypeIntrospection.getRoot(emfUri);
	}

	public static EObject getModelFileInState(String relativeFileUri) throws Exception {

		String fileUri = MMTFActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + relativeFileUri;

		return getModelFile(fileUri, false);
	}

	public static void deleteModelFile(Model model) throws MMTFException {
	
		model.deleteInstance();
		deleteFile(model.getUri(), true);
	}

	public static void deleteFile(String fileUri, boolean isWorkspaceRelative) {

		if (isWorkspaceRelative) {
			fileUri = prependWorkspaceToUri(fileUri);
		}
		Path filePath = Paths.get(fileUri);
		try {
			Files.deleteIfExists(filePath);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "File " + fileUri + " not deleted", e);
		}
	}

	public static void deleteFileInState(String relativeFileUri) {

		String fileUri = MMTFActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + relativeFileUri;
		deleteFile(fileUri, false);
	}

	public static void createDirectory(String directoryUri, boolean isWorkspaceRelative) throws Exception {

		if (isWorkspaceRelative) {
			directoryUri = prependWorkspaceToUri(directoryUri);
		}
		Path directoryPath = Paths.get(directoryUri);
		Files.createDirectory(directoryPath);
	}

	public static void createDirectoryInState(String relativeDirectoryUri) throws Exception {

		String directoryUri = MMTFActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + relativeDirectoryUri;
		createDirectory(directoryUri, false);
	}

	public static void deleteDirectory(String directoryUri, boolean isWorkspaceRelative) {

		if (isWorkspaceRelative) {
			directoryUri = prependWorkspaceToUri(directoryUri);
		}
		Path directoryPath = Paths.get(directoryUri);
		try {
			Files.walkFileTree(directoryPath, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}
				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}
				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					Files.delete(dir);
					return FileVisitResult.CONTINUE;
				}
			});
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "Directory " + directoryUri + " not deleted", e);
		}
	}

	public static void deleteDirectoryInState(String relativeDirectoryUri) {

		String directoryUri = MMTFActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + relativeDirectoryUri;
		deleteDirectory(directoryUri, false);
	}

}
