package playwright;


	 
	import java.util.List;

	import org.testng.annotations.Test;

	import com.microsoft.playwright.Browser;

	import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

	import com.microsoft.playwright.Playwright;

	import com.microsoft.playwright.BrowserType.LaunchOptions;
	 
	public class WindowHandleMaheshcode {
	 
		BrowserContext browserContext;
	 
		@Test

		public void setUp() throws InterruptedException {

			Playwright playwright = Playwright.create();
	 
			LaunchOptions lp = new LaunchOptions();

			// lp.setChannel("chrome");

			lp.setHeadless(false);

			lp.setArgs(List.of("--start-maximized"));

			lp.setChannel("chrome");
	 
			Browser browser = playwright.chromium().launch(lp);
	 
			browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

			Page page = browserContext.newPage();

			page.navigate("https://letcode.in/windows");
	 
//			Page popup = page.waitForPopup(()->{

//				page.locator("id=home").click();
	 
//			});

//			

//			popup.waitForLoadState();

//			//page.locator("xpath=//a[text()='Drop-Down']").click();

//			System.out.println("window title name is :"+popup.title());

//			System.out.println("window title name is :"+popup.url());

//			page.locator("xpath=//a[text()='Work-Space']").getAttribute("href");

//			popup.close();
	 
			// Frist way
	 
//			Page popup = page.waitForPopup(()->{

//				page.locator("id=multi").click();	

//			});

//			popup.waitForLoadState();

//			System.out.println(popup.url());
	 
			page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(p -> p.context().pages().size() == 3), () -> {

				page.locator("id=multi").click();
	 
			});
	 
			Thread.sleep(2000);

			// Secound way

			page.locator("id=multi").click();

			List<Page> pages = page.context().pages();

			for (Page tabs : pages) {

				tabs.waitForLoadState();

				System.out.println(tabs.url());

			}

			Thread.sleep(2000);

			// BrowserContext browserContext = browser.newContext(new

			// Browser.NewContextOptions().setViewportSize(null));

			Page alertpage = pages.get(1);

			browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

			Thread.sleep(2000);

			page.close();

			Page dropdownpage = pages.get(2);

			browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
			Locator fruits=page.locator("#fruits");
		     fruits.selectOption("Apple");
		    


			Thread.sleep(2000);

			page.close();

			System.out.println("alert page url : " + alertpage.url());

			Thread.sleep(2000);

			System.out.println("alert page text : " + alertpage.textContent("h1"));

			Thread.sleep(2000);
	 
			System.out.println("dropdown  page url : " + dropdownpage.url());

			Thread.sleep(2000);

			System.out.println("dropdown page text : " + dropdownpage.textContent("h1"));

			Thread.sleep(2000);
	 
			page.close();

			playwright.close();
	 
		}

	}



