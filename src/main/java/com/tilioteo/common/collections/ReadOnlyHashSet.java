/**
 * 
 */
package com.tilioteo.common.collections;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author kamil
 *
 */
@SuppressWarnings("serial")
public class ReadOnlyHashSet<E> extends HashSet<E> {
	
	@SafeVarargs
	public ReadOnlyHashSet(E ... elements) {
		if (elements != null) {
			for (E element : elements) {
				super.add(element);
			}
		}
	}

	@Override
	public boolean add(E e) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}
	
}
