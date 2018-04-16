import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by ibada1731710 on 2018-04-09.
 */
public class Adresse implements Serializable {
    private String numPorte;
    private String rue;
    private String ville;
    private String appart;
    private String province;
    private String pays;
    private String input;



    public String getNumPorte() {
        return numPorte;
    }

    public void setNumPorte(String numPorte) {
        this.numPorte = numPorte;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAppart() {
        return appart;
    }

    public void setAppart(String appart) {
        this.appart = appart;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    public void ajouterAdresse(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Adresse :");
        System.out.println("  Numéro de porte");
        setNumPorte(sc.next());
        System.out.println("  Rue :");
        setRue(Main.demanderString());
        System.out.println("  Appartement :");
        input=sc.nextLine().trim();
        input=sc.nextLine().trim();
        if (input.equals("")){
            setAppart("");
        }
        else {
            setAppart(sc.next());
        }
        System.out.println("  Ville :");
        setVille(Main.demanderString());
        System.out.println("  Province :");
        setProvince(Main.demanderString());
        System.out.println("  Pays :");
        setPays(Main.demanderString());
    }
    public void modifierAdresse(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Adresse : ");
        System.out.println("  Numéro de porte : ("+getNumPorte()+")");
        input=sc.nextLine().trim();
        input=sc.nextLine().trim();
        if(!input.equals("")){
            setNumPorte(input);
        }
        System.out.println("  Rue : ("+getRue()+")");
        input=Main.demanderString().trim();
        if(!input.equals("")){
            setRue(input);
        }
        System.out.println("  Appartement : ("+getAppart()+")");
        input=sc.nextLine().trim();
        if(!input.equals("")){
            setAppart(input);
        }
        System.out.println("  Ville : ("+getVille()+")");
        input=Main.demanderString().trim();
        if(!input.equals("")){
            setVille(input);
        }
        System.out.println("  Province : ("+getProvince()+")");
        input=Main.demanderString().trim();
        if(!input.equals("")){
            setProvince(input);
        }
        System.out.println("  Pays : ("+getPays()+")");
        input=Main.demanderString().trim();
        if(!input.equals("")){
            setPays(input);
        }

    }
    public void afficherAdresse(){
        System.out.println("Adresse : ");
        System.out.println("  Numéro de porte : "+getNumPorte());
        System.out.println("  Rue : "+getRue());
        System.out.println("  Appartement : "+getAppart());
        System.out.println("  Ville : "+getVille());
        System.out.println("  Province : "+getProvince());
        System.out.println("  Pays : "+getPays());
    }

}