import java.util.ArrayList;


public class Ausleiher {
	int ausleiherID;
	String vorname;
	String nachname;
	String strasse;
	int hausnummer;
	String plz;
	String ort;
	ArrayList<Ausleihe> ausleihen;
	

	
	public Ausleiher(int id,String vorname, String nachname, String strasse, int hausnummer, String plz, String ort, ArrayList<Ausleihe> ausleihen){
		Bibliothek bib= Bibliothek.getInstance();
		this.ausleiherID = id;
		this.vorname= vorname;
		this.nachname= nachname;
		this.strasse= strasse;
		this.hausnummer= hausnummer;
		this.plz= plz;
		this.ort= ort;
		this.ausleihen= ausleihen;
	}
	
	public void ausleiheZuordnen(Ausleihe ausleihe){
		this.ausleihen.add(ausleihe);
	}
	
}
