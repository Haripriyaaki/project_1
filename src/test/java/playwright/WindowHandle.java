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

public class WindowHandle {
	@Test
	public void windowHandle() throws InterruptedException {
		BrowserContext browsercontext;
		Playwright playwright=Playwright.create();
		LaunchOptions launchoptions=new LaunchOptions();
		launchoptions.setHeadless(false);
		launchoptions.setChannel("chrome");
		launchoptions.setArgs(List.of("--start-maximized"));
		Browser browser=playwright.chromium().launch(launchoptions);
		browsercontext=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page=browsercontext.newPage();
		page.navigate( "https://letcode.in/windows");
//		Page popup=page.waitForPopup(()->{
//			page.locator("#multi").click();
//			});
//		popup.waitForLoadState();
//	
//		System.out.println(popup.url());
//	
		page.locator("#multi").click();
		List<Page>tabs=page.context().pages();
		for (Page page2 : tabs) {
			page2.waitForLoadState();
			System.out.println(page2.url());}
			Page alertPage=tabs.get(1);
			browsercontext=browser.newContext(new NewContextOptions().setViewportSize(null));
			//page.locator("#accept").click();
			System.out.println(alertPage.url());
			alertPage.close();
			Page dropdownpage=tabs.get(2);
			browsercontext=browser.newContext(new NewContextOptions().setViewportSize(null));
			System.out.println(dropdownpage.url());
			Locator fruits=dropdownpage.locator("#fruits");
		     fruits.selectOption("Apple");
		     Thread.sleep(3000);
		     dropdownpage.close();
		     page.close();
			
		
		
	}

}
