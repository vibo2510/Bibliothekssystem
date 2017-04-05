import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Bibliothek implements AusleiherService, AusleiheService, MediumService {
	private static final Bibliothek BIB = new Bibliothek();
	
	ArrayList<Medium> medien;
	ArrayList<Ausleiher> ausleiher;
	ArrayList<Ausleihe> ausleihen;
	
	
	public Bibliothek(){
		this.medien= new ArrayList<Medium>();
		this.ausleihen = new ArrayList<Ausleihe>();
		this.ausleiher = new ArrayList<Ausleiher>();
		
	}
	
	public static Bibliothek getInstance(){
		return BIB;
	}
	
	public void init(){
		Buch buch2=new Buch(erzeugeID("Medium"),"Harry Potter und der Stein der Weisen",true,0.5f,"J.K. Rowling","Buch",new ArrayList<Ausleihe>());
		this.medien.add(buch2);
		Buch buch1=new Buch(erzeugeID("Medium"),"Harry Potter und die Kammer des Schreckens",true,0.5f,"J.K. Rowling","Buch",new ArrayList<Ausleihe>());
		this.medien.add(buch1);
		Buch buch =new Buch(erzeugeID("Medium"),"Harry Potter und der Gefangene von Askaban",true,0.5f,"J.K. Rowling","Buch",new ArrayList<Ausleihe>());
		this.medien.add(buch);
		Ausleiher ausleiherP = new Ausleiher(erzeugeID("Ausleiher"),"Herbert","Müller","Musterstrasse",1,"12345","Musterhausen",new ArrayList<Ausleihe>());
		this.ausleiher.add(ausleiherP);
		this.ausleihen.add(new Ausleihe(erzeugeID("Ausleihe"),new Date(2017,03,20),new Date(2017,04,20),3.3F,buch1,ausleiherP));
		this.ausleihen.add(new Ausleihe(erzeugeID("Ausleihe"),new Date(2017,04,20),new Date(2017,05,20),3.3F,buch2,ausleiherP));
		//this.ausleihen.add(new Ausleihe(erzeugeID("Ausleihe"),new Date(2017,05,20),new Date(2017,06,20),3.3F,buch,ausleiherP));
	}
	
	public int erzeugeID(String objekt){
		if(objekt.equals("Ausleihe")){
			return ausleihen.size();
		} 
		if(objekt.equals("Ausleiher")){
			return ausleiher.size();
		}
		
		if(objekt.equals("Medium")){
			return medien.size();
		}
		return 0;
		
		
	}
	
	@Override
	public Medium getMediumById(int id){
		for(Medium m: medien){
				if(m.mediumID==id){
					return m;
				}
		}
		return null;
		
	}

	@Override
	public void mediumErstellen(Medium medium) {
		medien.add(medium);
		
	}

	@Override
	public void mediumAendern(Medium medium, Medium geaendertesMedium) {
		for(Medium m: medien){
			if(m.equals(medium)){
				medien.set(medien.indexOf(m), geaendertesMedium);
			}
		}
		
	}

	@Override
	public void mediumLoeschen(Medium medium) {
		for(Medium m: medien){
			if(m.equals(medium)){
				medien.remove(m);
				return;
			}
		}
		
	}

	@Override
	public ArrayList<Medium> mediumSuchen(String suchbegriff, Suchtyp s) {
		ArrayList<Medium> gefundeneMedien= new ArrayList<Medium>();
		for(Medium m: medien){
			if(s.equals(Suchtyp.MEDIUM_ID)){
				if(m.mediumID==Integer.parseInt(suchbegriff)){
					gefundeneMedien.add(m);
				}
			}
		}
		return gefundeneMedien;
	}

	@Override
	public void ausleiheErstellen(Ausleihe ausleihe) {
		ausleihen.add(ausleihe);

	}

	@Override
	public void ausleiheAendern(Ausleihe ausleihe, Ausleihe geaenderteAusleihe) {
		for(Ausleihe a: ausleihen){
			if(a.equals(ausleihe)){
				ausleihen.remove(a);
				a=null;
				ausleihen.add(geaenderteAusleihe);
				return;
			}
		}
		
	}

	@Override
	public void ausleiheLoeschen(Ausleihe ausleihe) {
		for(Ausleihe a: ausleihen){
			if(a.equals(ausleihe)){
				ausleihen.remove(a);
				return;
			}
		}

	}

	@Override
	public ArrayList<Ausleihe> ausleiheSuchen(String suchbegriff) {
		ArrayList<Ausleihe> gefundeneAusleihen= new ArrayList<Ausleihe>();
		for(Ausleihe a: ausleihen){
			if(a.ausleiheID==Integer.parseInt(suchbegriff)){
					gefundeneAusleihen.add(a);
			}
		}
		return gefundeneAusleihen;
	}

	@Override
	public void ausleiherErstellen(Ausleiher ausleiher) {
		this.ausleiher.add(ausleiher);
		
	}

	@Override
	public void ausleiherAendern(Ausleiher ausleiher, Ausleiher geaenderterAusleiher) {
		for(Ausleiher a: this.ausleiher){
			if(a.equals(ausleiher)){
				this.ausleiher.set(medien.indexOf(a), geaenderterAusleiher);
			}
		}
		
		
	}

	@Override
	public void ausleiherLoeschen(Ausleiher ausleiher) {
		for(Ausleiher a: this.ausleiher){
			if(a.equals(ausleiher)){
				this.ausleiher.remove(a);
				return;
			}
		}
		
	}

	@Override
	public ArrayList<Ausleiher> ausleiherSuchen(String suchbegriff, Suchtyp s) {
		ArrayList<Ausleiher> gefundeneAusleiher= new ArrayList<Ausleiher>();
		for(Ausleiher a: this.ausleiher){
			if(a.ausleiherID==Integer.parseInt(suchbegriff)){
					gefundeneAusleiher.add(a);
			}
		}
		return gefundeneAusleiher;
	}

	public Ausleihe getAusleiheById(int id) {
		for(Ausleihe a: ausleihen){
			if(a.ausleiheID==id){
				return a;
			}
	}
	return null;
	
	}

	public Ausleiher getAusleiherByID(int id) {
		for(Ausleiher a: ausleiher){
			if(a.ausleiherID==id){
				return a;
			}
	}
	return null;
	
	}

}