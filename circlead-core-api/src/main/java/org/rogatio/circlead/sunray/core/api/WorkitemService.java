package org.rogatio.circlead.sunray.core.api;

import java.util.Collection;

public interface WorkitemService {

	Collection<Workitem> list();

	Workitem get(Long id);

	void add(Workitem booking);

	void remove(Long id);
	
}
