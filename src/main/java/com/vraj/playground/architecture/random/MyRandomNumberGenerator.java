/**
 * 
 */
package com.vraj.playground.architecture.random;

import java.math.BigInteger;

/**
 * Simple random number generator that generates random number between a given
 * interval with all number having equal probability.
 * 
 * @author vrajori
 *
 */
public class MyRandomNumberGenerator {

	private static int multiplier = 1;
	private static int modulus = 1;
	private static int increment = 1;
	private static int seed = 1;

	public static int nextInt(int range) {
		updateMetaAttrs(range);
		seed = ((multiplier * seed) + increment) % modulus;
		return seed;
	}

	private static void updateMetaAttrs(int range) {
		modulus = nextPrime(range);
		multiplier = modulus - range;
		increment = range;
		seed = range - 5;

	}

	private static int nextPrime(int range) {

		for (int i = range + 1;; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
	}

	static boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int seed = 10;
		for (int i = 0; i < 10; i++) {
			System.out.println(MyRandomNumberGenerator.nextInt(seed));
		}
	}

}
