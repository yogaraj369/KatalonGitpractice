import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.swing.factory.ActionFactory as ActionFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

'Launch the browser'
WebUI.openBrowser('https://www.amazon.in/')

WebUI.delay(3)

'Verifythe element is a hyperlink'
boolean isLink = WebUI.verifyElementHasAttribute(findTestObject('more list'), 'tabindex', 0)

if (isLink) {
    println('The element is a hyperlink.')
} else {
    println('The element is not a hyperlink.')
}

'Custom keyword for move to the element'
CustomKeywords.'sample.Common.moveToElement'(findTestObject('Object Repository/en'))

WebUI.delay(9)

'Verify '
boolean isnotChecked = WebUI.verifyElementNotChecked(findTestObject('Object Repository/radiobtn'), 10 // Set the timeout value as needed
    )

// Print the result
if (isnotChecked) {
    println('The radio button is not checked.')
} else {
    println('The radio button is checked.')
}

