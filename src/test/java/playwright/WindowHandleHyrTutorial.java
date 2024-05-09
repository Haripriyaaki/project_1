package playwright;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class WindowHandleHyrTutorial {

	@Test
	public void winHandle() throws InterruptedException {
		BrowserContext browsercontext;
		Playwright playwright=Playwright.create();

		LaunchOptions launchoptions=new LaunchOptions();

		launchoptions.setHeadless(false);

		launchoptions.setChannel("chrome");
		launchoptions.setArgs(List.of("--start-maximized"));
		Browser browser=playwright.chromium().launch(launchoptions);
		 browsercontext=browser.newContext(new NewContextOptions().setViewportSize(null));
		Page page=browsercontext.newPage();
		page.navigate("https://letcode.in/windows");
		page.locator("#multi").click();
		List<Page>pages=page.context().pages();
		for (Page page2 : pages) {
		page2.waitForLoadState();
		System.out.println(page2.url());}
		Page alertpage=pages.get(1);
		browsercontext=browser.newContext(new NewContextOptions().setViewportSize(null));
		System.out.println(alertpage.url());
		alertpage.close();
		Page dropdownpage=pages.get(2);
		browsercontext=browser.newContext(new NewContextOptions().setViewportSize(null));
		Locator fruits=dropdownpage.locator("#fruits");
		Thread.sleep(3000);
		fruits.selectOption("Apple");
		Thread.sleep(3000);
		fruits.selectOption("Banana");
		Thread.sleep(3000);
		fruits.selectOption(new SelectOption().setIndex(4));
		
		
		






	}

}
