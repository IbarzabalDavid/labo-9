import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by ibada1731710 on 2018-04-09.
 */
public class Occupation implements Serializable {
    private String poste;
    private Entreprise job;

    private String input;

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Entreprise getJob() {
        return job;
    }

    public void setJob(Entreprise job) {
        this.job = job;
    }
    public void ajouterOccupation(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Occupation :");
        System.out.println("  Poste :");
        setPoste(Main.demanderString());
        Entreprise entreprise=new Entreprise();
        entreprise.ajouterEntreprise();
        setJob(entreprise);

    }
    public void modifierOccupation(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Occupation : ");
        System.out.println("  Poste : ("+getPoste()+")");
        input=Main.demanderString().trim();
        if(!input.equals("")){
            setPoste(input);
        }
        getJob().modifierEntreprise();
    }
    public void afficherOccupation(){
        System.out.println("Occupation : ");
        System.out.println("  Poste : "+getPoste());
        getJob().afficherEntreprise();
    }
}