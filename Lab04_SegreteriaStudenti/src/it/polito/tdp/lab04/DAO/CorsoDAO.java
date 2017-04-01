package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {
		
		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {

				String codice=rs.getString("codins");
				
				int  crediti=rs.getInt("crediti");
				
				String nome=rs.getString("nome");
				
				int  periodo=rs.getInt("pd");
				
				Corso temp=new Corso(codice,crediti,nome,periodo);
				
				corsi.add(temp);
			}
			conn.close();
			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public LinkedList<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
		final String sql = "SELECT iscrizione.matricola,cognome,nome "+
							"FROM   iscrizione,studente "+
							"WHERE  studente.matricola=iscrizione.matricola and codins=?";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1,corso.getCodice());
			ResultSet rs = st.executeQuery();
			

			while (rs.next()) {

				String matricola=rs.getString("matricola");
				String nome=rs.getString("nome");
				String cognome=rs.getString("cognome");
				
				
				Studente temp=new Studente(matricola,nome,cognome);
				
				studenti.add(temp);
			}
			conn.close();
			return (LinkedList<Studente>) studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			//throw new RuntimeException("Errore Db");
			return null;
		}	
		
		
		
		
		
		
	}

	/*
	 * Data una matricola ed il codice insegnamento,
	 * iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		return false;
	}
}
