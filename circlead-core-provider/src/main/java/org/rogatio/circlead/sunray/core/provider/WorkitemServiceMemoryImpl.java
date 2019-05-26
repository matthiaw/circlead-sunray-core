package org.rogatio.circlead.sunray.core.provider;

import java.util.*;

import org.rogatio.circlead.sunray.core.api.Workitem;
import org.rogatio.circlead.sunray.core.api.WorkitemService;

/**
 * Simple implementation of the {@link WorkitemService} storing the {@link org.rogatio.circlead.sunray.core.api.Workitem}
 * instances in a list in memory.
 */
public class WorkitemServiceMemoryImpl implements WorkitemService {

    private final Map<Long, Workitem> workitems = new HashMap<>();

    @Override
    public Collection<Workitem> list() {
        return workitems.values();
    }

    @Override
    public Workitem get(Long id) {
        return workitems.get(id);
    }

    @Override
    public void add(Workitem booking) {
    	workitems.put(booking.getId(), booking);
    }

    @Override
    public void remove(Long id) {
    	workitems.remove(id);
    }
}
