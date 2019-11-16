package de.hannesbenne;

import java.io.IOException;
import java.sql.SQLException;
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
	
	
	private void addLabel(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		System.out.println("Add label called");

		int grammatur = Integer.parseInt(request.getParameter("grammatur"));
		String artikelnummer = request.getParameter("artikelnummer");
		String sortiment = request.getParameter("sortiment");
		String produktname = request.getParameter("produktbezeichnung");
		String namenszusatz = request.getParameter("namenszusatz"); 
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
		
		Label label = new Label(grammatur, artikelnummer, sortiment, produktname, namenszusatz
				, zutatenliste, barcode, nutritionFacts);
		
		System.out.println("add label" + label.toString());
		
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
