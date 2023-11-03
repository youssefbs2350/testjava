public class Main {
    public static void main(String[] args) {
      
        Agence agence = new Agence("location");


        Client client1 = new Client(1, "ahmed", "mohsen");
        Client client2 = new Client(2, "Janet", "elarafa");


        Voiture vo1 = new Voiture(1, "Toyota", 50.0f);
        Voiture vo2 = new Voiture(2, "Honda", 60.0f);
        Voiture vo3 = new Voiture(3, "Ford", 70.0f);

        try {

            try {
                agence.ajoutVoiture(vo1);
            } catch (Agence.VoitureException e) {
                throw new RuntimeException(e);
            } catch (ListVoitures.VoitureException e) {
                throw new RuntimeException(e);
            }
            agence.ajoutVoiture(vo2);
            agence.ajoutVoiture(vo3);


            agence.loueClientVoiture(client1, vo1);
            agence.loueClientVoiture(client1, vo2);
            agence.loueClientVoiture(client2, vo3);

            agence.afficheLesClientsEtLeursListesVoitures();
        } catch (Agence.VoitureException | ListVoitures.VoitureException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
