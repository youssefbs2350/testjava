import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> loueClientVoiture;

    public Agence(String nom) {
        this.nom = nom;
        vs = new ListVoitures();
        loueClientVoiture = new TreeMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException, ListVoitures.VoitureException {
        if (v == null) {
            throw new VoitureException("La voiture à ajouter n'existe pas.");
        }
        vs.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException, ListVoitures.VoitureException {
        if (v == null) {
            throw new VoitureException("La voiture à supprimer n'existe pas.");
        }
        vs.supprimeVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException, ListVoitures.VoitureException {
        if (cl == null || v == null) {
            throw new VoitureException("Client ou voiture invalide pour la location.");
        }
        if (!loueClientVoiture.containsKey(cl)) {
            loueClientVoiture.put(cl, new ListVoitures());
        }
        loueClientVoiture.get(cl).ajoutVoiture(v);
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException, ListVoitures.VoitureException {
        if (cl == null || v == null) {
            throw new VoitureException("Client ou voiture invalide pour le retour.");
        }
        if (loueClientVoiture.containsKey(cl)) {
            loueClientVoiture.get(cl).supprimeVoiture(v);
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> voituresFiltrees = new ArrayList<>();
        for (Voiture v : vs.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                voituresFiltrees.add(v);
            }
        }
        return voituresFiltrees;
    }

    public Set<Client> ensembleClientsLoueurs() {
        Set<Client> clientsLoueurs = new HashSet<>();
        for (Map.Entry<Client, ListVoitures> entry : loueClientVoiture.entrySet()) {
            if (!entry.getValue().getVoitures().isEmpty()) {
                clientsLoueurs.add(entry.getKey());
            }
        }
        return clientsLoueurs;
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        Collection<ListVoitures> voituresLouees = new ArrayList<>();
        for (ListVoitures listVoitures : loueClientVoiture.values()) {
            if (!listVoitures.getVoitures().isEmpty()) {
                voituresLouees.add(listVoitures);
            }
        }
        return voituresLouees;
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, ListVoitures> entry : loueClientVoiture.entrySet()) {
            System.out.println("Client: " + entry.getKey().getNom() + " " + entry.getKey().getPrenom());
            System.out.println("Liste de voitures louées:");
            entry.getValue().affiche();
            System.out.println();
        }
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        Map<Client, ListVoitures> triCroissant = new TreeMap<>(loueClientVoiture);
        return triCroissant;
    }

    public Map<Client, ListVoitures> triNomCroissant() {
        Map<Client, ListVoitures> triCroissant = new TreeMap<>(
                (client1, client2) -> client1.getNom().compareTo(client2.getNom())
        );
        triCroissant.putAll(loueClientVoiture);
        return triCroissant;
    }

    public class VoitureException extends Exception {
        public VoitureException(String message) {
            super(message);
        }
    }
}
