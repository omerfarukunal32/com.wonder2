package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.OmerPage;

public class OmerStepDefinition {
    OmerPage omerPage = new OmerPage();

    @Given("Sign in on the Theacher Admin")
    public void sign_in_on_the_theacher_admin() {
        omerPage.teacherLoginMethod("omer.faruk.unal@teacher.wonderworldcollege.com","wonderworld123");
    }

    @Given("{string} on the sidebar is displayed")
    public void on_the_sidebar_is_displayed(String string) {
        omerPage.applyLeaveOnSideBarVisible();
    }

    @Given("Apply Leave on the page is displayed")
    public void apply_leave_on_the_page_is_displayed() {
        omerPage.applyLeaveOnPageButtonVisible();
    }

    @Given("Apply Leave on the page is enable")
    public void apply_leave_on_the_page_is_enable() {
        omerPage.availableLeaveButtonEnable();
    }

    @Given("Open to the applyLeavePage")
    public void open_to_the_apply_leave_page() {
        omerPage.openApplyLeavePage("omer.faruk.unal@teacher.wonderworldcollege.com","wonderworld123");
    }

    @Given("Details On the Frame is Enable")
    public void details_on_the_frame_is_enable() {
        omerPage.detailsOnTheApplyLeaveEnable();
    }

    @Given("Select the necessary information on the Apply Leave frame")
    public void select_the_necessary_information_on_the_apply_leave_frame() {
        omerPage.selectDropBoxAvailableLeave();
        omerPage.selectLeaveFromAndToDateBox();
    }

    @Given("Verify Leaves enrollment was successful")
    public void verify_leaves_enrollment_was_successful() {
        omerPage.verifyToLeaveEnrollment();
    }

    @Given("Bug_Select the necessary information on the Apply Leave frame")
    public void bug_select_the_necessary_information_on_the_apply_leave_frame() {
        omerPage.bugSelectLeaveFromAndToDateBox();
    }

    @Given("Leave menu control and Leave deletion")
    public void leave_menu_control_and_leave_deletion() {
        omerPage.leaveRequestManagementOnTheLeaveList();
    }

    // =================  [US_38] ==================================

    @Given("Verify communicate menu on the sidebar")
    public void verify_communicate_menu_on_the_sidebar() {
        omerPage.verifyCommunicateButtonOnSidebar();
    }

    @Given("Verify email Template, titleBox and messageBox on the compose page")
    public void verify_email_template_title_box_and_message_box_on_the_compose_page() {
        omerPage.verifyEmailTitleMessageBoxOnComposePage();
    }

    @Given("Verify selectability of checkboxes")
    public void verify_selectability_of_checkboxes() {
        omerPage.selectControlCheckBoxesOnComposePage();
    }

    @Given("Sign in on the Teacher Admin and go to Individual")
    public void sign_in_on_the_teacher_admin_and_go_to_individual() {
        omerPage.goToIndividualOnSendMailPage();
    }
    @Given("Verify that any student can be selected and deleted from the list again")
    public void verify_that_any_student_can_be_selected_and_deleted_from_the_list_again() {
        omerPage.addStudentToMassageAndDeleteMethod();
    }

    @Given("Sign in on the Teacher Admin and go to Class Menu")
    public void sign_in_on_the_teacher_admin_and_go_to_class_menu() {
        omerPage.goToClassMenuOnComposePageMethod();
    }
    @Given("Verify that classes can be selected to send messages")
    public void verify_that_classes_can_be_selected_to_send_messages() {
        omerPage.selectToClassOnComposePageMethod();
    }



    /*
    Feature: [US_38] It should be verified that the functions under the Communicate menu title in the sidebar of the Teacher Panel are working properly.

  Scenario: [TC_01-->US_38] Verify that the functions under the Communicate menu title in the sidebar.

  @omer
    * Sign in on the Theacher Admin
    * Verify Communicate Button on the sidebar
     */
}
