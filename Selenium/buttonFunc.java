public class ButtonFunctionalityTest {
    private WebDriver driver;
    private String baseUrl = "http://your-covid19-site-url.com";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testButtonFunctionality() {
        driver.get(baseUrl + "/dashboard");
        WebElement refreshButton = driver.findElement(By.id("refreshButton"));
        Assert.assertTrue(refreshButton.isEnabled(), "Refresh button is not enabled.");
        refreshButton.click();
        WebElement updatedContent = driver.findElement(By.id("updatedContent"));
        Assert.assertTrue(updatedContent.isDisplayed(), "Button test failed: content not updated.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
