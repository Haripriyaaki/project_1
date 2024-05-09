package playwright;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

public class CodegenScreenRecording {
	
	@Test
	 public void dropDown() {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://www.amazon.in/");
		      page.getByLabel("Select the department you").selectOption("search-alias=nowstore");
		      page.locator("#nav-cover").click();
		      //page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Amazon miniTV")).click(new Locator.ClickOptions()
		      //  .setButton(MouseButton.RIGHT));
		      //Page page1 = context.newPage();
		      //page1.navigate("https://www.amazon.in/minitv?ref_=nav_avod_desktop_topnav");
		      //page1.navigate("https://www.amazon.in/minitv?ref_=nav_avod_desktop_topnav");
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Best Sellers")).click();
		      page.locator("a").filter(new Locator.FilterOptions().setHasText("Godrej aer Twist – Car Air")).click();
		      page.navigate("https://www.amazon.in/Godrej-aer-Twist-Freshener-Fresh/dp/B00NNOE3BW/ref=zg_bs_c_automotive_d_sccl_2/257-9797530-4021661?pd_rd_w=zQQqT&content-id=amzn1.sym.7dd29d48-66c1-486c-967d-2ed40101f2ea&pf_rd_p=7dd29d48-66c1-486c-967d-2ed40101f2ea&pf_rd_r=75J59PEJG0F6YG9KWNS7&pd_rd_wg=tO5pS&pd_rd_r=cb4fdbbf-fe7e-43cd-bf8d-98701bc485eb&pd_rd_i=B00NNOE3BW&th=1");
		      page.getByTitle("Add to Shopping Cart").click();
		      page.locator("#sw-gtc").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Go to Cart")).click();
		   
		    }
		  }

}
