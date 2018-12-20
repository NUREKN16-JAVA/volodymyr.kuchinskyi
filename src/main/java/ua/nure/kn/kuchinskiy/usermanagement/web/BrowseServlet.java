package ua.nure.kn.kuchinskiy.usermanagement.web;

import ua.nure.kn.kuchinskiy.usermanagement.db.DatabaseException;
import ua.nure.kn.kuchinskiy.usermanagement.db.ManageUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class BrowseServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        browse(req, resp);
    }

    private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection users;
        try {
            ManageUser manageUser = new ManageUser();
            users = manageUser.findAll();
            req.getSession().setAttribute("users", users);
            req.getRequestDispatcher("/browse.jsp").forward(req, resp);
        } catch (DatabaseException e) {


        }

    }
}
