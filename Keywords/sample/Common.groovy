
package sample

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.swing.plaf.basic.BasicButtonListener.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Common {

	//
	@Keyword
	def moveToElement(TestObject element) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement webElement = WebUI.findWebElement(element)
		Actions actions = new Actions(driver)
		actions.moveToElement(webElement).build().perform()
	}



}