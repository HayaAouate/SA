package sio.gestionbulletin.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Matiere
{
    private int numeroMatiere;
    private String nomMatiere;
    private ArrayList<Devoir> lesDevoirs;

    public Matiere(int numeroMatiere, String nomMatiere) {
        this.numeroMatiere = numeroMatiere;
        this.nomMatiere = nomMatiere;
        this.lesDevoirs = new ArrayList<>();
    }

    public int getNumeroMatiere() {
        return numeroMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public ArrayList<Devoir> getLesDevoirs() {
        return lesDevoirs;
    }

    public void ajouterDevoir(Devoir unDevoir)
    {
        lesDevoirs.add(unDevoir);
    }

    public String calculerMoyenneMatiere()
    {
        double moyenneMatiere =0;
        double total = 0;
        for (Devoir devoir : lesDevoirs)
        {
            total = total + Double.parseDouble(devoir.calculerMoyenneDevoir());
        }
        DecimalFormat df = new DecimalFormat("##.##");
        moyenneMatiere = (double) total / lesDevoirs.size();
        return df.format(moyenneMatiere);
    }
}
