package com.naturalmotion.webservice.api;

import java.util.Comparator;

import com.naturalmotion.webservice.service.json.ScoreMember;

public class MemberComparator implements Comparator<ScoreMember> {

	@Override
	public int compare(ScoreMember arg0, ScoreMember arg1) {
		int result = 0;
		if (arg1.getCc_contrib() == arg0.getCc_contrib()) {
			if ("LEADER".equals(arg1.getRole())) {
				result = 1;
			} else if ("LEADER".equals(arg0.getRole())) {
				result = -1;
			} else if (arg0.getRole().equals(arg1.getRole())) {
				result = Integer.compare(arg1.getLevel(), arg0.getLevel());
			} else if ("ADMIN".equals(arg1.getRole())) {
				result = 1;
			} else {
				result = -1;
			}
		} else {
			result = Integer.compare(arg1.getCc_contrib(), arg0.getCc_contrib());
		}
		return result;
	}

}
