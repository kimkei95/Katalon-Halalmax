import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject

// =========================
// OPEN BROWSER & LOGIN
// =========================
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

WebUI.setText(findTestObject('HalalMax/Login/FieldEmail'), 'testingkibot@gmail.com')

WebUI.delay(2)

WebUI.setText(findTestObject('HalalMax/Login/Fieldpassword'), 'P@ssword!1')

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/Login/LoginAkun'))

WebUI.delay(5)

WebUI.click(findTestObject('HalalMax/Login/BtnPrimary'))

WebUI.delay(3)

// =========================
// NAVIGASI PENGAJUAN
// =========================
WebUI.click(findTestObject('HalalMax/PelakuUsaha/AjukanSertif'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/KlikDropdownKBLI'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/pilihanKedaiMakanan'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/PengajuanFasilitator'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/BtnKirim'))

WebUI.delay(5)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/PilihJenisProduk'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/MemilihJenisProduk'))

WebUI.delay(3)

// =========================
// AMBIL DATA DDT
// =========================
def data = findTestData('Data Files/Daftar_Produk')

// =========================
// LOOP PRODUK (DDT)
// =========================
for (int i = 1; i <= data.getRowNumbers(); i++) {
    String namaProduk = data.getValue('Produk', i)

    String fotoPath = data.getValue('Foto', i)

    KeywordUtil.logInfo("========== MEMBUAT PRODUK: $namaProduk ==========")

    // Klik tambah produk
    WebUI.waitForElementClickable(findTestObject('HalalMax/PelakuUsaha/Produk1/Tambah Produk'), 20)

    WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Tambah Produk'))

    // Pilih manual
    WebUI.waitForElementClickable(findTestObject('HalalMax/PelakuUsaha/Produk1/Manual'), 20)

    WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Manual'))

    // Input nama produk
    TestObject fieldNama = findTestObject('HalalMax/PelakuUsaha/Produk1/KlikFieldNamaProduk')

    WebUI.waitForElementVisible(fieldNama, 20)

    WebUI.setText(fieldNama, namaProduk)

    WebUI.delay(1)

    // Dynamic klik suggestion
    String dynamicXpath = "//div[contains(., '$namaProduk')]"

    TestObject rekomendasiProduk = new TestObject()

    rekomendasiProduk.addProperty('xpath', ConditionType.EQUALS, dynamicXpath)

    WebUI.waitForElementClickable(rekomendasiProduk, 10)

    WebUI.click(rekomendasiProduk)

    KeywordUtil.logInfo("Berhasil pilih rekomendasi: $namaProduk")

    // Upload foto
    KeywordUtil.logInfo("Upload foto: $fotoPath")

    WebUI.uploadFile(findTestObject('HalalMax/PelakuUsaha/Produk1/AddFotoProduk'), fotoPath)

    // Trigger AI
    WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/GunakanAI'))

    // Tunggu hasil AI (WAJIB biar ga flaky)
    WebUI.delay(5)

    // Klik lanjut
    TestObject btnLanjut = findTestObject('HalalMax/PelakuUsaha/Produk1/LanjutkanButton')

    WebUI.waitForElementClickable(btnLanjut, 20)

    WebUI.click(btnLanjut)

    // Tunggu modal close / reset
    WebUI.delay(2)

    KeywordUtil.logInfo("Produk '$namaProduk' berhasil dibuat")
}

// =========================
// SUBMIT PENGAJUAN
// =========================
WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/KirimPengajuan'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox1'))

WebUI.delay(1)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox2'))

WebUI.delay(1)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/Checkbox3'))

WebUI.delay(1)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Modal-Ikrar/KirimPengajuanIkrar'))

WebUI.delay(3)

// =========================
// PILIH PENDAMPING
// =========================
WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/CariPendaming'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/KlikDropdownLokasiLP3H'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/PilihKabupaten'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/KlikDropdownPilihLP3H'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/PilihLp3h'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/PilihPendampingHalal'))

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/NamaPendamping'))

WebUI.delay(2)

WebUI.setText(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/FieldKodeFasilitator'), 'SEHATI26')

WebUI.delay(2)

WebUI.click(findTestObject('HalalMax/PelakuUsaha/Produk1/Pilih-Jenis-Pengajuan/BtnKirim'))

// =========================
// AMBIL ID DARI URL
// =========================
String currentUrl = WebUI.getUrl()

println('Current URL: ' + currentUrl)

def matcher = currentUrl =~ 'sertifikasi/(\\d+)'

if (matcher.find()) {
    String idPengajuan = matcher.group(1)

    println('ID ditemukan: ' + idPengajuan)
} else {
    KeywordUtil.markFailed('ID tidak ditemukan di URL')
}

// =========================
// SELESAI
// =========================
WebUI.delay(5)

WebUI.closeBrowser()

