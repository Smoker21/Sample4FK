package com.rainsoft.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Copy Iterable content to list
 * @author Lance
 *
 */
public class CollectionUtils {
	/**
	 * Copy Iterable content to a list. 
	 * @param iter : Iterable 
	 * @return
	 */
	public static <E> Collection<E> makeCollection(Iterable<E> iter) {
		Collection<E> list = new LinkedList<E>();
		for (E item:iter) {
			list.add(item);
		}
		return list; 
	}
	
	public static <E> List<E> makeList(Iterable<E> iter) {
		List<E> list = new LinkedList<E>();
		for (E item:iter) {
			list.add(item);
		}
		return list; 
	}
	
	
	
}
