package pres;

import dao.IDao;

import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException , IllegalArgumentException{
        Scanner scanner =new Scanner(new File("config.txt"));
        /*  Instanciation dynamic =>
                Connaitre le nom de la classe a travers le fichier --->  String daoClassName=scanner.nextLine();
                Charger la classe en memoire Class                 ---> cDao=Class.forName(daoClassName);
                Instancier la classe  Class                        ---> cDao=Class.forName(daoClassName);
                Avantage ==> Si je veux basculer de VERSION db,capteurs,.. ----> changer dans le file config.txt
        */

        String daoClassName=scanner.nextLine(); //nom de la 1er Classe dans config.txt
        Class cDao=Class.forName(daoClassName);

        /*
            forName Cherche si class existe et la charge en memoire soustype Class
            Sinon genere ClassNotFoundException
        */

        IDao dao= (IDao).cDao.newInstance(); // Pour creer un objet de la classe comme new, on connait pas la classe, est de type IDao

        /*
            newInstance fait appel au constructeur sans parametre
            InstantiationException si on a pas un  constructor par defaut
            IllegalAccessException et generer quand un conctructeur sans parameter est privée
                => donc on peut pas instancier la classe
         */

        //Meme chose pour Metier
        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=cMetier.newInstance();

        //Set ne se trouve pas dans interface car on met que les besoins fonctionnel dans interface
        Method method=cMetier.getMethod("setDao",IDao.class);
        //metier.setDao(dao)
        method.invoke(metier,dao);


    }
}
