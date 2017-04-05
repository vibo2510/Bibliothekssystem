import java.util.ArrayList;

public interface MediumService {
	public void mediumErstellen(Medium medium);
	public void mediumAendern(Medium medium, Medium geaendertesMedium);
	public void mediumLoeschen(Medium medium);
	public ArrayList<Medium> mediumSuchen(String suchbegriff, Suchtyp s);
	public Medium getMediumById(int id);
}
