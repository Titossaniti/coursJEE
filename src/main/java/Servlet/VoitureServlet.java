package Servlet;

import Entity.Voiture;
import DAO.VoitureDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/voitures")
public class VoitureServlet extends HttpServlet {
    private VoitureDAO voitureDAO;

    @Override
    public void init() throws ServletException {
        voitureDAO = new VoitureDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Voiture> listVoitures = voitureDAO.getAllVoitures();
        request.setAttribute("voitures", listVoitures);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/listeVoitures.jsp");
        dispatcher.forward(request, response);





        //        Voiture entity = new Voiture();
//        entity.setMarque("Marque test");
//        entity.setModel("Model test");
//        voitureDAO.save(entity);
//        request.setAttribute("message", entity);
//        request.getRequestDispatcher("WEB-INF/views/listeVoitures.jsp").forward(request, response);
    }

}
