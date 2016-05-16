package net.netconomy.training.spring.basic.device.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

import org.springframework.stereotype.Component;

import net.netconomy.training.spring.basic.AbstractSensor;
import net.netconomy.training.spring.basic.Device;

/**
 * @author hgrahsl
 *
 */

@Component
public class DummyDevice extends Observable implements Device {

	private final String serialNo;

	private Set<AbstractSensor> sensors = new HashSet<>();

	public DummyDevice(String serialNo) {
		this.serialNo = serialNo;
	}

	public DummyDevice(String serialNo, Set<AbstractSensor> sensors) {
		this.serialNo = serialNo;
		this.sensors = sensors;
	}

	public boolean registerSensor(AbstractSensor sensor) {
		this.addObserver(sensor);
		return sensors.add(sensor);
	}

	public boolean unregisterSensor(AbstractSensor sensor) {
		this.deleteObserver(sensor);
		return sensors.remove(sensor);
	}

	public void triggerSensors() {
		this.setChanged();
		this.notifyObservers();
	
	}

	@Override
	public Collection<AbstractSensor> getSensors() {
		for (AbstractSensor s : sensors) {
			this.registerSensor(s);
		}
		return sensors;
	}

	@Override
	public Collection<AbstractSensor> getActiveSensors() {
		Set<AbstractSensor> filtered = new HashSet<>();
		for (AbstractSensor s : sensors) {
			if (s.isActive())
				filtered.add(s);
		}
		return filtered;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "DummyDevice [serialNo=" + serialNo + ", sensors=" + (sensors != null ? toString(sensors, maxLen) : null)
				+ "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

	@Override
	public synchronized void deleteObservers() {
		for (AbstractSensor s : sensors) {
			this.unregisterSensor(s);
		}
		super.deleteObservers();
	}

	public String getSerialNo() {
		return serialNo;
	}
	
	public AbstractSensor getSensor(String sensorType){
		Iterator<AbstractSensor> i = sensors.iterator();
		while(i.hasNext()){
			if(i.next().getStringType().equals(sensorType)){
				return i.next();
			}
		}
		return null;
	}
	

}
