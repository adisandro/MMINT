/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.powerwindow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.powerwindow.PowerWindowFactory
 * @model kind="package"
 * @generated
 */
public interface PowerWindowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "powerwindow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/PowerWindow";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "powerwindow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PowerWindowPackage eINSTANCE = edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.NamedElementImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.WindowImpl <em>Window</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.WindowImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getWindow()
	 * @generated
	 */
	int WINDOW = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Sensor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__SENSOR = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Switches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__SWITCHES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.SensorImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getSensor()
	 * @generated
	 */
	int SENSOR = 1;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__DELAY = 0;

	/**
	 * The number of structural features of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.InfraredImpl <em>Infrared</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.InfraredImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getInfrared()
	 * @generated
	 */
	int INFRARED = 2;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRARED__DELAY = SENSOR__DELAY;

	/**
	 * The number of structural features of the '<em>Infrared</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRARED_FEATURE_COUNT = SENSOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Infrared</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRARED_OPERATION_COUNT = SENSOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.ForceDetectingImpl <em>Force Detecting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.ForceDetectingImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getForceDetecting()
	 * @generated
	 */
	int FORCE_DETECTING = 3;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_DETECTING__DELAY = SENSOR__DELAY;

	/**
	 * The number of structural features of the '<em>Force Detecting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_DETECTING_FEATURE_COUNT = SENSOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Force Detecting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_DETECTING_OPERATION_COUNT = SENSOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.SwitchImpl <em>Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.SwitchImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getSwitch()
	 * @generated
	 */
	int SWITCH = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Overridable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__OVERRIDABLE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.LockOutImpl <em>Lock Out</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.LockOutImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getLockOut()
	 * @generated
	 */
	int LOCK_OUT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_OUT__NAME = SWITCH__NAME;

	/**
	 * The feature id for the '<em><b>Overridable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_OUT__OVERRIDABLE = SWITCH__OVERRIDABLE;

	/**
	 * The number of structural features of the '<em>Lock Out</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_OUT_FEATURE_COUNT = SWITCH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Lock Out</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_OUT_OPERATION_COUNT = SWITCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.MovementImpl <em>Movement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.MovementImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getMovement()
	 * @generated
	 */
	int MOVEMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVEMENT__NAME = SWITCH__NAME;

	/**
	 * The feature id for the '<em><b>Overridable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVEMENT__OVERRIDABLE = SWITCH__OVERRIDABLE;

	/**
	 * The number of structural features of the '<em>Movement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVEMENT_FEATURE_COUNT = SWITCH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Movement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVEMENT_OPERATION_COUNT = SWITCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.RockerImpl <em>Rocker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.RockerImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getRocker()
	 * @generated
	 */
	int ROCKER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROCKER__NAME = MOVEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Overridable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROCKER__OVERRIDABLE = MOVEMENT__OVERRIDABLE;

	/**
	 * The number of structural features of the '<em>Rocker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROCKER_FEATURE_COUNT = MOVEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rocker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROCKER_OPERATION_COUNT = MOVEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.PushPullImpl <em>Push Pull</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PushPullImpl
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getPushPull()
	 * @generated
	 */
	int PUSH_PULL = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_PULL__NAME = MOVEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Overridable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_PULL__OVERRIDABLE = MOVEMENT__OVERRIDABLE;

	/**
	 * The number of structural features of the '<em>Push Pull</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_PULL_FEATURE_COUNT = MOVEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Push Pull</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_PULL_OPERATION_COUNT = MOVEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.Window <em>Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Window</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Window
	 * @generated
	 */
	EClass getWindow();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.powerwindow.Window#getSensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sensor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Window#getSensor()
	 * @see #getWindow()
	 * @generated
	 */
	EReference getWindow_Sensor();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.powerwindow.Window#getSwitches <em>Switches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Switches</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Window#getSwitches()
	 * @see #getWindow()
	 * @generated
	 */
	EReference getWindow_Switches();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Sensor
	 * @generated
	 */
	EClass getSensor();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.powerwindow.Sensor#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Sensor#getDelay()
	 * @see #getSensor()
	 * @generated
	 */
	EAttribute getSensor_Delay();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.Infrared <em>Infrared</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrared</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Infrared
	 * @generated
	 */
	EClass getInfrared();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.ForceDetecting <em>Force Detecting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Force Detecting</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.ForceDetecting
	 * @generated
	 */
	EClass getForceDetecting();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Switch
	 * @generated
	 */
	EClass getSwitch();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.powerwindow.Switch#isOverridable <em>Overridable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overridable</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Switch#isOverridable()
	 * @see #getSwitch()
	 * @generated
	 */
	EAttribute getSwitch_Overridable();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.LockOut <em>Lock Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lock Out</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.LockOut
	 * @generated
	 */
	EClass getLockOut();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.Movement <em>Movement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movement</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Movement
	 * @generated
	 */
	EClass getMovement();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.Rocker <em>Rocker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rocker</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.Rocker
	 * @generated
	 */
	EClass getRocker();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.PushPull <em>Push Pull</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Pull</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.PushPull
	 * @generated
	 */
	EClass getPushPull();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.powerwindow.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.powerwindow.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PowerWindowFactory getPowerWindowFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.WindowImpl <em>Window</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.WindowImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getWindow()
		 * @generated
		 */
		EClass WINDOW = eINSTANCE.getWindow();

		/**
		 * The meta object literal for the '<em><b>Sensor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WINDOW__SENSOR = eINSTANCE.getWindow_Sensor();

		/**
		 * The meta object literal for the '<em><b>Switches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WINDOW__SWITCHES = eINSTANCE.getWindow_Switches();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.SensorImpl <em>Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.SensorImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR__DELAY = eINSTANCE.getSensor_Delay();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.InfraredImpl <em>Infrared</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.InfraredImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getInfrared()
		 * @generated
		 */
		EClass INFRARED = eINSTANCE.getInfrared();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.ForceDetectingImpl <em>Force Detecting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.ForceDetectingImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getForceDetecting()
		 * @generated
		 */
		EClass FORCE_DETECTING = eINSTANCE.getForceDetecting();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.SwitchImpl <em>Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.SwitchImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getSwitch()
		 * @generated
		 */
		EClass SWITCH = eINSTANCE.getSwitch();

		/**
		 * The meta object literal for the '<em><b>Overridable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH__OVERRIDABLE = eINSTANCE.getSwitch_Overridable();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.LockOutImpl <em>Lock Out</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.LockOutImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getLockOut()
		 * @generated
		 */
		EClass LOCK_OUT = eINSTANCE.getLockOut();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.MovementImpl <em>Movement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.MovementImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getMovement()
		 * @generated
		 */
		EClass MOVEMENT = eINSTANCE.getMovement();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.RockerImpl <em>Rocker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.RockerImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getRocker()
		 * @generated
		 */
		EClass ROCKER = eINSTANCE.getRocker();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.PushPullImpl <em>Push Pull</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PushPullImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getPushPull()
		 * @generated
		 */
		EClass PUSH_PULL = eINSTANCE.getPushPull();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.powerwindow.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.NamedElementImpl
		 * @see edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

	}

} //PowerWindowPackage
