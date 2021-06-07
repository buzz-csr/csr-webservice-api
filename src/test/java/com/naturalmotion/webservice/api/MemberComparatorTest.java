package com.naturalmotion.webservice.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.naturalmotion.webservice.service.json.ScoreMember;

public class MemberComparatorTest {

	private MemberComparator comparator = new MemberComparator();

	@Test
	public void testCompare() throws Exception {
		Assertions.assertThat(comparator.compare(create(90, 999, "MEMBER"), create(95, 1050, "MEMBER"))).isEqualTo(1);
		Assertions.assertThat(comparator.compare(create(95, 999, "MEMBER"), create(95, 1050, "MEMBER"))).isEqualTo(1);
		Assertions.assertThat(comparator.compare(create(95, 1100, "MEMBER"), create(95, 1050, "ADMIN"))).isEqualTo(1);
		Assertions.assertThat(comparator.compare(create(95, 1100, "ADMIN"), create(95, 1050, "LEADER"))).isEqualTo(1);

		Assertions.assertThat(comparator.compare(create(100, 999, "MEMBER"), create(95, 1050, "MEMBER"))).isEqualTo(-1);
		Assertions.assertThat(comparator.compare(create(95, 999, "ADMIN"), create(95, 1050, "MEMBER"))).isEqualTo(-1);
		Assertions.assertThat(comparator.compare(create(95, 1100, "ADMIN"), create(95, 1050, "ADMIN"))).isEqualTo(-1);
		Assertions.assertThat(comparator.compare(create(95, 999, "LEADER"), create(95, 1050, "ADMIN"))).isEqualTo(-1);

		Assertions.assertThat(comparator.compare(create(95, 1050, "MEMBER"), create(95, 1050, "MEMBER"))).isEqualTo(0);
		Assertions.assertThat(comparator.compare(create(95, 1050, "ADMIN"), create(95, 1050, "ADMIN"))).isEqualTo(0);
	}

	private ScoreMember create(int rp, int rank, String role) {
		ScoreMember left = new ScoreMember();
		left.setCc_contrib(rp);
		left.setLevel(rank);
		left.setRole(role);
		return left;
	}

}
