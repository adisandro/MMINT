/*******************************************************************************
 * Copyright (c) 2022, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.util;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
import org.eclipse.jface.viewers.ITreeContentProvider;

import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNLeanEncoder.PropertyTemplate;

public class TemplatePropertyContentProvider implements ITreeContentProvider {

  private Map<String, List<PropertyTemplate>> templates;

  public TemplatePropertyContentProvider(Map<String, List<PropertyTemplate>> templates) {
    this.templates = Objects.requireNonNull(templates);
  }

  @Override
  public Object[] getElements(Object inputElement) {
    var categories = this.templates.keySet().stream().filter(c -> c != null).collect(Collectors.<Object>toList());
    var uncategorized = this.templates.get(null);
    if (uncategorized != null) {
      categories.addAll(uncategorized);
    }
    return categories.toArray();
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof String) {
      return this.templates.get(parentElement).toArray();
    }
    return new Object[] {};
  }

  @Override
  public Object getParent(Object element) {
    if (element instanceof PropertyTemplate) {
      return ((PropertyTemplate) element).category;
    }
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    return (element instanceof String);
  }
}
