package ua.nure.kn.kuchinskiy.usermanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.jupiter.api.Test;

class TestUser {
	
	private static final String FULL_NAME = "Ivanov Ivan";
	private static final String FIRST_NAME = "Ivan";
	private static final String LAST_NAME = "Ivanov";
	
	private static final int YEAR_OF_BIRTH = 1999;
	private static final int CURRENT_YEAR = 2018;
	
	private static final int AGE = CURRENT_YEAR - YEAR_OF_BIRTH;
	private static final int DAY_OF_BIRTH = 23;
	private static final int MONTH_OF_BIRTH = 9;
	private User user = new User();
	
	@After
	public void tearDown() throws Exception {}
	
	@Test void testGetAge( ) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
		user.setDateOfBirth(calendar.getTime());
		assertEquals(AGE, user.getAge());
	}
	
	@Test void getFullName() {
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		assertEquals(FULL_NAME, user.getFullName());
	}

}
