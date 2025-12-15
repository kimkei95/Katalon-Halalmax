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

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Button Popup Mengerti'))

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Button Lihat'))

WebUI.delay(5)

WebUI.click(findTestObject('Halalmax/Komite Fatwa/Button Lihat Selengkapnya'))

WebUI.delay(2)

WebUI.click(findTestObject('Halalmax/Komite Fatwa/Pengembalian KF/Button Pengembalian (KF)'))

WebUI.delay(2)

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Pengembalian/Klik Alasan Pengembalian'))

WebUI.delay(2)

WebUI.setText(findTestObject('Halalmax/Sekretariat Komite Fatwa/Pengembalian/Klik Alasan Pengembalian'), 'Produk yang digunakan belum sesuai')

TestObject deskripsi = findTestObject('Halalmax/Sekretariat Komite Fatwa/Pengembalian/Klik Alasan Pengembalian')

WebUI.executeJavaScript('arguments[0].dispatchEvent(new Event(\'input\', { bubbles: true }));', Arrays.asList(WebUI.findWebElement(
            deskripsi, 10)))

WebUI.delay(3)

WebUI.uploadFile(findTestObject('Halalmax/Sekretariat Komite Fatwa/Tolak Pengajuan/Ambil Foto atau Video'), 'C:\\Users\\Kibotsky\\Downloads\\ktp fortina.png')

WebUI.delay(5)

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Tolak Pengajuan/Button Gunakan Foto'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Komite Fatwa/Pengembalian KF/Button Lanjutkan Pengembalian (KF)'))

WebUI.delay(5)

WebUI.closeBrowser()

