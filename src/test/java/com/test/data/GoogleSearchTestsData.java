package com.test.data;

import org.testng.annotations.DataProvider;

public class GoogleSearchTestsData {

	@DataProvider(name = "dataForTests")
	public static Object[][] dataForTests() {
		return new Object[][] { { "qaz", "qaz" }, { "wsx", "wsx" }, { "edc", "edc" } };
	}

}
