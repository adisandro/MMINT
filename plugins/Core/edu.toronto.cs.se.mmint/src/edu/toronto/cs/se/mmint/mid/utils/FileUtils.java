/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import edu.toronto.cs.se.mmint.MMINTActivator;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.ui.SiriusUtils;

public class FileUtils {

  private static Map<String, Object> SAVE_OPTIONS = Map.of(
    XMLResource.OPTION_SCHEMA_LOCATION, true,
    XMLResource.OPTION_ENCODING, "UTF-8",
    XMLResource.OPTION_SAVE_ONLY_IF_CHANGED, XMLResource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

  public static URI createEMFUri(String uri, boolean isWorkspaceRelative) {
		var emfUri = (isWorkspaceRelative) ?
			URI.createPlatformResourceURI(uri, true) :
			URI.createFileURI(uri);

		return emfUri;
	}

	private static String getFirstSegmentFromPath(String path) {
		var sepIndex = path.indexOf(IPath.SEPARATOR, 1);

		return (sepIndex == -1) ?
			path.substring(1) :
			path.substring(1, sepIndex);
	}

	public static String getAllButLastSegmentFromPath(String path) {
    if (path.isEmpty()) { // empty path
      return path;
    }
    var end = path.length() - 1;
    if (path.charAt(end) == IPath.SEPARATOR) { // last segment is a dir
      end -= 1;
    }
		var sepIndex = path.lastIndexOf(IPath.SEPARATOR, end);
		if (sepIndex == -1) { // the path has 1 segment only
			return "";
		}

		return path.substring(0, sepIndex + 1);
	}

	public static String getLastSegmentFromPath(String path) {
	  if (path.isEmpty()) { // empty path
	    return path;
	  }
	  var end = path.length() - 1;
    if (path.charAt(end) == IPath.SEPARATOR) { // last segment is a dir
      end -= 1;
    }
		var sepIndex = path.lastIndexOf(IPath.SEPARATOR, end);
		if (sepIndex == -1) { // the path has 1 segment only
			return path;
		}

		return path.substring(sepIndex + 1, path.length());
	}

	public static String getFileNameFromPath(String path) {
		String lastSegment = FileUtils.getLastSegmentFromPath(path);
		var sepIndex = lastSegment.lastIndexOf(MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR);
		if (sepIndex == -1) { // the last segment is already the file name
			return lastSegment;
		}

		return lastSegment.substring(0, sepIndex);
	}

	public static String getFileExtensionFromPath(String path) {
		String lastSegment = FileUtils.getLastSegmentFromPath(path);
		var sepIndex = lastSegment.lastIndexOf(MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR);
		if (sepIndex == -1) { // no extension
			return "";
		}

		return lastSegment.substring(sepIndex + 1, lastSegment.length());
	}

	public static String replaceLastSegmentInPath(String path, String newLastSegment) {
		return FileUtils.getAllButLastSegmentFromPath(path) + newLastSegment;
	}

	public static String replaceFileNameInPath(String path, String newFileName) {
		String fileExtension = FileUtils.getFileExtensionFromPath(path);
		var newLastSegment = fileExtension.equals("") ?
			newFileName :
			newFileName + MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + fileExtension;

		return FileUtils.replaceLastSegmentInPath(path, newLastSegment);
	}

	public static String replaceFileExtensionInPath(String path, String newFileExtension) {
		String fileName = FileUtils.getFileNameFromPath(path);
		var newLastSegment = fileName + MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + newFileExtension;

		return FileUtils.replaceLastSegmentInPath(path, newLastSegment);
	}

	public static String addFileNameSuffixInPath(String path, String newFileNameSuffix) {
		String fileName = FileUtils.getFileNameFromPath(path);

		return FileUtils.replaceFileNameInPath(path, fileName + newFileNameSuffix);
	}

	public static String getUniquePath(String basePath, boolean isWorkspaceRelative, boolean isDirectory) {
		String uniquePath = basePath;
		if (!isFileOrDirectory(uniquePath, isWorkspaceRelative)) { // basePath itself is ok
			return uniquePath;
		}

		String fileName = FileUtils.getFileNameFromPath(basePath);
		var i = -1;
		do { // append a counter to basePath until ok
			i++;
			uniquePath = (isDirectory) ?
				basePath + i :
				FileUtils.replaceFileNameInPath(basePath, fileName + i);
		}
		while (isFileOrDirectory(uniquePath, isWorkspaceRelative));

		return uniquePath;
	}

	public static @Nullable IProject getWorkspaceProject(String relativePath) {
	  var projectName = FileUtils.getFirstSegmentFromPath(relativePath);
      var workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
      var project = workspaceRoot.getProject(projectName);

      return project;
	}

	public static String prependWorkspacePath(String relativePath) {
		var project = FileUtils.getWorkspaceProject(relativePath);
		var absolutePath = (project == null) ?
			ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + relativePath :
			project.getLocation().toString() + relativePath.replaceFirst(IPath.SEPARATOR + project.getName(), "");

		return absolutePath;
	}

	public static String prependStatePath(String relativePath) {
		return MMINTActivator.getDefault().getStateLocation().toOSString() + IPath.SEPARATOR + relativePath;
	}

	public static void createTextFile(String filePath, String textContent, boolean isWorkspaceRelative) throws Exception {
		if (isWorkspaceRelative) {
			filePath = FileUtils.prependWorkspacePath(filePath);
		}
		var path = Paths.get(filePath);
		try (var writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
			writer.write(textContent);
		}
	}

	public static void createTextFileInState(String textContent, String relativeFilePath) throws Exception {
		FileUtils.createTextFile(FileUtils.prependStatePath(relativeFilePath), textContent, false);
	}

	public static void copyTextFileAndReplaceText(String origFilePath, String newFilePath, String origText,
	                                              String newText, boolean isWorkspaceRelative) throws Exception {
		if (isWorkspaceRelative) {
			origFilePath = FileUtils.prependWorkspacePath(origFilePath);
			newFilePath = FileUtils.prependWorkspacePath(newFilePath);
		}
		var origPath = Paths.get(origFilePath);
		var newPath = Paths.get(newFilePath);
		try (var oldBuffer = Files.newBufferedReader(origPath, Charset.forName("UTF-8"))) {
			try (var newBuffer = Files.newBufferedWriter(newPath, Charset.forName("UTF-8"))) {
				String oldLine;
				while ((oldLine = oldBuffer.readLine()) != null) {
					//System.out.println(URLDecoder.decode(origText, "UTF-8"));
					newBuffer.write(oldLine.replace(origText, newText));
					newBuffer.newLine();
				}
			}
		}
	}

	public static void copyTextFileAndReplaceTextInState(String origRelativeFilePath, String newRelativeFilePath,
	                                                     String origText, String newText) throws Exception {
		FileUtils.copyTextFileAndReplaceText(
			FileUtils.prependStatePath(origRelativeFilePath),
			FileUtils.prependStatePath(newRelativeFilePath),
			origText,
			newText,
			false);
	}

	private static Path getPath(String path, boolean isWorkspaceRelative) {
		if (isWorkspaceRelative) {
			path = FileUtils.prependWorkspacePath(path);
		}

		return Paths.get(path);
	}

	public static boolean isFile(String filePath, boolean isWorkspaceRelative) {
		var path = FileUtils.getPath(filePath, isWorkspaceRelative);

		return Files.exists(path) && !Files.isDirectory(path);
	}

	public static boolean isDirectory(String dirPath, boolean isWorkspaceRelative) {
		var path = FileUtils.getPath(dirPath, isWorkspaceRelative);

		return Files.exists(path) && Files.isDirectory(path);
	}

	public static boolean isFileOrDirectory(String path, boolean isWorkspaceRelative) {
		return Files.exists(FileUtils.getPath(path, isWorkspaceRelative));
	}

	public static boolean isFileInState(String relativePath) {
		return FileUtils.isFile(FileUtils.prependStatePath(relativePath), false);
	}

	public static boolean isDirectoryInState(String relativePath) {
		return FileUtils.isDirectory(FileUtils.prependStatePath(relativePath), false);
	}

	public static boolean isFileOrDirectoryInState(String relativePath) {
		return FileUtils.isFileOrDirectory(FileUtils.prependStatePath(relativePath), false);
	}

	public static void deleteFile(String filePath, boolean isWorkspaceRelative) {
		Path path = FileUtils.getPath(filePath, isWorkspaceRelative);
		try {
			Files.deleteIfExists(path);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.INFO, "File " + filePath + " not deleted", e);
		}
	}

	public static void deleteFileInState(String relativeFilePath) {
		FileUtils.deleteFile(FileUtils.prependStatePath(relativeFilePath), false);
	}

	public static void createDirectory(String directoryPath, boolean isWorkspaceRelative) throws Exception {
		Path path = FileUtils.getPath(directoryPath, isWorkspaceRelative);
		Files.createDirectory(path);
	}

	public static void createDirectoryInState(String relativeDirectoryPath) throws Exception {
		FileUtils.createDirectory(FileUtils.prependStatePath(relativeDirectoryPath), false);
	}

  public static void copyDirectory(String srcDirectoryPath, boolean srcWorkspaceRelative,
                                   String tgtDirectoryPath, boolean tgtWorkspaceRelative)
                                  throws Exception {
    Path srcPath = FileUtils.getPath(srcDirectoryPath, srcWorkspaceRelative);
    Path tgtPath = FileUtils.getPath(tgtDirectoryPath, tgtWorkspaceRelative);
    Files.walkFileTree(srcPath, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        try {
          Files.createDirectory(tgtPath.resolve(srcPath.relativize(dir)));
        }
        catch (FileAlreadyExistsException e) {
          // continue
        }
        return FileVisitResult.CONTINUE;
      }
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.copy(file, tgtPath.resolve(srcPath.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
      }
    });
  }

	public static void deleteDirectory(String directoryPath, boolean isWorkspaceRelative) {
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
			MMINTException.print(IStatus.INFO, "Directory " + directoryPath + " not deleted", e);
		}
	}

	public static void deleteDirectoryInState(String relativeDirectoryPath) {
		FileUtils.deleteDirectory(FileUtils.prependStatePath(relativeDirectoryPath), false);
	}

  public static Resource writeEMFResource(URI emfUri, @Nullable ResourceSet resourceSet) {
    if (resourceSet == null) {
      resourceSet = new ResourceSetImpl();
    }
    return resourceSet.createResource(emfUri);
  }

	public static Resource writeEMFResource(String filePath, @Nullable ResourceSet resourceSet,
	                                        boolean isWorkspaceRelative) {
    var emfUri = FileUtils.createEMFUri(filePath, isWorkspaceRelative);
    return writeEMFResource(emfUri, resourceSet);
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
	public static Resource writeModelFile(EObject rootModelObj, String filePath, @Nullable ResourceSet resourceSet,
	                                      boolean isWorkspaceRelative) throws IOException {
	  var resource = writeEMFResource(filePath, resourceSet, isWorkspaceRelative);
		resource.getContents().add(rootModelObj);
		resource.save(FileUtils.SAVE_OPTIONS);
		return resource;
	}

	public static Resource writeModelFileInState(EObject rootModelObj, String relativeFilePath) throws IOException {
		return writeModelFile(rootModelObj, FileUtils.prependStatePath(relativeFilePath), null, false);
	}

  public static Resource getEMFResource(URI emfUri, @Nullable ResourceSet resourceSet) throws Exception {
    if (resourceSet == null) {
      resourceSet = new ResourceSetImpl();
    }
    resourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
    var resource = resourceSet.getResource(emfUri, true);
    if (resource.getErrors().size() > 0) {
      var errors = resource.getErrors().stream().map(Diagnostic::getMessage).collect(Collectors.joining(". "));
      throw new MMINTException("Errors loading resource: " + errors);
    }
    if (resource.getContents().size() == 0) {
      throw new MMINTException("Empty resource");
    }

    return resource;
  }

  public static Resource getEMFResource(String filePath, @Nullable ResourceSet resourceSet, boolean isWorkspaceRelative)
                                       throws Exception {
    var emfUri = FileUtils.createEMFUri(filePath, isWorkspaceRelative);
    return FileUtils.getEMFResource(emfUri, resourceSet);
  }

  public static EObject readModelFile(String filePath, @Nullable ResourceSet resourceSet, boolean isWorkspaceRelative)
                                     throws Exception {
    var resource = FileUtils.getEMFResource(filePath, resourceSet, isWorkspaceRelative);
    return resource.getContents().get(0);
	}

	public static EObject readModelFileInState(String relativeFilePath) throws Exception {
		return FileUtils.readModelFile(FileUtils.prependStatePath(relativeFilePath), null, false);
	}

	public static EObject readModelObject(String fileObjectUri, @Nullable Resource resource) throws Exception {
		var emfUri = URI.createURI(fileObjectUri, false, URI.FRAGMENT_LAST_SEPARATOR);
		if (resource == null) {
		  resource = FileUtils.getEMFResource(emfUri, null);
		}
		return resource.getEObject(emfUri.fragment());
	}

	public static @Nullable Object getModelObjectFeature(EObject modelObj, String featureName) throws MMINTException {
		var feature = modelObj.eClass().getEStructuralFeature(featureName);
		if (feature == null) {
			throw new MMINTException("Feature " + featureName + " not found in " + modelObj);
		}

		return modelObj.eGet(feature);
	}

	public static Object convertStringToEType(EAttribute emfAttribute, String value) {
    var emfType = emfAttribute.getEAttributeType();
    Object emfValue;
    if (emfType instanceof EEnum) {
      emfValue = emfType.getEPackage().getEFactoryInstance().createFromString(emfType, value);
    }
    else {
      emfValue = switch(emfType.getName()) {
        case "EBoolean" -> Boolean.parseBoolean(value);
        case "EInt"     -> Integer.parseInt(value);
        case "EFloat"   -> Float.parseFloat(value);
        case "EDouble"  -> Double.parseDouble(value);
        case "EString"  -> value;
        default         -> value;
      };
    }

    return emfValue;
	}

  public static void setModelObjectFeature(EObject modelObj, EStructuralFeature feature, @Nullable Object value) throws MMINTException {
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
        throw new MMINTException("Feature " + feature.getName() + " is not multi-valued");
      }
      modelObj.eSet(feature, value);
    }
  }

	public static void setModelObjectFeature(EObject modelObj, String featureName, @Nullable Object value) throws MMINTException {
		var feature = modelObj.eClass().getEStructuralFeature(featureName);
    if (feature == null) {
      throw new MMINTException("Feature " + featureName + " not found in " + modelObj);
    }
		setModelObjectFeature(modelObj, feature, value);
	}

	public static IEditorPart openEclipseEditor(String filePath, @Nullable String editorId, boolean isWorkspaceRelative)
	                                           throws MMINTException {
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
		      return SiriusUtils.openRepresentation(sReprUri);
		    }
		    else {
    			var activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    			if (isWorkspaceRelative) {
    				var file = ResourcesPlugin.getWorkspace().getRoot().getFile(
    					new org.eclipse.core.runtime.Path(filePath));
    				if (editorId != null) {
    					return IDE.openEditor(activePage, file, editorId);
    				}
    				else {
    					return IDE.openEditor(activePage, file);
    				}
    			}
    			else {
    				if (editorId != null) {
    					if (filePath.endsWith(GMFUtils.DIAGRAM_SUFFIX)) {
    						URI emfUri = FileUtils.createEMFUri(filePath, false);
    						return IDE.openEditor(activePage, new URIEditorInput(emfUri), editorId);
    					}
    					else {
    						var fileUri = new File(filePath).toURI();
    						return IDE.openEditor(activePage, fileUri, editorId, true);
    					}
    				}
    				else {
    					var fileUri = new File(filePath).toURI();
    					var file = EFS.getStore(fileUri);
    					return IDE.openEditorOnFileStore(activePage, file);
    				}
    			}
		    }
		}
		catch (Exception e) {
			throw new MMINTException("Error opening Eclipse editor", e);
		}
	}

	public static void openEclipseEditorInState(String filePath, @Nullable String editorId) throws MMINTException {
		FileUtils.openEclipseEditor(FileUtils.prependStatePath(filePath), editorId, false);
	}
}
