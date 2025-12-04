package common;

import pages.LogInPage;

public class CommonPage {
	
	////this is used to extended by the stepdefination classes so keep only nav and common pages in a files

	public LogInPage loginpage;
	public LogInPage getLogInPage() {
		if (loginpage == null) {
			loginpage = new LogInPage();
		}
		return loginpage;
	}
	

}
