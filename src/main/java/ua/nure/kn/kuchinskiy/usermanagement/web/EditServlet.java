package ua.nure.kn.kuchinskiy.usermanagement.web;

import ua.nure.kn.kuchinskiy.usermanagement.User;
import ua.nure.kn.kuchinskiy.usermanagement.db.DatabaseException;
import ua.nure.kn.kuchinskiy.usermanagement.db.ManageUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class EditServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("okButton") != null) {
            ok(req, resp);
        } else if (req.getParameter("cancelButton") != null) {
            cancel(req, resp);
        } else {
            showPage(req, resp);
        }
    }

    private void ok(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUser(req);
        processUser(user.getId(), user);
        req.getRequestDispatcher("/browse").forward(req, resp);
    }

    private void cancel(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) {
    }

    private User getUser(HttpServletRequest req) {
        User user = new User();
        String idStr = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateOfBirth = req.getParameter("dateOfBirth");

        if (idStr != null) {
            user.setId(new Integer(idStr));
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDateOfBirth(LocalDate.parse(dateOfBirth));
        return null;
    }

    private void processUser(Integer id, User user) {
        ManageUser userManager = new ManageUser();
        userManager.update(id, user);
    }
}
