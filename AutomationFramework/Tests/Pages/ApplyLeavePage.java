package Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Objects.ObjConnect;
import Reusables.Keywords;

public class ApplyLeavePage extends Keywords {

	ObjConnect ob = new ObjConnect();

	public void ApplyLeave(HashMap<String, String> data) throws Exception {
		List<String> result = new ArrayList<String>();

		result.add(click(ob.applyleaveobj.applyleave, "Apply Leave"));
		result.add(actionSelect(ob.applyleaveobj.SelectLeavetype, data.get("leaveType"), "Leave type"));
		result.add(enterText(ob.applyleaveobj.Fromdate, data.get("FromDate"), "From Date"));
		result.add(enterText(ob.applyleaveobj.Comment, data.get("Comments"), "Comments"));
		result.add(click(ob.applyleaveobj.Apply, "Apply button"));
		result.add(click(ob.applyleaveobj.Close, "Close Button"));
		result.add(click(ob.applyleaveobj.Home, "Home Button"));

		addReport(result, "Apply Leave");
	}

}
