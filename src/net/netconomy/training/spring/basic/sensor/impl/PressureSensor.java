package net.netconomy.training.spring.basic.sensor.impl;

import java.util.Observable;
import java.util.Random;
import javax.annotation.PostConstruct;
import net.netconomy.training.spring.basic.AbstractSensor;
import net.netconomy.training.spring.basic.Sensor;
import net.netconomy.training.spring.basic.measurement.impl.BasicMeasurement;

public class PressureSensor extends AbstractSensor {

	private final static Random RANDOM = new Random();
	private final int clockTickResolution;
	private int numClockTicks;

	public PressureSensor(int clockTickResolution, boolean isActive) {
		super(Sensor.TYPE_PRESSURE, Sensor.STRING_TYPE_PRESSURE, isActive);
		this.clockTickResolution = clockTickResolution;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (isActive && (numClockTicks % clockTickResolution == 0)) {
			this.generateMeasurement();
		}
		numClockTicks++;

	}

	@PostConstruct
	@Override
	public void generateMeasurement() {
		// TODO This generates a random pressure force between 0 and 100 bar
		float[] pressureValues = { 0, RANDOM.nextFloat() * (0f - 100f) + 5f, 0 };
		measurements.add(new BasicMeasurement(pressureValues));

	}

}
