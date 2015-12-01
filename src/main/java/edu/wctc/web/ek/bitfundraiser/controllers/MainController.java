package edu.wctc.web.ek.bitfundraiser.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import edu.wctc.web.ek.bitfundraiser.entity.Linkedin;
import edu.wctc.web.ek.bitfundraiser.service.LinkedInService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author emmakordik
 */
@WebServlet(name = "MainController", urlPatterns = {"/fundraiser"})
public class MainController extends HttpServlet {

    private static final String DESTINATION_PAGE = "/resuls.jsp";
    private static final String LIST_PAGE = "/listPage.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext sctx = getServletContext();
        WebApplicationContext ctx
                = WebApplicationContextUtils.getWebApplicationContext(sctx);
        LinkedInService service = (LinkedInService) ctx.getBean("lService");

        String action = request.getParameter("action");
        String name = "";
        String destination = DESTINATION_PAGE;

        switch (action) {
            case "list":
                List<Linkedin> list = service.findAll();
                request.setAttribute("list", list);
                destination = LIST_PAGE;
                break;
            case "delete":
                String id = request.getParameter("listId");
                Linkedin p = service.findById(id);
                service.remove(p);
                
                list = service.findAll();
                request.setAttribute("list", list);
                destination = LIST_PAGE;
                break;
            default:
                name = request.getParameter("name");
                String email = request.getParameter("email");

                Linkedin person = new Linkedin();
                person.setName(name);
                person.setEmail(email);
                person.setDate(new Date());
                service.edit(person);

                request.setAttribute("name", name);
        }
    // Forward to destination page
    RequestDispatcher dispatcher
            = getServletContext().getRequestDispatcher(destination);

    dispatcher.forward (request, response);
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
