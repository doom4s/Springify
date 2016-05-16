package net.netconomy.training.spring.basic.sensor.impl;

import java.util.Observable;
import java.util.Random;
import javax.annotation.PostConstruct;
import net.netconomy.training.spring.basic.AbstractSensor;
import net.netconomy.training.spring.basic.Sensor;
import net.netconomy.training.spring.basic.measurement.impl.BasicMeasurement;

public class ProximitySensor extends AbstractSensor {

	private final static Random RANDOM = new Random();
	private final int clockTickResolution;
	private int numClockTicks;

	public ProximitySensor(int clockTickResolution, boolean isActive) {
		super(Sensor.TYPE_PROXIMITY, Sensor.STRING_TYPE_PROXIMITY, isActive);
		this.clockTickResolution = clockTickResolution;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (isActive && (numClockTicks % clockTickResolution == 0)) {
			this.generateMeasurement();
		}
		numClockTicks++;
	}

	@PostConstruct
	@Override
	public void generateMeasurement() {
		// TODO This generates a random distance between 0 and 100 km
		float[] proximityValues = { 0, RANDOM.nextFloat() * (0f - 100f) + 10f, 0 };
		measurements.add(new BasicMeasurement(proximityValues));

	}

}
