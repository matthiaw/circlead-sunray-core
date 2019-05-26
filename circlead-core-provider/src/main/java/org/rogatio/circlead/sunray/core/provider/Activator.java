package org.rogatio.circlead.sunray.core.provider;

import org.apache.karaf.util.tracker.BaseActivator;
import org.apache.karaf.util.tracker.annotation.ProvideService;
import org.apache.karaf.util.tracker.annotation.Services;
import org.rogatio.circlead.sunray.core.api.WorkitemService;

@Services(provides = { @ProvideService(WorkitemService.class) })
public class Activator extends BaseActivator {

	@Override
	public void doStart() {
		WorkitemServiceMemoryImpl workitemService = new WorkitemServiceMemoryImpl();
		this.register(WorkitemService.class, workitemService);
	}

}
