package net.netconomy.training.spring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.netconomy.training.spring.basic.AbstractSensor;
import net.netconomy.training.spring.basic.Device;
import net.netconomy.training.spring.basic.Measurement;
import net.netconomy.training.spring.dao.DeviceDao;

@Controller
@RequestMapping("/")
public class MainController {

	private DeviceDao deviceDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("devices", deviceDao.getDevices());
		return "index";
	}

	@RequestMapping(value = "/devices", method = RequestMethod.GET)
	public String getDevices(Model model) {
		model.addAttribute("devices", deviceDao.getDevices());
		return "devices";
	}

	@RequestMapping(value = "/JSON/devices", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody ArrayList<String> getJsonDevices() {
		return deviceDao.getDevicesBySerialNo();
	}

	@RequestMapping(value = "/devices/{serialNo}", method = RequestMethod.GET)
	public String getSensors(@PathVariable String serialNo, Model model) {
		ArrayList<String> sensors = deviceDao.getSensors(serialNo);
		model.addAttribute("sensors", sensors);
		return "sensors";
	}

	@RequestMapping(value = "/sensors", method = RequestMethod.GET)
	public String getSensors(Model model) {
		ArrayList<Device> devices = deviceDao.getDevices();
		ArrayList<String> sensors = new ArrayList<>();
		for (Device device : devices) {
			Iterator<AbstractSensor> i = device.getSensors().iterator();
			while (i.hasNext()) {
				sensors.add(i.next().getStringType());
			}
		}
		model.addAttribute("sensors", sensors);
		return "sensors";
	}

	@RequestMapping(value = "/{serialNo}", method = RequestMethod.GET)
	public String getSensorsR(@PathVariable String serialNo, Model model) {
		ArrayList<String> sensors = deviceDao.getSensors(serialNo);
		model.addAttribute("sensors", sensors);
		return "sensors";
	}

	@RequestMapping(value = "/JSON/devices/{serialNo}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody ArrayList<String> getJsonSensors(@PathVariable String serialNo) {
		ArrayList<String> sensors = deviceDao.getSensors(serialNo);
		if (!sensors.isEmpty()) {
			return sensors;
		} else {
			System.out.println("Prazan !");
			return null;
		}
	}

	@RequestMapping(value = "/{serialNo}/{sensorType}", method = RequestMethod.GET)
	public String getSensorMeasurments(@PathVariable String serialNo,
			@PathVariable String sensorType ,Model model) {
		Queue<Measurement> measurements = deviceDao.getDevice(serialNo).getSensor(sensorType).getMeasurements();
		model.addAttribute("measurements", measurements);
		return "measurements";
	}
	
	
	@RequestMapping(value = "/devices/{serialNo}/{sensorType}", method = RequestMethod.GET)
	public String getMeasurments(@PathVariable String serialNo,
			@PathVariable String sensorType ,Model model) {
		Queue<Measurement> measurements = deviceDao.getDevice(serialNo).getSensor(sensorType).getMeasurements();
		model.addAttribute("measurements", measurements);
		return "measurements";
	}
	
	@RequestMapping(value = "/measurements", method = RequestMethod.GET)
	public String getAllMeasurments(Model model) {
		ArrayList<String> measurements = new ArrayList<>();
		ArrayList<Device> devices = deviceDao.getDevices();
		for (Device device : devices) {
			Iterator<AbstractSensor> i = device.getActiveSensors().iterator();
			while (i.hasNext()) {
				measurements.add(i.next().getMeasurements().toString());
			}
		}
		model.addAttribute("measurements", measurements);
		return "measurements";
	}

	@RequestMapping(value = "/JSON/devices/{serialNo}/{sensorType}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Collection<Measurement> getJsonMeasurments(@PathVariable String serialNo,
			@PathVariable String sensorType) {
		Collection<Measurement> measurements = deviceDao.getDevice(serialNo).getSensor(sensorType).getMeasurements();
		return measurements;
	}
	
	@RequestMapping(value = "/JSON/measurements", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody ArrayList<String> getJsonAllMeasurments() {
		ArrayList<String> measurements = new ArrayList<>();
		ArrayList<Device> devices = deviceDao.getDevices();
		for (Device device : devices) {
			Iterator<AbstractSensor> i = device.getActiveSensors().iterator();
			while (i.hasNext()) {
				measurements.add(i.next().getMeasurements().toString());
			}
		}
		return measurements;
	}

	public DeviceDao getDeviceDao() {
		return deviceDao;
	}

	@Autowired
	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}

}
