import java.util.ArrayList;

public class Medium {
	int mediumID;
	String titel;
	boolean verfuegbarkeit;
	float leihgebuehr;
	String medientyp;
	ArrayList<Ausleihe> ausleihen;
	
	
	public Medium( int mediumID, String titel, boolean verfuegbarkeit, float leihgebuehr, String medientyp, ArrayList<Ausleihe> ausleihen){
		this.mediumID = mediumID;
		this.titel= titel;
		this.verfuegbarkeit= verfuegbarkeit;
		this.leihgebuehr= leihgebuehr;
		this.medientyp= medientyp;
		this.ausleihen=ausleihen;
	}
	
	public void ausleiheZuordnen(Ausleihe ausleihe){
		this.ausleihen.add(ausleihe);	
		}
	
	
}
