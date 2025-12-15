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

// --- Mulai Skenario ---
// 1. Tentukan Test Object
WebUI.openBrowser('https://staging-halalmaxcert.indonesiancloud.com/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('HalalMax/Login/text'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/pegiatUsaha'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/Konfirmasi'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/Masuk'))

WebUI.delay(3)

WebUI.setText(findTestObject('HalalMax/Login/FieldEmail'), 'muhammadakmalalhaqi91@gmail.com')

WebUI.delay(3)

WebUI.setText(findTestObject('HalalMax/Login/Fieldpassword'), '123456')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/LoginAkun'))

WebUI.delay(5)

WebUI.click(findTestObject('HalalMax/Login/2FACheckbox'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/BtnLanjutkan'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/BtnPrimary'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/AjukanSertif'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/KlikDropdownKBLI'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/pilihanKedaiMakanan'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/BtnKirim'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/DropdownJenisKbli'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/PilihJenisKBLI'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Tambah Produk'))

WebUI.delay(3)

WebUI.uploadFile(findTestObject('HalalMax/PelakuUsaha/UploadBatchProduk/UploadVideo'), 'C:\\Users\\akmal\\Downloads\\WhatsApp Video 2025-12-08 at 3.35.02 PM.mp4')

WebUI.waitForElementClickable(findTestObject('HalalMax/PelakuUsaha/UploadBatchProduk/BtnSimpan'),
                              30)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/UploadBatchProduk/BtnSimpan'))
