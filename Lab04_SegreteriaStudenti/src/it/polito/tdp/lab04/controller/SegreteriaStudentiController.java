/**
 * Sample Skeleton for 'SegreteriaStudenti.fxml' Controller Class
 */

package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SegreteriaStudentiController {
	Model model;
	
	public void setModel(Model model) {
		this.model=model;
		//inizializzo il menù a tendina
        ComboCorso.getItems().addAll(model.elencoDiTuttiCorsi());
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ComboCorso"
    private ComboBox<Corso> ComboCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscrittiCorso"
    private Button btnCercaIscrittiCorso; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaNome"
    private ImageView btnCercaNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	String matricola=txtMatricola.getText();
    	Studente temp=model.cercaStudentePerMatricola(matricola);
    	if(temp==null){
        		txtResult.appendText("matrcola errata\n");	
        		return;
        	}
    	LinkedList<Corso> corsi=model.tuttiICorsiDelloStudente(temp);
    	if(ComboCorso.getValue()==null){
    	for(Corso c:corsi ){
    		txtResult.appendText(c+"\n");
    	}}
    	else{
    		if(corsi.contains(ComboCorso.getValue()))
    			txtResult.appendText("Studente già iscritto a questo corso\n");
    		else
    			txtResult.appendText("Studente non ancora iscritto a questo corso\n");
    	}
    	

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	Corso corso= ComboCorso.getValue();
    	if(corso==null){
    		txtResult.appendText("Inserire il corso \n");
    		return;
    	}
    	LinkedList<Studente> studenti=model.tuttiGliStudentiIscrittiAlCorso(corso);
    	for(Studente s:studenti ){
    		txtResult.appendText(s+"\n");
    	}
    	}

    @FXML
    void doCercaNome(ActionEvent event) {
    	String matricola=txtMatricola.getText();
    	
    	Studente temp=model.cercaStudentePerMatricola(matricola);
    	
    	if(temp!=null){
    	txtMatricola.setText(temp.getMatricola());
    	txtNome.setText(temp.getNome());
    	txtCognome.setText(temp.getCognome());
    	}else{
    		txtResult.appendText("matrcola errata\n");	
    	}
   

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	String matricola=txtMatricola.getText();
    	Studente studente=model.cercaStudentePerMatricola(matricola);
    	if(studente==null){
        		txtResult.appendText("matrcola errata\n");	
        		return;
        	}
    	Corso corso= ComboCorso.getValue();
    	if(corso==null){
    		txtResult.appendText("Inserire il corso \n");
    		return;
    	}
    	model.iscriviStudente(studente,corso);
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtMatricola.setText("");
    	txtNome.setText("");
    	txtCognome.setText("");
    	txtResult.setText("");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ComboCorso != null : "fx:id=\"ComboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
}
}
