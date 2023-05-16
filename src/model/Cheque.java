package model;

public class Cheque extends Compte{
    private static final double frai=20;

    @Override
    public void depot(double mtn){
        super.depot(mtn-frai);
    }
}