package metier;

import dao.IDao;

//Metier Ferme a la modification

public class MetierImpl implements IMetier {
    //Couplage faible
    private IDao dao=null;   //pas de =new sinn couplage fort
    @Override
    public double calcul(){
        double tmp=dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }

    //Injecter la var dao un objet d'une classe qui implement interface IDao

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
