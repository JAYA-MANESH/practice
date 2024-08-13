package hardcodedscripts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class login_with_existing_organization_script3 {
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

		// clicking on the contacts module
		driver.findElement(By.linkText("Contacts")).click();

		if (driver.findElement(By.linkText("Contacts")).isDisplayed()) {
			System.out.println("Contacts page is Displayed");

		} else {
			System.out.println("Contacts page is not Displayed");
			driver.quit();
		}

		// clicking on create new organization button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		if (driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).isDisplayed()) {
			System.out.println("Create new Contact page is Dispalyed");
		} else {
			System.out.println("Create new Contact is not Displayed");
			driver.quit();
		}

		// entering last name details
		driver.findElement(By.name("lastname")).sendKeys("lastnamesfield");

		// clicking on the new button
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();

		// transfering the control to the child window

		String parwin = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();

		for (String ele : allids) {
			if (ele.equals(parwin)) {

			} else {
				driver.switchTo().window(ele);
				driver.findElement(By.id("1")).click();
				System.out.println("added successfully");
			}
		}

		driver.switchTo().window(parwin);
		// saving
		driver.findElement(By.xpath("(//input[@name='button' and @type='submit'] )[1]")).click();

		String conhead = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (conhead.contains("lastnamesfield")) {
			System.out.println("Contact is created with Existing organization");
		} else {
			System.out.println("Contact is Not created with Existing organization");
			driver.quit();
		}

		driver.findElement(By.xpath("//input[@name='Delete']")).click();
		driver.switchTo().alert().accept();

		if (driver.getTitle().contains("Contacts"))
			System.out.println("Contacts Page is Displayed");
		else
			driver.quit();
		Actions act = new Actions(driver);

		// moving to adminster
		act.moveToElement(driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/user.PNG')]")))
				.perform();
		act.moveToElement(driver.findElement(By.linkText("Sign Out"))).click().perform();

		driver.quit();

	}

}
