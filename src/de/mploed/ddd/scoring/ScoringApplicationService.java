package de.mploed.ddd.scoring;

import de.mploed.ddd.scoring.ApplicationNumber;
import de.mploed.ddd.scoring.agencyResult.AgencyResultAggregate;
import de.mploed.ddd.scoring.applicant.ApplicantAggregate;
import de.mploed.ddd.scoring.calculation.ScoringResultAggregate;
import de.mploed.ddd.scoring.financialSituation.FinancialSituationAggregate;

/**
 * This service aims to show how working with various aggregates can be implemented using application services.
 *
 * This class is also a very good starting point for taking a look at the public APIs of the aggregates.
 */
public class ScoringApplicationService {
	public ScoringResultAggregate performScoring(ApplicationNumber applicationNumber) {
		// Load an AgencyResultAggregate
		AgencyResultAggregate agencyResultAggregate = loadAgencyResult();
		//Perform Scoring on the AgencyResultAggregate
		int agencyPoints = agencyResultAggregate.calculateScoringPoints();
		boolean noGoPresent = agencyResultAggregate.isAcceptable();

		// Load an ApplicantAggregate
		ApplicantAggregate applicantAggregate = loadApplicant(applicationNumber);
		// Perform Scoring on ApplicantAggregate
		int applicantPoints = applicantAggregate.calculateScoringPoints();

		// Load a FinancialSituationAggregate
		FinancialSituationAggregate financialSituationAggregate = loadFinancialSituation(applicationNumber);
		int financialSituationPoints = financialSituationAggregate.calculateScoringPoints();

		ScoringResultAggregate scoringResultAggregate = new ScoringResultAggregate.Builder(applicationNumber)
				.agencyScoring(agencyPoints)
				.applicantScoring(applicantPoints)
				.financialSituationScoring(financialSituationPoints)
				.noGoCriteria(noGoPresent)
				.build();


		return scoringResultAggregate;
	}

	/**
	 * Method that simulates the retrieval of an AgencyResultAggregate. This would usually be done with a Respository
	 * (which is not the scope of this demo project)
	 *
	 * @return a fully initialized AgencyResultAggregate
	 */
	private AgencyResultAggregate loadAgencyResult() {
		return new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson("Michael", "Plöd", "Kreuzstrasse 16", "80331", "Munich")
				.withPoints(80)
				.withWarning("100", "Did not pay his last bill at the restaurant")
				.build();

	}

	/**
	 * Method that simulates the retrieval of an ApplicantAggregate. This would usually be done with a Respository
	 * (which is not the scope of this demo project)
	 *
	 * @return a fully initialized ApplicantAggregate
	 */
	private ApplicantAggregate loadApplicant(ApplicationNumber applicationNumber) {
		return new ApplicantAggregate.ApplicantAggregateBuilder(applicationNumber)
				.city("Munich")
				.firstName("Michael")
				.lastName("Plöd")
				.postCode("80331")
				.street("Kreuzstrasse 16")
				.accountBalance(12000)
				.build();

	}


	/**
	 * Method that simulates the retrieval of an FinancialSituationAggregate. This would usually be done with a Respository
	 * (which is not the scope of this demo project)
	 *
	 * @return a fully initialized FinancialSituationAggregate
	 */
	private FinancialSituationAggregate loadFinancialSituation(ApplicationNumber applicationNumber) {
		return new FinancialSituationAggregate.FinancialSituationBuilder(applicationNumber)
				.salary(2500)
				.rent(800)
				.otherIncome(200)
				.costOfLiving(400)
				.build();
	}
}
