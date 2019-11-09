package com.presto.qe.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.presto.qe.utils.WebDriverUtils;


public class AmazonHome extends WebDriverUtils {

	private @FindBy(id="twotabsearchtextbox") WebElement searchBoxIdentifier;
	private @FindBy(css="input[value='Go']") WebElement searchButtonIdentifier;
	private @FindBy(id="twotabsearchtextbox") WebElement searchBox;
	private @FindBys({@FindBy(xpath="//div[contains(@class,'result-item') and *//span[text()='Best Seller']]//span[@data-component-type='s-product-image']")}) List<WebElement> bestSellersIdentifier;
	private @FindBy(id="add-to-cart-button") WebElement addToCartButtonIdentifier;
	private @FindBy(xpath="//div[@id='attach-added-to-cart-message']//h4[text()='Added to Cart']") WebElement waitForaddedToCartIdentifier;
	private @FindBy(xpath="//div[contains(@id,'confirm-text-')]") WebElement waitForSuccessfullyAddedToCart;
	private @FindBy(id="hlb-ptc-btn") WebElement proceedToCheckOutIdentifier;
	private @FindBy(id="attach-close_sideSheet-link") WebElement closeAddedToCartIdentifier;
	
	private String bestSellersXpath = "(//div[contains(@class,'result-item') and *//span[text()='Best Seller']]//span[@data-component-type='s-product-image'])";
	
	/**
	 * Constructor of AmazonHome
	 * Initilaize the webdriver and loading amazon page object repository
	 */
	public AmazonHome() {	
		getWebDriver();
		loadAmazonPage();			
		PageFactory.initElements(driver, this);
		
	}
	
	/**
	 * To load Amazon page by reading the url from Properties File
	 */
	public void loadAmazonPage() {
		loadURL(loadProperties.getURL());
	}

	/**
	 * Enter text in search box
	 * 
	 */
	public void typeInSearchBox(String searchText) {
		sendKeys(searchBoxIdentifier, searchText);
	}
	 
	/**
	 * to click on search button
	 */
	public void clickSearchButton() {
		clickElement(searchButtonIdentifier);
	}
	
	/**
	 * to add all best sellers product to the cart
	 */
	public void addAllBestSellers() {
		int iBestSellers = bestSellersIdentifier.size();
		for(int i =1; i<= iBestSellers; i++) {
			clickElementByXpath(bestSellersXpath+"["+i+"]");
			waitForElement(addToCartButtonIdentifier);
			clickElement(addToCartButtonIdentifier);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(isElementExistsByXpath("//div[contains(@id,'confirm-text-')]")) {
				waitForElement(waitForSuccessfullyAddedToCart);
			}
			else if(isElementExistsByID("attach-added-to-cart-message")) {
				waitForElement(waitForaddedToCartIdentifier);
				clickElement(closeAddedToCartIdentifier);
			}
			else {
				try {
					throw new Exception("Unknown Page");
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			
				clickBackButton();
			
				clickBackButton();
			
		}
	}
	
	/**
	 * to quit the webdriver instance
	 */
	public void quit() {
		quitDriver();
	}
}
