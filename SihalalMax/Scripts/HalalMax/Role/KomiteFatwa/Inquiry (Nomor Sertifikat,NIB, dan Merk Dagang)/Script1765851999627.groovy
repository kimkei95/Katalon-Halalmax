import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.annotation.Keyword as Keyword

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://staging-halalmaxcert.indonesiancloud.com/')

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Pilih Role'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Komite Fatwa/Ambil Role Komite Fatwa'))

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Button Konfirmasi'))

WebUI.delay(2)

WebUI.click(findTestObject('Halalmax/Komite Fatwa/Masuk Sebagai Komite Fatwa'))

WebUI.click(findTestObject('Halalmax/Login/Field Email'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Halalmax/Login/Field Email'), 'KF.ZULFA')

WebUI.click(findTestObject('Halalmax/Login/Field Password'))

WebUI.setText(findTestObject('Halalmax/Login/Field Password'), 'Development1Halal.go.id')

WebUI.click(findTestObject('Halalmax/Login/Button Masuk'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Button Popup Mengerti'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Komite Fatwa/Inquiry/Navbar Inquiry'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/Komite Fatwa/Inquiry/Field Nomor Sertifikat'))

WebUI.delay(2)

WebUI.setText(findTestObject('HalalMax/Komite Fatwa/Inquiry/Field Nomor Sertifikat'), 'ID32410032221271225')

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/Komite Fatwa/Inquiry/Field Nomor NIB'))

WebUI.delay(2)

WebUI.setText(findTestObject('HalalMax/Komite Fatwa/Inquiry/Field Nomor NIB'), '1205230062308')

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/Komite Fatwa/Inquiry/Field Merk Dagang'))

WebUI.delay(3)

WebUI.setText(findTestObject('HalalMax/Komite Fatwa/Inquiry/Field Merk Dagang'), 'NIDA')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Komite Fatwa/Inquiry/Inquiry(Klik Lihat)'))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('HalalMax/Komite Fatwa/Inquiry/Element Untuk Scroll Page'), 5)

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Komite Fatwa/Inquiry/Button Lihat (Inquiry)'))

WebUI.delay(5)

WebUI.closeBrowser()

