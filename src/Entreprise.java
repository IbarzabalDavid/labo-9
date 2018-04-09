import java.util.Scanner;

/**
 * Created by ibada1731710 on 2018-04-09.
 */
public class Entreprise {
    private String nomJob;
    private Adresse adresseJob;
    private Scanner sc=new Scanner(System.in);
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
        System.out.println("  Entreprise :");
        System.out.println("    Nom :");
        setNomJob(sc.next());
        Adresse adresseJob=new Adresse();
        adresseJob.ajouterAdresse();
        setAdresseJob(adresseJob);
    }
    public void modifierEntreprise(){
        System.out.println("  Entrprise : ");
        System.out.println("    Nom : ("+getNomJob()+")");
        input=sc.nextLine().trim();
        input=sc.nextLine().trim();
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