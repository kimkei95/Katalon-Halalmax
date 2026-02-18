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

WebUI.openBrowser('https://staging-halalmaxcert.indonesiancloud.com/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('HalalMax/Login/text'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Login/LP3H'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/Login/Konfirmasi'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Login/MasukSebagaiLP3H'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Login/FieldEmail'))

WebUI.delay(3)

WebUI.setText(findTestObject('Halalmax/Login/FieldEmail'), 'sekretariat@ekonomisyariah.org')

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Login/Fieldpassword'))

WebUI.delay(3)

WebUI.setText(findTestObject('Halalmax/Login/Fieldpassword'), 'Development1Halal.go.id')

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Login/LoginLP3H'))

WebUI.delay(5)

WebUI.click(findTestObject('HalalMax/LP3H/SidebarData/Sidebar-DATA'))

WebUI.delay(5)

WebUI.click(findTestObject('HalalMax/LP3H/SidebarData/DataPelakuUsaha'))

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/LP3H/SidebarData/FieldSearch'))

WebUI.delay(3)

def names = ['INDAR LIANI', 'UNAH', 'ASHAR ADE PUTRA', 'MIRA SETIAWAN', 'RIKO MAHENDRA', 'UMMI MANURUNG', 'NURKHOLIS', 'JL.ARIA SANTIKA, RT/RW -, SUMUR PACING, KARAWACI'
    , 'alamat asal', 'JL. GADING INDAH UTARA X NI 13 NO. 10', 'JL. PASTI CEPAT A7/66', 'DUSUN IVAir Joman', 'BLOK GIRANG']

def randomName = names[new Random().nextInt(names.size())]

WebUI.setText(findTestObject('HalalMax/LP3H/SidebarData/FieldSearch'), randomName)

println('Nama yang dipakai: ' + randomName)

WebUI.delay(3)

WebUI.click(findTestObject('HalalMax/LP3H/SidebarData/IconSearch'))

WebUI.delay(5)

WebUI.closeBrowser()

