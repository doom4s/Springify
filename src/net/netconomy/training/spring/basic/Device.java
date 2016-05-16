/*
 * The Initial Developer of the content of this file is NETCONOMY.
 * All portions of the code written by NETCONOMY are property of
 * NETCONOMY. All Rights Reserved.
 *
 * NETCONOMY Software & Consulting GmbH
 * Hilmgasse 4, A-8010 Graz (Austria)
 * FN 204360 f, Landesgericht fuer ZRS Graz
 * Tel: +43 (316) 815 544
 * Fax: +43 (316) 815544-99
 * www.netconomy.net
 *
 * (c) 2015 by NETCONOMY Software & Consulting GmbH
 */

package net.netconomy.training.spring.basic;

import java.util.Collection;

/**
 * @author cprobst
 *
 */
public interface Device {

	/**
	 *
	 * @return all sensors which are available for this device
	 */
	String getSerialNo();

	Collection<AbstractSensor> getSensors();
	AbstractSensor getSensor(String sensorType);
	/**
	 *
	 * @return all active sensors for the current device
	 */
	Collection<AbstractSensor> getActiveSensors();

	/**
	 *
	 * @param sensor
	 *            the AbstractSensor to register
	 * @return true if successfully registered, false otherwise
	 */
	boolean registerSensor(AbstractSensor sensor);

	/**
	 *
	 * @param sensor
	 *            the AbstractSensor to unregister
	 * @return true if successfully unregistered, false otherwise
	 */
	boolean unregisterSensor(AbstractSensor sensor);

	/**
	 * triggers the device's sensors to generate measurements for current data.
	 */
	void triggerSensors();
}
