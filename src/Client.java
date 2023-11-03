import java.util.Objects;

public class Client {
    private int code;
    private String nom;
    private String prenom;
    public Client(int code, String nom, String prenom) {
this.code = code ;
this.nom= nom ;
this.prenom= prenom ;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String
                                  prenom) {
        this.prenom = prenom;
    }
    public int hashCode() {
return Objects.hash(code,nom,prenom);
    }
    public boolean equals(Object obj) {
        if (obj==null) return false ;
        if (this.getClass() != obj.getClass()) return false ;
        Client l = (Client) obj ;
        return  (this.code == l.code)  ;
    }
    public String toString(){
return "le nom est" + nom + "le prenom est " + prenom + "le code est" + code ;
    }}