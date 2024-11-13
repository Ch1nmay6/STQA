public class RegisteredUserLoginTest {
    private WebDriver driver;
    private String baseUrl = "http://your-covid19-site-url.com";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRegisteredUserLogin() {
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("registeredUser");
        driver.findElement(By.id("password")).sendKeys("CorrectPassword");
        driver.findElement(By.id("loginButton")).click();
        WebElement dashboard = driver.findElement(By.id("dashboard"));
        Assert.assertTrue(dashboard.isDisplayed(), "Registered user login failed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
