
import java.util.Date;

public class Ausleihe {
	int ausleiheID;
	Date ausleihTag;
	Date spaetesteRueckgabe;
	float gesamtGebuehr;
	Medium medium;
	Ausleiher ausleiher;
	
	public Ausleihe( int id,Date ausleihTag, Date spaetesteRueckgabe, float gesamtGebuehr, Medium medium, Ausleiher ausleiher){
		Bibliothek bib= Bibliothek.getInstance();
		this.ausleiheID= id;
		this.ausleihTag= ausleihTag;
		this.spaetesteRueckgabe= spaetesteRueckgabe;
		this.gesamtGebuehr= gesamtGebuehr;
		this.medium= medium;
		this.ausleiher= ausleiher;
		
		
		for(Medium m: bib.medien){
			if(m.equals(medium)){
				m.ausleiheZuordnen(this);
			}
		}
		for(Ausleiher a: bib.ausleiher){
			if(a.equals(ausleiher)){
				a.ausleiheZuordnen(this);
			}
		}
		
	}
}
