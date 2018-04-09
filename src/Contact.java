import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ibada1731710 on 2018-04-09.
 */
public class Contact {
    private String nom;
    private String nomFamille;
    private Adresse add;
    private ArrayList<Telephone> liste = new ArrayList<>();
    private Occupation occ;
    private Scanner sc=new Scanner(System.in);
    private char reponse;
    private String input;



    public String getNom() {
        return nom;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public Adresse getAdd() {
        return add;
    }

    public Occupation getOcc() {
        return occ;
    }

    public ArrayList<Telephone> getListe() {return liste;}

    public void setListe(ArrayList<Telephone> liste) {this.liste = liste;}

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public void setAdd(Adresse add) {
        this.add = add;
    }


    public void setOcc(Occupation occ) {
        this.occ = occ;
    }


    public void ajouterContact(){
        boolean answer=false;
        System.out.println("---------------------------------");
        System.out.println("Veuillez entrer les informations suivantes :"+System.lineSeparator());
        System.out.println("Prénom :");
        setNom(sc.next());
        System.out.println("Nom :");
        setNomFamille(sc.next());
        Adresse adresse=new Adresse();
        adresse.ajouterAdresse();
        setAdd(adresse);
        Occupation occupation =new Occupation();
        occupation.ajouterOccupation();
        setOcc(occupation);



        while (!answer){
            System.out.println("Voulez-vous ajouter un numéro de téléphone? (o/n)");
            reponse=sc.next().toLowerCase().charAt(0);
            if (reponse=='o'){
                Telephone telephone=new Telephone();
                telephone.ajoutelTel();
                liste.add(telephone);
            }
            else if (reponse=='n'){
                answer=true;
            }
            else {
                System.out.println("Entrez oui ou non");
            }

        }


    }
    public void modifierContact(){
        int i=0;
        boolean keepGoing=true;
        boolean answer=false;
        System.out.println("Veuillez entrer les informations suivantes (laisser vide si correct) :");
        System.out.println("---------------------------------");
        System.out.println("Prénom : ("+getNom()+")");
        input=sc.nextLine().trim();
        input=sc.nextLine().trim();
        if(!input.equals("")){
            setNom(input);
        }
        System.out.println("Nom de famille : ("+getNomFamille()+")");
        input=sc.nextLine().trim();
        if(!input.equals("")){
            setNomFamille(input);
        }
        getAdd().modifierAdresse();
        getOcc().modifierOccupation();

        while (keepGoing){
            if (liste.contains(i)){
                liste.get(i).modifierTelephone();
            }
            else {
                keepGoing=false;
            }
            i++;
        }

        while (!answer){
            System.out.println("Voulez-vous ajouter un numéro de téléphone? (o/n)");
            reponse=sc.next().toLowerCase().charAt(0);
            if (reponse=='o'){
                Telephone telephone=new Telephone();
                telephone.ajoutelTel();
                liste.add(telephone);
            }
            else if (reponse=='n'){
                answer=true;
            }
            else {
                System.out.println("Entrez oui ou non");
            }

        }



    }
    public void afficherContact(){
        System.out.println("---------------------------------");
        System.out.println("Prénom : "+getNom());
        System.out.println("Nom de famille : "+getNomFamille());
        getAdd().afficherAdresse();
        getOcc().afficherOccupation();
        for (Telephone telephone: liste){
            telephone.afficherTelephone();
        }


    }

}