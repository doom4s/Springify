package net.netconomy.training.spring.basic.sensor.impl;

import java.util.Observable;
import java.util.Random;
import javax.annotation.PostConstruct;
import net.netconomy.training.spring.basic.AbstractSensor;
import net.netconomy.training.spring.basic.Sensor;
import net.netconomy.training.spring.basic.measurement.impl.BasicMeasurement;

/**
 * @author hgrahsl
 *
 */
public class GravitySensor extends AbstractSensor {

	private final static Random RANDOM = new Random();
	private final int clockTickResolution;
	private int numClockTicks;

	public GravitySensor(int clockTickResolution, boolean isActive) {
		super(Sensor.TYPE_GRAVITY, Sensor.STRING_TYPE_GRAVITY, isActive);
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
		// NOTE: this generates a random gravity on y-axis between 9.75-9.95
		// m/s^2
		float[] gravityValues = { 0, RANDOM.nextFloat() * (9.95f - 9.75f) + 9.75f, 0 };
		measurements.add(new BasicMeasurement(gravityValues));
	}

}
