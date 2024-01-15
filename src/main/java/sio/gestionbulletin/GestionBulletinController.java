package sio.gestionbulletin;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import sio.gestionbulletin.Model.Devoir;
import sio.gestionbulletin.Model.Etudiant;
import sio.gestionbulletin.Model.Matiere;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GestionBulletinController implements Initializable
{
    ArrayList<Matiere> lesMatieres;
    Matiere matiereSelectionnee;
    Devoir devoirSelectionne;
    Etudiant etudiantSelectionne;

    @FXML
    private TableView<Matiere> tvMatieres;
    @FXML
    private TableColumn tcNumeroMatiere;
    @FXML
    private TableColumn tcNomMatiere;
    @FXML
    private TableView<Devoir> tvDevoirs;
    @FXML
    private TableColumn tcNumeroDevoir;
    @FXML
    private TableColumn tcNomDevoir;
    @FXML
    private TableView<Etudiant> tvEtudiants;
    @FXML
    private TableColumn tcDateDevoir;
    @FXML
    private TableColumn tcNoteEtudiant;
    @FXML
    private TableColumn tcPrenomEtudiant;
    @FXML
    private TextField txtMoyenneMatiere;
    @FXML
    private TextField txtMoyenneDevoir;
    @FXML
    private TextField txtMoyenneGeneraleEtudiant;
    @FXML
    private Button btnModifier;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        lesMatieres = new ArrayList<>();
        initDatas();

        tcNumeroMatiere.setCellValueFactory(new PropertyValueFactory<>("numeroMatiere"));
        tcNomMatiere.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));

        tcNumeroDevoir.setCellValueFactory(new PropertyValueFactory<>("numeroDevoir"));
        tcNomDevoir.setCellValueFactory(new PropertyValueFactory<>("nomDevoir"));
        tcDateDevoir.setCellValueFactory(new PropertyValueFactory<>("dateDevoir"));

        tcPrenomEtudiant.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tcNoteEtudiant.setCellValueFactory(new PropertyValueFactory<>("note"));

        tcNoteEtudiant.setCellFactory(tc-> new TextFieldTableCell<>(new DoubleStringConverter()));

        tvMatieres.setItems(FXCollections.observableArrayList(lesMatieres));

        tcNoteEtudiant.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent cellEditEvent) {
                TablePosition tablePosition = cellEditEvent.getTablePosition();
                devoirSelectionne.getLesEtudiants().get(tablePosition.getRow()).setNote(Double.parseDouble(cellEditEvent.getNewValue().toString()));
            }
        });
        tvEtudiants.setEditable(true);
    }

    // NE PAS MODIFIER LE CODE DE CETTE METHODE
    public void initDatas()
    {
        Matiere francais = new Matiere(1,"Français");
        Matiere maths = new Matiere(2,"Maths");
        Matiere anglais = new Matiere(3,"Anglais");

        Devoir devoir1 = new Devoir(1,"Devoir n°1","08/10/2023");
        Devoir devoir2 = new Devoir(2,"Devoir n°2","17/11/2023");
        Devoir devoir3 = new Devoir(3,"Devoir n°3","12/12/2023");

        Devoir devoir4 = new Devoir(4,"Devoir n°1","03/09/2023");
        Devoir devoir5 = new Devoir(5,"Devoir n°2","24/11/2023");

        Devoir devoir6 = new Devoir(6,"Devoir n°1","12/09/2023");
        Devoir devoir7 = new Devoir(7,"Devoir n°2","14/10/2023");
        Devoir devoir8 = new Devoir(8,"Devoir n°3","16/11/2023");

        Etudiant etudiant1 = new Etudiant("Enzo",8.5);
        Etudiant etudiant2 = new Etudiant("Noa",11);
        Etudiant etudiant3 = new Etudiant("Lilou",12.5);
        Etudiant etudiant4 = new Etudiant("Milo",14);

        devoir1.ajouterEtudiant(etudiant1);
        devoir1.ajouterEtudiant(etudiant2);
        devoir1.ajouterEtudiant(etudiant3);
        devoir1.ajouterEtudiant(etudiant4);

        etudiant1 = new Etudiant("Enzo",15);
        etudiant2 = new Etudiant("Noa",4);
        etudiant3 = new Etudiant("Lilou",13);
        etudiant4 = new Etudiant("Milo",9);

        devoir2.ajouterEtudiant(etudiant1);
        devoir2.ajouterEtudiant(etudiant2);
        devoir2.ajouterEtudiant(etudiant3);
        devoir2.ajouterEtudiant(etudiant4);

        etudiant1 = new Etudiant("Enzo",5);
        etudiant2 = new Etudiant("Noa",14);
        etudiant3 = new Etudiant("Lilou",11);
        etudiant4 = new Etudiant("Milo",6.5);

        devoir3.ajouterEtudiant(etudiant1);
        devoir3.ajouterEtudiant(etudiant2);
        devoir3.ajouterEtudiant(etudiant3);
        devoir3.ajouterEtudiant(etudiant4);

        etudiant1 = new Etudiant("Enzo",10);
        etudiant2 = new Etudiant("Noa",11.5);
        etudiant3 = new Etudiant("Lilou",14);
        etudiant4 = new Etudiant("Milo",16.5);

        devoir4.ajouterEtudiant(etudiant1);
        devoir4.ajouterEtudiant(etudiant2);
        devoir4.ajouterEtudiant(etudiant3);
        devoir4.ajouterEtudiant(etudiant4);

        etudiant1 = new Etudiant("Enzo",13.5);
        etudiant2 = new Etudiant("Noa",11);
        etudiant3 = new Etudiant("Lilou",17);
        etudiant4 = new Etudiant("Milo",11.5);

        devoir5.ajouterEtudiant(etudiant1);
        devoir5.ajouterEtudiant(etudiant2);
        devoir5.ajouterEtudiant(etudiant3);
        devoir5.ajouterEtudiant(etudiant4);

        etudiant1 = new Etudiant("Enzo",16);
        etudiant2 = new Etudiant("Noa",15);
        etudiant3 = new Etudiant("Lilou",17);
        etudiant4 = new Etudiant("Milo",16.5);

        devoir6.ajouterEtudiant(etudiant1);
        devoir6.ajouterEtudiant(etudiant2);
        devoir6.ajouterEtudiant(etudiant3);
        devoir6.ajouterEtudiant(etudiant4);

        etudiant1 = new Etudiant("Enzo",10.5);
        etudiant2 = new Etudiant("Noa",7);
        etudiant3 = new Etudiant("Lilou",8);
        etudiant4 = new Etudiant("Milo",11);

        devoir7.ajouterEtudiant(etudiant1);
        devoir7.ajouterEtudiant(etudiant2);
        devoir7.ajouterEtudiant(etudiant3);
        devoir7.ajouterEtudiant(etudiant4);

        etudiant1 = new Etudiant("Enzo",6);
        etudiant2 = new Etudiant("Noa",4);
        etudiant3 = new Etudiant("Lilou",7.5);
        etudiant4 = new Etudiant("Milo",5.5);

        devoir8.ajouterEtudiant(etudiant1);
        devoir8.ajouterEtudiant(etudiant2);
        devoir8.ajouterEtudiant(etudiant3);
        devoir8.ajouterEtudiant(etudiant4);

        francais.ajouterDevoir(devoir1);
        francais.ajouterDevoir(devoir2);
        francais.ajouterDevoir(devoir3);

        maths.ajouterDevoir(devoir4);
        maths.ajouterDevoir(devoir5);

        anglais.ajouterDevoir(devoir6);
        anglais.ajouterDevoir(devoir7);
        anglais.ajouterDevoir(devoir8);

        lesMatieres.add(francais);lesMatieres.add(maths);lesMatieres.add(anglais);
    }

    @FXML
    public void tvMatieresClicked(Event event)
    {
        matiereSelectionnee = tvMatieres.getSelectionModel().getSelectedItem();
        tvDevoirs.setItems(FXCollections.observableArrayList(matiereSelectionnee.getLesDevoirs()));
        txtMoyenneMatiere.setText(matiereSelectionnee.calculerMoyenneMatiere());
        txtMoyenneDevoir.setText("");
        txtMoyenneGeneraleEtudiant.setText("");

    }

    @FXML
    public void tvDevoirsClicked(Event event)
    {
        devoirSelectionne = tvDevoirs.getSelectionModel().getSelectedItem();
        tvEtudiants.setItems(FXCollections.observableArrayList(devoirSelectionne.getLesEtudiants()));
        txtMoyenneDevoir.setText(String.valueOf(devoirSelectionne.calculerMoyenneDevoir()));
        txtMoyenneGeneraleEtudiant.setText("");
    }

    @FXML
    public void tvEtudiantsClicked(Event event)
    {







        calculerMoyenneGeneraleEtudiant();
    }

    @FXML
    public void btnModifierClicked(Event event)
    {
        if(tvDevoirs.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sélection d'un devoir");
            alert.setHeaderText("");
            alert.setContentText("Veuillez sélectionner un devoir");
            alert.showAndWait();
        }
        else
        {
            calculerMoyenneGeneraleEtudiant();
        }
    }
    public void calculerMoyenneGeneraleEtudiant()
    {
        int nbDevoirs = 0;
        double total = 0;
        double moyenneEudiant = 0;
        etudiantSelectionne = tvEtudiants.getSelectionModel().getSelectedItem();
        // On calcule la moyenne générale de l'étudiant
        for(Matiere matiere : lesMatieres)
        {
            for (Devoir devoir : matiere.getLesDevoirs())
            {
                for(Etudiant etudiant : devoir.getLesEtudiants())
                {
                    if(etudiant.getPrenom().equals(etudiantSelectionne.getPrenom()))
                    {
                        total = total + etudiant.getNote();
                    }
                }
            }
            nbDevoirs = nbDevoirs +  matiere.getLesDevoirs().size();
        }
        DecimalFormat df = new DecimalFormat("##.##");
        moyenneEudiant = (double)total / nbDevoirs;
        txtMoyenneGeneraleEtudiant.setText(df.format(moyenneEudiant));
        txtMoyenneMatiere.setText(matiereSelectionnee.calculerMoyenneMatiere());
        txtMoyenneDevoir.setText(String.valueOf(devoirSelectionne.calculerMoyenneDevoir()));
    }
}