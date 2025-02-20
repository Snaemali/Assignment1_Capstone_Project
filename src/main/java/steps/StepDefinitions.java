package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions{

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Initialize a new Chrome browser instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the registration page
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        // Fill in the registration form
        driver.findElement(By.name("firstName")).sendKeys("John");
        driver.findElement(By.name("lastName")).sendKeys("Doe");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("userName")).sendKeys("john.doe@example.com");
        driver.findElement(By.name("address1")).sendKeys("123 Main St");
        driver.findElement(By.name("city")).sendKeys("Anytown");
        driver.findElement(By.name("state")).sendKeys("CA");
        driver.findElement(By.name("postalCode")).sendKeys("12345");
        driver.findElement(By.name("country")).sendKeys("UNITED STATES");
        driver.findElement(By.name("email")).sendKeys("john.doe@example.com");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.name("confirmPassword")).sendKeys("password123");

        // Submit the form
        driver.findElement(By.name("submit")).click();

        // Close the browser
        driver.quit();
    }
}
