import java.util.ArrayList;

public class Buch extends Medium{
	String autor;
	
	
	
	
	public Buch( int mediumID,String titel, boolean verfuegbarkeit, float leihgebuehr, String autor, String medientyp, ArrayList<Ausleihe> ausleihen) {
		super(mediumID,titel, verfuegbarkeit, leihgebuehr, medientyp, ausleihen);
		this.autor= autor;
	}

}
