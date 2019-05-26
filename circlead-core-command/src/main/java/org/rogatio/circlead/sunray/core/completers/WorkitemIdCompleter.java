package org.rogatio.circlead.sunray.core.completers;

import java.util.List;

import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.api.console.CommandLine;
import org.apache.karaf.shell.api.console.Completer;
import org.apache.karaf.shell.api.console.Session;
import org.apache.karaf.shell.support.completers.StringsCompleter;
import org.rogatio.circlead.sunray.core.api.Workitem;
import org.rogatio.circlead.sunray.core.api.WorkitemService;

@Service
public class WorkitemIdCompleter implements Completer {

	@Reference
	private WorkitemService workitemService;

	@Override
	public int complete(Session session, CommandLine commandLine, List<String> candidates) {
		StringsCompleter delegate = new StringsCompleter();
		for (Workitem booking : this.workitemService.list()) {
			delegate.getStrings().add(String.valueOf(booking.getId()));
		}
		return delegate.complete(session, commandLine, candidates);
	}

}
