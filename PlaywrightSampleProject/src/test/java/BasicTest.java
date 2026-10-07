import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class BasicTest {

    @Test
    public  void  DemoTest(){
        Playwright playwright = Playwright.create();
        Browser browser =playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https/event.rahulshettyacademy.com.login");
        System.out.println("Hello World");
    }
}
