package com.naturalmotion.webservice.service.json.tchat.params;

import java.util.List;

public class ChatBodyParams {

	private List<String> ids;

	private Filters filters;

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public Filters getFilters() {
		return filters;
	}

	public void setFilters(Filters filters) {
		this.filters = filters;
	}

}
