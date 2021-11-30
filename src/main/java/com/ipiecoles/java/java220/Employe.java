package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    public Employe() {
    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche!= null && dateEmbauche.isAfter(LocalDate.now()))
    {
        throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
    }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete()
        {
            Integer getNombreAnneeAnciennete = LocalDate.now().getYear() - getDateEmbauche().getYear();
            return getNombreAnneeAnciennete;
        }

        public static Integer getNbConges()
        {
            return Entreprise.NB_CONGES_BASE;
        }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        Employe employe = (Employe) o;
        return Objects.equals(getNom(), employe.getNom()) && Objects.equals(getPrenom(), employe.getPrenom()) && Objects.equals(getMatricule(), employe.getMatricule()) && Objects.equals(getDateEmbauche(), employe.getDateEmbauche()) && Objects.equals(getSalaire(), employe.getSalaire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom(), getMatricule(), getDateEmbauche(), getSalaire());
    }

    public void  augmenterSalaire(Double prctAug)
    {
        this.salaire = getSalaire() * (1 + prctAug);
    }

}