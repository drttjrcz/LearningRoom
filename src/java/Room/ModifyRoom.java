/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Room;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import newpackage.Test;

/**
 *
 * @author rjg
 */
public class ModifyRoom extends HttpServlet {

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
           //  HttpSession session=request.getSession(true);
          //  int i=Integer.parseInt(request.getParameter("i"));
        //    String[][]  data  =  (String[][])session.getAttribute("table_number");
        //    String peopleStr=(String)data[i][2];
        //    int people= Integer.parseInt(peopleStr);
       //      String sizeStr=(String)data[i][2];
        //    int size= Integer.parseInt(sizeStr);
           response.setContentType("text/html;charset=UTF-8");
           request.setCharacterEncoding("UTF-8");
        String number=request.getParameter("num");
        int size=Integer.parseInt(request.getParameter("size"));
        int people=Integer.parseInt(request.getParameter("people"));
           String discri=request.getParameter("discri");
         String mnum=request.getParameter("mnum");
        
     
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String str="update roomtable set size = "+size+", peonum="+people+",discri= '"+discri+"' , mnum= '"+mnum+"' where number = '"+number+"' ";
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModifyRoom</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
               //out.println(data[i][0]+" "+people+" "+size);
               
           try{
           Test DBconnect1 =new Test();
           int n=DBconnect1.exeU(str);
           if(n==0)
           {
               out.println("更新失败");
               
           }
           else
           {
               out.println("更新成功");
           }
            out.println("<a href=\"/LearningRoom/manage/index.jsp\">返回</a>");
            DBconnect1.closeCL();
            DBconnect1.closeSM();
           
            }catch(Exception e)
            {
                 response.setStatus(400, "数据库异常，稍后再试");
                 e.printStackTrace();
            }
           
               out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            
        }catch (Exception e) {
             response.setStatus(400, "数据库异常，稍后再试");
            e.printStackTrace();
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
