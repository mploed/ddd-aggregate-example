package de.mploed.ddd;

import de.mploed.ddd.scoring.ApplicationNumber;
import de.mploed.ddd.scoring.ScoringApplicationService;
import de.mploed.ddd.scoring.calculation.ScoringResultAggregate;

public class ScoringExample {
	public static void main(String[] args) {

		ScoringApplicationService scoringApplicationService = new ScoringApplicationService();
		ScoringResultAggregate scoringResultAggregate = scoringApplicationService.performScoring(new ApplicationNumber("123456"));
		System.out.println("Score Color: " + scoringResultAggregate.getScoreColor());
		System.out.println("Score Points: " + scoringResultAggregate.getScorePoints());

	}
}
