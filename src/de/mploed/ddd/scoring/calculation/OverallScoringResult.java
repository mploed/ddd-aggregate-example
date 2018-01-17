package de.mploed.ddd.scoring.calculation;

class OverallScoringResult {
	private int points;
	private ScoringColor color;

	public OverallScoringResult(int points, ScoringColor color) {
		this.points = points;
		this.color = color;
	}

	int getPoints() {
		return points;
	}

	ScoringColor getColor() {
		return color;
	}
}
