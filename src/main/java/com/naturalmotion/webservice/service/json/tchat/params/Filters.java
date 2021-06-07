package com.naturalmotion.webservice.service.json.tchat.params;

import java.util.List;

public class Filters {

	private List<String> attrs;

	private Range range;

	public List<String> getAttrs() {
		return attrs;
	}

	public void setAttrs(List<String> attrs) {
		this.attrs = attrs;
	}

	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}

}
