package net.netconomy.training.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author vmaric
 *
 */
@EnableScheduling
public class Demo {

	public static void main(String[] args) {

		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
	}

}
