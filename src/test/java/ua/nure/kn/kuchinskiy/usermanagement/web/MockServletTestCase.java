package ua.nure.kn.kuchinskiy.usermanagement.web;

import com.mockrunner.servlet.BasicServletTestCaseAdapter;
import ua.nure.kn.kuchinskiy.usermanagement.db.ManageUser;

public abstract class MockServletTestCase extends BasicServletTestCaseAdapter {
    private ManageUser userManager;

    protected void setUp() throws Exception {
        super.setUp();
        userManager = new ManageUser();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    protected ManageUser getUserManager() {
        return userManager;
    }
}
