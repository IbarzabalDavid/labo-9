import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by ibada1731710 on 2018-04-09.
 */
public class Entreprise implements Serializable {
    private String nomJob;
    private Adresse adresseJob;

    private String input;

    public String getNomJob() {
        return nomJob;
    }

    public void setNomJob(String nomJob) {
        this.nomJob = nomJob;
    }

    public Adresse getAdresseJob() {
        return adresseJob;
    }

    public void setAdresseJob(Adresse adresseJob) {
        this.adresseJob = adresseJob;
    }
    public void ajouterEntreprise(){
        Scanner sc=new Scanner(System.in);
        System.out.println("  Entreprise :");
        System.out.println("    Nom :");
        setNomJob(Main.demanderString());
        Adresse adresseJob=new Adresse();
        adresseJob.ajouterAdresse();
        setAdresseJob(adresseJob);
    }
    public void modifierEntreprise(){
        Scanner sc=new Scanner(System.in);
        System.out.println("  Entrprise : ");
        System.out.println("    Nom : ("+getNomJob()+")");
        input=Main.demanderString().trim();
        if(!input.equals("")){
            setNomJob(input);
        }
        getAdresseJob().modifierAdresse();
    }
    public void afficherEntreprise(){
        System.out.println("  Entrprise : ");
        System.out.println("    Nom : "+getNomJob());
        getAdresseJob().afficherAdresse();
    }
}