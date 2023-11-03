import java.util.Objects;
import java.util.List;
public class Voiture {
    private int immariculation;
    private String marque;
    private float prixLocation;
    public Voiture(int immariculation, String marque, float prixLocation) {
this.immariculation= immariculation ;
this.marque=marque ;
this.prixLocation= prixLocation ;
    }
    public int getImmariculation() {
        return immariculation;
    }
    public void setImmariculation(int immariculation) {
        this.immariculation = immariculation;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public float getPrixLocation() {
        return prixLocation;
    }
    public void setPrixLocation(float prixLocation) {
        this.prixLocation = prixLocation;
    }

    public int hashCode() {
        return Objects.hash(immariculation, marque, prixLocation);
    }

    public boolean equals(Object obj) {
if (obj==null) return false ;
if (this.getClass() != obj.getClass()) return false ;
 Voiture v = (Voiture) obj ;
return ((this.marque.equals(v.marque)) && (this.immariculation == v.immariculation)) ;

    }
    public String toString(){
return "la marque est " +marque + "et l'immatriculation est " + immariculation ;

    }
}