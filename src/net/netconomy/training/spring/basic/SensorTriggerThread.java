package net.netconomy.training.spring.basic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author hgrahsl
 *
 */
@Component
public class SensorTriggerThread implements Runnable {

	private final List<Device> devices;
	public static final long _TIME =3000;
	
	@Autowired
	public SensorTriggerThread(List<Device> devices) {
		this.devices = devices;
	}
	
	@Scheduled(fixedDelay=_TIME)
	@Override
	public void run() {
		for(Device d : devices) {
			d.triggerSensors();
			System.out.println(d);
		}
	}

}
