import java.util.ArrayList;

public interface AusleiherService {
	public void ausleiherErstellen(Ausleiher ausleiher);
	public void ausleiherAendern(Ausleiher ausleiher, Ausleiher geaenderterAusleiher);
	public void ausleiherLoeschen(Ausleiher ausleiher);
	public ArrayList<Ausleiher> ausleiherSuchen(String suchbegriff, Suchtyp s);
	
}
