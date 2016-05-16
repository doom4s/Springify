package net.netconomy.training.spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.inject.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.netconomy.training.spring.basic.AbstractSensor;
import net.netconomy.training.spring.basic.Device;

@Component
@Singleton
public class DeviceDao {

	private ArrayList<Device> devices = new ArrayList<>();
	@SuppressWarnings("unused")
	private Device device;

	public DeviceDao() {
	}

	public DeviceDao(Device device) {
		this.devices.add(device);
	}

	public DeviceDao(ArrayList<Device> devices) {
		this.devices = devices;
	}

	public ArrayList<Device> getDevices() {
		return devices;
	}

	public void setDevices(ArrayList<Device> devices) {
		this.devices = devices;
	}

	public Device getDevice(String serial) {
		for (Device d : devices) {
			if (d.getSerialNo().equals(serial)) {
				return d;
			}
		}
		return null;

	}

	@Autowired
	public void setDevice(Device device) {
		this.device = device;
		this.addDevice(device);
		System.out.println("Device added to list !");
	}

	public void addDevice(Device device) {
		this.devices.add(device);
	}

	public ArrayList<String> getDevicesBySerialNo() {
		ArrayList<String> deviceSerialNos = new ArrayList<>();
		for (Device device : this.getDevices()) {
			deviceSerialNos.add(device.getSerialNo());
		}
		return deviceSerialNos;
	}
	
	public ArrayList<String> getSensors(String serialNo){
		ArrayList<String> sensorList = new ArrayList<>();
		Collection<AbstractSensor> sensors = this.getDevice(serialNo).getSensors();
		Iterator<AbstractSensor> iterator = sensors.iterator();
		while (iterator.hasNext()){
			sensorList.add(iterator.next().getStringType());
		}
		return sensorList ;
	}

}
