package com.lao
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

package com.example.keywords

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
class dropdownvalidation {


	@Keyword
	def verifyExcelDropdownMatch(String testDataPath, String sheetName, TestObject dropdownObject) {
		// Read the Excel data
		ExcelData testData = findTestData(testDataPath)
		List<Map<String, String>> excelValues = testData.findTestData(sheetName).getAllData()

		// Get the dropdown values
		List<String> dropdownValues = WebUI.getOptionsForSelect(dropdownObject)

		// Verify that each Excel cell value matches a dropdown value
		for (int i = 0; i < excelValues.size(); i++) {
			String cellValue = excelValues[i].get('Column1') // Replace 'Column1' with the name of the column in your Excel sheet
			String dropdownValue = dropdownValues[i]

			KeywordUtil.logInfo('Comparing Excel cell value ' + cellValue + ' with dropdown value ' + dropdownValue)

			WebUI.verifyMatch(cellValue, dropdownValue)
		}
	}
}








@Keyword
def refreshBrowser() {
	KeywordUtil.logInfo("Refreshing")
	WebDriver webDriver = DriverFactory.getWebDriver()
	webDriver.navigate().refresh()
	KeywordUtil.markPassed("Refresh successfully")
}

/**
 * Click element
 * @param to Katalon test object
 */
@Keyword
def clickElement(TestObject to) {
	try {
		WebElement element = WebUiBuiltInKeywords.findWebElement(to);
		KeywordUtil.logInfo("Clicking element")
		element.click()
		KeywordUtil.markPassed("Element has been clicked")
	} catch (WebElementNotFoundException e) {
		KeywordUtil.markFailed("Element not found")
	} catch (Exception e) {
		KeywordUtil.markFailed("Fail to click on element")
	}
}

/**
 * Get all rows of HTML table
 * @param table Katalon test object represent for HTML table
 * @param outerTagName outer tag name of TR tag, usually is TBODY
 * @return All rows inside HTML table
 */
@Keyword
def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
	WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
	List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
	return selectedRows
}
}