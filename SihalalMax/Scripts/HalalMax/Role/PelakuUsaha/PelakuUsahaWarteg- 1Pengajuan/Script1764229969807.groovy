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
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import java.util.Arrays


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

WebUI.setText(findTestObject('HalalMax/Login/FieldEmail'), 'xjnhtwza@sharklasers.com')

WebUI.delay(3)

WebUI.setText(findTestObject('HalalMax/Login/Fieldpassword'), 'P@ssword!1')

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

WebUI.click(findTestObject('HalalMax/PelakuUsaha/pilihanKedaiMinuman'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/PengajuanFasilitator'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/BtnKirim'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/PilihJenisProduk'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/MemilihJenisProduk'))

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

TestObject howToCookField = findTestObject('HalalMax/FIELD')
String wordToDelete = 'garam'

// Tunggu field muncul
WebUI.waitForElementVisible(howToCookField, 15)

// Ambil element asli (lebih stabil untuk contenteditable)
WebElement howToCookElement = WebUiCommonHelper.findWebElement(howToCookField, 20)

// Ambil text via JS (lebih akurat untuk div / React)
String initialText = WebUI.executeJavaScript(
	"return arguments[0].innerText;",
	Arrays.asList(howToCookElement)
)

KeywordUtil.logInfo("Teks awal: " + initialText)

// Jika field kosong, tetap lanjut
if (initialText == null || initialText.trim().isEmpty()) {
	KeywordUtil.logInfo("Field kosong. Lanjut tanpa modifikasi.")
}
else if (!initialText.toLowerCase().contains(wordToDelete)) {
	KeywordUtil.logInfo("Kata '$wordToDelete' tidak ditemukan. Lanjut tanpa modifikasi.")
}
else {

	KeywordUtil.logInfo("Kata ditemukan. Menghapus...")

	String jsScript = """
        var el = arguments[0];
        var word = arguments[1];
        var regex = new RegExp(word, 'gi');
        el.innerHTML = el.innerHTML.replace(regex, '');
        return el.innerText;
    """

	String modifiedContent = WebUI.executeJavaScript(
		jsScript,
		Arrays.asList(howToCookElement, wordToDelete)
	)

	KeywordUtil.logInfo("Teks setelah modifikasi: " + modifiedContent)

	// Trigger React update
	WebUI.executeJavaScript("""
        var el = arguments[0];
        el.dispatchEvent(new Event('input', { bubbles: true }));
        el.dispatchEvent(new Event('change', { bubbles: true }));
    """, Arrays.asList(howToCookElement))

	WebUI.delay(1)
}

// =========================
//  TUNGGU TOMBOL ENABLE
// =========================

TestObject btnLanjut = findTestObject('HalalMax/PelakuUsaha/Produk1/LanjutkanButton')

// Tunggu sampai clickable
WebUI.waitForElementClickable(btnLanjut, 20)

// Klik
WebUI.click(btnLanjut)

KeywordUtil.logInfo("Berhasil klik tombol Lanjutkan")

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/KirimPengajuan'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/BtnYaKali'))
WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox1'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox2'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox3'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox4'))

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

WebUI.setText(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/FieldKodeFasilitator'), 'SEHATI26')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/BtnKirim'))

WebUI.delay(5)

WebUI.closeBrowser()

