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

def jadwalType = 'hari'
def jadwalDay = 'rabu|Rabu'
def expectedJadwalHeader = 'Rabu'

'Open browser'
WebUI.openBrowser(GlobalVariable.urlBase)

'click on stakeholder -> mahasiswa'
WebUI.callTestCase(findTestCase('pages/index/click mahasiswa button'), [:], FailureHandling.STOP_ON_FAILURE)

'click on jadwal kuliah'
WebUI.callTestCase(findTestCase('pages/info-mahasiswa/click jadwal kuliah button'), [:], FailureHandling.STOP_ON_FAILURE)

'switch to jadwal iframe'
WebUI.switchToFrame(findTestObject('jadwal-kuliah/ifr_jadwal_kuliah'), GlobalVariable.timeOutFast)

'select jadwal by type hari'
WebUI.callTestCase(findTestCase('pages/jadwal-kuliah/select jadwal by type'), [('value'): jadwalType], FailureHandling.STOP_ON_FAILURE)

'select hari rabu'
WebUI.callTestCase(findTestCase('pages/jadwal-kuliah/select jadwal by hari'), [('value'): jadwalDay], FailureHandling.STOP_ON_FAILURE)

'assert header text is changed to rabu'
WebUI.callTestCase(findTestCase('pages/jadwal-kuliah/assert header text'), [('value'): expectedJadwalHeader], FailureHandling.STOP_ON_FAILURE)