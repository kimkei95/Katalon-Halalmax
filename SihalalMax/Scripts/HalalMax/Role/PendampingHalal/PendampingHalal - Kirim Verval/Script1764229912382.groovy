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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType

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

// Masuk halaman pengajuan
WebUI.click(findTestObject('HalalMax/PendampingHalal/LihatPengajuan'))

WebUI.delay(3)

// cek button check in kalo udah di klik dia bakal skip 
boolean isCheckInVisible = WebUI.verifyElementPresent(findTestObject('HalalMax/PendampingHalal/BtnCheckIn'), 5, FailureHandling.OPTIONAL)

if (isCheckInVisible) {
    WebUI.comment('Tombol CheckIn ditemukan → Klik tombol CheckIn')

    WebUI.click(findTestObject('HalalMax/PendampingHalal/BtnCheckIn'))

    WebUI.delay(2)
} else {
    WebUI.comment('Tombol CheckIn TIDAK ada → Lanjutkan ke langkah berikutnya')
}

WebUI.click(findTestObject('HalalMax/PendampingHalal/Checkbox1'))

WebUI.delay(1)

for (int i = 2; i <= 11; i++) {
    // Build dynamic XPath
    String dynamicXpath = ('(//div[contains(@class,\'border\') and contains(@class,\'cursor-pointer\') and @tabindex=\'0\'])[' + 
    i) + ']'

    TestObject to = new TestObject('dynamicDropdown')

    to.addProperty('xpath', ConditionType.EQUALS, dynamicXpath)
}

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PendampingHalal/Checkbox2'))

WebUI.delay(3)

List<WebElement> dropdowns = WebUI.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[contains(text(),\'Verifikasi Produk\')]/following::table[1]//div[contains(@class,\'cursor-pointer\')]'), 
    10)

println('Total dropdown ditemukan: ' + dropdowns.size())

String baseXpath = '(//div[contains(@class,\'border\') and contains(@class,\'rounded-lg\')]//table)[4]//tr//div[contains(@class,\'cursor-pointer\')]'

for (int i = 1; ; i++) {
    List<WebElement> dropdownVerifikasi = WebUI.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS, 
            baseXpath), 5)

    if (i > dropdownVerifikasi.size()) {
        break
    }
    
    String dropdownXpathIndexed = ((('(' + baseXpath) + ')[') + i) + ']'

    TestObject dropdownObj = new TestObject('dropdown_' + i)

    dropdownObj.addProperty('xpath', ConditionType.EQUALS, dropdownXpathIndexed)

    // scroll & klik dropdown
    WebUI.scrollToElement(dropdownObj, 3)

    WebUI.click(dropdownObj)

    WebUI.delay(0.3)

    String opsiTidakXpath = dropdownXpathIndexed + '/following::div[normalize-space()=\'Tidak\'][1]'

    TestObject pilihTidak = new TestObject('pilihTidak_' + i)

    pilihTidak.addProperty('xpath', ConditionType.EQUALS, opsiTidakXpath)

    try {
        // tunggu sampai clickable, scroll ke element, lalu klik
        WebUI.waitForElementClickable(pilihTidak, 5)

        WebUI.scrollToElement(pilihTidak, 2)

        WebUI.click(pilihTidak)

        WebUI.delay(0.3)

        println(('Baris ' + i) + ' => dipilih \'Tidak\'')
    }
    catch (Exception e) {
        println((('Gagal klik opsi \'Tidak\' untuk dropdown index ke ' + i) + ' — coba alternatif locator. Error: ') + e.getMessage())

        try {
            TestObject pilihanFallback = new TestObject('pilihanFallback_' + i)

            pilihanFallback.addProperty('xpath', ConditionType.EQUALS, '//div[normalize-space()=\'Tidak\' and not(contains(@style,\'display:none\'))][1]')

            WebUI.waitForElementClickable(pilihanFallback, 3)

            WebUI.click(pilihanFallback)

            println(('Baris ' + i) + ' => dipilih \'Tidak\' via fallback')
        }
        catch (Exception ex2) {
            println(('Fallback juga gagal pada baris ' + i) + '. Lewati baris ini.')
        } 
    } 
}

WebUI.delay(3)

WebUI.uploadFile(findTestObject('HalalMax/PendampingHalal/UploadKTP'), 'C:\\Users\\akmal\\Downloads\\ohim.jpg')

// buat TestObject dinamis untuk tombol "Lihat Media"
TestObject lihatMediaBtn = new TestObject('lihatMedia')

lihatMediaBtn.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Lihat Media\']')

// tunggu tombol muncul
WebUI.waitForElementVisible(lihatMediaBtn, 20)

WebUI.delay(3)

WebUI.uploadFile(findTestObject('HalalMax/PendampingHalal/UploadFotoKunjungan'), 'C:\\Users\\akmal\\Downloads\\kunjungan.jpg')

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/PendampingHalal/TombolGunakan'))

