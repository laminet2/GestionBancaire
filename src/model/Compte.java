package model;

import java.util.UUID;

public class Compte {
    protected String id;
    protected String numero;
    protected double solde;
    protected Client client;

    
    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
        this.id=UUID.randomUUID().toString();
    }
    public Compte() {
        this.id=UUID.randomUUID().toString();
    }
    
    public boolean retrait(double mtn ){
        if(mtn<=solde){
            solde-=mtn;
            return true;
        }return false;
    }
    public void depot(double mtn){
        solde+=mtn;
    }
    public boolean virement(double mtn,Compte cpt){
        if(solde>=mtn){
            solde-=mtn;
            cpt.setSolde(cpt.getSolde()+mtn);
            return true;
        }return false;
    }
    
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        long temp;
        temp = Double.doubleToLongBits(solde);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Compte other = (Compte) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
            return false;
        return true;
    }
    
}
