package de.hannesbenne;

public class Label {
	private int id;
	private int grammatur;
	private String artikelnummer;
	private String sortiment;
	private String bodentext;
	private String layout;
	private String produktname;
	private String namenszusatz;
	private String zutatenliste;
	private String barcode;
	private NutritionFacts nutritionFacts;
	
	
	
	public Label(int id, int grammatur, String artikelnummer, String sortiment, String layout, String produktname,
			String namenszusatz, String bodentext, String zutatenliste, String barcode, NutritionFacts nutritionFacts) {
		this.id = id;
		this.grammatur = grammatur;
		this.artikelnummer = artikelnummer;
		this.sortiment = sortiment;
		this.layout = layout;
		this.produktname = produktname;
		this.namenszusatz = namenszusatz;
		this.bodentext = bodentext;
		this.zutatenliste = zutatenliste;
		this.barcode = barcode;
		this.nutritionFacts = nutritionFacts;
	}

	
	public Label(int grammatur, String artikelnummer, String sortiment, String layout, String produktname,
			String namenszusatz, String bodentext, String zutatenliste, String barcode, NutritionFacts nutritionFacts) {
		this.grammatur = grammatur;
		this.artikelnummer = artikelnummer;
		this.sortiment = sortiment;
		this.layout = layout;
		this.produktname = produktname;
		this.namenszusatz = namenszusatz;
		this.bodentext = bodentext;
		this.zutatenliste = zutatenliste;
		this.barcode = barcode;
		this.nutritionFacts = nutritionFacts;

	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrammatur() {
		return grammatur;
	}
	public void setGrammatur(int grammatur) {
		this.grammatur = grammatur;
	}
	public String getArtikelnummer() {
		return artikelnummer;
	}
	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}
	public String getSortiment() {
		return sortiment;
	}
	public void setSortiment(String sortiment) {
		this.sortiment = sortiment;
	}
	public String getProduktname() {
		return produktname;
	}
	public void setProduktname(String produktname) {
		this.produktname = produktname;
	}
	public String getNamenszusatz() {
		return namenszusatz;
	}
	public void setNamenszusatz(String namenszusatz) {
		this.namenszusatz = namenszusatz;
	}
	public String getZutatenliste() {
		return zutatenliste;
	}
	public void setZutatenliste(String zutatenliste) {
		this.zutatenliste = zutatenliste;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public NutritionFacts getNutritionFacts() {
		return nutritionFacts;
	}
	public void setNutritionFacts(NutritionFacts nutritionFacts) {
		this.nutritionFacts = nutritionFacts;
	}


	@Override
	public String toString() {
		return "Label [id=" + id + ", grammatur=" + grammatur + ", artikelnummer=" + artikelnummer + ", sortiment="
				+ sortiment + ", produktname=" + produktname + ", namenszusatz=" + namenszusatz + ", zutatenliste="
				+ zutatenliste + ", barcode=" + barcode + ", nutritionFacts=" + nutritionFacts + "]";
	}


	public String getBodentext() {
		return bodentext;
	}


	public void setBodentext(String bodentext) {
		this.bodentext = bodentext;
	}


	public String getLayout() {
		return layout;
	}


	public void setLayout(String layout) {
		this.layout = layout;
	}


	
	
	
	
	
}
