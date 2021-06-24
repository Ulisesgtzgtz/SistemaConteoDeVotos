/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lenov
 */
@WebServlet(name = "ConteoVotos", urlPatterns = {"/ConteoVotos"})
public class ConteoVotos extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConteoVotos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConteoVotos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        
        PrintWriter out = response.getWriter();
        
        Connection con = null;                                                                 // Variable, se emplea para realizar la conexion a MySQL. (Proceso de conexion)
        Statement stmt = null;  
        
        int idcas;
        int pan;
        int pri;
        int prd;
        int hagamos;
        int pt;
        int morena;
        int pv;
        int somos;
        int pes;
        int fuerzamexico;
        int rsp;
        int futuro;
        int mc;
        
        idcas = Integer.parseInt(request.getParameter ("CASILLA"));
        pan = Integer.parseInt(request.getParameter ("PAN"));
        pri = Integer.parseInt(request.getParameter("PRI"));
        prd = Integer.parseInt(request.getParameter("PRD"));
        pt = Integer.parseInt(request.getParameter("PT"));
        pv = Integer.parseInt(request.getParameter("PV"));
        somos = Integer.parseInt(request.getParameter("SOMOS"));
        mc = Integer.parseInt(request.getParameter("MC"));
        fuerzamexico = Integer.parseInt(request.getParameter("FUERZAMEXICO"));
        futuro = Integer.parseInt(request.getParameter("FUTURO"));
        hagamos = Integer.parseInt(request.getParameter("HAGAMOS"));
        morena = Integer.parseInt(request.getParameter("MORENA"));
        rsp = Integer.parseInt(request.getParameter("RSP"));
        pes = Integer.parseInt(request.getParameter("PES"));
        

        
        String url = "jdbc:mysql://localhost:3307/votaciones";                                        //Variable, indica donde esta la base de datos, es la liga de conexion. Driver: Base de Datos: Ubicacion: Puerto: Nombre de la base de datos
        String usuario = "root";                                                                   //Variable, usuario de la base de datos. (Siempre es root a menos de haberlo cambiado)
        String contrasena = "12345";
        
        try{
            Object newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();             //Genera una nueva instancia del driver, para crear la conexion con la base de datos.
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            Logger.getLogger(ConteoVotos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            con = DriverManager.getConnection(url, usuario, contrasena);                       //Variable, guarda los parametros de la conexion siempre y cuando existan y coincidan los parametros url, usuario y contraseña.
        }catch(SQLException ex){
            Logger.getLogger(ConteoVotos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(con != null){                                                                       //Condicion, verifica si se realizo la conexion.
            out.println("Se ha establecido una conexión a la base de datos " + "\n " + url );      //Mensaje, notifica la conexion. 
        }
        
        try{
        stmt = con.createStatement(); 
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+pan+"', 1) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+pri+"', 2) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+prd+"', 3) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+pv+"', 4) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+pt+"', 5) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+mc+"', 6) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+morena+"', 7) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+somos+"', 8) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+pes+"', 9) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+hagamos+"', 10) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+futuro+"', 11) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+rsp+"', 12) ");
        stmt.executeUpdate("INSERT INTO casilla_has_candidatos (idCasilla, votosCasilla, idCandidato) VALUES ('"+idcas+"','"+fuerzamexico+"', 13) ");
        
        

        //PreparedStatement ps = null;
        //ps = con.prepareStatement("UPDATE partidopolitico set votos ='"+pan+"' where idPartidoPolitico = 1");
        
        /*ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+pri+"' where idPartidoPolitico = 2");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+prd+"' where idPartidoPolitico = 3");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+pv+"' where idPartidoPolitico = 4");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+pt+"' where idPartidoPolitico = 5");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+mc+"' where idPartidoPolitico = 6");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+morena+"' where idPartidoPolitico = 7");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+somos+"' where idPartidoPolitico = 8");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+pes+"' where idPartidoPolitico = 9");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+hagamos+"' where idPartidoPolitico = 10");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+futuro+"' where idPartidoPolitico = 11");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+rsp+"' where idPartidoPolitico = 12");
        ps = con.prepareStatement("UPDATE partidopolitico set votos = '"+fuerzamexico+"' where idPartidoPolitico = 13");
        */
        out.println("Los valores han sido agregados a la base de datos "); 
        response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/Registro_Consulta.jsp");
        } catch(SQLException e){ 
            System.out.println( e.getMessage());
        } 
  
        finally{ 
            if(con != null){ 
                try{ 
                    con.close(); 
                    stmt.close(); 
                } catch( SQLException e ) { 
                    System.out.println( e.getMessage()); 
                } 

            }
        }
    
    
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
