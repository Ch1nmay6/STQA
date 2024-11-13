public class LoginTest {
    private WebDriver driver;
    private String baseUrl = "http://your-covid19-site-url.com";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("wrongUser");
        driver.findElement(By.id("password")).sendKeys("wrongPassword");
        driver.findElement(By.id("loginButton")).click();
        WebElement errorMessage = driver.findElement(By.id("loginError"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Login test failed: error message not displayed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
