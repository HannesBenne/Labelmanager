package de.hannesbenne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;




public class DbUtil {
	private DataSource datasource;

	public DbUtil(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<Label> getLabels() throws SQLException{
		
		List<Label> labels = new ArrayList<Label>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from label;";
		
		try {
			connection = datasource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				int grammatur = resultSet.getInt("grammatur");
				String artikelnummer = resultSet.getString("artikelnummer");
				String sortiment = resultSet.getString("sortiment");
				String layout = resultSet.getString("layout");
				String produktname = resultSet.getString("produktname");
				String namenszusatz = resultSet.getString("namenszusatz");
				String bodentext = resultSet.getString("bodentext");
				String zutatenliste = resultSet.getString("zutatenliste");
				String barcode = resultSet.getString("barcode");
				
				double energieJule = resultSet.getDouble("energie_joule");
				double energieKalorien = resultSet.getDouble("energie_kalorien");
				double anteilFett = resultSet.getDouble("fett");
				double anteilGesaettigteFettsaeure = resultSet.getDouble("gesaettigte_fettsaeuren");
				double kohlenhydrate = resultSet.getDouble("kohlenhydrate");
				double zuckerAnteil = resultSet.getDouble("zucker");
				double eiweissAnteil = resultSet.getDouble("eiweiss");
				double salzAnteil = resultSet.getDouble("salz");
				
				NutritionFacts nutritionFacts = new NutritionFacts(energieJule, energieKalorien
						, anteilFett, anteilGesaettigteFettsaeure, kohlenhydrate, zuckerAnteil
						, eiweissAnteil, salzAnteil);
				
				Label label = new Label(id, grammatur, artikelnummer, sortiment, layout, produktname,
						namenszusatz, bodentext, zutatenliste, barcode, nutritionFacts);
				
				labels.add(label);
			}
			
		}finally {
			close(connection, statement, resultSet);
		}
		Collections.sort(labels, (s1,s2) -> s1.getProduktname().compareTo(s2.getProduktname()));
		return labels;
	}

	private void close(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			
			if(statement != null) {
				statement.close();
			}
			
			if(connection != null) {
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void addLabel(Label label) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = datasource.getConnection();
			String sql = "insert into label"
					+"(grammatur, artikelnummer, sortiment, layout, produktname, namenszusatz, bodentext, zutatenliste, barcode"
					+ ", energie_joule, energie_kalorien, fett, gesaettigte_fettsaeuren, kohlenhydrate"
					+ ", zucker, eiweiss, salz)"
					+  "values"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, label.getGrammatur());
			preparedStatement.setString(2, label.getArtikelnummer());
			preparedStatement.setString(3, label.getSortiment());
			preparedStatement.setString(4, label.getLayout());
			preparedStatement.setString(5, label.getProduktname());
			preparedStatement.setString(6, label.getNamenszusatz());
			preparedStatement.setString(7, label.getBodentext());
			preparedStatement.setString(8, label.getZutatenliste());
			preparedStatement.setString(9, label.getBarcode());
			preparedStatement.setDouble(10, label.getNutritionFacts().getEnergieJule());
			preparedStatement.setDouble(11, label.getNutritionFacts().getEnergieKalorien());
			preparedStatement.setDouble(12, label.getNutritionFacts().getAnteilFett());
			preparedStatement.setDouble(13, label.getNutritionFacts().getAnteilGesaettigteFettsaeure());
			preparedStatement.setDouble(14, label.getNutritionFacts().getKohlenhydrate());
			preparedStatement.setDouble(15, label.getNutritionFacts().getZuckerAnteil());
			preparedStatement.setDouble(16, label.getNutritionFacts().getEiweissAnteil());
			preparedStatement.setDouble(17, label.getNutritionFacts().getSalzAnteil());
			
			preparedStatement.execute();

		}finally {
			close(connection, preparedStatement, null); 
		}
		
	}

	public void deleteLabel(String id) throws SQLException {
		int intID = Integer.parseInt(id);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = datasource.getConnection();
			String sql = "delete from label where id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,intID);
			preparedStatement.execute();
		}finally {
			close(connection, preparedStatement, null);
		}
	}

	public Label getLabel(int id) throws SQLException {
		Label label = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from label where id = ?;";
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				id = resultSet.getInt("id");
				int grammatur = resultSet.getInt("grammatur");
				String artikelnummer = resultSet.getString("artikelnummer");
				String sortiment = resultSet.getString("sortiment");
				String layout = resultSet.getString("layout");
				String produktname = resultSet.getString("produktname");
				String namenszusatz = resultSet.getString("namenszusatz");
				String bodentext = resultSet.getString("bodentext");
				String zutatenliste = resultSet.getString("zutatenliste");
				String barcode = resultSet.getString("barcode");
				
				double energieJule = resultSet.getDouble("energie_joule");
				double energieKalorien = resultSet.getDouble("energie_kalorien");
				double anteilFett = resultSet.getDouble("fett");
				double anteilGesaettigteFettsaeure = resultSet.getDouble("gesaettigte_fettsaeuren");
				double kohlenhydrate = resultSet.getDouble("kohlenhydrate");
				double zuckerAnteil = resultSet.getDouble("zucker");
				double eiweissAnteil = resultSet.getDouble("eiweiss");
				double salzAnteil = resultSet.getDouble("salz");
				
				NutritionFacts nutritionFacts = new NutritionFacts(energieJule, energieKalorien
						, anteilFett, anteilGesaettigteFettsaeure, kohlenhydrate, zuckerAnteil
						, eiweissAnteil, salzAnteil);
				
				label = new Label(id, grammatur, artikelnummer, sortiment, layout, produktname, namenszusatz, bodentext,
						zutatenliste, barcode, nutritionFacts);

				
			} else {
				throw new SQLException("Could not find student id " + id);
			}
		} finally {
			close(connection, preparedStatement, resultSet); 
		}
		return label;
	}

	public void updateLabel(Label label) throws SQLException {
		Connection connection = null;
		PreparedStatement  preparedStatement = null;
		try {
			connection = datasource.getConnection();
			String sql = "update label set"
					+" grammatur=?, artikelnummer=?, sortiment=?, layout = ?, produktname=?, namenszusatz=?, bodentext = ?, zutatenliste=?, "
					+ "barcode=?, energie_joule=?, energie_kalorien=?, fett=?, gesaettigte_fettsaeuren=?, kohlenhydrate=?, "
					+ "zucker=?, eiweiss=?, salz=?"
					+  "where id= ?;";
					
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, label.getGrammatur());
			preparedStatement.setString(2, label.getArtikelnummer());
			preparedStatement.setString(3, label.getSortiment());
			preparedStatement.setString(4, label.getLayout());
			preparedStatement.setString(5, label.getProduktname());
			preparedStatement.setString(6, label.getNamenszusatz());
			preparedStatement.setString(7, label.getBodentext());
			preparedStatement.setString(8, label.getZutatenliste());
			preparedStatement.setString(9, label.getBarcode());
			preparedStatement.setDouble(10, label.getNutritionFacts().getEnergieJule());
			preparedStatement.setDouble(11, label.getNutritionFacts().getEnergieKalorien());
			preparedStatement.setDouble(12, label.getNutritionFacts().getAnteilFett());
			preparedStatement.setDouble(13, label.getNutritionFacts().getAnteilGesaettigteFettsaeure());
			preparedStatement.setDouble(14, label.getNutritionFacts().getKohlenhydrate());
			preparedStatement.setDouble(15, label.getNutritionFacts().getZuckerAnteil());
			preparedStatement.setDouble(16, label.getNutritionFacts().getEiweissAnteil());
			preparedStatement.setDouble(17, label.getNutritionFacts().getSalzAnteil());
			preparedStatement.setInt(18, label.getId());
			
			preparedStatement.execute();
		}finally {
			close(connection, preparedStatement, null);
		}
		
	}

	public List<Label> searchLabels(String searchID) throws SQLException {
		
		List<Label> labels = new ArrayList<Label>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = datasource.getConnection();
			
			if(null != searchID && !"".equals(searchID.trim())) {
				String sql = "select * from label where artikelnummer = ?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, Integer.parseInt(searchID));
			}else {
				String sql = "select * from label";
				preparedStatement = connection.prepareStatement(sql);
			}
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				int grammatur = resultSet.getInt("grammatur");
				String artikelnummer = resultSet.getString("artikelnummer");
				String sortiment = resultSet.getString("sortiment");
				String layout = resultSet.getString("layout");
				String produktname = resultSet.getString("produktname");
				String namenszusatz = resultSet.getString("namenszusatz"); 
				String bodentext = resultSet.getString("bodentext");
				String zutatenliste = resultSet.getString("zutatenliste");
				String barcode = resultSet.getString("barcode");
				
				double energieJule = resultSet.getDouble("energie_joule");
				double energieKalorien = resultSet.getDouble("energie_kalorien");
				double anteilFett = resultSet.getDouble("fett");
				double anteilGesaettigteFettsaeure = resultSet.getDouble("gesaettigte_fettsaeuren");
				double kohlenhydrate = resultSet.getDouble("kohlenhydrate");
				double zuckerAnteil = resultSet.getDouble("zucker");
				double eiweissAnteil = resultSet.getDouble("eiweiss");
				double salzAnteil = resultSet.getDouble("salz");
				
				NutritionFacts nutritionFacts = new NutritionFacts(energieJule, energieKalorien
						, anteilFett, anteilGesaettigteFettsaeure, kohlenhydrate, zuckerAnteil
						, eiweissAnteil, salzAnteil);
				
				Label label = new Label(id, grammatur, artikelnummer, sortiment, layout, produktname, namenszusatz, bodentext, 
						zutatenliste, barcode, nutritionFacts);
				
				labels.add(label);
			}
			
		}finally {
			close(connection, preparedStatement, resultSet);
		}
		
		Collections.sort(labels, (s1,s2) -> s1.getProduktname().compareTo(s2.getProduktname()));
		return labels;
	}




}

