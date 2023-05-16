package model;

import java.time.LocalDate;
import java.util.UUID;

import javax.annotation.processing.Generated;
import javax.swing.text.StyledEditorKit.BoldAction;


public class Epargne extends Compte{
    private final static double tauxP=0.2;
    private LocalDate  dateDbBlocage;
    private LocalDate dateFinBlocage;

    public static double getTaux(){
        return tauxP;
    }

    public Epargne(){
        super();
    }

    public Epargne(String numero,double solde){
        super(numero,solde);
    }
    @Override
    public boolean retrait(double mtn ){
        if(!periodeBlocage()){
            return super.retrait(mtn);
        }return false;
    }
    @Override
    public  void depot(double mtn){

        if(!periodeBlocage()){
            super.depot(mtn);
        }
    } 

    @Override
    public boolean virement(double mtn,Compte cpt){
        if(!periodeBlocage()){
            return super.virement(mtn, cpt);
        }return false;
    }

    public boolean periodeBlocage(){
        LocalDate toDay= LocalDate.now();
        if(toDay.isBefore(dateDbBlocage) || toDay.isAfter(dateFinBlocage)){
            return false;
        }return true;
    }

}
