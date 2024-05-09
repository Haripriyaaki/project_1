package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.RecordVideoSize;

public class CodeGen {
	public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get(".//videos//")).setRecordVideoSize(new RecordVideoSize(1280,720)));
	      Page page = context.newPage();
	      page.navigate("https://www.sejda.com/en/index.html");
	      page.navigate("https://www.amazon.in/");
	      page.getByLabel("Select the department you").selectOption("search-alias=alexa-skills");
	      page.getByLabel("Select the department you").selectOption("search-alias=beauty");
	      page.getByLabel("Select the department you").selectOption("search-alias=computers");
//	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Mobiles, Computers")).click();
//	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("All Mobile Accessories")).click();
//	      page.locator("div:nth-child(5) > div > .bxc-grid__content > .bxc-grid__image > a").first().click();
//	   
	    }
	}

}
