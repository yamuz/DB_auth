package servlets;

import bitlab.entities.User;
import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/process")
public class AuthServlet extends HttpServlet {
    DBManager dbman;

    public void init(){
        dbman = new DBManager();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String act = request.getParameter("act");
        String redirect="";
        if (act!=null){
            if (act.equals("auth")){
                String login    = request.getParameter("login");
                String password = request.getParameter("password");
                User user      = dbman.getUsers(login, password);

                if (user!=null){
                    redirect = "/process?act=profile";
                } else
                    redirect = "/process?act=home&error=1";
            }
            //jspPage = act;
        }
        response.sendRedirect(redirect);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jspPage = "home";
        String act = request.getParameter("act");

        if(act!=null){
            if(act.equals("home")){
                jspPage = "home";
            }else if(act.equals("profile")){
                jspPage = "profile";
            }
        }

        request.getRequestDispatcher("/"+jspPage+".jsp").forward(request, response);
    }
}

