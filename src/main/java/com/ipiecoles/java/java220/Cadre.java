package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Cadre extends Employe {

    private Double coefficient = 1d;

    public Cadre(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Boolean tempsPartiel, String sexe, Double coefficient) {
        super(nom, prenom, matricule, dateEmbauche, salaire, tempsPartiel, sexe);
        this.coefficient = coefficient;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return super.toString() + "Cadre{" +
                "coefficient=" + coefficient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cadre)) return false;
        if (!super.equals(o)) return false;
        Cadre cadre = (Cadre) o;
        return super.equals(o) && Objects.equals(getCoefficient(), cadre.getCoefficient());
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(super.hashCode(), getCoefficient());
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() * coefficient;
    }


    public Integer getNbConges() {
        return (int)Math.round(super.getNbConges() + 1) ;
    }
}
