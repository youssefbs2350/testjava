public class CritereMarque implements Critere {
private String marque; public
CritereMarque(String marque) {
        this.marque = marque;
        }
public boolean estSatisfaitPar(Voiture v) {
        if (v.getMarque() != this.marque)
                return false;
        else return true;
}
        }