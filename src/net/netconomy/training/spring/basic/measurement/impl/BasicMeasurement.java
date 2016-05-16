package net.netconomy.training.spring.basic.measurement.impl;

import java.util.Arrays;

import net.netconomy.training.spring.basic.Measurement;

/**
 * @author hgrahsl
 *
 */
public class BasicMeasurement implements Measurement {

	private final long timestamp;
	private final float[] values;	
	
	public BasicMeasurement(float[] values) {
		this.timestamp = System.currentTimeMillis();
		//NOTE: this implementation simply copies the values while
		//other types may do something different...
		this.values = Arrays.copyOf(values, values.length);
	}
	
	@Override
	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public float[] getValues() {
		return values;
	}
	
	@Override
	public String toString() {
		return "BasicMeasurement [timestamp="
				+ timestamp
				+ ", values="
				+ (values != null ? Arrays.toString(Arrays.copyOf(values,
						values.length)) : null) + "]";
	}
	
}
