package de.hannesbenne;

public class NutritionFacts {
	
	private double energieJule;
	private double energieKalorien;
	private double anteilFett;
	private double anteilGesaettigteFettsaeure;
	private double kohlenhydrate;
	private double zuckerAnteil;
	private double eiweissAnteil;
	private double salzAnteil;
	
	public NutritionFacts(double energieJule, double energieKalorien, double anteilFett,
			double anteilGesaettigteFettsaeure, double kohlenhydrate, double zuckerAnteil, double eiweissAnteil,
			double salzAnteil) {
		this.energieJule = energieJule;
		this.energieKalorien = energieKalorien;
		this.anteilFett = anteilFett;
		this.anteilGesaettigteFettsaeure = anteilGesaettigteFettsaeure;
		this.zuckerAnteil = zuckerAnteil;
		this.kohlenhydrate = kohlenhydrate;
		this.eiweissAnteil = eiweissAnteil;
		this.salzAnteil = salzAnteil;
	}

	public double getEnergieJule() {
		return energieJule;
	}

	public void setEnergieJule(double energieJule) {
		this.energieJule = energieJule;
	}

	public double getEnergieKalorien() {
		return energieKalorien;
	}

	public void setEnergieKalorien(double energieKalorien) {
		this.energieKalorien = energieKalorien;
	}

	public double getAnteilFett() {
		return anteilFett;
	}

	public void setAnteilFett(double anteilFett) {
		this.anteilFett = anteilFett;
	}

	public double getAnteilGesaettigteFettsaeure() {
		return anteilGesaettigteFettsaeure;
	}

	public void setAnteilGesaettigteFettsaeure(double anteilGesaettigteFettsaeure) {
		this.anteilGesaettigteFettsaeure = anteilGesaettigteFettsaeure;
	}

	public double getZuckerAnteil() {
		return zuckerAnteil;
	}

	public void setZuckerAnteil(double zuckerAnteil) {
		this.zuckerAnteil = zuckerAnteil;
	}

	public double getKohlenhydrate() {
		return kohlenhydrate;
	}

	public void setKohlenhydrate(double kohlenhydrate) {
		this.kohlenhydrate = kohlenhydrate;
	}

	public double getEiweissAnteil() {
		return eiweissAnteil;
	}

	public void setEiweissAnteil(double eiweissAnteil) {
		this.eiweissAnteil = eiweissAnteil;
	}

	public double getSalzAnteil() {
		return salzAnteil;
	}

	public void setSalzAnteil(double salzAnteil) {
		this.salzAnteil = salzAnteil;
	}
	
}

