package hardcodedscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_and_delete_organization_Script1 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// verifying login page
		if (driver.getTitle().contains("vtiger CRM")) {
			System.out.println("Login page is Displayed");
		} else {
			System.out.println("Login page not displayed");
			driver.quit();
		}

		// passing data into the login page
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// verifying home page
		if (driver.getTitle().contains("Home")) {
			System.out.println("Home page is Displayed");
		} else {
			System.out.println("Home page is not Displayed");
			driver.quit();
		}

		// clicking on the organization module
		driver.findElement(By.linkText("Organizations")).click();

		if (driver.findElement(By.linkText("Organizations")).isDisplayed()) {
			System.out.println("organization page is Displayed");

		} else {
			System.out.println("organization page is not Displayed");
			driver.quit();
		}

		// clicking on create new organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		if (driver.findElement(By.xpath("//span[text()='Creating New Organization']")).isDisplayed()) {
			System.out.println("Create new Organization page is Displayed");
		} else {
			System.out.println("Create new Organization page is not Displayed");
			driver.quit();
		}

		// filling create new organization page
		driver.findElement(By.name("accountname")).sendKeys("sampleorganization");

		// clicking on save button
		driver.findElement(By.xpath("(//input[@name='button' and @accesskey='S'])[1]")).click();

		String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (title.contains("sampleorganization")) {
			System.out.println("organization is created successfully");
		} else {
			System.out.println("organization is not Displayed");
			driver.quit();
		}

		// deleting the organization
		driver.findElement(By.xpath("(//input[@name='Delete'])[1]")).click();

		// handling alert
		driver.switchTo().alert().accept();

		// actions class

		Actions act = new Actions(driver);

		// moving to adminster
		act.moveToElement(driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/user.PNG')]")))
				.perform();
		act.moveToElement(driver.findElement(By.linkText("Sign Out"))).click().perform();

		driver.quit();
	}

}
