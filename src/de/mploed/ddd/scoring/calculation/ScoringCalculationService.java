package de.mploed.ddd.scoring.calculation;

import de.mploed.ddd.scoring.ApplicationNumber;
import de.mploed.ddd.scoring.agencyResult.AgencyResultAggregate;
import de.mploed.ddd.scoring.applicant.ApplicantAggregate;
import de.mploed.ddd.scoring.financialSituation.FinancialSituationAggregate;

public class ScoringCalculationService {
	private ApplicationNumber applicationNumber;
	private AgencyResultAggregate agencyResultAggregate;
	private ApplicantAggregate applicantAggregate;
	private FinancialSituationAggregate financialSituationAggregate;

	public ScoringCalculationService(ApplicationNumber applicationNumber, AgencyResultAggregate agencyResultAggregate, ApplicantAggregate applicantAggregate, FinancialSituationAggregate financialSituationAggregate) {
		this.applicationNumber = applicationNumber;
		this.agencyResultAggregate = agencyResultAggregate;
		this.applicantAggregate = applicantAggregate;
		this.financialSituationAggregate = financialSituationAggregate;
	}

	public ScoringResultAggregate performScoring() {
		int agencyPoints = agencyResultAggregate.calculateScoringPoints();

		boolean noGoPresent = agencyResultAggregate.isAcceptable();
		int applicantPoints = applicantAggregate.calculateScoringPoints();
		int financialSituationPoints = financialSituationAggregate.calculateScoringPoints();

		ScoringResultAggregate scoringResultAggregate = new ScoringResultAggregate.Builder(applicationNumber)
				.agencyScoring(agencyPoints)
				.applicantScoring(applicantPoints)
				.financialSituationScoring(financialSituationPoints)
				.noGoCriteria(noGoPresent)
				.build();


		return scoringResultAggregate;
	}
}
