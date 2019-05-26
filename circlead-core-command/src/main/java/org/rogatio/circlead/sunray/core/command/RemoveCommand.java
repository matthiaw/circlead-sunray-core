package org.rogatio.circlead.sunray.core.command;

import java.util.List;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Completion;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.rogatio.circlead.sunray.core.api.WorkitemService;
import org.rogatio.circlead.sunray.core.completers.WorkitemIdCompleter;

@Service
@Command(scope = "item", name = "remove", description = "Remove an existing item")
public class RemoveCommand implements Action {

	@Reference
	private WorkitemService workitemService;

	@Argument(index = 0, name = "ids", description = "List of items to remove", required = true, multiValued = true)
	@Completion(WorkitemIdCompleter.class)
	List<Long> ids;

	@Override
	public Object execute() throws Exception {
		for (Long id : this.ids) {
			this.workitemService.remove(id);
		}
		return null;
	}

}
