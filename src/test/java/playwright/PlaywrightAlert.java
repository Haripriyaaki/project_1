package playwright;

import java.util.List;
import java.util.function.Consumer;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightAlert {
	@Test()
	public void Simplealert() {
		BrowserContext browsercontext;
		Playwright playwright =Playwright.create();
		LaunchOptions launchoptions=new LaunchOptions() ;
		launchoptions.setChannel("chrome");
		launchoptions.setHeadless(false);
		launchoptions.setArgs(List.of("--start-maximized"));
		Browser browser=playwright.chromium().launch(launchoptions);
	    browsercontext= browser.newContext(new NewContextOptions().setViewportSize(null)); 
	    Page page=browsercontext.newPage();
	    page.navigate("https://letcode.in/alert");
	    page.onDialog(dialog->{
	    	System.out.println(dialog.message());
	    	dialog.accept();
	    });
	    page.locator("#accept").click();
		
	}
	@Test
	public void PromptAlert() {
		BrowserContext browsercontext;
		Playwright playwright=Playwright.create();
		LaunchOptions launchoptions=new LaunchOptions();
		launchoptions.setChannel("chrome");
		launchoptions.setArgs(List.of("--start-maximized"));
		launchoptions.setHeadless(false);
		Browser browser=playwright.chromium().launch(launchoptions);
		browsercontext=browser.newContext(new NewContextOptions().setViewportSize(null));
		Page page=browsercontext.newPage();
		page.navigate("https://letcode.in/alert");
		page.onDialog(dialog->{
			System.out.println(dialog.message());
			dialog.accept("haripriya");

		});
		page.locator("#prompt").click();
		System.out.println(page.locator("#myName").textContent());
	}
     
	@Test
	public void confirmAlert() {
		Playwright playwright=Playwright.create();
		LaunchOptions launchoptions=new LaunchOptions();
		launchoptions.setArgs(List.of("--start-maximized"));
		launchoptions.setChannel("chrome");
		launchoptions.setHeadless(false);
		Browser browser=playwright.chromium().launch(launchoptions);
		BrowserContext browsercontext=browser.newContext(new NewContextOptions().setViewportSize(null));
		Page page=browsercontext.newPage();
		page.navigate("https://letcode.in/alert");
		page.onceDialog(dialog->{
			System.out.println(dialog.message());
			dialog.dismiss();
		});
		page.locator("#confirm").click();
	}
	// when we have more prompt alerts we can not use above method we use ofdialog method in this we use this keyword
	// this keyword is not used in lambda functions.so we use consumer function
	//java 1.7 below we can not use lambda function so in that case we override the method and perform the operation
	//above 8 version onwards we use lambda functions.
	
	
	@Test
	public void Handle2AlertsAtaTime() {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setArgs(List.of("--start-maximized")).setChannel("chrome").setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://letcode.in/alert");
		Consumer<Dialog> alert=new Consumer<Dialog>() {

			
			public void accept(Dialog dialog) {
				System.out.println(dialog.message());
				String defaultvalue=dialog.defaultValue();
				System.out.println(defaultvalue);
				dialog.accept("haripriya");
				page.offDialog(this);

			}
			
		};
		page.onDialog(alert);
		page.locator("#prompt").click();
		System.out.println(page.locator("#myName").textContent());
		
		
		
		page.onDialog(a->{
			System.out.println(a.message());
			a.dismiss();
			page.offDialog(alert);
		});

        page.locator("#accept").click();
	    
	    page.onceDialog(d->{
			System.out.println(d.message());
			d.accept();
		});
		page.locator("#confirm").click();

	    
	    
	    

	}
	
	@Test()
	public void handlingAlertsInAnotherWay() {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setArgs(List.of("--start-maximized")).setChannel("chrome").setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://letcode.in/alert");
		page.onceDialog(dialog ->{
			System.out.println(dialog.message());
			String defaultvalue=dialog.defaultValue();
			System.out.println(defaultvalue);
			dialog.accept("haripriyavamsi");
			
		});
		page.locator("#prompt").click();
		System.out.println(page.locator("#myName").textContent());
		
		page.onceDialog(a->{
			System.out.println(a.message());
			a.dismiss();
				
		});
        page.locator("#accept").click();
        
        page.onDialog(alert->{
        	System.out.println(alert.message());
        	alert.accept();
        	
        });
	page.locator("#confirm").click();


		
	}
	

}
