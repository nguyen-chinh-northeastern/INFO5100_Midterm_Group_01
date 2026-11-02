# INFO5100_Midterm_Group_01
INFO 5100 Midterm Project: Digital University System with Role-Based Access Control (RBAC) across Admin, Faculty, and Student roles (Group 01)

---

## 1. Team Information

| Team Member Name | NUID | Assigned Role | Core Responsibilities |
| :--- | :--- | :--- | :--- |
| **Lee Wang** | **3947002** | University Admin | Administer user accounts, register persons, manage student records, manage faculty records, manage own profile, login/logout |
| **Chinh Nguyen** | **3946343** | Faculty Member | Manage courses, manage own profile, generate performance reports, manage student profiles |
| **Rachel Macaulay** | **2082631** | Student | Manage coursework, register for classes, perform graduation audit, review transcript |

---

## 2. Project Overview

The **Digital University System** is a Java project designed to support real-world University functionality to include the following:

- **Enforce Secure Access Controls:** Authenticates credentials through a centralized user account directory and enforces role-based authorization to ensure users only access their assigned work areas.
- **Maintain Architectural Modularity:** Decouples core business domain entities (Person, Department, CourseCatalog, CourseSchedule, Employee, Student, Faculty) from authentication logic and Swing UI presentation.
- **Role-Based Functionality:** Provides specialized, role-specific workflows for Administrators, Faculty, and Students.
- **Core Implemented Use Cases:**
  - **Administrator:** Administer user accounts, registers university personnel, manages student and faculty records, and manages administrator profile data.
  - **Faculty:** Manages the course catalog (view/update/add/delete), reviews student profiles and academic progress, manages faculty profile attributes, and generates class performance reports.
  - **Student:** Manages coursework (submit assignments, track progress), enrolls in and drops courses, monitors degree completion via graduation audit, and reviews academic transcripts.

---

## 3. Installation & Setup Instructions

### Prerequisites
- **JDK:** Java Development Kit 19 or higher
- **IDE:** Apache NetBeans IDE (v16+ recommended)

### Step-by-Step Setup
1. **Clone the repository:**
```bash
git clone https://github.com/nguyen-chinh-northeastern/INFO5100_Midterm_Group_01.git
```

2. **Open in NetBeans IDE:**
* Launch NetBeans -> File -> Open Project.
* Browse to the cloned directory and select the project.

3. **Clean and Build:**
* Right-click the project root in the **Projects** panel -> click **Clean and Build** (or **Run** -> **Clean and Build Project**).

4. **Run Application:**
* Click the **Run Project** button (or press **F6**).

---

## 4. Authentication & Access Control

The Digital University System incorporates Role-Based Access Control (RBAC) architecture that is both localized and decoupled.

System access requires validation against user profiles, which are credentialed. Username and password are used against a directory (UserAccountDirectory) for the authentication process. Access is granted to each user based on their assigned role. Further description of the parameters of these roles is available based on the features attributed to the implementation of each.

The utilization of the CardSequencePanel initializes the correct target panel with its required data dependencies and switches views.

Instanceof checks help ensure that sub-panels cannot be loaded without holding the correct profile type.

---

## 5. Features Implemented

### 5.1 Administrator Role (Implemented by: Lee Wang)

* **Administer user accounts**: create, modify, and delete accounts.
* **Register persons**: students, faculty, academic staff.
* **Manage student records**: update, delete, or view student data.
* **Manage faculty records**: update, delete, or view faculty data.
* **Manage own profile**: update, view, but NOT delete or disable (to prevent lockout).

### 5.2 Faculty Role (Implemented by: Chinh Nguyen)

* **Manage courses**: view/update course details, add course, delete course.
* **Manage own profile**: view/update ID (name), NUID, email, phone, department, academic rank, office location.
* **Generate performance reports**: view grade statistics and enrolled student GPAs for each course.
* **Manage student profiles**: view hobbies, interests, academic progress.

### 5.3 Student Role (Implemented by: Rachel Macaulay)

* **Manage coursework**: submit assignments, track progress.
* **Register for classes**: enroll, drop courses.
* **Perform graduation audit**: track credits and graduation requirements.
* **Review transcript**: view academic history.

---

## 6. Usage Instructions

### 1. Authentication
* **Account Access:** Enter credentials (Username and Passwords) and click "Login."
* **System Verification:** The application invokes 'UserAccountDirectory' and 'Access Control Layer' validation routines. Incorrect credentials will not allow a user access. If authorized, the active panel updates via CardLayout to display a work area particular to the user role.
* **Access Control:** Incorrect credentials will not allow a user access.
* **Dynamic Routing:** The active panel updates via CardLayout to display a work area particular to the user role.

### 2. Adminitrator
* **2.1 Administer User Accounts:** Click **Administer User Accounts** from the Admin Work Area to view, create, delete, and update user accounts. Note: User's Personnel Profile must already exist in HR to create an account. Profiles are created centrally through the **Register Persons** panel.
* **2.1.1 Create User:** Click "Create."
    * 2.1.1.1 Select User from combo box.
    * 2.1.1.2 Add Username
    * 2.1.1.3 Add Password
    * 2.1.1.4 Click "Create."
* **2.1.2 Delete User:** Click "Delete."
    * 2.1.1.1 Select User from combo box.
    * 2.1.1.2 Select "Yes" to delete the account. Select "No" to retain the account.
* **2.1.3 Update User:**
    * 2.1.3.1 Select User from table.
    * 2.1.3.2 click "Next>>" to access selected user account details (name, NUID, username, and password).
    * 2.1.3.3 Make changes to username, password, or enable/disable account.
    * 2.1.3.4 Click "Update>>" to save changes.
* **2.2 Manage Faculty:** Click **Manage Faculty** from the Admin Work Area to view, delete, and update faculty profiles. Profiles are created centrally through the **Register Persons** panel.
* **2.2.1 Delete Profile:** Click "Delete."
    * 2.2.1.1 Select User from combo box.
    * 2.2.1.2 Select "Yes" to delete the account. Select "No" to retain the account.
* **2.2.2 Update Profile:**
    * 2.2.2.1 Select Profile from table.
    * 2.2.2.2 click "View>>" to access selected profile details (name, NUID, username, and password, etc).
    * 2.2.2.3 Make changes to username, password, or enable/disable account.
    * 2.2.2.4 Click "Update" to save changes.
* **2.3 Manage Students:** Click **Manage Students** from the Admin Work Area to view, delete, and update students profiles. Profiles are created centrally through the **Register Persons** panel.
* **2.3.1 Delete Profile:** Click "Delete."
    * 2.3.1.1 Select User from combo box.
    * 2.3.1.2 Select "Yes" to delete the account. Select "No" to retain the account.
* **2.3.2 Update Profile:**
    * 2.3.2.1 Select Profile from table.
    * 2.3.2.2 click "View>>" to access selected profile details (name, NUID, username, and password, etc).
    * 2.3.2.3 Make changes to username, password, or enable/disable account.
    * 2.3.2.4 Click "Update" to save changes.
* **2.4 Register Persons:** Click **Register Persons (HR)** from the Admin Work Area to create new HR profiles and view all existing HR profiles.
* **2.4.1 Create Profile:** Click "Register>>"
    * 2.4.1.1 Enter profile details into the forms.
    * 2.4.1.2 Select Role from combo box.
    * 2.4.1.3 Click "Register" to create the new personnel profile, contingent on successful validation.
* **2.5 Administrator (Own) Profile:** Click **My Profile** from the Admin Work Area to view and update the Administrator's own profile.
* **2.5.1 Update Profile:**
    * 2.5.1.1 Enter profile details into the forms.
    * 2.4.1.2 Select the "Telework" checkbox if user is working remotely.
    * 2.4.1.3 Click "Update>>" to update the profile, contingent on successful validation.
  
### 3. Faculty
- **3.1 Manage Courses:** Click **Manage Courses** from the Faculty Work Area to add, view/update and delete courses in the course catalog.
  * **3.1.1 Add a Course:** Click **Add Course**.
    * 3.1.1.1 Enter Course Number, Course Name, Credits, and Price.
    * 3.1.1.1.1 Total course price is automatically calculated as **Price * Credits**.
    * 3.1.1.2 All fields are required. The system performs a check to ensure that all fields are available and valid (i.e. Price > $0, Credits > 0, and non-duplicate Course Number).
    * 3.1.1.3 Click **Save**. Successful entries populate the course list table.
  * **3.1.2 View and Edit Details:**
    * 3.1.2.1 Highlight a course in the table.
    * 3.1.2.2 Click **Next >>** to display course details.
    * 3.1.2.3 Modify fields as needed within expected constraints and click **Update** to save the changes.
  * **3.1.3 Delete a Course:**
    * 3.1.3.1 Select a Course from the table.
    * 3.1.3.2 Click **Delete**
    * 3.1.3.2.1 Review the Popup message. Click **Yes** to delete. Click **No** to take no action. If **Yes** is selected, a success message will appear.
- **3.2 Manage Student Profiles:**
  * 3.2.1 Click **Manage Student Profiles** from the Faculty Work Area.
  * 3.2.2 The panel displays a list of all registered students.
  * 3.2.3 Highlight a student in the table and click **View Details**.
  * 3.2.4 Faculty can view student details including hobbies, interests, and academic progress (enrolled courses, earned credits, and individual course GPAs).
- **3.3 Faculty Profile:**
  * 3.3.1 Click **My Profile** from the Faculty Work Area
  * 3.3.2 Faculty can view and update their own profile data including ID (Name), NUID, email, phone, department, academic rank, and office location.
  * 3.3.3 After implementing changes, click **Update>>** to save them.
  * 3.3.4 The system performs validation before persisting: **ID (Name)** is not empty, **NUID** is unique and not already assigned to another person in the directory. Upon completion, a success message will appear.
- **3.4 Performance Reports:**
  * 3.4.1 Click **Performance Reports** from the Faculty Work Area
  * 3.4.2 Select a course from the drop down combo box (shows only courses taught by this faculty member).
  * 3.4.3 The top panel shows class summary metrics: number of enrolled students, class GPA, passing rate, and the highest and lowest grades.
  * 3.4.4 The table will show individual student performance information, including GPA, letter grade, and status (Passing or Needs Review).

### 4. Student
* **4.1 Coursework:** Click **Course Work** from the Student Work Area to track class progress.
  * 4.1.1 Detail view: Select a course to verify if it is marked as *Completed* or *Active*.
  * 4.1.2 Assignment inspection: Click **View Course** on active records to examine specific assignments, file logs, and completion statistics.
  * 4.1.2.1 Progress metrics: Tracks workflow momentum based on completed versus expected course submissions.
  * 4.1.2.2 File submission: Select an assignment and use **Attach** to bind a local file, or click **Remove** to stage a replacement.
  * 4.1.2.3 Upload tracking: Clicking **Submit** changes status to *Submitted* and immediately updates progress bars.
* **4.2 Transcript:** Click **Transcript** from the Student Work Area to request an official performance summary.
  * 4.2.1 Read-only metrics: Displays user identity and summary metrics including *Name*, *NUID*, *Degree Program*, *Credits Earned*, *Cumulative Satisfaction Index*, and *GPA*.
  * 4.2.2 Background evaluations: Calculates GPA and satisfaction scores by averaging performance over completed modules.
  * 4.2.3 Course breakdown: Lists specific semester achievements by *Number*, *Name*, *Satisfaction Rating*, and *Letter Grade*.
* **4.3 Graduation Audit:** Click **Graduation Audit** from the Student Work Area to assess degree completion requirements.
  * 4.3.1 Curriculum checklist: Cross-references your transcript against designated core requirements and elective streams.
  * 4.3.2 Summary counts: Compares *Credits Earned* (completed units) and *Credits Planned* (registered units) against *Total Credits Required*.
  * 4.3.3 Status banner: Displays an alert at the top of the interface. This banner switches to green the moment total earned credits fulfill the graduation barrier.
* **4.4 Registration:** Click **Registration** from the Student Work Area to adjust active semester profiles.
  * 4.4.1 Timeline protection: Built-in business logic limits registration modifications exclusively to future semesters.
  * 4.4.2 Autocomplete search: Inputting a valid course number automatically populates the corresponding *Course Name* string.
  * 4.4.3 Verification rules: If the input number fails to map to an existing catalog entry, registration is blocked.
  * 4.4.4 Adding a course: Select a valid target semester, click **Add**, and check the updated live workspace tables.
  * 4.4.5 Dropping a course: Select a registered class item, click **Drop**, and verify the operation in the safety alert popup to clear the record.
  * 4.4.6 Redundancy checks: Attempting to register for a course you are already enrolled in prompts an error message.



---

## 7. Testing Guide

### 1. **Pre-Configured Demo Credentials**
The system initializes demo accounts for testing authentication, access control boundaries, and role-specific workflows:

| Role | Username |
| :--- | :--- |
| **Administrator** | `admin` |
| **Faculty** | `laura` |
| **Student** | `adam` |

### 2. **Authentication and Roles**
   * **Invalid Credentials**
      * Administrator
         * Test Case Description: Enter a credentialed Administrator User Name and an incorrect password
         * Expected Result: System will not allow log in
      * Faculty
        * Test Case Description: Enter a credentialed Faculty User Name and an incorrect password
         * Expected Result: System will not allow log in
      * Student
         * Test Case Description: Enter a credentialed Student User Name and an incorrect password
         * Expected Result: System will not allow log in
      * Uncredentialed User
        * Test Case Description: Enter a User Name that does not correspond to any existing user and:
           * a null password
           * a password from a credentialed user
         * Expected Result: System will not allow log in
   * **Valid Credentials, Role Routing**
      * Administrator
         * Test Case Description: Enter the correct user name and password for an administrator user
         * Expected Result: System will allow log in and update via CardLayout to display work area corresponding to the Administrator role only
      * Faculty
         * Test Case Description: Enter the correct user name and password for a faculty user
         * Expected Result: System will allow log in and update via CardLayout to display work area corresponding to the Faculty role only
      * Student
         * Test Case Description: Enter the correct user name and password for a student user
         * Expected Result: System will allow log in and update via CardLayout to display work area corresponding to the Student role only
           
### 3. **Administrative Features**
   * Register Persons (HR)
      * Register Person
         * Test Case Description: Go to Register Persons (HR). Click Register. Enter Name, a unique 9-digit NUID, a valid email address, and a phone number in the format ###-###-####. Enter Department. Select Admin, Faculty, or Student as the role. Click Register. Repeat for each role.
         * Expected Result: Success message and addition of the person to the directory with the selected role profile. A user account must be created separately before the person can log in.
      * Invalid Input - Empty Name
         * Test Case Description: Go to Register Persons (HR). Click Register. Leave Name blank and enter valid values for the remaining fields. Click Register.
         * Expected Result: Error message. Person is not registered.
      * Invalid Input - Invalid NUID
         * Test Case Description: Go to Register Persons (HR). Click Register. Leave NUID blank, enter an NUID containing non-numeric characters, or enter an NUID that is not exactly 9 digits. Enter valid values for the remaining fields. Click Register.
         * Expected Result: Error message. Person is not registered.
      * Invalid Input - Duplicate NUID
         * Test Case Description: Go to Register Persons (HR). Click Register. Enter an NUID assigned to another person in the directory. Enter valid values for the remaining fields. Click Register.
         * Expected Result: Error message. Person is not registered.
      * Invalid Input - Email or Phone
         * Test Case Description: Go to Register Persons (HR). Click Register. Leave email or phone blank, enter an invalid email address, or enter a phone number that does not match the format ###-###-####. Enter valid values for the remaining fields. Click Register.
         * Expected Result: Error message. Person is not registered.
   * Administer User Accounts
      * Create User Account
         * Test Case Description: Go to Administer User Accounts. Click Create. Select an available profile. Enter a unique username and a non-empty password. Click Create.
         * Expected Result: Role displays according to the selected profile. Success message and addition of the account to the user accounts table.
      * Invalid Input - Missing Credentials
         * Test Case Description: Go to Administer User Accounts. Click Create. Select an available profile. Leave username or password blank. Click Create.
         * Expected Result: Error message. User account is not created.
      * Invalid Input - Duplicate Username
         * Test Case Description: Go to Administer User Accounts. Click Create. Select an available profile. Enter a username assigned to another account and a non-empty password. Click Create.
         * Expected Result: Error message. User account is not created.
      * View/Update User Account
         * Test Case Description: Go to Administer User Accounts. Select an account from the table. Click Next. Change the username to an available username or enter a new password. Click Update.
         * Expected Result: Success message and updated account details. System will allow log in with the updated credentials.
      * Update Account - Blank Password
         * Test Case Description: Go to Administer User Accounts. Select an account from the table. Click Next. Change the username to an available username and leave the password field blank. Click Update.
         * Expected Result: Success message. Username is updated and the existing password is retained.
      * Invalid Input - Empty or Duplicate Username
         * Test Case Description: Go to Administer User Accounts. Select an account from the table. Click Next. Clear the username or enter a username assigned to another account. Click Update.
         * Expected Result: Error message. Account details are not updated.
      * Activate/Deactivate User Account
         * Test Case Description: Go to Administer User Accounts. Select another user's account from the table. Click Next. Clear Active. Click Update. Attempt to log in with that account. Reactivate the account and attempt to log in again.
         * Expected Result: Success message after each update. System will not allow log in while the account is inactive and will allow log in with valid credentials after reactivation.
      * No Changes Made
         * Test Case Description: Go to Administer User Accounts. Select an account from the table. Click Next. Do not change any fields. Click Update.
         * Expected Result: Warning message indicating no changes were made.
      * Delete User Account
         * Test Case Description: Go to Administer User Accounts. Select an account other than the logged-in administrator's account. Click Delete. Select Yes on confirmation popup.
         * Expected Result: Success message and account removed from the table. System will no longer allow log in with the deleted account.
      * Delete User Account - Cancel
         * Test Case Description: Go to Administer User Accounts. Select an account other than the logged-in administrator's account. Click Delete. Select No on confirmation popup.
         * Expected Result: Deletion canceled and account retained in the table.
      * Delete Own Account
         * Test Case Description: Go to Administer User Accounts. Select the logged-in administrator's account. Click Delete.
         * Expected Result: Error message. Administrator cannot delete their own account.
      * Null selection
         * Test Case Description: Go to Administer User Accounts. Do not select an account from the table. Click Next or Delete.
         * Expected Result: Warning message.
   * Manage Students
      * View/Update Student Profile
         * Test Case Description: Go to Manage Students. Select a student from the table. Click View. Modify Name, NUID, email, phone, department, hobbies, or interests with valid values. Click Update.
         * Expected Result: Success message and student profile details updated.
      * Invalid Input - Empty Name
         * Test Case Description: Go to Manage Students. Select a student from the table. Click View. Clear the Name field. Click Update.
         * Expected Result: Validation message. Student profile is not updated.
      * Invalid Input - Invalid or Duplicate NUID
         * Test Case Description: Go to Manage Students. Select a student from the table. Click View. Leave NUID blank, enter a value that is not exactly 9 digits, or enter an NUID assigned to another person in the directory. Click Update.
         * Expected Result: Error or validation message. Student profile is not updated.
      * Invalid Input - Email or Phone
         * Test Case Description: Go to Manage Students. Select a student from the table. Click View. Enter an invalid or blank email address, or a phone number that is blank or does not match the format ###-###-####. Click Update.
         * Expected Result: Error message. Student profile is not updated.
      * No Changes Made
         * Test Case Description: Go to Manage Students. Select a student from the table. Click View. Do not change any fields. Click Update.
         * Expected Result: Informational message indicating no changes were made.
      * Delete Student
         * Test Case Description: Go to Manage Students. Select a student from the table. Click Delete. Select Yes on confirmation popup.
         * Expected Result: Success message and student removed from the table. Associated person record and user account, if one exists, are also removed.
      * Delete Student - Cancel
         * Test Case Description: Go to Manage Students. Select a student from the table. Click Delete. Select No on confirmation popup.
         * Expected Result: Deletion canceled and student retained in the table.
      * Null selection
         * Test Case Description: Go to Manage Students. Do not select a student from the table. Click View or Delete.
         * Expected Result: Warning message.
   * Manage Faculty
      * View/Update Faculty Profile
         * Test Case Description: Go to Manage Faculty. Select a faculty member from the table. Click View. Modify Name, NUID, email, phone, department, academic rank, or office location with valid values. Click Update.
         * Expected Result: Success message and faculty profile details updated.
      * Invalid Input - Empty Name
         * Test Case Description: Go to Manage Faculty. Select a faculty member from the table. Click View. Clear the Name field. Click Update.
         * Expected Result: Validation message. Faculty profile is not updated.
      * Invalid Input - Invalid or Duplicate NUID
         * Test Case Description: Go to Manage Faculty. Select a faculty member from the table. Click View. Leave NUID blank, enter a value that is not exactly 9 digits, or enter an NUID assigned to another person in the directory. Click Update.
         * Expected Result: Error or validation message. Faculty profile is not updated.
      * Invalid Input - Email or Phone
         * Test Case Description: Go to Manage Faculty. Select a faculty member from the table. Click View. Enter an invalid or blank email address, or a phone number that is blank or does not match the format ###-###-####. Click Update.
         * Expected Result: Error message. Faculty profile is not updated.
      * No Changes Made
         * Test Case Description: Go to Manage Faculty. Select a faculty member from the table. Click View. Do not change any fields. Click Update.
         * Expected Result: Informational message indicating no changes were made.
      * Delete Faculty
         * Test Case Description: Go to Manage Faculty. Select a faculty member from the table. Click Delete. Select Yes on confirmation popup.
         * Expected Result: Success message and faculty member removed from the table. Associated person record and user account, if one exists, are also removed.
      * Delete Faculty - Cancel
         * Test Case Description: Go to Manage Faculty. Select a faculty member from the table. Click Delete. Select No on confirmation popup.
         * Expected Result: Deletion canceled and faculty member retained in the table.
      * Null selection
         * Test Case Description: Go to Manage Faculty. Do not select a faculty member from the table. Click View or Delete.
         * Expected Result: Warning message.
   * Administrator Profile
      * View/Update Profile
         * Test Case Description: Go to My Profile. Modify ID (Name), NUID, email, phone, department, Hours/Week, or Telework with valid values. Click Update.
         * Expected Result: Success message and administrator profile details updated.
      * Invalid Input - Empty ID or Department
         * Test Case Description: Go to My Profile. Clear the ID (Name) or Department field. Click Update.
         * Expected Result: Validation message. Administrator profile is not updated.
      * Invalid Input - Invalid or Duplicate NUID
         * Test Case Description: Go to My Profile. Leave NUID blank, enter a value that is not exactly 9 digits, or enter an NUID assigned to another person in the directory. Click Update.
         * Expected Result: Error or validation message. Administrator profile is not updated.
      * Invalid Input - Email or Phone
         * Test Case Description: Go to My Profile. Enter an invalid or blank email address, or a phone number that is blank or does not match the format ###-###-####. Click Update.
         * Expected Result: Error message. Administrator profile is not updated.
      * Invalid Input - Working Hours
         * Test Case Description: Go to My Profile. Leave Hours/Week blank or enter a non-integer value, a negative value, or a value greater than 168. Click Update.
         * Expected Result: Error message. Administrator profile is not updated.
      * Working Hours - Boundary Values
         * Test Case Description: Go to My Profile. Enter 0 for Hours/Week and click Update. Repeat with 168, keeping the remaining fields valid.
         * Expected Result: Both boundary values are accepted and saved when they change the existing value.
      * No Changes Made
         * Test Case Description: Go to My Profile. Do not change any fields. Click Update.
         * Expected Result: Informational message indicating no changes were made.
   
### 4. **Faculty Features**
   * Manage Courses
      * Add Course
         * Test Case Description: Go to Manage Courses. Click Add Course. Enter valid Course Number, Course Name, Credits, and Price. Click Save.
         * Expected Result: Total price calculates automatically (Price * Credits). Success message and addition of course to the catalog table.
      * Invalid Input - Missing or Negative Fields
         * Test Case Description: Go to Manage Courses. Click Add Course. Leave fields blank or enter non-positive values (Price <= 0 or Credits <= 0). Click Save.
         * Expected Result: Error message. Course is not added.
      * Invalid Input - Duplicate Course
         * Test Case Description: Go to Manage Courses. Click Add Course. Enter a course number that already exists in the course catalog. Click Save.
         * Expected Result: Error message.
      * Update Course
         * Test Case Description: Go to Manage Courses. Select a course from the table. Click Next. Modify course details with valid values. Click Update.
         * Expected Result: Success message and updated course details reflected in the table.
      * Delete Course
         * Test Case Description: Go to Manage Courses. Select a course from the table. Click Delete. Select Yes on confirmation popup.
         * Expected Result: Success message and course removed from the table.
      * Delete Course - Cancel
         * Test Case Description: Go to Manage Courses. Select a course from the table. Click Delete. Select No on confirmation popup.
         * Expected Result: Deletion canceled and course retained in the table.
      * Null selection
         * Test Case Description: Go to Manage Courses. Do not select a course from the table. Click Next or Delete.
         * Expected Result: Error message.
   * Manage Student Profiles
      * View Student Details
         * Test Case Description: Go to Manage Student Profiles. Select a student from the table. Click View Details.
         * Expected Result: Detail view displays with student personal information (Name, NUID), hobbies, interests, and academic progress (enrolled courses, credits, and GPAs).
      * Null selection
         * Test Case Description: Go to Manage Student Profiles. Do not select a student from the table. Click View Details.
         * Expected Result: Error message.
   * Faculty Profile
      * View/Update Profile
         * Test Case Description: Go to My Profile. Modify email, phone, department, academic rank, or office location. Click Update.
         * Expected Result: Success message and profile details updated.
      * Invalid Input - Empty ID
         * Test Case Description: Go to My Profile. Clear the ID (Name) field. Click Update.
         * Expected Result: Error message.
      * Invalid Input - Duplicate NUID
         * Test Case Description: Go to My Profile. Enter an NUID assigned to another person in the directory. Click Update.
         * Expected Result: Error message.
      * No Changes Made
         * Test Case Description: Go to My Profile. Do not change any fields. Click Update.
         * Expected Result: Informational message indicating no changes were made.
   * Performance Reports
      * View Course Performance
         * Test Case Description: Go to Performance Reports. Select an assigned course from the drop-down combo box.
         * Expected Result:
           * Combo box only displays courses assigned to the logged-in faculty member.
           * Summary metrics display number of enrolled students, class GPA, passing rate, and highest/lowest grades.
           * Table displays students enrolled with Name, NUID, GPA, Letter Grade, and Status (Passing or Needs Review).
      
### 5. **Student Features**
   * Class Registration
      * Register 
         * Test Case Description: Go to Registration. Enter an existing course number from CourseList in which the user is not enrolled. Select a semester. Attempt to add.
         * Expected Result: Success message and addition of course to the table.
      * Invalid Selection - Course ID Not Found
         * Test Case Description: Go to Registration. Enter a course number that does not exist in CourseList. Select a semester. Attempt to add.
         * Expected Result: Error message.
     * Invalid Selection - Course ID Null
         * Test Case Description: Go to Registration. Do not enter a course number. Select a semester. Attempt to add.
         * Expected Result: Error message.
     * Invalid Selection - Duplicate Course
         * Test Case Description: Go to Registration. Enter a course number in which the user has already enrolled. Select a semester. Attempt to add.
         * Expected Result: Error message.
   * Course Work
      * Submit work to current course
         * Test Case Description: Go to Course Work. Select Active Course. Select View Course. Select Assignment Pending Submission. Attach file. Submit.
         * Expected Result: Assignment Status Updated to Submitted. Course Progress increased to account for new submission.
      * Submit work to past course
         * Test Case Description: Go to Course Work. Select Completed Course. Select View Course.
         * Expected Result: Error Message
      * Null selection
         * Test Case Description: Go to Course Work. Click View Course.
         * Expected Result: Error Message
   * Transcript
     * Test Case Description: Go to Transcript.
     * Expected Result: Transcript displays with Name, NUID, Degree Program, Credits Earned, Cumulative Satisfaction Index, GPA, and Course List. GPA reflects Grades not "In Progress." Courses "In Progress" are consistent with those with pending submissions in Course Work.  User cannot change fields.
   * Graduation Audit
     * Test Case Description: Go to Graduation Audit.
     * Expected Result: Graduation Audit displays with message regarding fulfillment of graduation requirements dependent on if credits earned is equal to or greater than credits required. Courses listed based on degree with their status and type (Core or Elective) displayed. User cannot change fields.

---

## 8. Challenges & Solutions

- **Branch Integration & Model Synchronization:**
  - **Challenge:** Developing separate feature branches risked creating conflicts if underlying business classes were modified simultaneously.
  - **Solution:** 
    - **Shared Model Baseline:** Prior to creating feature branches, the team aligned on a minimal working baseline containing core model classes (**Person**, **Profile**, **UserAccount**, etc.) with just enough configured test data to support authentication and routing.
    - **Coordinated Merging:** Handled integration points in shared setup files (**ConfigureABusiness.java**) and core domain models through peer-reviewed pull requests. Whenever team members introduced new attributes or methods (such as faculty office details or student hobbies and interests), they were reviewed before merging to ensure naming consistency, avoid duplicate declarations and reduce conflicts across branches.


- **Cross-Timezone Collaboration:**
  - **Challenge:** eam members operated across different time zones and had different work and academic schedules, making pair programming and immediate pull request turnarounds difficult to maintain continuously.
  - **Solution:** Held scheduled Microsoft Teams kickoff and checkpoint meetings to align on role boundaries, data requirements, and timeline expectations early. For day-to-day execution, the team adopted an asynchronous workflow, using Microsoft Teams chat for quick updates and GitHub Pull Requests for code reviews, discussions, and approvals whenever members came online.

---

## 9. Future Enhancements

- **Additional University Modules & Features:**
   - **Current State:** The system focuses on core workflows across Administrator, Faculty, and Student roles with baseline catalog and registration capabilities.
   - **Enhancement:** Implement supplementary institutional modules including student self-service profile management (updating personal hobbies, interests, and portfolio links), classroom scheduling, tuition billing, payment processing, and prerequisite enforcement.

- **Persistent Database Integration:**
   - **Current State:** The system stores all data in-memory, resetting all state upon application restart.
   - **Enhancement:** Use a relational database (such as PostgreSQL or MySQL) using JDBC or Hibernate/JPA. This ensures persistent record storage, transactional atomicity, and scalable querying for large academic institutions.

- **Security Hardening & Password Hashing:**
   - **Current State:** Credentials in **UserAccount** store passwords as plaintext strings during runtime authentication.
   - **Enhancement:** Implement cryptographic salting and hashing using industry-standard algorithms such as **BCrypt** or **Argon2** before storing passwords. Enforce security policies such as multi-factor authentication (MFA/2FA) and role-based session token invalidation upon timeout or logout.

---

## 10. Contribution Breakdown

| Contributor | Assigned Role | Key Contributions |
| --- | --- | --- |
| **Lee Wang** | University Admin | Administer user accounts, register persons, manage student records, manage faculty records, manage own profile, login/logout |
| **Chinh Nguyen** | Faculty Member | Manage courses, manage own profile, generate performance reports, manage student profiles |
| **Rachel Macaulay** | Student | Manage coursework, register for classes, perform graduation audit, review transcript |
