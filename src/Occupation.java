import java.util.Scanner;

/**
 * Created by ibada1731710 on 2018-04-09.
 */
public class Occupation {
    private String poste;
    private Entreprise job;
    private Scanner sc=new Scanner(System.in);
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
        System.out.println("Occupation :");
        System.out.println("  Poste :");
        setPoste(sc.next());
        Entreprise entreprise=new Entreprise();
        entreprise.ajouterEntreprise();
        setJob(entreprise);

    }
    public void modifierOccupation(){
        System.out.println("Occupation : ");
        System.out.println("  Poste : ("+getPoste()+")");
        input=sc.nextLine().trim();
        input=sc.nextLine().trim();
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