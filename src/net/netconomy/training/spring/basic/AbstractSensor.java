package net.netconomy.training.spring.basic;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author hgrahsl
 *
 */
public abstract class AbstractSensor implements Sensor, Observer {

	protected final int type;
	protected final String stringType;
	protected boolean isActive;
	
	protected final Queue<Measurement> measurements = new LinkedList<>();
	
	public AbstractSensor(int type, String stringType, boolean isActive) {
		super();
		this.type = type;
		this.stringType = stringType;
		this.isActive = isActive;
	}

	@Override
	public boolean isActive() { 
		return isActive;
	}
	
	@Override
	public void setActive(boolean active) { 
		isActive = active;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public String getStringType() {
		return stringType;
	}

	@Override
	public String toString() {
		final int maxLen = 100;
		return "AbstractSensor [type="
				+ type
				+ ", stringType="
				+ stringType
				+ ", isActive="
				+ isActive
				+ ", measurements="
				+ (measurements != null ? toString(measurements, maxLen) : null)
				+ "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((stringType == null) ? 0 : stringType.hashCode());
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractSensor))
			return false;
		AbstractSensor other = (AbstractSensor) obj;
		if (stringType == null) {
			if (other.stringType != null)
				return false;
		} else if (!stringType.equals(other.stringType))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public boolean add(Measurement e) {
		return measurements.add(e);
	}

	@Override
	public boolean offer(Measurement e) {
		return measurements.offer(e);
	}

	@Override
	public Measurement remove() {
		return measurements.remove();
	}

	@Override
	public Measurement poll() {
		return measurements.poll();
	}

	@Override
	public Measurement element() {
		return measurements.element();
	}

	@Override
	public Measurement peek() {
		return measurements.peek();
	}

	@Override
	public int size() {
		return measurements.size();
	}

	@Override
	public boolean isEmpty() {
		return measurements.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return measurements.contains(o);
	}

	@Override
	public Iterator<Measurement> iterator() {
		return measurements.iterator();
	}

	@Override
	public Object[] toArray() {
		return measurements.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return measurements.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		return measurements.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return measurements.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Measurement> c) {
		return measurements.addAll(c);
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		return measurements.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return measurements.retainAll(c);
	}

	@Override
	public void clear() {
		measurements.clear();	
	}

	@Override
	public abstract void update(Observable o, Object arg);
	
	@Override
	public abstract void generateMeasurement();

	public Queue<Measurement> getMeasurements() {
		return measurements;
	}
	
}
