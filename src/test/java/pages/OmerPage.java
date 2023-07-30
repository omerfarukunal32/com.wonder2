package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class OmerPage extends Base{

    //  --------------------------------[US_37] Locate ----------------------------------

    @FindBy(xpath = "//i[@class='fa fa-user-plus']")
    private WebElement teacherLoginButton;

    // Teacher Login Page -> EmailBox
    @FindBy(id = "form-username")
    private WebElement teacherEmailBox;

    //Teacher Login Page -> passwordBox
    @FindBy(id = "form-password")
    private WebElement teacherPasswordBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement teacherSingInButton;

    @FindBy(xpath = "//*[text()='Human Resource']")
    private WebElement humanResourceOnSideBar;

    @FindBy(xpath = "//*[@id=\"sibe-box\"]/ul[2]/li[6]/ul/li[2]/a/i")
    private WebElement applyLeaveOnSideBar;

    @FindBy(xpath = "//*[@onclick='addLeave()']")
    private WebElement applyLeaveOnPageButton;

    @FindBy(xpath = "//select[@name='leave_type']")
    private WebElement availableLeaveBox;

    @FindBy(id = "applieddate" )
    private WebElement applyDateBox;

    @FindBy(id = "leave_from_date")
    private WebElement leaveFromDateBox;

    @FindBy(id = "leave_to_date")
    private WebElement leaveToDateBox;

    @FindBy(id = "reason")
    private WebElement reasonBox;

    @FindBy(id = "submitbtn")
    private WebElement applyLeaveSaveButton;

    @FindBy(xpath = "/html/body/div[7]/div[1]/table/thead/tr[1]/th[3]")
    private WebElement nextToleaveFromDateBox;

    //td[text()='15']
    @FindBy(xpath = "//*[text()='15']")
    private WebElement dateLeaveFromDateBox;

    //     /html/body/div[7]/div[1]/table/thead/tr[1]/th[3]
    @FindBy(xpath = "/html/body/div[7]/div[1]/table/thead/tr[1]/th[3]")
    private WebElement nextToleaveToDateBox;

    //    /html/body/div[7]/div[1]/table/tbody/tr[3]/td[2]
    @FindBy(xpath = "//*[text()='15']")
    private WebElement dateLeaveToDateBox;

    //   //*[text()='Pending']
    @FindBy(xpath = "//*[text()='Pending']")
    private WebElement pendingButton;

    //     //*[@id="DataTables_Table_0"]/tbody/tr/td[7]/a[2]/i
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[7]/a[2]/i")
    private WebElement applyLeaveDeleteButton;

    //    //*[text()='Records: 0 to 0 of 0']
    @FindBy(xpath = "//*[text()='Records: 0 to 0 of 0']")
    private WebElement noResultApplyLeavePage;

    @FindBy(xpath = "//*[text()='15']")
    private WebElement BugDateLeaveFromDateBox;

    @FindBy(xpath = "//*[text()='16']")
    private WebElement BugDateLeaveToDateBox;

    //  TC_003-->US37
    @FindBy(xpath = "//*[@class='sorting'][1]")
    private WebElement staffLeavesPage;

    @FindBy(xpath = "//*[@class='sorting'][2]")
    private WebElement leaveTypeLeavesPage;

    @FindBy(xpath = "//*[@class='sorting'][3]")
    private WebElement leaveDateLeavesPage;

    @FindBy(xpath = "//*[@class='sorting'][4]")
    private WebElement daysLeavesPage;

    @FindBy(xpath = "//*[@class='sorting'][5]")
    private WebElement applyDateLeavesPage;

    @FindBy(xpath = "//*[text()='Status']")
    private WebElement statusLeavesPage;

    @FindBy(xpath = "//*[@class='text-right noExport sorting']")
    private WebElement actionLeavesPage;

    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[7]/a[1]/i")
    private WebElement viewLeavesButton;

    @FindBy(xpath = "//*[text()='Details']")
    private WebElement detailsViewFrameText;

    @FindBy(xpath = "//*[@id='leavedetails']/div/div/div[1]/button")
    private WebElement closeViewFrameButton;








    // =========================== [US_37] Methods ===================================

    public void teacherLoginMethod (String teacherEmail, String teacherPassword){
        Driver.getDriver().get(ConfigReader.getProperty("teacherLoginUrl"));
        teacherLoginButton.click();
        ReusableMethods.switchToWindow("Login : Wonder World College");
        teacherEmailBox.sendKeys(teacherEmail);
        teacherPasswordBox.sendKeys(teacherPassword);
        teacherSingInButton.click();
    }

    public void applyLeaveOnSideBarVisible(){
        humanResourceOnSideBar.click();
        applyLeaveOnSideBar.click();
    }

    public void applyLeaveOnPageButtonVisible(){
        Assert.assertTrue(applyLeaveOnPageButton.isEnabled());
    }

    public void availableLeaveButtonEnable(){
        applyLeaveOnPageButton.click();
        Assert.assertTrue(availableLeaveBox.isEnabled());
        Driver.quitDriver();
    }

    public void openApplyLeavePage(String teacherEmail, String teacherPassword){
        teacherLoginMethod(teacherEmail,teacherPassword);
        humanResourceOnSideBar.click();
        applyLeaveOnSideBar.click();
    }

    public void detailsOnTheApplyLeaveEnable(){
        applyLeaveOnPageButton.click();
        Assert.assertTrue(applyDateBox.isEnabled());
        Assert.assertTrue(availableLeaveBox.isEnabled());
        Assert.assertTrue(leaveFromDateBox.isEnabled());
        Assert.assertTrue(leaveToDateBox.isEnabled());
        Assert.assertTrue(reasonBox.isEnabled());
        Assert.assertTrue(applyLeaveSaveButton.isEnabled());
    }

    public void selectDropBoxAvailableLeave(){
        Select select1 = new Select(availableLeaveBox);
        select1.selectByValue("1");
    }

    public void selectLeaveFromAndToDateBox(){
        leaveFromDateBox.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(leaveFromDateBox).click(nextToleaveFromDateBox).perform();
        actions.moveToElement(dateLeaveFromDateBox).click().perform();

        leaveToDateBox.click();
        actions.click(leaveToDateBox).click(nextToleaveToDateBox).perform();
        actions.moveToElement(dateLeaveToDateBox).click().perform();

        applyLeaveSaveButton.click();
    }

    public void verifyToLeaveEnrollment(){  // burada delete yaptim, yoksa ikici kayit olmuyor
        Assert.assertTrue(pendingButton.isEnabled());
        applyLeaveDeleteButton.click();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(noResultApplyLeavePage.isDisplayed());
        Driver.quitDriver();
    }

    public void bugSelectLeaveFromAndToDateBox(){
        leaveFromDateBox.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(leaveFromDateBox).click(nextToleaveFromDateBox).perform();
        actions.moveToElement(BugDateLeaveFromDateBox).click().perform();

        leaveToDateBox.click();
        actions.click(leaveToDateBox).click(nextToleaveToDateBox).perform();
        actions.moveToElement(BugDateLeaveToDateBox).click().perform();

        applyLeaveSaveButton.click();
        Assert.assertFalse(applyLeaveSaveButton.isDisplayed());
    }

    public void leaveRequestManagementOnTheLeaveList(){
        Assert.assertTrue(staffLeavesPage.isDisplayed());
        Assert.assertTrue(leaveTypeLeavesPage.isDisplayed());
        Assert.assertTrue(leaveDateLeavesPage.isDisplayed());
        Assert.assertTrue(daysLeavesPage.isDisplayed());
        Assert.assertTrue(applyDateLeavesPage.isDisplayed());
        Assert.assertTrue(statusLeavesPage.isDisplayed());
        Assert.assertTrue(actionLeavesPage.isDisplayed());

        // view butonuna basip cikan frame'i kapatmayi tekrar dene
        Assert.assertTrue(viewLeavesButton.isEnabled());

        applyLeaveDeleteButton.click();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(noResultApplyLeavePage.isDisplayed());
        Driver.quitDriver();

    }


    // =========================== [US_37] Locate ===================================

    @FindBy(xpath = "//*[@id='sibe-box']/ul[2]/li[7]/a/i[1]")
    private WebElement communicateMenuOnSidebar;

    @FindBy(xpath = "//*[@id='sibe-box']/ul[2]/li[7]/ul/li[2]/a/i")
    private WebElement sendMailOnSidebar;

    @FindBy(xpath = "//select[@id='template_id']")
    private WebElement emailTemplateDropDownMenuOnCommunicate;

    //    //input[@id='group_title']
    @FindBy(xpath = "//input[@id='group_title']")
    private WebElement titleBoxOnCommunicate;

    //   //*[@id="cke_1_contents"]/iframe
    @FindBy(id = "cke_1_contents")
    private WebElement messageBoxOnCommunicate;

    //  //input[@value='student']
    @FindBy(xpath = "//input[@value='student']")
    private WebElement checkBoxStudentsOnCommunicate;

    @FindBy(xpath = "//input[@value='parent']")
    private WebElement checkBoxGuardiansOnCommunicate;

    @FindBy(xpath = "//input[@value='1']")
    private WebElement checkBoxAdminOnCommunicate;

    @FindBy(xpath = "//input[@value='2']")
    private WebElement checkBoxTeacherOnCommunicate;

    @FindBy(xpath = "//input[@value='3']")
    private WebElement checkBoxAccountantOnCommunicate;

    @FindBy(xpath = "//input[@value='4']")
    private WebElement checkBoxLibrarianOnCommunicate;

    @FindBy(xpath = "//input[@value='6']")
    private WebElement checkBoxReceptionistOnCommunicate;

    @FindBy(xpath = "//input[@value='7']")
    private WebElement checkBoxSuperAdminOnCommunicate;

    @FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div/div/div/ul/li[3]/a")
    private WebElement individualButtonOnSendEmailPage;

    @FindBy(xpath = "//*[@id='individual_form']/div[1]/div/div[2]/div[1]/div/div[1]/button/span[1]")
    private WebElement dropboxOnMessageToInIndividual;

    @FindBy(xpath = "//*[@id='individual_form']/div[1]/div/div[2]/div[1]/div/div[1]/ul/li[1]")
    private WebElement studentDropBoxMenuOnIndividual;

    @FindBy(xpath = "//li[@record_id='2']")
    private WebElement studentRobinPeterson;

    @FindBy(id = "search-query")
    private WebElement textBoxMessageToInIndividual;

    @FindBy(xpath = "//*[text()='Add']")
    private WebElement addButtonMessageToInIndividual;

    @FindBy(xpath = "//*[@id='student-2']/i[2]")
    private WebElement deleteButtonMessageToInIndividual;


    // Class Menu
    @FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div/div/div/ul/li[2]")
    private WebElement classButtonOnComposePage;

    @FindBy(id = "class_id")
    private WebElement dropBoxMessageToInClassMenu;

    @FindBy(xpath = "//*[@id='class_id']/option[14]")
    private WebElement class13InDropBoxOnClass;

    @FindBy(xpath = "//*[text()='A']")
    private WebElement AClass13CheckBox;




    // =========================== [US_37] Methods ===================================

    public void verifyCommunicateButtonOnSidebar(){
        String expectedComposePageUrl = "https://qa.wonderworldcollege.com/admin/mailsms/compose";
        communicateMenuOnSidebar.click();
        Assert.assertTrue(sendMailOnSidebar.isEnabled());
        sendMailOnSidebar.click();
        String actualComposePageUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedComposePageUrl,actualComposePageUrl);
    }

    public void verifyEmailTitleMessageBoxOnComposePage(){
        Assert.assertTrue(emailTemplateDropDownMenuOnCommunicate.isEnabled());
        Assert.assertTrue(titleBoxOnCommunicate.isEnabled());
        Assert.assertTrue(messageBoxOnCommunicate.isEnabled());
    }

    public void selectControlCheckBoxesOnComposePage(){
        checkBoxStudentsOnCommunicate.click();
        Assert.assertTrue(checkBoxStudentsOnCommunicate.isSelected());
        checkBoxGuardiansOnCommunicate.click();
        Assert.assertTrue(checkBoxGuardiansOnCommunicate.isSelected());
        checkBoxAdminOnCommunicate.click();
        Assert.assertTrue(checkBoxAdminOnCommunicate.isSelected());
        checkBoxTeacherOnCommunicate.click();
        Assert.assertTrue(checkBoxTeacherOnCommunicate.isSelected());
        checkBoxAccountantOnCommunicate.click();
        Assert.assertTrue(checkBoxAccountantOnCommunicate.isSelected());
        checkBoxLibrarianOnCommunicate.click();
        Assert.assertTrue(checkBoxLibrarianOnCommunicate.isSelected());
        checkBoxReceptionistOnCommunicate.click();
        Assert.assertTrue(checkBoxReceptionistOnCommunicate.isSelected());
        checkBoxSuperAdminOnCommunicate.click();
        Assert.assertTrue(checkBoxSuperAdminOnCommunicate.isSelected());

        Driver.quitDriver();
    }

    public void goToIndividualOnSendMailPage(){
        teacherLoginMethod("omer.faruk.unal@teacher.wonderworldcollege.com","wonderworld123");
        communicateMenuOnSidebar.click();
        sendMailOnSidebar.click();
        individualButtonOnSendEmailPage.click();
    }

    public void addStudentToMassageAndDeleteMethod(){
        dropboxOnMessageToInIndividual.click();
        studentDropBoxMenuOnIndividual.click();
        Actions actions = new Actions(Driver.getDriver());

        textBoxMessageToInIndividual.sendKeys("Robin");
        actions.click(studentRobinPeterson).perform();
        addButtonMessageToInIndividual.click();
        deleteButtonMessageToInIndividual.click();
        Driver.quitDriver();
    }

    public void goToClassMenuOnComposePageMethod(){
        teacherLoginMethod("omer.faruk.unal@teacher.wonderworldcollege.com","wonderworld123");
        communicateMenuOnSidebar.click();
        sendMailOnSidebar.click();
        classButtonOnComposePage.click();

    }

    public void selectToClassOnComposePageMethod(){
        dropBoxMessageToInClassMenu.click();
        Select select = new Select(dropBoxMessageToInClassMenu);
        select.selectByVisibleText("Class 13");
        classButtonOnComposePage.click();
        //Actions actions = new Actions(Driver.getDriver());
        //actions.click(class13InDropBoxOnClass).perform();
        //select.selectByIndex(1);
        AClass13CheckBox.click();
        Assert.assertTrue(AClass13CheckBox.isEnabled());
        Driver.quitDriver();
    }




}
