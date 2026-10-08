import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasicTest {

    @Test
    public  void  DemoTest(){
        Playwright playwright = Playwright.create();

//        Using the different Browser Webkit, Chrome, Firefox
//        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));

        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://eventhub.rahulshettyacademy.com/login");
        System.out.println(page.title());
        assertThat(page).hasTitle("EventHub — Discover & Book Events");
        System.out.println("Hello World");

//      Input Text  and Click
//        page.getByLabel("Email").fill("rahulshetty1@yahoo.com");
        page.getByPlaceholder("you@email.com").fill("rahulshetty1@yahoo.com");
        page.getByLabel("Password").fill("Magiclife1!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();


    }
}
