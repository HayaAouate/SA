package sio.gestionbulletin.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Devoir
{
    private int numeroDevoir;
    private String nomDevoir;
    private String dateDevoir;
    private ArrayList<Etudiant> lesEtudiants;

    public Devoir(int numeroDevoir, String nomDevoir, String dateDevoir) {
        this.numeroDevoir = numeroDevoir;
        this.nomDevoir = nomDevoir;
        this.dateDevoir = dateDevoir;
        this.lesEtudiants = new ArrayList<>();
    }

    public int getNumeroDevoir() {
        return numeroDevoir;
    }

    public String getNomDevoir() {
        return nomDevoir;
    }

    public String getDateDevoir() {
        return dateDevoir;
    }

    public ArrayList<Etudiant> getLesEtudiants() {
        return lesEtudiants;
    }

    public void ajouterEtudiant(Etudiant unEtudiant)
    {
        lesEtudiants.add(unEtudiant);
    }

    public String calculerMoyenneDevoir()
    {
        double moyenneDevoir =0;
        double total = 0;
        for(Etudiant etudiant : lesEtudiants)
        {
            total = total + etudiant.getNote();
        }
        DecimalFormat df = new DecimalFormat("##.##");
        moyenneDevoir = (double) total / lesEtudiants.size();
        return df.format(moyenneDevoir).replace(',','.');
    }
}
