package de.mploed.ddd.scoring.financialSituation;

import de.mploed.ddd.scoring.ApplicationNumber;

class FinancialSituationRootEntity {
	private final ApplicationNumber applicationNumber;

	private final Incomings incomings;
	private final Outgoings outgoings;

	FinancialSituationRootEntity(ApplicationNumber applicationNumber, Incomings incomings, Outgoings outgoings) {
		this.applicationNumber = applicationNumber;
		this.incomings = incomings;
		this.outgoings = outgoings;
	}

	int sum() {
		return incomings.sum() - outgoings.sum();
	}

}
