/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import edu.toronto.cs.se.mmint.MMINTActivator;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.ui.SiriusUtils;

public class FileUtils {

	public static @NonNull URI createEMFUri(@NonNull String uri, boolean isWorkspaceRelative) {

		URI emfUri = (isWorkspaceRelative) ?
			URI.createPlatformResourceURI(uri, true) :
			URI.createFileURI(uri);

		return emfUri;
	}

	private static @NonNull String getFirstSegmentFromPath(@NonNull String path) {

		int sepIndex = path.indexOf(IPath.SEPARATOR, 1);

		return (sepIndex == -1) ?
			path.substring(1) :
			path.substring(1, sepIndex);
	}

	private static @NonNull String getAllButLastSegmentFromPath(@NonNull String path) {

		int sepIndex = path.lastIndexOf(IPath.SEPARATOR);
		if (sepIndex == -1) { // the path has no segments
			return "";
		}

		return path.substring(0, sepIndex + 1);
	}

	public static @NonNull String getLastSegmentFromPath(@NonNull String path) {

		int sepIndex = path.lastIndexOf(IPath.SEPARATOR);
		if (sepIndex == -1) { // the path has no segments
			return path;
		}

		return path.substring(sepIndex + 1, path.length());
	}

	public static @NonNull String getFileNameFromPath(@NonNull String path) {

		String lastSegment = FileUtils.getLastSegmentFromPath(path);
		int sepIndex = lastSegment.lastIndexOf(MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR);
		if (sepIndex == -1) { // the last segment is already the file name
			return lastSegment;
		}

		return lastSegment.substring(0, sepIndex);
	}

	public static @NonNull String getFileExtensionFromPath(@NonNull String path) {

		String lastSegment = FileUtils.getLastSegmentFromPath(path);
		int sepIndex = lastSegment.lastIndexOf(MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR);
		if (sepIndex == -1) { // no extension
			return "";
		}

		return lastSegment.substring(sepIndex + 1, lastSegment.length());
	}

	public static @NonNull String replaceLastSegmentInPath(@NonNull String path, @NonNull String newLastSegment) {

		return FileUtils.getAllButLastSegmentFromPath(path) + newLastSegment;
	}

	public static @NonNull String replaceFileNameInPath(@NonNull String path, @NonNull String newFileName) {

		String fileExtension = FileUtils.getFileExtensionFromPath(path);
		String newLastSegment = fileExtension.equals("") ?
			newFileName :
			newFileName + MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + fileExtension;

		return FileUtils.replaceLastSegmentInPath(path, newLastSegment);
	}

	public static @NonNull String replaceFileExtensionInPath(@NonNull String path, @NonNull String newFileExtension) {

		String fileName = FileUtils.getFileNameFromPath(path);
		String newLastSegment = fileName + MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + newFileExtension;

		return FileUtils.replaceLastSegmentInPath(path, newLastSegment);
	}

	public static @NonNull String addFileNameSuffixInPath(@NonNull String path, @NonNull String newFileNameSuffix) {

		String fileName = FileUtils.getFileNameFromPath(path);

		return FileUtils.replaceFileNameInPath(path, fileName + newFileNameSuffix);
	}

	public static @NonNull String getUniquePath(@NonNull String basePath, boolean isWorkspaceRelative, boolean isDirectory) {

		String uniquePath = basePath;
		if (!isFileOrDirectory(uniquePath, isWorkspaceRelative)) { // basePath itself is ok
			return uniquePath;
		}

		String fileName = FileUtils.getFileNameFromPath(basePath);
		int i = -1;
		do { // append a counter to basePath until ok
			i++;
			uniquePath = (isDirectory) ?
				basePath + i :
				FileUtils.replaceFileNameInPath(basePath, fileName + i);
		}
		while (isFileOrDirectory(uniquePath, isWorkspaceRelative));

		return uniquePath;
	}

	public static @Nullable IProject getWorkspaceProject(@NonNull String relativePath) {

	    String projectName = FileUtils.getFirstSegmentFromPath(relativePath);
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = workspaceRoot.getProject(projectName);

        return project;
	}

	public static @NonNull String prependWorkspacePath(@NonNull String relativePath) {

		IProject project = FileUtils.getWorkspaceProject(relativePath);
		String absolutePath = (project == null) ?
			ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + relativePath :
			project.getLocation().toString() + relativePath.replaceFirst(IPath.SEPARATOR + project.getName(), "");

		return absolutePath;
	}

	public static @NonNull String prependStatePath(@NonNull String relativePath) {

		return MMINTActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + relativePath;
	}

	public static void createTextFile(@NonNull String filePath, @NonNull String textContent, boolean isWorkspaceRelative) throws Exception {

		if (isWorkspaceRelative) {
			filePath = FileUtils.prependWorkspacePath(filePath);
		}
		Path path = Paths.get(filePath);
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
			writer.write(textContent);
		}
	}

	public static void createTextFileInState(@NonNull String textContent, @NonNull String relativeFilePath) throws Exception {

		FileUtils.createTextFile(FileUtils.prependStatePath(relativeFilePath), textContent, false);
	}

	public static void copyTextFileAndReplaceText(@NonNull String origFilePath, @NonNull String newFilePath, @NonNull String origText, @NonNull String newText, boolean isWorkspaceRelative) throws Exception {

		if (isWorkspaceRelative) {
			origFilePath = FileUtils.prependWorkspacePath(origFilePath);
			newFilePath = FileUtils.prependWorkspacePath(newFilePath);
		}
		Path origPath = Paths.get(origFilePath);
		Path newPath = Paths.get(newFilePath);
		try (BufferedReader oldBuffer = Files.newBufferedReader(origPath, Charset.forName("UTF-8"))) {
			try (BufferedWriter newBuffer = Files.newBufferedWriter(newPath, Charset.forName("UTF-8"))) {
				String oldLine;
				while ((oldLine = oldBuffer.readLine()) != null) {
					//System.out.println(URLDecoder.decode(origText, "UTF-8"));
					newBuffer.write(oldLine.replace(origText, newText));
					newBuffer.newLine();
				}
			}
		}
	}

	public static void copyTextFileAndReplaceTextInState(@NonNull String origRelativeFilePath, @NonNull String newRelativeFilePath, @NonNull String origText, @NonNull String newText) throws Exception {

		FileUtils.copyTextFileAndReplaceText(
			FileUtils.prependStatePath(origRelativeFilePath),
			FileUtils.prependStatePath(newRelativeFilePath),
			origText,
			newText,
			false);
	}

	private static @NonNull Path getPath(@NonNull String filePath, boolean isWorkspaceRelative) {

		if (isWorkspaceRelative) {
			filePath = FileUtils.prependWorkspacePath(filePath);
		}
		Path path = Paths.get(filePath);

		return path;
	}

	public static boolean isFile(@NonNull String path, boolean isWorkspaceRelative) {

		Path nioPath = FileUtils.getPath(path, isWorkspaceRelative);

		return Files.exists(nioPath) && !Files.isDirectory(nioPath);
	}

	public static boolean isDirectory(@NonNull String path, boolean isWorkspaceRelative) {

		Path nioPath = FileUtils.getPath(path, isWorkspaceRelative);

		return Files.exists(nioPath) && Files.isDirectory(nioPath);
	}

	public static boolean isFileOrDirectory(@NonNull String path, boolean isWorkspaceRelative) {

		return Files.exists(FileUtils.getPath(path, isWorkspaceRelative));
	}

	public static boolean isFileInState(@NonNull String relativePath) {

		return FileUtils.isFile(FileUtils.prependStatePath(relativePath), false);
	}

	public static boolean isDirectoryInState(@NonNull String relativePath) {

		return FileUtils.isDirectory(FileUtils.prependStatePath(relativePath), false);
	}

	public static boolean isFileOrDirectoryInState(@NonNull String relativePath) {

		return FileUtils.isFileOrDirectory(FileUtils.prependStatePath(relativePath), false);
	}

	public static void deleteFile(@NonNull String filePath, boolean isWorkspaceRelative) {

		Path path = FileUtils.getPath(filePath, isWorkspaceRelative);
		try {
			Files.deleteIfExists(path);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "File " + filePath + " not deleted", e);
		}
	}

	public static void deleteFileInState(@NonNull String relativeFilePath) {

		FileUtils.deleteFile(FileUtils.prependStatePath(relativeFilePath), false);
	}

	public static void createDirectory(@NonNull String directoryPath, boolean isWorkspaceRelative) throws Exception {

		Path path = FileUtils.getPath(directoryPath, isWorkspaceRelative);
		Files.createDirectory(path);
	}

	public static void createDirectoryInState(@NonNull String relativeDirectoryPath) throws Exception {

		FileUtils.createDirectory(FileUtils.prependStatePath(relativeDirectoryPath), false);
	}

	public static void deleteDirectory(@NonNull String directoryPath, boolean isWorkspaceRelative) {

		Path path = FileUtils.getPath(directoryPath, isWorkspaceRelative);
		try {
			Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
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
			MMINTException.print(IStatus.WARNING, "Directory " + directoryPath + " not deleted", e);
		}
	}

	public static void deleteDirectoryInState(@NonNull String relativeDirectoryPath) {

		FileUtils.deleteDirectory(FileUtils.prependStatePath(relativeDirectoryPath), false);
	}

	/**
	 * Writes the root of an ECore model from memory into an ECore model file.
	 *
	 * @param rootModelObj
	 *            The root of the ECore model.
	 * @param filePath
	 *            The path of the ECore model file.
	 * @param isWorkspaceRelative
	 *            True if the path is relative to the Eclipse workspace, false if it's absolute.
	 * @throws IOException
	 *             If the ECore model file could not be created or overwritten.
	 */
	public static void writeModelFile(@NonNull EObject rootModelObj, @NonNull String filePath, boolean isWorkspaceRelative) throws IOException {

		URI emfUri = FileUtils.createEMFUri(filePath, isWorkspaceRelative);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(emfUri);
		resource.getContents().add(rootModelObj);
		Map<String, Object> options = new HashMap<>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, true);
		resource.save(options);
	}

	public static void writeModelFileInState(@NonNull EObject rootModelObj, @NonNull String relativeFilePath) throws IOException {

		FileUtils.writeModelFile(rootModelObj, FileUtils.prependStatePath(relativeFilePath), false);
	}

	public static @NonNull EObject readModelFile(@NonNull String filePath, boolean isWorkspaceRelative) throws Exception {

		URI emfUri = FileUtils.createEMFUri(filePath, isWorkspaceRelative);
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(emfUri, true);
		if (resource.getErrors().size() > 0 || resource.getContents().size() == 0) {
		  throw new MMINTException("Error loading model resource");
		}

		return resource.getContents().get(0);
	}

	public static @NonNull EObject readModelFileInState(@NonNull String relativeFilePath) throws Exception {

		return FileUtils.readModelFile(FileUtils.prependStatePath(relativeFilePath), false);
	}

	public static @NonNull EObject readModelObject(@NonNull String fileObjectUri, @Nullable Resource resource) throws Exception {

		URI emfUri = URI.createURI(fileObjectUri, false, URI.FRAGMENT_LAST_SEPARATOR);
		if (resource == null) {
			ResourceSet set = new ResourceSetImpl();
			resource = set.getResource(emfUri, true);
		}

		return resource.getEObject(emfUri.fragment());
	}

	public static @Nullable Object getModelObjectFeature(@NonNull EObject modelObj, @NonNull String featureName) throws MMINTException {

		EStructuralFeature feature = modelObj.eClass().getEStructuralFeature(featureName);
		if (feature == null) {
			throw new MMINTException("Feature " + featureName + " not found in " + modelObj);
		}

		return modelObj.eGet(feature);
	}

	public static void setModelObjectFeature(@NonNull EObject modelObj, @NonNull String featureName, @NonNull Object value) throws MMINTException {

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
			if (value instanceof EList<?>) {
				throw new MMINTException("Feature " + featureName + " is not multi-valued");
			}
			modelObj.eSet(feature, value);
		}
	}

	public static void openEclipseEditor(@NonNull String filePath, @Nullable String editorId, boolean isWorkspaceRelative) throws MMINTException {

        //TODO MMINT[OO] Move all into Editor/Diagram
	    String sReprUri = null;
	    if (filePath.contains(MMINTConstants.MODEL_URI_SEPARATOR)) { // Sirius
	        sReprUri = filePath;
	        filePath = MIDRegistry.getModelUri(sReprUri);
	    }
		if (!FileUtils.isFile(filePath, isWorkspaceRelative)) {
			throw new MMINTException("The file " + filePath + " does not exist");
		}

		try {
		    if (sReprUri != null) {
		        SiriusUtils.openRepresentation(sReprUri);
		    }
		    else {
    			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    			if (isWorkspaceRelative) {
    				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
    					new org.eclipse.core.runtime.Path(filePath));
    				if (editorId != null) {
    					IDE.openEditor(activePage, file, editorId);
    				}
    				else {
    					IDE.openEditor(activePage, file);
    				}
    			}
    			else {
    				if (editorId != null) {
    					if (filePath.endsWith(GMFUtils.DIAGRAM_SUFFIX)) {
    						URI emfUri = FileUtils.createEMFUri(filePath, false);
    						IDE.openEditor(activePage, new URIEditorInput(emfUri), editorId);
    					}
    					else {
    						java.net.URI fileUri = new File(filePath).toURI();
    						IDE.openEditor(activePage, fileUri, editorId, true);
    					}
    				}
    				else {
    					java.net.URI fileUri = new File(filePath).toURI();
    					IFileStore file = EFS.getStore(fileUri);
    					IDE.openEditorOnFileStore(activePage, file);
    				}
    			}
		    }
		}
		catch (Exception e) {
			throw new MMINTException("Error opening Eclipse editor", e);
		}
	}

	public static void openEclipseEditorInState(@NonNull String filePath, @Nullable String editorId) throws MMINTException {

		FileUtils.openEclipseEditor(FileUtils.prependStatePath(filePath), editorId, false);
	}

}
