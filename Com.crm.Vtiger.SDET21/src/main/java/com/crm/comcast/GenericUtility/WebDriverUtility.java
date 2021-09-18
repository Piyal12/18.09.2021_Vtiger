package com.crm.comcast.GenericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class content webDriver specific generic methods
 * 
 * @author PIYAL
 *
 */
public class WebDriverUtility {

	/**
	 * this methods wait for 20 seconds to load the page
	 * 
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * this method will maximise the window
	 * 
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method will select the dropdown menu using index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * this method will select the dropdown menu using visibleText
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, String Text) {
		Select s = new Select(element);
		s.selectByValue(Text);
	}

	/**
	 * this method will move the mouse into the perticular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverMovetoElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	/**
	 * this method will provide right click into the particular element
	 * 
	 * @param driver
	 * @param element
	 */

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * this method will provide double click into the particular element
	 * 
	 * @param driver
	 * @param element
	 */

	public void doubleClick(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method will accept the alert
	 * 
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	/**
	 * This method will fetch the alert
	 * 
	 * @param driver
	 */

	public String fetchAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		return alt.getText();
	}

	/**
	 * This method will dismiss the alert
	 * 
	 * @param driver
	 */

	public void dismissAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}

	/**
	 * This method will switch to another frame based on index value
	 * 
	 * @param driver
	 * @param index
	 */

	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch to other frame based on id
	 * 
	 * @param driver
	 * @param id
	 */
	public void swithToFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * This Method will switch to other frame based on webelement
	 * 
	 * @param driver
	 * @param frameelement
	 */

	public void swithToFrame(WebDriver driver, WebElement frameelement) {
		driver.switchTo().frame(frameelement);
	}

	/**
	 * This method will switch to other session ID
	 * 
	 * @param driver
	 * @param pertialWinTitle
	 */

	public void swithToWindow(WebDriver driver, String pertialWinTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		while (it.hasNext()) {
			String winid = it.next();
			String actTitle = driver.switchTo().window(winid).getTitle();
			if (actTitle.contains(pertialWinTitle)) {

				break;
			}
		}
	}

	/**
	 * This method will provide explicit wait of visibility of element
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * This method will provide explicit wait of element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementToClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will provide to close the browser
	 * 
	 * @param driver
	 */

	public void closeBrowser(WebDriver driver) {
		driver.close();
	}

	/**
	 * This method wait for the element to be clicked , its custom wait created to
	 * avoid elemenInterAceptable Exception
	 * 
	 * @param element
	 * @throws throwable
	 * 
	 */

	public void waitAndClick(WebElement element) {
		int count = 0;
		while (count < 5) {
			try {
				element.click();
				count++;
			} catch (Exception e) {

			}
		}

	}

}
