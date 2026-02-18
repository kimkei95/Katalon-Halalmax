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

// --- MULAI SKENARIO ---
// Open website
WebUI.openBrowser('https://staging-halalmaxcert.indonesiancloud.com/')

WebUI.maximizeWindow()

// Login flow
WebUI.click(findTestObject('HalalMax/Login/text'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/PendampingHalal'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/Konfirmasi'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/LoginPendampingHalal'))

WebUI.delay(3)

// Input email
WebUI.click(findTestObject('HalalMax/Login/FieldEmail'))

WebUI.delay(1)

WebUI.setText(findTestObject('HalalMax/Login/FieldEmail'), '081287771165')

// Input password
WebUI.delay(1)

WebUI.click(findTestObject('HalalMax/Login/Fieldpassword'))

WebUI.delay(1)

WebUI.setText(findTestObject('HalalMax/Login/Fieldpassword'), 'Development1Halal.go.id')

// Klik login
WebUI.delay(1)

WebUI.click(findTestObject('HalalMax/Login/LoginAkun'))

WebUI.delay(5)

WebUI.click(findTestObject('HalalMax/PendampingHalal/Pengajuan Sertifikasi Halal/click sidebar'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PendampingHalal/Pengajuan Sertifikasi Halal/Informasi Sertifikasi Halal'))

WebUI.delay(6)

WebUI.click(findTestObject('HalalMax/PendampingHalal/Pengajuan Sertifikasi Halal/SearchBar'))

WebUI.delay(3)

def names = ['3721', '3718', '3720', '3716', '3715', 'ASHAR ADE PUTRA', 'UNAH', 'putri rizki']

def randomName = names[new Random().nextInt(names.size())]

WebUI.setText(findTestObject('Object Repository/HalalMax/PendampingHalal/Pengajuan Sertifikasi Halal/SearchBar'), randomName)

println('Nama yang dipakai: ' + randomName)

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PendampingHalal/Pengajuan Sertifikasi Halal/Lihat'))

WebUI.delay(6)

WebUI.closeBrowser()

