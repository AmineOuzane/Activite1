package dao;

//DAO Ferme a modification ouvert a extension

public class DaoImpl implements IDao{
    @Override
    public double getData() {
        /*
                Se connecter a la BD pour récupérer la température
         */
        System.out.println("version BD");
        double  temp=Math.random()*40;
        return temp;
    }
}
