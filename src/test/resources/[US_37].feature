Feature: [US_37] As an administrator (teacher), I want a page where I can create online permission records and check all the permissions I have used.


  Scenario: [TC_001-->US_037] User Interface Enhancements for Leave Application in Teacher Panel

    * Sign in on the Theacher Admin
    * 'Apply Leave' on the sidebar is displayed
    * Apply Leave on the page is displayed
    * Apply Leave on the page is enable



    Scenario: [TC_002-->US_037] The "Apply Leave" button opens an "Add Details" window with active fields. Upon filling in the required information and clicking Save, a new leave request is generated.

    * Open to the applyLeavePage
    * Details On the Frame is Enable
    * Select the necessary information on the Apply Leave frame
    * Verify Leaves enrollment was successful


    Scenario: [TC_002-->US_037] (Bug)The "Apply Leave" button opens an "Add Details" window with active fields. Upon filling in the required information and clicking Save, a new leave request is generated.

      * Open to the applyLeavePage
      * Details On the Frame is Enable
      * Bug_Select the necessary information on the Apply Leave frame



      Scenario: [TC_003-->US_037] Leave Request Management in the "Leaves List"

        * Open to the applyLeavePage
        * Details On the Frame is Enable
        * Select the necessary information on the Apply Leave frame
        * Leave menu control and Leave deletion


        @omer
        Scenario: [TC_01-->US_38] Verify that the functions under the Communicate menu title in the sidebar.

          * Sign in on the Theacher Admin
          * Verify communicate menu on the sidebar





