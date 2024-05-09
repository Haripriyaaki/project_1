package playwright;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FramesPlaywright {
	
	@Test
	public void handlingFrames() {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/iframe");
		FrameLocator framelocator=page.frameLocator("iframe[title='Rich Text Area']");
		Locator bodylocator=framelocator.locator("#tinymce");
		bodylocator.fill("hello Haripriya how are you");
		
		
	}
	
	@Test()
	public void nestedFrames() {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://letcode.in/frame");
		FrameLocator framelocator=page.frameLocator("#firstFr");
		framelocator.locator("//input[@placeholder='Enter name']").fill("haripriya");
		framelocator.locator("input[name='lname']").fill("pulavarthi");
		FrameLocator innerframe=framelocator.frameLocator("//iframe[@class='has-background-white']");
		innerframe.locator("input[name=email]").fill("queenharipriya@gmail.com");
		
		
	}

}
