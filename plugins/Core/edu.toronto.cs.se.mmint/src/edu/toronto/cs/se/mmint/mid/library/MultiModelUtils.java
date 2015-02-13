/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.library;

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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTActivator;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;

public class MultiModelUtils {

	public static @NonNull URI getEMFUri(@NonNull String uri, boolean isWorkspaceRelative) {

		URI emfUri = (isWorkspaceRelative) ?
			URI.createPlatformResourceURI(uri, true) :
			URI.createFileURI(uri);

		return emfUri;
	}

	private static String getFirstSegmentFromUri(String uri) {

		int firstSeparator = uri.indexOf(MMINT.URI_SEPARATOR, 1);

		return (firstSeparator == -1) ?
			uri.substring(1) :
			uri.substring(1, firstSeparator);
	}

	public static String getLastSegmentFromUri(String uri) {

		return uri.substring(uri.lastIndexOf(MMINT.URI_SEPARATOR) + 1, uri.length());
	}

	public static String getFileNameFromUri(String uri) {

		String lastSegmentUri = getLastSegmentFromUri(uri);

		return lastSegmentUri.substring(0, lastSegmentUri.lastIndexOf(MMINT.MODEL_FILEEXTENSION_SEPARATOR));
	}

	public static String getFileExtensionFromUri(String uri) {

		String lastSegmentUri = getLastSegmentFromUri(uri);

		return lastSegmentUri.substring(lastSegmentUri.lastIndexOf(MMINT.MODEL_FILEEXTENSION_SEPARATOR) + 1, lastSegmentUri.length());
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

		return uri.replace(MMINT.MODEL_FILEEXTENSION_SEPARATOR + fileExtension, MMINT.MODEL_FILEEXTENSION_SEPARATOR + newFileExtension);
	}

	public static String addFileNameSuffixInUri(String uri, String newFileNameSuffix) {

		String fileExtension = getFileExtensionFromUri(uri);

		return uri.replace(MMINT.MODEL_FILEEXTENSION_SEPARATOR + fileExtension, newFileNameSuffix + MMINT.MODEL_FILEEXTENSION_SEPARATOR + fileExtension);
	}

	public static @NonNull String getUniqueUri(@NonNull String baseUri, boolean isWorkspaceRelative, boolean isDirectory) {

		int i = -1;
		String x;
		do {
			i++;
			x = (isDirectory) ?
				baseUri + i :
				replaceFileNameInUri(baseUri, getFileNameFromUri(baseUri) + i);
		}
		while (isFileOrDirectory(x, isWorkspaceRelative));

		return x;
	}

	public static String prependWorkspaceToUri(String uri) {

		String absoluteUri;
		String projectName = getFirstSegmentFromUri(uri);
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = workspaceRoot.getProject(projectName);
		absoluteUri = (project == null) ?
			ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + uri :
			project.getLocation().toString() + uri.replace(MMINT.URI_SEPARATOR + projectName, "");

		return absoluteUri;
	}

	public static @NonNull String prependStateToUri(@NonNull String uri) {

		return MMINTActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + uri;
	}

	public static void createTextFile(String fileUri, String text, boolean isWorkspaceRelative) throws Exception {

		if (isWorkspaceRelative) {
			fileUri = prependWorkspaceToUri(fileUri);
		}
		Path filePath = Paths.get(fileUri);
		try (BufferedWriter writer = Files.newBufferedWriter(filePath, Charset.forName("UTF-8"))) {
			writer.write(text);
		}
	}

	public static void createTextFileInState(String text, String relativeFileUri) throws Exception {

		createTextFile(prependStateToUri(relativeFileUri), text, false);
	}

	public static void copyTextFileAndReplaceText(String origFileUri, String newFileUri, String origText, String newText, boolean isWorkspaceRelative) throws Exception {

		if (isWorkspaceRelative) {
			origFileUri = prependWorkspaceToUri(origFileUri);
			newFileUri = prependWorkspaceToUri(newFileUri);
		}
		Path oldFilePath = Paths.get(origFileUri);
		Path newFilePath = Paths.get(newFileUri);
		try (BufferedReader oldBuffer = Files.newBufferedReader(oldFilePath, Charset.forName("UTF-8"))) {
			try (BufferedWriter newBuffer = Files.newBufferedWriter(newFilePath, Charset.forName("UTF-8"))) {
				String oldLine;
				while ((oldLine = oldBuffer.readLine()) != null) {
					newBuffer.write(oldLine.replaceAll(origText, newText));
					newBuffer.newLine();
				}
			}
		}
	}

	public static void copyTextFileAndReplaceTextInState(String origRelativeFileUri, String newRelativeFileUri, String origText, String newText) throws Exception {

		copyTextFileAndReplaceText(prependStateToUri(origRelativeFileUri), prependStateToUri(newRelativeFileUri), origText, newText, false);
	}

	private static @NonNull Path getPath(@NonNull String uri, boolean isWorkspaceRelative) {

		if (isWorkspaceRelative) {
			uri = prependWorkspaceToUri(uri);
		}
		Path path = Paths.get(uri);

		return path;
	}

	public static boolean isFile(@NonNull String uri, boolean isWorkspaceRelative) {

		Path filePath = getPath(uri, isWorkspaceRelative);

		return Files.exists(filePath) && !Files.isDirectory(filePath);
	}

	public static boolean isDirectory(@NonNull String uri, boolean isWorkspaceRelative) {

		Path dirPath = getPath(uri, isWorkspaceRelative);

		return Files.exists(dirPath) && Files.isDirectory(dirPath);
	}

	public static boolean isFileOrDirectory(@NonNull String uri, boolean isWorkspaceRelative) {

		Path path = getPath(uri, isWorkspaceRelative);

		return Files.exists(path);
	}

	public static boolean isFileInState(@NonNull String relativeUri) {

		return isFile(prependStateToUri(relativeUri), false);
	}

	public static boolean isDirectoryInState(@NonNull String relativeUri) {

		return isDirectory(prependStateToUri(relativeUri), false);
	}

	public static boolean isFileOrDirectoryInState(@NonNull String relativeUri) {

		return isFileOrDirectory(prependStateToUri(relativeUri), false);
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
	public static void createModelFile(@NonNull EObject root, @NonNull String fileUri, boolean isWorkspaceRelative) throws Exception {

		MultiModelTypeIntrospection.writeRoot(root, getEMFUri(fileUri, isWorkspaceRelative));
	}

	public static void createModelFileInState(EObject root, String relativeFileUri) throws Exception {

		createModelFile(root, prependStateToUri(relativeFileUri), false);
	}

	public static @NonNull EObject getModelFile(@NonNull String fileUri, boolean isWorkspaceRelative) throws Exception {

		return MultiModelTypeIntrospection.getRoot(getEMFUri(fileUri, isWorkspaceRelative));
	}

	public static EObject getModelFileInState(String relativeFileUri) throws Exception {

		return getModelFile(prependStateToUri(relativeFileUri), false);
	}

	public static void deleteModelFile(Model model) throws MMINTException {
	
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
			MMINTException.print(IStatus.WARNING, "File " + fileUri + " not deleted", e);
		}
	}

	public static void deleteFileInState(String relativeFileUri) {

		deleteFile(prependStateToUri(relativeFileUri), false);
	}

	public static void createDirectory(String directoryUri, boolean isWorkspaceRelative) throws Exception {

		if (isWorkspaceRelative) {
			directoryUri = prependWorkspaceToUri(directoryUri);
		}
		Path directoryPath = Paths.get(directoryUri);
		Files.createDirectory(directoryPath);
	}

	public static void createDirectoryInState(String relativeDirectoryUri) throws Exception {

		createDirectory(prependStateToUri(relativeDirectoryUri), false);
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
			MMINTException.print(IStatus.WARNING, "Directory " + directoryUri + " not deleted", e);
		}
	}

	public static void deleteDirectoryInState(String relativeDirectoryUri) {

		deleteDirectory(prependStateToUri(relativeDirectoryUri), false);
	}

	@SuppressWarnings("unchecked")
	public static void setModelObjFeature(EObject modelObj, String featureName, Object value) throws MMINTException {

		EStructuralFeature feature = modelObj.eClass().getEStructuralFeature(featureName);
		if (feature == null) {
			throw new MMINTException("Feature " + featureName + " not found in " + modelObj);
		}
		if (feature.isMany()) {
			if (value instanceof EList<?>) {
				modelObj.eSet(feature, value);
			}
			else {
				((EList<Object>) modelObj.eGet(feature)).add(value);
			}
		}
		else {
			modelObj.eSet(feature, value);
		}
	}

}
