package sio.gestionbulletin.Model;

public class Etudiant
{
    private String prenom;
    private double note;

    public Etudiant(String prenom, double note) {
        this.prenom = prenom;
        this.note = note;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
