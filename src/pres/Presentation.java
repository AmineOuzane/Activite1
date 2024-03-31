package pres;


import dao.DaoImpl;
import metier.MetierImpl;

//Presentation seul classe qui peut subir modification

public class Presentation {
    public static void main(String[] args) {

        /*
            Injection de dependence par instanciation statique
            => new => couplage fort => poubelle
             null pour la maintenance
        */

        /*
        Partie a modifier pour travailler avec DAO2 Version Capteurs
        DaoImpl2 dao=new DapImpl2;
        */

        //Couplage fort =new ...
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl();
        //Set pour satisfaire les Dépendences
        metier.setDao(dao);
        System.out.println("Resultats="+metier.calcul());
        /*
        qui genere une erreur car objet pas creer 'dao' 'null' nullpointerexception
        */
    }
}
