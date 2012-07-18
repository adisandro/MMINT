/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.powerwindow.impl;

import edu.toronto.cs.se.modelepedia.powerwindow.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PowerwindowFactoryImpl extends EFactoryImpl implements PowerwindowFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PowerwindowFactory init() {
		try {
			PowerwindowFactory thePowerwindowFactory = (PowerwindowFactory)EPackage.Registry.INSTANCE.getEFactory("http://se.cs.toronto.edu/modelepedia/powerwindow"); 
			if (thePowerwindowFactory != null) {
				return thePowerwindowFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PowerwindowFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerwindowFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PowerwindowPackage.WINDOW: return createWindow();
			case PowerwindowPackage.INFRARED: return createInfrared();
			case PowerwindowPackage.FORCE_DETECTING: return createForceDetecting();
			case PowerwindowPackage.LOCK_OUT: return createLockOut();
			case PowerwindowPackage.ROCKER: return createRocker();
			case PowerwindowPackage.PUSH_PULL: return createPushPull();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Window createWindow() {
		WindowImpl window = new WindowImpl();
		return window;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Infrared createInfrared() {
		InfraredImpl infrared = new InfraredImpl();
		return infrared;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForceDetecting createForceDetecting() {
		ForceDetectingImpl forceDetecting = new ForceDetectingImpl();
		return forceDetecting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LockOut createLockOut() {
		LockOutImpl lockOut = new LockOutImpl();
		return lockOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rocker createRocker() {
		RockerImpl rocker = new RockerImpl();
		return rocker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PushPull createPushPull() {
		PushPullImpl pushPull = new PushPullImpl();
		return pushPull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerwindowPackage getPowerwindowPackage() {
		return (PowerwindowPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PowerwindowPackage getPackage() {
		return PowerwindowPackage.eINSTANCE;
	}

} //PowerwindowFactoryImpl
