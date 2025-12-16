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
import com.kms.katalon.core.testobject.ConditionType

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://staging-halalmaxcert.indonesiancloud.com/')

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Pilih Role'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Ambil Role Sekretariat KF'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Button Konfirmasi'))

WebUI.delay(2)

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Masuk sebagai sekretariat komite fatwa'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Login/Field Email'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.setText(findTestObject('Halalmax/Login/Field Email'), 'WIMPYAN')

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Login/Field Password'))

WebUI.delay(3)

WebUI.setText(findTestObject('Halalmax/Login/Field Password'), 'Development1Halal.go.id')

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Login/Button Masuk'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Button Popup Mengerti'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Sidebar/clickSidebar'))

WebUI.delay(3)

WebUI.click(findTestObject('Halalmax/Sekretariat Komite Fatwa/Sidebar/submenuInquiry'))


def randomFillPair(
	TestObject fieldID,
	TestObject fieldPendaftaran,
	TestObject dropdownStatus,
	List<Map> dataPairs
) {

	def pair = dataPairs[new Random().nextInt(dataPairs.size())]

	WebUI.comment("Selected ID=${pair.id}, REG=${pair.pendaftaran}, STATUS=${pair.status}")


	WebUI.waitForElementVisible(fieldID, 5)
	WebUI.setText(fieldID, pair.id)

	
	WebUI.waitForElementVisible(fieldPendaftaran, 5)
	WebUI.setText(fieldPendaftaran, pair.pendaftaran)


	WebUI.waitForElementClickable(dropdownStatus, 5)
	WebUI.click(dropdownStatus)

	WebUI.delay(1)


	TestObject optionStatus = findTestObject(
		'Halalmax/Sekretariat Komite Fatwa/Inquiry/StatusPermohonanDropdown/PenerbitanSertifikasiOlehKF'
	)

	WebUI.waitForElementVisible(optionStatus, 10)


	WebUI.executeJavaScript(
		"arguments[0].scrollIntoView({block:'center'});",
		Arrays.asList(WebUI.findWebElement(optionStatus, 10))
	)

	WebUI.executeJavaScript(
		"arguments[0].dispatchEvent(new MouseEvent('mousedown',{bubbles:true}));" +
		"arguments[0].dispatchEvent(new MouseEvent('mouseup',{bubbles:true}));" +
		"arguments[0].click();",
		Arrays.asList(WebUI.findWebElement(optionStatus, 10))
	)

	WebUI.comment("Status Permohonan berhasil dipilih")
}

		
randomFillPair(
    findTestObject('Halalmax/Sekretariat Komite Fatwa/Inquiry/NomorID'),
    findTestObject('Halalmax/Sekretariat Komite Fatwa/Inquiry/NomorPendaftaran'),
    findTestObject('Halalmax/Sekretariat Komite Fatwa/Inquiry/StatusPermohonanDropdown/DropdownStatusPermohonan'),
    [
        [id:'3501', pendaftaran:'SH2025-1-623438', status:'Penerbitan Sertifikasi oleh Komite Fatwa'],
        [id:'3446', pendaftaran:'SH2025-1-623389', status:'Penerbitan Sertifikasi oleh Komite Fatwa'],
        [id:'3437', pendaftaran:'SH2025-1-623385', status:'Penerbitan Sertifikasi oleh Komite Fatwa'],
        [id:'3430', pendaftaran:'SH2025-1-623381', status:'Penerbitan Sertifikasi oleh Komite Fatwa'],
        [id:'3394', pendaftaran:'SH2025-1-623354', status:'Penerbitan Sertifikasi oleh Komite Fatwa']
    ]
)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Halalmax/Sekretariat Komite Fatwa/Inquiry/BtnLihat'))
WebUI.closeBrowser()
