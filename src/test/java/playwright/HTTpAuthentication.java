package playwright;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HTTpAuthentication {
	@Test()
	public void basicAuth() {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext browsercontext=browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin","admin"));
		Page page=browsercontext.newPage();
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		System.out.println(page.locator("//h3").textContent());
	}

}
