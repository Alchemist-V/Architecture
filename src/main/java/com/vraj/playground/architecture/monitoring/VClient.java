/**
 * 
 */
package com.vraj.playground.architecture.monitoring;

/**
 * Simple client to facilitate metric collection of applications using this
 * client.
 * 
 * @author vrajori
 *
 */
public class VClient {

	private static VClient instance;
	private Dimension dimension1;
	private Dimension dimenstion2;
	private Dimension dimenstion3;

	public static VClient getInstance() {

		if (instance == null) {
			synchronized (VClient.class) {
				if (instance == null) {
					init();
				}
			}
		}
		return instance;
	}

	private static void init() {
		instance = new VClient();
	}

	public void registerDimensions(Dimension dimension) {

	}

}
