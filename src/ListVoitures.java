import java.util.*;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures() {

    }
    public ListVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }



    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public void ajoutVoiture(Voiture v)
            throws VoitureException {


        if (voitures.contains(v)) {
            throw new VoitureException("la voiture déja existe");
        }
        voitures.add(v);
    }

    public void supprimeVoiture(Voiture v) throws VoitureException {
        if (!voitures.contains(v)) {
            throw new VoitureException("La voiture n'existe pas dans la liste.");
        }
        voitures.remove(v);
    }

    public int size() {
        return voitures.size();
    }

    public void affiche() {
        for (Voiture voiture : voitures) {
            System.out.println("Immatriculation: " + voiture.getImmariculation());
            System.out.println("Marque: " + voiture.getMarque());
            System.out.println("Prix: " + voiture.getPrixLocation());
            System.out.println();
        }
    }

    private class VoitureException extends Exception {
        public VoitureException(String message) {
            super(message);
        }
    }
}
