package steps;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class StepDefinitionsTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(StepDefinitionsTest.class.getName());

    @Before
    public void setUp() {
        super.setUp();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Given("I launch the URL {string}")
    public void i_launch_the_url(String url) {
        logger.info("Launching URL: " + url);
        getDriver().get(url);
    }

    @Then("the title of the page should be {string}")
    public void the_title_of_the_page_should_be(String title) {
        Assert.assertEquals(getDriver().getTitle(), title);
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        getDriver().get("http://the-internet.herokuapp.com/");
    }

    @When("I click on {string} link")
    public void i_click_on_link(String linkText) {
        getDriver().findElement(By.linkText(linkText)).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Then("the text on the page should be {string}")
    public void the_text_on_the_page_should_be(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        String[] expectedTexts = text.split("\\|");
        boolean textFound = false;
        for (String expectedText : expectedTexts) {
            System.out.println("Actual text: " + body.getText()+ "Expected text: " + expectedText);
            if (body.getText().contains(expectedText)) {
                textFound = true;
                break;
            }
        }
        Assert.assertTrue(textFound, "Expected text not found on the page");
    }

    @When("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String option) {
        WebElement dropdown = getDriver().findElement(By.id("dropdown"));
        dropdown.findElement(By.xpath("//option[. = '" + option + "']")).click();
    }

    @Then("{string} should be selected")
    public void should_be_selected(String option) {
        WebElement dropdown = getDriver().findElement(By.id("dropdown"));
        WebElement selectedOption = dropdown.findElement(By.xpath("//option[@selected]"));
        Assert.assertEquals(selectedOption.getText(), option);
    }

    @Then("the following links should be present on the Frames page")
    public void the_following_links_should_be_present_on_the_frames_page(List<String> links) {
        for (String link : links) {
            Assert.assertTrue(getDriver().findElement(By.linkText(link)).isDisplayed());
        }
    }

}