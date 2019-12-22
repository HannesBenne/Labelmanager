package de.hannesbenne;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/LabelControllerServlet")
public class LabelControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbUtil dbUtil;
       
    @Resource(name="jdbc/labelmanager" )
	private DataSource dataSource;
    
    
    @Override
    public void init() throws ServletException{
    	super.init();
    	
    	try {
    		dbUtil = new DbUtil(dataSource);
    	}catch(Exception e){
    		throw new ServletException(e);
    	}
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String command = request.getParameter("command");
		try {
			if(command == null) {
				command = "LIST";
			}
			
			switch(command) {
			case "LIST":
				listLabels(request, response);
				break;
			case "LOAD":
				loadLabel(request,response);
				break;
			case "UPDATE":
				updateLabel(request,response);
				break;
			case "DELETE":
				deleteLabel(request, response);
				break;
			case "SEARCH":
				searchLabel(request,response);
				break;
			default:
				listLabels(request, response);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			String command = request.getParameter("command");
			if(command == null) {
				command = "LIST";
			}
			
			switch(command) {
				case "ADD":
					addLabel(request, response);
					break;
				default:
					listLabels(request, response);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} 
	
	
	private void searchLabel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String searchID = request.getParameter("searchValue");
		List<Label> labels = dbUtil.searchLabels(searchID);
		request.setAttribute("labelList", labels);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("list-labels.jsp");
		requestDispatcher.forward(request, response);
	}

	
	private void updateLabel(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int grammatur = Integer.parseInt(request.getParameter("grammatur"));
		String artikelnummer = request.getParameter("artikelnummer");
		String sortiment = request.getParameter("sortiment");
		String layout = request.getParameter("layout");
		String produktname = request.getParameter("produktbezeichnung");
		String namenszusatz = request.getParameter("namenszusatz");
		String bodentext = request.getParameter("bodentext");
		String zutatenliste = request.getParameter("zutatenliste");
		String barcode = request.getParameter("barcode");
		
		double energieJule = Double.parseDouble(request.getParameter("energie_joule"));
		double energieKalorien = Double.parseDouble(request.getParameter("energie_kalorien"));
		double anteilFett = Double.parseDouble(request.getParameter("fett"));
		double anteilGesaettigteFettsaeure = Double.parseDouble(request.getParameter("gesaettigte_fettsaeuren"));
		double kohlenhydrate = Double.parseDouble(request.getParameter("kohlenhydrate"));
		double zuckerAnteil = Double.parseDouble(request.getParameter("zucker"));
		double eiweissAnteil = Double.parseDouble(request.getParameter("eiweiss"));
		double salzAnteil = Double.parseDouble(request.getParameter("salz"));
		
		NutritionFacts nutritionFacts = new NutritionFacts(energieJule, energieKalorien, anteilFett
				, anteilGesaettigteFettsaeure, kohlenhydrate, zuckerAnteil, eiweissAnteil, salzAnteil);
		
		Label label = new Label(id, grammatur, artikelnummer, sortiment, layout, produktname, namenszusatz, 
				bodentext, zutatenliste, barcode, nutritionFacts);
				
		
		dbUtil.updateLabel(label);
		 
		listLabels(request, response);
		
	}


	private void loadLabel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Label label = dbUtil.getLabel(id);
		request.setAttribute("label", label);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update-label.jsp");
		requestDispatcher.forward(request, response); 
	}


	private void deleteLabel(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		dbUtil.deleteLabel(id);
		listLabels(request, response);
		
	}
	
	
	private void addLabel(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		System.out.println("Add label called");

		int grammatur = Integer.parseInt(request.getParameter("grammatur"));
		String artikelnummer = request.getParameter("artikelnummer");
		String sortiment = request.getParameter("sortiment");
		String layout = request.getParameter("layout");
		String produktname = request.getParameter("produktbezeichnung");
		String namenszusatz = request.getParameter("namenszusatz"); 
		String bodentext = request.getParameter("bodentext");
		String zutatenliste = request.getParameter("zutatenliste");
		String barcode = request.getParameter("barcode");
		
		double energieJule = Double.parseDouble(request.getParameter("energie_joule"));
		double energieKalorien = Double.parseDouble(request.getParameter("energie_kalorien"));
		double anteilFett = Double.parseDouble(request.getParameter("fett"));
		double anteilGesaettigteFettsaeure = Double.parseDouble(request.getParameter("gesaettigte_fettsaeuren"));
		double kohlenhydrate = Double.parseDouble(request.getParameter("kohlenhydrate"));
		double zuckerAnteil = Double.parseDouble(request.getParameter("zucker"));
		double eiweissAnteil = Double.parseDouble(request.getParameter("eiweiss"));
		double salzAnteil = Double.parseDouble(request.getParameter("salz"));
		
		NutritionFacts nutritionFacts = new NutritionFacts(energieJule, energieKalorien, anteilFett
				, anteilGesaettigteFettsaeure, kohlenhydrate, zuckerAnteil, eiweissAnteil, salzAnteil);
		
		Label label = new Label(grammatur, artikelnummer, sortiment, layout, produktname, namenszusatz,
				bodentext, zutatenliste, barcode, nutritionFacts);
		
		dbUtil.addLabel(label);
		 
		response.sendRedirect(request.getContextPath() + "/LabelControllerServlet?command=LIST");
		  
	}
	
	
	private void listLabels(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		List<Label> labels = dbUtil.getLabels();
		request.setAttribute("labelList", labels);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-labels.jsp");
		dispatcher.forward(request, response);
	}
	

}
