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

WebUI.click(findTestObject('HalalMax/PelakuUsaha/KBLINonWarteg'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/PengajuanFasilitator'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/BtnKirim'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/NonWarteg/Berikutnya'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/NonWarteg/Selesai'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/NonWarteg/Ajukan'))

WebUI.delay(5)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/PilihJenisProduk'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/NonWarteg/Produk Non Warteg'))

WebUI.delay(3)

// =========================
// LIST PRODUK (DATA UJI)
// =========================

def daftarProduk = [
	"Nasi Goreng Kecombrang",
	"Jus Alpukat",
	"Jus Apel",
	"Jus Mangga",
	"Bulgogi Sapi Sambal Matah",
	"Jus Jambu",
	"Jus Pepaya",
	"Es Tangkuban Perahu",
	"Bulgogi Sapi",
	"Ayam Bakar Bumbu Kacang"
]

def daftarFoto = [
	'C:\\Users\\akmal\\Downloads\\telor balado.jpg',
	'C:\\Users\\akmal\\Downloads\\ayam_bumbu_kuning_tanpa_santan.jpg',
	'C:\\Users\\akmal\\Downloads\\buat es jeruk.jpg',
	'C:\\Users\\akmal\\Downloads\\CAPCAI.jpg',
	'C:\\Users\\akmal\\Downloads\\es kopih.jpg'
	]

	Random random = new Random()
// =========================
// LOOP PRODUK
// =========================

for (String namaProduk : daftarProduk) {

	KeywordUtil.logInfo("========== MEMBUAT PRODUK: $namaProduk ==========")

	WebUI.waitForElementClickable(findTestObject('HalalMax/PelakuUsaha/Produk1/Tambah Produk'), 20)
	WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Tambah Produk'))

	WebUI.waitForElementClickable(findTestObject('HalalMax/PelakuUsaha/Produk1/Manual'), 20)
	WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Manual'))

	// =========================
	// INPUT NAMA PRODUK
	// =========================

	TestObject fieldNama = findTestObject('HalalMax/PelakuUsaha/Produk1/KlikFieldNamaProduk')

	WebUI.waitForElementVisible(fieldNama, 20)
	WebUI.setText(fieldNama, namaProduk)

	WebUI.delay(1) // tunggu dropdown suggestion muncul

	// =========================
	// DYNAMIC CLICK REKOMENDASI
	// =========================

	String dynamicXpath = "//div[contains(normalize-space(), '" + namaProduk + "')]"

	TestObject rekomendasiProduk = new TestObject()
	rekomendasiProduk.addProperty(
		"xpath",
		com.kms.katalon.core.testobject.ConditionType.EQUALS,
		dynamicXpath
	)

	WebUI.waitForElementClickable(rekomendasiProduk, 10)
	WebUI.click(rekomendasiProduk)

	KeywordUtil.logInfo("Berhasil pilih rekomendasi: $namaProduk")

	// =========================
	// UPLOAD FOTO
	// =========================

	String fotoRandom = daftarFoto[random.nextInt(daftarFoto.size())]
	
	KeywordUtil.logInfo("Upload foto: " + fotoRandom)
	
	WebUI.uploadFile(
		findTestObject('HalalMax/PelakuUsaha/Produk1/AddFotoProduk'),
		fotoRandom
	)

	WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Icon-Buang'))

	WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/GunakanAI'))

	// =========================
	// HAPUS KATA GARAM
	// =========================

	TestObject howToCookField = findTestObject('HalalMax/FIELD')
	WebUI.waitForElementVisible(howToCookField, 15)

	WebElement howToCookElement = WebUiCommonHelper.findWebElement(howToCookField, 20)

	String initialText = WebUI.executeJavaScript(
		"return arguments[0].innerText;",
		Arrays.asList(howToCookElement)
	)

	if (initialText != null && initialText.toLowerCase().contains('garam')) {

		String jsScript = """
			var el = arguments[0];
			var regex = new RegExp('garam', 'gi');
			el.innerHTML = el.innerHTML.replace(regex, '');
			return el.innerText;
		"""

		WebUI.executeJavaScript(jsScript, Arrays.asList(howToCookElement))

		WebUI.executeJavaScript("""
			var el = arguments[0];
			el.dispatchEvent(new Event('input', { bubbles: true }));
			el.dispatchEvent(new Event('change', { bubbles: true }));
		""", Arrays.asList(howToCookElement))

		WebUI.delay(1)
	}

	// =========================
	// KLIK LANJUT
	// =========================

	TestObject btnLanjut = findTestObject('HalalMax/PelakuUsaha/Produk1/LanjutkanButton')

	WebUI.waitForElementClickable(btnLanjut, 20)
	WebUI.click(btnLanjut)

	KeywordUtil.logInfo("Produk '$namaProduk' berhasil dibuat")
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

WebUI.setText(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/FieldKodeFasilitator'), 'SEHATI26')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/BtnKirim'))


String currentUrl = WebUI.getUrl()
println("Current URL: " + currentUrl)

def matcher = (currentUrl =~ /sertifikasi\/(\d+)/)

if (matcher.find()) {
	String idPengajuan = matcher.group(1)
	println("ID ditemukan: " + idPengajuan)
	
	// SIMPAN KE GLOBAL
	GlobalVariable.idPengajuan = idPengajuan
	
	println("ID disimpan ke GlobalVariable: " + GlobalVariable.idPengajuan)
	
} else {
	KeywordUtil.markFailed("ID tidak ditemukan di URL")
}
WebUI.delay(5)
WebUI.closeBrowser()


