# INFO5100_Midterm_Group_01
INFO 5100 Midterm Project: Digital University System with Role-Based Access Control (RBAC) across Admin, Faculty, and Student roles (Group 01)

---

## 1. Team Information

| Team Member Name | NUID | Assigned Role | Core Responsibilities |
| :--- | :--- | :--- | :--- |
| **Lee Wang** | - | University Admin | Administer user accounts, register persons, manage student records, manage faculty records, manage own profile |
| **Chinh Nguyen** | **3946343** | Faculty Member | Manage courses, manage own profile, generate performance reports, manage student profiles |
| **Rachel Macaulay** | **2082631** | Student | Manage coursework, register for classes, perform graduation audit, review transcript |

---

## 2. Project Overview

The **Digital University System** is a java project designed to support real-world University functionality to include the following:

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
* **Manage own profile**.

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

### 2. Adminitrator (TBD)
* **2.1 Administer User Accounts:** Click **Administer User Accounts** from the Admin Work Area to view, create, delete, and update user accounts.
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
    * 2.1.3.2 click "Next>>" to access selected user account details (name, NUID, username, and password)
    * 2.1.3.3 TBD Make changes
    * 2.1.3.4 Click "Update>>" to save changes
* **2.2 Manage Faculty:**
* **2.3 Manage Students:**
* **2.4 Register Persons:**
* **2.5 Administrator (Own) Profile:**
  
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
     (To be added)
   
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
| **Lee Wang** | University Admin | Administer user accounts, register persons, manage student records, manage faculty records, manage own profile |
| **Chinh Nguyen** | Faculty Member | Manage courses, manage own profile, generate performance reports, manage student profiles |
| **Rachel Macaulay** | Student | Manage coursework, register for classes, perform graduation audit, review transcript |
