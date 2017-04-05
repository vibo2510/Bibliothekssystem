import java.util.ArrayList;

public class DVD extends Medium{
	String regisseur;
	String hauptdarsteller;
	
	
	
	public DVD(int id,String titel, boolean verfuegbarkeit, float leihgebuehr, String regisseur, String hauptdarsteller, String medientyp, ArrayList<Ausleihe> ausleihen) {
		super(id,titel, verfuegbarkeit, leihgebuehr, medientyp, ausleihen);
		this.regisseur= regisseur;
		this.hauptdarsteller= hauptdarsteller;
	}

}
