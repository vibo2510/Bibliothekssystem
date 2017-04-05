import java.util.ArrayList;

public interface AusleiheService {
	public void ausleiheErstellen(Ausleihe ausleihe);
	public void ausleiheAendern(Ausleihe ausleihe, Ausleihe geaenderteAusleihe);
	public void ausleiheLoeschen(Ausleihe ausleihe);
	public ArrayList<Ausleihe> ausleiheSuchen(String suchbegriff);
}
