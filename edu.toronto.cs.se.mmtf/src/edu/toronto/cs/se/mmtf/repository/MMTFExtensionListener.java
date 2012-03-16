package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;

import edu.toronto.cs.se.mmtf.MMTF;

public abstract class MMTFExtensionListener implements IRegistryEventListener {

	protected MMTF mmtf;

	public MMTFExtensionListener(MMTF mmtf) {

		this.mmtf = mmtf;
	}

	@Override
	public abstract void added(IExtension[] extensions);

	@Override
	public abstract void removed(IExtension[] extensions);

	@Override
	public void added(IExtensionPoint[] extensionPoints) {
		// do nothing
	}

	@Override
	public void removed(IExtensionPoint[] extensionPoints) {
		// do nothing
	}

}
