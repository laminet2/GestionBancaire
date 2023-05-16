package model;

import java.util.ArrayList;
import java.util.UUID;

public class Client {
   private String nom;
   private String prenom;
   private String id;
   private ArrayList <Compte> tabComptes = new ArrayList<Compte>() ;
   
   
public Client(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
    this.id=generateId();
}

public String generateId(){
    return UUID.randomUUID().toString();
}

public Client() {
    this.id=generateId();
}

public void addCompte(Compte cpt){
    tabComptes.add(cpt);
}
public ArrayList<Compte> getCompteArrayList(){
    return tabComptes;
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

public void setPrenom(String prenom) {
    this.prenom = prenom;
}
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
@Override
public String toString() {
    return "Client [nom=" + nom + ", prenom=" + prenom + ", id=" + id + "]";
}
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nom == null) ? 0 : nom.hashCode());
    result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Client other = (Client) obj;
    if (nom == null) {
        if (other.nom != null)
            return false;
    } else if (!nom.equals(other.nom))
        return false;
    if (prenom == null) {
        if (other.prenom != null)
            return false;
    } else if (!prenom.equals(other.prenom))
        return false;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}
   
}
