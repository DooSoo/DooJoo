import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.ast.ErrorCollector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class ShiptBuy {
	
	@Test
	public void testGroceryPurchase() throws InterruptedException{
		

		ArrayList<String> buylist =new ArrayList<String>();
		buylist.add("Naval Orange");
		buylist.add("Coca Cola Coke Classic");
		
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Selenium\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.shipt.com/");
		driver.findElement(By.xpath("html/body/div[3]/div[1]/header/div/div/nav/ul[2]/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='myid']/div/ion-content/div/div/div[2]/form/div/label[1]/input")).sendKeys("qatest@shipt.com");
		driver.findElement(By.xpath("//*[@id='myid']/div/ion-content/div/div/div[2]/form/div/label[2]/input")).sendKeys("Sh1pt123!");
		//Thread.sleep(4000L);
		driver.findElement(By.xpath("//*[@id='start_shopping_login_button']")).click();
		//type Orange in search
		driver.findElement(By.xpath("html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[2]/ion-header-bar/div[2]/span/div/form/label/input")).sendKeys("Naval Orange");
		Thread.sleep(3000L);
		//click on Search button
		driver.findElement(By.xpath("//button[@class='button button-positive button-icon icon ion-ios-search']")).click();
		//finding how many Add buttons
		List<WebElement> add_button = driver.findElements(By.xpath("//button[@class='button button-positive button-small qty-button add-button if-fade']"));
		System.out.println("total buttons: "+ add_button.size());
		//click on the 1st item
		WebElement firstbutton = add_button.get(0);
		firstbutton.click();
		
		
		//click on Shop by Category link
		driver.findElement(By.xpath("html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view/div/button[1]")).click();
		//Extracting the category list
		List<WebElement> category_item=driver.findElements(By.xpath("//div[@class='list']/ion-item[@class='item category-list-item item-icon-right dark wrap ng-binding']"));
		System.out.println("Number of Category: "+category_item.size());
		Thread.sleep(3000L);
		//Selecting the Beverage category at category3
		WebElement select_category3 = category_item.get(2);
		select_category3.click();
		
		/*
		List<WebElement> item = driver.findElements(By.xpath("//*[@id='productsIonContent']/div/div/div[2]/div/div/div/ion-item/div[1]/p"));
		System.out.println("Number of items: "+item.size());
		Thread.sleep(3000L);
		ErrorCollector errCol4 = new ErrorCollector();
		//*[@id='productsIonContent']/div/div/div[2]/div/div/div[4]/ion-item/div[1]/div[4]/button[2]
		//*[@id='productsIonContent']/div/div/div[2]/div/div/div[1]/ion-item/div[1]/div[4]/button[2]
		
		for(int i=0; i<item.size(); i++){
			
			
			try{
				if (buylist.get(1).contains(item.get(i).getText())){
					System.out.println("Found ----"+item.get(i).getText());
					driver.findElement(By.xpath("//*[@id='productsIonContent']/div/div/div[2]/div/div/div[i+1]/ion-item/div[1]/div[4]/button[2]")).click();
				}
			}catch(Throwable t){
				// code to report error
				System.out.println("item is not found"); 
				System.out.println(t.getMessage());
				//fail = true;
				return;
			
			}
			
		}
		*/
		
		
		//Click Add category
		driver.findElement(By.xpath("//*[@id='productsIonContent']/div/div/div[2]/div/div/div[4]/ion-item/div[1]/div[4]/button[2]")).click();

		//click Cart
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//button[@class='button button-icon icon ion-ios-cart ng-binding']")).click();
		
		//finding how many items in the cart
		Thread.sleep(3000L);
		List<WebElement> totalitems = driver.findElements(By.xpath("//div[@class='col col-50 cart-item-name']"));
		System.out.println("total items: "+ totalitems.size());
		
		//print out items in the cart
		for(int i=0; i<totalitems.size(); i++){
			Thread.sleep(3000L);
			String stuff1 = totalitems.get(i).getText();
			System.out.println("items in cart:"+stuff1);
			if (buylist.contains(totalitems.get(i).getText())){
				Thread.sleep(3000L);
				System.out.println("Found ----"+totalitems.get(i).getText());
			}
		
		}
		driver.close();
		 
	}
	
}


