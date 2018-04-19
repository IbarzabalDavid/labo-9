import java.io.*;
import java.util.*;
/**
 * Created by Ibada1731710 on 2018-04-09.
 */
public class Main {
    public static void main(String[] args) {
        int choix = 0;
        String nom;
        boolean ok = false;
        char rep;
        Queue<String> fileRappel = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        HashMap<String, Contact> map = new HashMap<>();

        System.out.println("LISTE DE CONTACTS");
        while (choix != 8) {
            System.out.println("------------------------");
            System.out.println("1- Ajouter un contact");
            System.out.println("2- Modifier un contact");
            System.out.println("3- Afficher les contacts");
            System.out.println("4- Supprimer un contact");
            System.out.println("5- Ajouter à la liste de rappel");
            System.out.println("6- Afficher la liste de rappel");
            System.out.println("7- Charger");
            System.out.println("8- Quitter et sauvegarder");
            System.out.println("Que souhaitez-vous faire?");

            try{
                String temp=sc.nextLine();
                choix=Integer.parseInt(temp);
            }catch (Exception ex){
                System.out.println("Exception trouvée : "+ex);
                choix=0;
            }
            switch (choix) {
                case 1:
                    Contact contact = new Contact();
                    contact.ajouterContact();
                    map.put(contact.getNom().toLowerCase(), contact);
                    break;
                case 2:
                    System.out.println("---------------------------------");
                    System.out.println("Entrez le nom de la personne a modifier.");
                    nom = sc.next().toLowerCase();
                    if (map.containsKey(nom)) {
                        map.get(nom).modifierContact();

                        if (!nom.equals(map.get(nom).getNom())) {
                            map.put(map.get(nom).getNom(), map.get(nom));
                            map.remove(nom);
                        }

                    } else {
                        System.out.println("Contact inexistant :(");
                    }
                    break;
                case 3:
                    for (Contact contact1 : map.values()) {
                        contact1.afficherContact();
                    }
                    break;
                case 4:
                    System.out.println("Entrez le nom de la personne a supprimer.");
                    nom = sc.next().toLowerCase();
                    if (map.containsKey(nom)) {
                        map.remove(nom);
                    } else {
                        System.out.println("Contact inexistant");
                    }

                    break;
                case 5:
                    System.out.println("Qui voulez-vous ajouter à la liste de rappel? (entrez le nom)");
                    nom = sc.next();
                    if (map.containsKey(nom)) {
                        fileRappel.add(nom);
                    } else {
                        System.out.println("Contact inexistant");
                    }
                    break;
                case 6:
                    int i = 0;
                    if (!fileRappel.isEmpty()) {
                        System.out.println("La personne a appeler en priorité est : " + fileRappel.peek());
                    }
                    while (!ok && !fileRappel.isEmpty()) {
                        System.out.println(System.lineSeparator() + "Avez vous appelez le premier sur la liste? (o/n)");
                        rep = sc.next().toLowerCase().charAt(0);
                        if (rep == 'o') {
                            ok = true;
                            fileRappel.poll();
                            System.out.println("Le premier nom a été retiré de la liste de rappel.");
                        } else if (rep == 'n') {
                            ok = true;
                        } else {
                            System.out.println("Entrez oui ou non");
                        }
                    }
                    ok = false;

                    break;
                case 7:
                    map = load();
                    fileRappel = loadQueue();
                    break;
                case 8:
                    save(map, fileRappel);
                    System.out.println("Bye! Bye!");
                    break;
                default:
                    System.out.println("Entrez une réponse valide SVP!");
            }
        }
    }

    public static void save(HashMap<String, Contact> liste, Queue queue) {
        try {
            ObjectOutputStream sortie = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("monfichier.dat")));
            sortie.writeObject(liste);
            sortie.writeObject(queue);
            sortie.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Imposssible de sauvegarder");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Imposssible de sauvegarder");
        }
    }

    public static HashMap<String, Contact> load() {
        HashMap<String, Contact> liste = null;
        try {
            ObjectInputStream entree = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("monfichier.dat")));
            try {
                liste = (HashMap<String, Contact>) entree.readObject();
                entree.close();
                System.out.println("charge de la liste reussi");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Imposssible de charger Liste");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Imposssible de charger Liste");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Imposssible de charger Liste");
        }
        return liste;
    }

    public static Queue<String> loadQueue() {
        Queue<String> queue = null;
        try {
            ObjectInputStream entree = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("monfichier.dat")));
            try {
                entree.readObject();
                queue = (Queue<String>) entree.readObject();
                entree.close();
                System.out.println("charge de la file reussi");
            } catch (IOException e) {
                System.out.println("Imposssible de charger File");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("Imposssible de charger File");
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Imposssible de charger File");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Imposssible de charger File");
            e.printStackTrace();
        }
        return queue;
    }

    public static String demanderString(){
        Scanner sc =new Scanner(System.in);
        boolean justLettre=false;
        String rep="";
        while (!justLettre){
            rep=sc.nextLine();
            for (int i=0;i<rep.length();i++){
                int temp=(int)rep.charAt(i);
                if (temp<65||temp>122||(temp<97&&temp>90)&& temp!=32){
                    justLettre=false;
                    System.out.println("Entrez seulement des lettres (A à Z)");
                    i=rep.length();
                }
                else {
                    justLettre=true;
                }
            }
            if (rep.length()==0){
                justLettre=true;
            }
        }

        return rep;

    }
    public static String demanderNombre(){
        Scanner sc =new Scanner(System.in);
        boolean justNb=false;
        String rep="";
        while (!justNb){
            rep=sc.nextLine();
            for (int i=0;i<rep.length();i++){
                int temp=(int)rep.charAt(i);
                if (temp<48||temp>57){
                    justNb=false;
                    System.out.println("Entrez seulement des chiffres (0 à 9)");
                    i=rep.length();
                }
                else {
                    justNb=true;
                }
            }
            if (rep.length()==0){
                justNb=true;
            }
        }

        return rep;

    }
    public static String checkUpPhone(){
        Scanner sc =new Scanner(System.in);
        boolean phoneOK=false;
        String rep="";
        while (!phoneOK){
            rep=sc.nextLine();
            if (rep.length()==12){
                for (int i=0;i<12;i++){
                    int temp=(int)rep.charAt(i);
                    if (i==3||i==7){
                        if (temp==45){
                            phoneOK=true;
                        }
                        else {
                            System.out.println("Entrez votre numero sur la forme:  418-542-3435");
                        }
                    }
                    else if (temp<48||temp>57){
                        phoneOK=false;
                        System.out.println("Entrez votre numero sur la forme:  418-542-3435");
                        i=rep.length();
                    }
                    else {
                        phoneOK=true;
                    }
                }
                if (rep.length()==0){
                    phoneOK=true;
                }
            }
            else {
                System.out.println("Entrez votre numero sur la forme:  418-542-3435");
            }

        }

        return rep;

    }
    public static String checkUpPays(){
        String tabPays[]={"canada","états-unis","mexique","congo","france","allemagne","espagne","portugal","argentine","brésil"};
        Scanner sc=new Scanner(System.in);
        String rep="";
        boolean paysOk=false;

        while (!paysOk){
            rep=sc.nextLine();
            if (rep.length()==0){
                paysOk=true;
            }
            for (int i=0;i<tabPays.length;i++){
                if (tabPays[i].equals(rep)){
                    paysOk=true;
                }
            }
            if (!paysOk){
                System.out.println("Le pays entré n'existe pas ou n'est pas dans la liste permise");
            }
        }

        return rep;
    }
    public static String checkUpProvince() {
        String tabProvince[]={"colombie britanique","alberta","saskatchewan","manitoba","ontario","quebec","yukon","nunavut","nord ouest","terre neuve et labrador","prince édouard","nouvelle écosse","nouveau brunkswick"};
        Scanner sc = new Scanner(System.in);
        String rep = "";
        boolean provOk = false;
        while (!provOk) {
            rep = sc.nextLine();
            if (rep.length()==0){
                provOk=true;
            }
            for (int i = 0; i < tabProvince.length; i++) {
                if (tabProvince[i].equals(rep)) {
                    provOk = true;
                }
            }
            if (!provOk) {
                System.out.println("La province n'existe pas ou n'est pas dans la liste permise");
            }
        }

        return rep;
    }

}
