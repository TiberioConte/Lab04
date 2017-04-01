package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public Studente findStudente(String matricola) {
		Studente s=null;
		String sql="select matricola,cognome,nome "+
					"from studente "+
					"where matricola='146101'";
		try {
			
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement ste = conn.prepareStatement(sql);
			
			ste.setString(1, matricola);
			
			ResultSet rs = ste.executeQuery();
			
			if(rs.next()){
				 s= new Studente(
						rs.getString("matricola"),
						rs.getString("nome"),
						rs.getString("cognome"));
				 
			}
			conn.close();
			return s;

		} catch (SQLException e) {
			// e.printStackTrace();
			//throw new RuntimeException("Errore Db");
			return null;
		}
	}

	public LinkedList<Corso> CorsiStudente(Studente studente) {
		final String sql = "SELECT corso.codins,crediti,nome,pd "+
							"FROM   iscrizione,corso "+
							"WHERE  corso.codins=iscrizione.codins and matricola=?";
		
		List<Corso> corsi = new LinkedList<Corso>();
		
		try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1,studente.getMatricola());
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
		return (LinkedList<Corso>) corsi;
		
		} catch (SQLException e) {
		// e.printStackTrace();
		//throw new RuntimeException("Errore Db");
		return null;
		}	
	}

}
			
