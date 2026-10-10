import com.microsoft.playwright.*;
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


        assertThat(page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Browse Events →"))).isVisible();

        page.navigate("https://eventhub.rahulshettyacademy.com/admin/events");
        page.locator("#event-title-input").fill("QA Summit Rahul Shetty");
        page.locator("#admin-event-form textarea").fill("Rahul Shetty QA Meetups");
        page.getByLabel("Category").selectOption("Concert");
        page.getByLabel("City").fill("Test City");
        page.getByLabel("Venue").fill("Test Venue");
        page.getByLabel("Event Date & Time").fill("2026-12-18T07:25");
        //page.waitForTimeout(3000);
        page.getByLabel("Price ($)").fill("100");
        page.getByLabel("Total Seats").fill("50");
        page.locator("#add-event-btn").click();
        //Event created!
        assertThat(page.getByText("Event created")).isVisible();

        //Step 2 - Find newly created event in the events page
        page.locator("nav-events").click();
        Locator eventCards = page.getByTestId("event-card");
        eventCards.filter();
        System.out.println(eventCards.count());
        //Visibility of the card which we have added
        Locator targetCard = eventCards.filter(new Locator.FilterOptions().setHasText("QA Summit Rahul Shetty"));
        assertThat(targetCard).isVisible();
    }
}
