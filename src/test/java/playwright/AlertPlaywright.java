package playwright;

import java.util.function.Consumer;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertPlaywright {
	@Test
	public void Alert() {
	
	Playwright playwright = Playwright.create();

			Page page = playwright.chromium().launch(new BrowserType.LaunchOptions()

					.setHeadless(false)).newPage();

			page.navigate("https://letcode.in/alert");
	 
			Consumer<Dialog> alert = new Consumer<Dialog>() {

				public void accept(Dialog dialog) {

					System.out.println(dialog.message());

					String defaultValue = dialog.defaultValue();

					System.out.println(defaultValue);

					dialog.dismiss();

					page.offDialog(this);

				}

			};

			page.onDialog(alert);
	

}
}
