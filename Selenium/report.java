public class SearchAndDownloadReportTest {
    private WebDriver driver;
    private String baseUrl = "http://your-covid19-site-url.com";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchAndDownloadReport() {
        driver.get(baseUrl + "/reports");
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys("COVID-19 Cases");
        driver.findElement(By.id("searchButton")).click();
        WebElement reportLink = driver.findElement(By.id("reportDownloadLink"));
        Assert.assertTrue(reportLink.isDisplayed(), "Report download link not displayed.");
        reportLink.click();
        // Verify file download in the Downloads folder if possible
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
