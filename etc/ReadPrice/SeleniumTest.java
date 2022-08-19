import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";	// 드라이버 ID
	public static final String WEB_DRIVER_PATH = "C:\\xampp\\htdocs\\study\\JAVA\\PriceRead\\exe\\chromedriver.exe";	// 드라이버 경로
//	public static final String WEB_DRIVER_PATH = "./exe/chromedriver.exe";	// 드라이버 경로(상대경로로 작성해도 작동하는 것 같음)

	public static void main(String[] args) {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		ChromeOptions options = new ChromeOptions();
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");	// google.com 으로 이동
		
		driver.findElement(By.name("q")).sendKeys("꿈꾸는 개발자 yong");	// 검색 창에 검색어 입력
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);			// Enter 키 입력
		
		driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div.NJo7tc.Z26q7c.UK95Uc.uUuwM.jGGQ5e > div > a > h3")).click();	// 블로그 링크 클릭
	}

}
