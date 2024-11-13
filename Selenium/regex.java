public class RegexTest {
    private WebDriver driver;
    private String baseUrl = "http://your-covid19-site-url.com";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRegex() {
        driver.get(baseUrl + "/signup");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("invalid-email");
        WebElement errorMessage = driver.findElement(By.id("emailError"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Regex test for email validation failed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
