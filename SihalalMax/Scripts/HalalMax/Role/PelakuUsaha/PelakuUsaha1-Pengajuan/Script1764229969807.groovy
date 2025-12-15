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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import java.util.Arrays as Arrays
import com.kms.katalon.core.testobject.ConditionType as ConditionType

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

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Manual'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/KlikFieldNamaProduk'))

WebUI.delay(3)

WebUI.setText(findTestObject('HalalMax/PelakuUsaha/Produk1/KlikFieldNamaProduk'), 'Telur Asin')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/MakananTelurAsin'))

WebUI.delay(3)

WebUI.uploadFile(findTestObject('HalalMax/PelakuUsaha/Produk1/AddFotoProduk'), 'C:\\Users\\akmal\\Downloads\\telur asin.jpg')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Icon-Buang'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/GunakanAI'))

WebUI.delay(3)

// =========================
//  HAPUS KATA "GARAM"
// =========================
// Ambil field
TestObject howToCookField = findTestObject('HalalMax/FIELD')

String wordToDelete = 'garam'

// Pastikan field tersedia
WebUI.verifyElementPresent(howToCookField, 10)

// Ambil teks awal
String initialText = WebUI.getText(howToCookField)

if (!(initialText.contains(wordToDelete))) {
	KeywordUtil.logInfo("Kata '$wordToDelete' tidak ditemukan, langsung klik lanjutkan.")

	WebUI.waitForElementClickable(findTestObject('HalalMax/PelakuUsaha/Produk1/LanjutkanButton'), 20)

	WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/LanjutkanButton'))

	return null
}

KeywordUtil.logInfo('Teks Awal: ' + initialText)

// Javascript untuk hapus kata
String jsScript = '\n    var el = arguments[0];\n    var w = arguments[1];\n\n    // Hapus semua kemunculan kata\n    var r = new RegExp(w, "g");\n    el.innerHTML = el.innerHTML.replace(r, "");\n\n    return el.innerHTML;\n'

// Eksekusi JS
WebElement howToCookElement = WebUiCommonHelper.findWebElement(howToCookField, 30)

String modifiedContent = WebUI.executeJavaScript(jsScript, Arrays.asList(howToCookElement, wordToDelete))

KeywordUtil.logInfo('Teks Setelah Modifikasi: ' + modifiedContent)

// =========================
//  TRIGGER REACT STATE UPDATE
// =========================
// Trigger input & change supaya React sadar teks berubah
WebUI.executeJavaScript('\n    var el = arguments[0];\n    el.dispatchEvent(new Event(\'input\', { bubbles: true }));\n    el.dispatchEvent(new Event(\'change\', { bubbles: true }));\n',
	Arrays.asList(howToCookElement))

WebUI.delay(1 // kecil saja cukup
	)

// =========================
//  EXTRA FALLBACK (kadang wajib di Next.js)
// =========================
WebUI.click(howToCookField)

WebUI.delay(1)

// =========================
//  TUNGGU TOMBOL ENABLE
// =========================
TestObject btnLanjut = findTestObject('HalalMax/PelakuUsaha/Produk1/LanjutkanButton')

int timeoutSeconds = 20
boolean clicked = false

for (int i = 0; i < timeoutSeconds; i++) {

	// cek apakah tombol sudah enable
	if (WebUI.verifyElementClickable(findTestObject('HalalMax/PelakuUsaha/Produk1/LanjutkanButton'), FailureHandling.OPTIONAL)) {

		KeywordUtil.logInfo("Tombol Lanjutkan sudah enable di detik ke-${i}, melakukan klik.")
		WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/LanjutkanButton'))
		clicked = true
		break
	}

	// jika belum enable, tunggu 1 detik
	WebUI.delay(1)
}
if (!clicked) {
	KeywordUtil.markFailed("Tombol Lanjutkan tidak pernah enable setelah ${timeoutSeconds} detik.")
	return
} else {
	KeywordUtil.logInfo('Berhasil klik tombol Lanjutkan, melanjutkan ke step selanjutnya.')
}


WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/KirimPengajuan'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox1'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox2'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox3'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/KirimPengajuanIkrar'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/CariPendaming'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/KlikDropdownLokasiLP3H'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/PilihKabupaten'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/KlikDropdownPilihLP3H'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/PilihLp3h'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/PilihPendampingHalal'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/NamaPendamping'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/FieldKodeFasilitator'))

WebUI.delay(3)

WebUI.setText(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/FieldKodeFasilitator'), 'KODEFAS')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/BtnKirim'))

WebUI.delay(5)

WebUI.closeBrowser()

