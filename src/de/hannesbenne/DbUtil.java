package de.hannesbenne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
				String produktname = resultSet.getString("produktname");
				String namenszusatz = resultSet.getString("namenszusatz"); 
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
				
				Label label = new Label(id, grammatur, artikelnummer, sortiment, produktname
						, namenszusatz, zutatenliste, barcode, nutritionFacts);
				
				labels.add(label);
			}
			
		}finally {
			close(connection, statement, resultSet);
		}
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
					+"(grammatur, artikelnummer, sortiment, produktname, namenszusatz, zutatenliste, barcode"
					+ ", energie_joule, energie_kalorien, fett, gesaettigte_fettsaeuren, kohlenhydrate"
					+ ", zucker, eiweiss, salz)"
					+  "values"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, label.getGrammatur());
			preparedStatement.setString(2, label.getArtikelnummer());
			preparedStatement.setString(3, label.getSortiment());
			preparedStatement.setString(4, label.getProduktname());
			preparedStatement.setString(5, label.getNamenszusatz());
			preparedStatement.setString(6, label.getZutatenliste());
			preparedStatement.setString(7, label.getBarcode());
			preparedStatement.setDouble(8, label.getNutritionFacts().getEnergieJule());
			preparedStatement.setDouble(9, label.getNutritionFacts().getEnergieKalorien());
			preparedStatement.setDouble(10, label.getNutritionFacts().getAnteilFett());
			preparedStatement.setDouble(11, label.getNutritionFacts().getAnteilGesaettigteFettsaeure());
			preparedStatement.setDouble(12, label.getNutritionFacts().getKohlenhydrate());
			preparedStatement.setDouble(13, label.getNutritionFacts().getZuckerAnteil());
			preparedStatement.setDouble(14, label.getNutritionFacts().getEiweissAnteil());
			preparedStatement.setDouble(15, label.getNutritionFacts().getSalzAnteil());
			
			preparedStatement.execute();
			System.out.println(preparedStatement);
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


}

