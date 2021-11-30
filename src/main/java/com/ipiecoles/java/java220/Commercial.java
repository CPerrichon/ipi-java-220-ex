package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.text.DecimalFormat;

public class Commercial extends Employe {

    private Double caAnnuel;

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(){}


    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }



    @Override
    public Double getPrimeAnnuelle() {
        if (this.caAnnuel == null){
            return  500d;
        }
        return Math.max(Math.ceil(this.caAnnuel * 0.05),500d);
    }
}
