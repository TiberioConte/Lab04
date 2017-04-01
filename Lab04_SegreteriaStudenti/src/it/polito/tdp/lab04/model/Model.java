package it.polito.tdp.lab04.model;

import java.util.LinkedList;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	
	public LinkedList<Corso> elencoDiTuttiCorsi(){
		CorsoDAO dao=new CorsoDAO();
		return (LinkedList<Corso>) dao.getTuttiICorsi();
		}

	public Studente cercaStudentePerMatricola(String matricola) {
		StudenteDAO dao=new StudenteDAO();
		return dao.findStudente(matricola);
	}
	
	public LinkedList<Studente> tuttiGliStudentiIscrittiAlCorso(Corso corso) {
		// TODO
		CorsoDAO dao=new CorsoDAO();
		return dao.getStudentiIscrittiAlCorso(corso);
		
	}

	public LinkedList<Corso> tuttiICorsiDelloStudente(Studente studente) {
		// TODO Auto-generated method stub
		StudenteDAO dao=new StudenteDAO();
		return dao.CorsiStudente(studente);
	}
	
	
	
	

}
