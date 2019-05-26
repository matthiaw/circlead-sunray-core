package org.rogatio.circlead.sunray.core.command;

import java.util.Random;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.rogatio.circlead.sunray.core.api.Workitem;
import org.rogatio.circlead.sunray.core.api.WorkitemService;

@Service
@Command(scope = "item", name = "add", description = "Add a item")
public class AddCommand implements Action {

	/**
	 * Use with karaf@root()> item:add -d "Description of item" Itemtitle ITT
	 */
	
	@Reference
	private WorkitemService workitemService;

	@Option(name = "-i", aliases = "--id", description = "Workitem ID", required = false, multiValued = false)
	Long id = 0L;

	@Argument(index = 0, name = "title", description = "Workitem title", required = true, multiValued = false)
	String title;

	@Argument(index = 1, name = "abbreviation", description = "Workitem abbreviation", required = true, multiValued = false)
	String abbreviation;
	
	@Option(name = "-d", aliases = {"--description" }, description = "Workitem description", required = false, multiValued = true)
	String description;
	
	@Override
	public Object execute() throws Exception {
		Workitem workitem = new Workitem();
		if (this.id == 0) {
			Random random = new Random();
			this.id = new Long(random.nextInt(9000000) + 1000000);
		}
		workitem.setId(this.id);
		workitem.setTitle(this.title);
		workitem.setDescription(this.description);
		this.workitemService.add(workitem);
		return null;
	}

}
