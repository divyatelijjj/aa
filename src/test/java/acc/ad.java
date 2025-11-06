package acc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ad {

    private WebDriver driver;

    // Set up WebDriver using WebDriverManager before tests
    @BeforeClass
    public void setUp() {
    	WebDriverManager.firefoxdriver().setup();
    	WebDriverManager.firefoxdriver().setup();

        // Create a FirefoxProfile object
        FirefoxProfile profile = new FirefoxProfile();
        
        // Set preferences in FirefoxProfile
        profile.setPreference("dom.webnotifications.enabled", false);  // Disable notifications
        profile.setPreference("browser.privatebrowsing.autostart", true); // Enable private browsing

        // Create FirefoxOptions and set the profile
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.addArguments("--start-maximized");  // Maximize the window (optional)

        // Initialize FirefoxDriver with the options
        driver = new FirefoxDriver(options);
    }

    // Simple test to check if Google page title is correct
    @Test
    public void testGoogleTitle() {
        // Open Google homepage
        driver.get("https://www.google.com");

        // Get the title of the page
        String title = driver.getTitle();

        // Assert the title to check if it's correct
        Assert.assertEquals(title, "Google");
        System.out.println("hi");
    }

    // Close the driver after tests
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser after the test
        }
    }//sure
} 

