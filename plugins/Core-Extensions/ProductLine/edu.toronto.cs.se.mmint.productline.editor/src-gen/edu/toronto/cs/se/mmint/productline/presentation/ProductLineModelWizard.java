/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.productline.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import edu.toronto.cs.se.mmint.productline.ProductLineFactory;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.provider.ProductLineEditPlugin;

/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductLineModelWizard extends Wizard implements INewWizard {
  /**
   * The supported extensions for created files.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays.asList(ProductLineEditorPlugin.INSTANCE.getString("_UI_ProductLineEditorFilenameExtensions")
                                                                                                                                .split("\\s*,\\s*")));

  /**
   * A formatted list of supported file extensions, suitable for display.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String FORMATTED_FILE_EXTENSIONS = ProductLineEditorPlugin.INSTANCE.getString("_UI_ProductLineEditorFilenameExtensions")
                                                                                         .replaceAll("\\s*,\\s*", ", ");

  /**
   * This caches an instance of the model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProductLinePackage productLinePackage = ProductLinePackage.eINSTANCE;

  /**
   * This caches an instance of the model factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProductLineFactory productLineFactory = this.productLinePackage.getProductLineFactory();

  /**
   * This is the file creation page.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProductLineModelWizardNewFileCreationPage newFileCreationPage;

  /**
   * This is the initial object creation page.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProductLineModelWizardInitialObjectCreationPage initialObjectCreationPage;

  /**
   * Remember the selection during initialization for populating the default container.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IStructuredSelection selection;

  /**
   * Remember the workbench during initialization.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IWorkbench workbench;

  /**
   * Caches the names of the types that can be created as the root object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected List<String> initialObjectNames;

  /**
   * This just records the information.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void init(IWorkbench workbench, IStructuredSelection selection) {
    this.workbench = workbench;
    this.selection = selection;
    setWindowTitle(ProductLineEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
    setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(ProductLineEditorPlugin.INSTANCE.getImage("full/wizban/NewProductLine")));
  }

  /**
   * Returns the names of the types that can be created as the root object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Collection<String> getInitialObjectNames() {
    if (this.initialObjectNames == null) {
      this.initialObjectNames = new ArrayList<>();
      for (EClassifier eClassifier : this.productLinePackage.getEClassifiers()) {
        if (eClassifier instanceof EClass eClass) {
          if (!eClass.isAbstract()) {
            this.initialObjectNames.add(eClass.getName());
          }
        }
      }
      Collections.sort(this.initialObjectNames, CommonPlugin.INSTANCE.getComparator());
    }
    return this.initialObjectNames;
  }

  /**
   * Create a new model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EObject createInitialModel() {
    var eClass = (EClass) this.productLinePackage.getEClassifier(this.initialObjectCreationPage.getInitialObjectName());
    var rootObject = this.productLineFactory.create(eClass);
    return rootObject;
  }

  /**
   * Do the work after everything is specified.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean performFinish() {
    try {
      // Remember the file.
      //
      final var modelFile = getModelFile();

      // Do the work within an operation.
      //
      WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
        @Override
        protected void execute(IProgressMonitor progressMonitor) {
          try {
            // Create a resource set
            //
            ResourceSet resourceSet = new ResourceSetImpl();

            // Get the URI of the model file.
            //
            var fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

            // Create a resource for this file.
            //
            var resource = resourceSet.createResource(fileURI);

            // Add the initial model object to the contents.
            //
            var rootObject = createInitialModel();
            if (rootObject != null) {
              resource.getContents().add(rootObject);
            }

            // Save the contents of the resource to the file system.
            //
            Map<Object, Object> options = new HashMap<>();
            options.put(XMLResource.OPTION_ENCODING, ProductLineModelWizard.this.initialObjectCreationPage.getEncoding());
            resource.save(options);
          }
          catch (Exception exception) {
            ProductLineEditorPlugin.INSTANCE.log(exception);
          }
          finally {
            progressMonitor.done();
          }
        }
      };

      getContainer().run(false, false, operation);

      // Select the new file resource in the current view.
      //
      var workbenchWindow = this.workbench.getActiveWorkbenchWindow();
      var page = workbenchWindow.getActivePage();
      final var activePart = page.getActivePart();
      if (activePart instanceof ISetSelectionTarget) {
        final ISelection targetSelection = new StructuredSelection(modelFile);
        getShell().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            ((ISetSelectionTarget) activePart).selectReveal(targetSelection);
          }
        });
      }

      // Open an editor on the new file.
      //
      try {
        page.openEditor(new FileEditorInput(modelFile), this.workbench.getEditorRegistry().getDefaultEditor(modelFile
                                                                                                                .getFullPath()
                                                                                                                .toString())
                                                                 .getId());
      }
      catch (PartInitException exception) {
        MessageDialog.openError(workbenchWindow.getShell(), ProductLineEditorPlugin.INSTANCE.getString(
                                                                                                       "_UI_OpenEditorError_label"),
                                exception.getMessage());
        return false;
      }

      return true;
    }
    catch (Exception exception) {
      ProductLineEditorPlugin.INSTANCE.log(exception);
      return false;
    }
  }

  /**
   * This is the one page of the wizard.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public class ProductLineModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
    /**
     * Pass in the selection.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProductLineModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
      super(pageId, selection);
    }

    /**
     * The framework calls this to see if the file is correct.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validatePage() {
      if (super.validatePage()) {
        var extension = new Path(getFileName()).getFileExtension();
        if (extension == null || !ProductLineModelWizard.FILE_EXTENSIONS.contains(extension)) {
          var key = ProductLineModelWizard.FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
          setErrorMessage(ProductLineEditorPlugin.INSTANCE.getString(key, new Object[] { ProductLineModelWizard.FORMATTED_FILE_EXTENSIONS }));
          return false;
        }
        return true;
      }
      return false;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IFile getModelFile() {
      return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
    }
  }

  /**
   * This is the page where the type of object to create is selected.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public class ProductLineModelWizardInitialObjectCreationPage extends WizardPage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Combo initialObjectField;

    /**
     * @generated
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    protected List<String> encodings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Combo encodingField;

    /**
     * Pass in the selection.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProductLineModelWizardInitialObjectCreationPage(String pageId) {
      super(pageId);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void createControl(Composite parent) {
      var composite = new Composite(parent, SWT.NONE);
      {
        var layout = new GridLayout();
        layout.numColumns = 1;
        layout.verticalSpacing = 12;
        composite.setLayout(layout);

        var data = new GridData();
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        composite.setLayoutData(data);
      }

      var containerLabel = new Label(composite, SWT.LEFT);
      {
        containerLabel.setText(ProductLineEditorPlugin.INSTANCE.getString("_UI_ModelObject"));

        var data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        containerLabel.setLayoutData(data);
      }

      this.initialObjectField = new Combo(composite, SWT.BORDER);
      {
        var data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        this.initialObjectField.setLayoutData(data);
      }

      for (String objectName : getInitialObjectNames()) {
        this.initialObjectField.add(getLabel(objectName));
      }

      if (this.initialObjectField.getItemCount() == 1) {
        this.initialObjectField.select(0);
      }
      this.initialObjectField.addModifyListener(this.validator);

      var encodingLabel = new Label(composite, SWT.LEFT);
      {
        encodingLabel.setText(ProductLineEditorPlugin.INSTANCE.getString("_UI_XMLEncoding"));

        var data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        encodingLabel.setLayoutData(data);
      }
      this.encodingField = new Combo(composite, SWT.BORDER);
      {
        var data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        this.encodingField.setLayoutData(data);
      }

      for (String encoding : getEncodings()) {
        this.encodingField.add(encoding);
      }

      this.encodingField.select(0);
      this.encodingField.addModifyListener(this.validator);

      setPageComplete(validatePage());
      setControl(composite);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModifyListener validator = new ModifyListener() {
      @Override
      public void modifyText(ModifyEvent e) {
        setPageComplete(validatePage());
      }
    };

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected boolean validatePage() {
      return getInitialObjectName() != null && getEncodings().contains(this.encodingField.getText());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setVisible(boolean visible) {
      super.setVisible(visible);
      if (visible) {
        if (this.initialObjectField.getItemCount() == 1) {
          this.initialObjectField.clearSelection();
          this.encodingField.setFocus();
        }
        else {
          this.encodingField.clearSelection();
          this.initialObjectField.setFocus();
        }
      }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInitialObjectName() {
      var label = this.initialObjectField.getText();

      for (String name : getInitialObjectNames()) {
        if (getLabel(name).equals(label)) {
          return name;
        }
      }
      return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEncoding() {
      return this.encodingField.getText();
    }

    /**
     * Returns the label for the specified type name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected String getLabel(String typeName) {
      try {
        return ProductLineEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
      }
      catch (MissingResourceException mre) {
        ProductLineEditorPlugin.INSTANCE.log(mre);
      }
      return typeName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<String> getEncodings() {
      if (this.encodings == null) {
        this.encodings = new ArrayList<>();
        for (var stringTokenizer = new StringTokenizer(ProductLineEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens();) {
          this.encodings.add(stringTokenizer.nextToken());
        }
      }
      return this.encodings;
    }
  }

  /**
   * The framework calls this to create the contents of the wizard.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void addPages() {
    // Create a page, set the title, and the initial model file name.
    //
    this.newFileCreationPage = new ProductLineModelWizardNewFileCreationPage("Whatever", this.selection);
    this.newFileCreationPage.setTitle(ProductLineEditorPlugin.INSTANCE.getString("_UI_ProductLineModelWizard_label"));
    this.newFileCreationPage.setDescription(ProductLineEditorPlugin.INSTANCE.getString("_UI_ProductLineModelWizard_description"));
    this.newFileCreationPage.setFileName(ProductLineEditorPlugin.INSTANCE.getString("_UI_ProductLineEditorFilenameDefaultBase")
      + "." + ProductLineModelWizard.FILE_EXTENSIONS.get(0));
    addPage(this.newFileCreationPage);

    // Try and get the resource selection to determine a current directory for the file dialog.
    //
    if (this.selection != null && !this.selection.isEmpty()) {
      // Get the resource...
      //
      var selectedElement = this.selection.iterator().next();
      if (selectedElement instanceof IResource selectedResource) {
        if (selectedResource.getType() == IResource.FILE) {
          selectedResource = selectedResource.getParent();
        }

        // This gives us a directory...
        //
        if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
          // Set this for the container.
          //
          this.newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

          // Make up a unique new name here.
          //
          var defaultModelBaseFilename = ProductLineEditorPlugin.INSTANCE.getString("_UI_ProductLineEditorFilenameDefaultBase");
          var defaultModelFilenameExtension = ProductLineModelWizard.FILE_EXTENSIONS.get(0);
          var modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
          for (var i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
            modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
          }
          this.newFileCreationPage.setFileName(modelFilename);
        }
      }
    }
    this.initialObjectCreationPage = new ProductLineModelWizardInitialObjectCreationPage("Whatever2");
    this.initialObjectCreationPage.setTitle(ProductLineEditorPlugin.INSTANCE.getString("_UI_ProductLineModelWizard_label"));
    this.initialObjectCreationPage.setDescription(ProductLineEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
    addPage(this.initialObjectCreationPage);
  }

  /**
   * Get the file from the page.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IFile getModelFile() {
    return this.newFileCreationPage.getModelFile();
  }

}
