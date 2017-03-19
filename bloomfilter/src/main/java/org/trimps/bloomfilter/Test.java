package org.trimps.bloomfilter;

import org.trimps.bloomfilter.task.SimpleBloomTask;
import org.trimps.bloomfilter.task.SimpleHashTask;

public class Test {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				SimpleHashTask task = new SimpleHashTask();
				task.begin();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				SimpleBloomTask task = new SimpleBloomTask();
				task.begin();
			}
		});
		thread1.start();
		thread2.start();
	}

}
