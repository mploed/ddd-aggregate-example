package de.mploed.ddd.scoring.agencyResult;

import de.mploed.ddd.scoring.PersonId;

import java.util.HashSet;
import java.util.Set;

public class AgencyResultAggregate {
	private AgencyResultRootEntity agencyResultRootEntity;

	AgencyResultRootEntity getAgencyResultRootEntity() {
		return agencyResultRootEntity;
	}

	private AgencyResultAggregate(AgencyResultBuilder builder) {
		this.agencyResultRootEntity = new AgencyResultRootEntity(builder.personId, builder.points);
		this.agencyResultRootEntity.addAllKoCriteria(builder.koCriteria);
		this.agencyResultRootEntity.addAllWarningMessage(builder.warningMessages);
	}


	public boolean isAcceptable() {
		return agencyResultRootEntity.isAcceptable();
	}

	public int calculateScoringPoints() {
		return agencyResultRootEntity.calculateScoringPoints();
	}

	public static class AgencyResultBuilder {
		private final int points;
		private final Set<KoCriteria> koCriteria;
		private final Set<WarningMessage> warningMessages;
		private PersonId personId;

		public AgencyResultBuilder(int points) {
			this.points = points;
			this.koCriteria = new HashSet<KoCriteria>();
			this.warningMessages = new HashSet<WarningMessage>();
		}

		public AgencyResultBuilder withWarning(String key, String message) {
			this.warningMessages.add(new WarningMessage(key, message));
			return this;
		}

		public AgencyResultBuilder withKoCriteria(String key, String message) {
			this.koCriteria.add(new KoCriteria(key, message));
			return this;
		}

		public AgencyResultBuilder forPerson(String firstName, String lastName, String street, String postCode, String city) {
			this.personId = new PersonId.PersonIdBuilder(firstName, lastName)
					.city(city)
					.street(street)
					.postCode(postCode)
					.build();
			return this;
		}

		public AgencyResultAggregate build() {
			return new AgencyResultAggregate(this);
		}

	}
}
