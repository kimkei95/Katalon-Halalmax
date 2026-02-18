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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.testobject.ConditionType as ConditionType

String idPengajuan = GlobalVariable.idPengajuan

println('ID diterima di Sekretariat KF: ' + idPengajuan)

if ((idPengajuan == null) || idPengajuan.trim().isEmpty()) {
    KeywordUtil.markFailed('ID Pengajuan kosong! Flow sebelumnya gagal.')
}

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://staging-halalmaxcert.indonesiancloud.com/')

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Pilih Role'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Role Sekretariat KF'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Button Konfirmasi'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Masuk sebagai sekretariat komite fatwa'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/Field Email'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.setText(findTestObject('HalalMax/Login/Field Email'), 'WIMPYAN')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/Field Password'))

WebUI.delay(3)

WebUI.setText(findTestObject('HalalMax/Login/Field Password'), 'Development1Halal.go.id')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/Button Masuk'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Button Popup Mengerti'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Penugasan/Sidebar Ambiil Penugasan e2e'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PendampingHalal/RadioTerbaru'))

WebUI.delay(3)

// ==========================================
// CARI DAN KLIK "AMBIL PENGAJUAN" BERDASARKAN ID
// ==========================================
String dynamicXpath =
"//button[normalize-space()='Ambil Penugasan' and " +
"ancestor::*[.//*[normalize-space()='" + idPengajuan + "']]]"

TestObject btnAmbilPengajuan = new TestObject('btnAmbilPengajuanDynamic')
btnAmbilPengajuan.addProperty('xpath', ConditionType.EQUALS, dynamicXpath)

WebUI.waitForElementPresent(btnAmbilPengajuan, 20)
WebUI.waitForElementClickable(btnAmbilPengajuan, 20)
WebUI.click(btnAmbilPengajuan)

println('Berhasil klik Ambil Pengajuan untuk ID: ' + idPengajuan)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Penugasan/Button Kembali e2e'))

WebUI.delay(5)

WebUI.click(findTestObject('HalalMax/PendampingHalal/RadioTerbaru'))

WebUI.delay(3)

// ===============================
// CLICK BUTTON LIHAT BERDASARKAN ID
// ===============================
String lihatButtonXpath = ('//tr[.//p[normalize-space()=\'' + idPengajuan) + '\']]//div[h1[normalize-space()=\'Lihat\']]'

TestObject btnLihat = new TestObject('btnLihatDynamic')

btnLihat.addProperty('xpath', ConditionType.EQUALS, lihatButtonXpath)

WebUI.waitForElementClickable(btnLihat, 20)

WebUI.click(btnLihat)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Penugasan/TandaiOK e2e'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Penugasan/btn Iya E2e'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Penugasan/Distribusi ke Komite e2e'))

WebUI.delay(3)

// ===============================================
// CARI DAN KLIK CHECKBOX BERDASARKAN ID PENGAJUAN
// ===============================================
String checkboxXpath = ('//tr[.//*[normalize-space()=\'' + idPengajuan) + '\']]//input[@type=\'checkbox\']'

TestObject checkbox = new TestObject('checkboxDynamic')

checkbox.addProperty('xpath', ConditionType.EQUALS, checkboxXpath)

WebUI.waitForElementClickable(checkbox, 20)

WebUI.click(checkbox)

println('Checkbox berhasil diklik untuk ID: ' + idPengajuan)

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Penugasan/Distribusi Ke Komite- Distribusi Button'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Penugasan/Dropdown Distribusi e2e'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Penugasan/Pilih Distribusi KFZULFA e2e'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Sekretariat Komite Fatwa/Ambil Penugasan/Btn Simpan e2e'))

WebUI.delay(3)

WebUI.closeBrowser()

