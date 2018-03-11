/**
 * 
 */
package com.vraj.playground.architecture.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

/**
 * Implementation of basic LRU Cache. For simplicity lets assume its a Integer
 * to String map.
 * 
 * @author vrajori
 *
 */
public class SimpleLRUCache {

	private MyLRUCache lruCache;

	SimpleLRUCache(int size) {
		lruCache = new MyLRUCache(size);
	}

	public String get(int key) {
		return lruCache.get(key);
	}

	public void put(int key, String val) {
		lruCache.put(key, val);
	}

	private class MyLRUCache {
		private LinkedList<Integer> cacheList;
		private Map<Integer, String> cacheMap;
		private int cacheSize;

		public MyLRUCache(int size) {
			this.cacheList = new LinkedList<>();
			this.cacheMap = new HashMap<>();
			this.cacheSize = size;
		}

		void put(int key, String val) {
			if (cacheList.contains(Integer.valueOf(key))) {
				// no need to alter list size here.
				remove(key);
			} else {
				// this may cause size change for queue
				if (cacheList.size() >= cacheSize) {
					int keyToRem = cacheList.removeLast();
					cacheMap.remove(key);
				}
			}
			cacheList.addFirst(key);
			cacheMap.put(key, val);

		}

		String get(int key) {
			remove(key);
			cacheList.addFirst(key);
			return cacheMap.get(Integer.valueOf(key));
		}

		void remove(int key) {
			System.out.println("Delete log start: ");
			System.out.println("Removing key: " + key);
			System.out.println("Queue status: " + cacheList.toString());
			System.out.println("Delete log end \n\n");
			cacheList.removeFirstOccurrence(Integer.valueOf(key));
		}
	}

	public static void main(String[] args) {
		SimpleLRUCache cache = new SimpleLRUCache(20);
		String[] units = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		Random random = new Random();
		for (int i = 0; i < 19; i++) {
			int key = random.nextInt(20);
			cache.put(i, units[i]);
		}

	}

}
