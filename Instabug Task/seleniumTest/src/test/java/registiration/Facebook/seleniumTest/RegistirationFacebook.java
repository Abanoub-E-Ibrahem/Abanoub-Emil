package registiration.Facebook.seleniumTest;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistirationFacebook {

	WebDriver driver;
	WebDriverWait wait;
	ArrayList<String> wins;

	@DataProvider(name= "Testdata")
	public static Object [][] Data() {
		return new Object [][] {
			{"abanoub first username", "Instabug@2022"}
		};
	}


	@BeforeTest
	public void openurl() {
		String chromePath = System.getProperty("user.dir")+"\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromePath);
		driver = new ChromeDriver();
		System.out.println("Open URL");
		driver.navigate().to("https://developers.facebook.com/apps/1034951913749569/roles/test-users/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test
	public void case00_login() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("01008685472");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Abasel@0629");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.navigate().to("https://developers.facebook.com/apps/1034951913749569/roles/test-users/");

	}

	@Test(priority = 1, enabled =false)
	public void case01_registar_user() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Create test users')]")).click();
		driver.findElement(By.xpath("//input[contains(@type,'number')]")).click();
		driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys("25");
		driver.findElement(By.xpath("//div[@class='g1fckbup sdgvddc7 b8b10xji okyvhjd0 rpcniqb6 jytk9n0j ojz0a1ch avm085bc mtc4pi7f jza0iyw7 njc9t6cs qhe9tvzt spzutpn9 puibpoiz svsqgeze h706y6tg qbdq5e12 j90q0chr rbzcxh88 h8e39ki1 rgsc13q7 a53abz89 jztyeye0 jdcxz0ji frrweqq6 dfy4e4am b1hd98k5 c332bl9r f1dwqt7s rqkdmjxc if5qj5rh har4n1i8 diwav8v6 nlmdo9b9 tb4cuiq2 s7wjoji2 qnavoh4n d5rc5kzv nmystfjm kojzg8i3 m33fj6rl wy1fu5n8 chuaj5k6 hkz453cq dkjikr3h ay1kswi3 lcvupfea siqinikb ppbiusal gcxdxe9k llt6l64p bmtosu2b hk3wrqk2 pt6x234n']")).click();


		Assert.assertTrue(true);

	}

	@Test(dataProvider = "Testdata", enabled=true)
	public void case02_change_username_and_passw0rd(String name, String password) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[1]/td[6]/div[1]/div[1]")));
		driver.findElement(By.xpath("//tr[1]/td[6]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("(//div[@class='yukb02kx pz2dhob4'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='name']")).clear();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Enter a new password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@placeholder='Confirm the new password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@value='1']")).click();	
		Assert.assertTrue(true);
	}

	@Test
	public void case03_login_with_test_user() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[1]/td[6]/div[1]/div[1]")));
		driver.findElement(By.xpath("//tr[1]/td[6]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("(//div[@class='yukb02kx pz2dhob4'])[6]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		ArrayList<String> wins = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(wins.get(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='_42ft mtm _4jy0 _4jy4 _4jy1 selected _51sy']")));
		driver.findElement(By.xpath("//button[@class='_42ft mtm _4jy0 _4jy4 _4jy1 selected _51sy']")).click();		
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();		
		Assert.assertTrue(true);

	}

	@Test(enabled = false)
	public void case001_normal_registiration() {

		//********This Old case that for normal registration without Test user***********
		//*******************************************************************************
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("01289906512");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("012822215");
		driver.findElement(By.xpath("//select[@id='day']")).click();
		driver.findElement(By.xpath("//select[@id='day']//option[@value='5']")).click();
		driver.findElement(By.xpath("//select[@id='month']")).click();
		driver.findElement(By.xpath("//select[@id='month']//option[@value='2']")).click();
		driver.findElement(By.xpath("//select[@id='year']")).click();
		driver.findElement(By.xpath("//select[@id='year']//option[@value='2004']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();

	}

}
