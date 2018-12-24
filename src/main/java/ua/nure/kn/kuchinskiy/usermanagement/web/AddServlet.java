package ua.nure.kn.kuchinskiy.usermanagement.web;

import ua.nure.kn.kuchinskiy.usermanagement.User;
import ua.nure.kn.kuchinskiy.usermanagement.db.DatabaseException;
import ua.nure.kn.kuchinskiy.usermanagement.db.ManageUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends EditServlet {
    protected void processUser(User user) throws DatabaseException {
        ManageUser manageUser = new ManageUser();
        manageUser.create(user);
    }

    protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);

    }
}
