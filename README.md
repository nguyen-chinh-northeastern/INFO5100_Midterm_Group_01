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

- The **Digital University System** is a java project designed to support real-world University functionality to include the following:
- **Enforce Secure Access Controls **
- **Maintain Architectural Modularity**
- **Role-Based Functionality** for Administrators, Faculty, and Students
- **Minimum Features:**

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

### 3. Faculty
* **3.1 Manage Courses: ** Click **Manage User Accounts** from the Admin Work Area  add, view, and update class offerings.
  * **3.1.1 Add a Course:** Click "Add Course."
    * 3.1.1.1 Enter Course Number, Course Name, Credits, and Price.
    * 3.1.1.1.1 Total price is determined based on the Price and Credits entries
    * 3.1.1.2 All fields are required. The system performs a check to ensure that all fields are available and suitable (i.e. Price > $0).
    * 3.1.1.3 Click "Save." Successful entries populate the course list table.
  * **3.1.2 View and Edit Details:**
    * 3.1.2.1 Highlight a course in the table
    * 3.1.2.2 Click **Next >>** to display course detials
    * 3.1.2.3 Modify fields as needed within expected constraints and click **Update** to save the changes
  * **3.1.3 Delete a Course:**
    * 3.1.3.1 Select a Course
    * 3.1.3.2 Click ** Delete **
    * 3.1.3.2.1 Review the Popup message. Click ** Yes ** to delete. Click ** No ** to take no action. If they select ** Yes ** a success message will appear.
 * **3.2 Manage Student Profiles: **
     *  3.2.1 Click ** Manage Student Profiles ** from the Faculty Work Area
       *  3.2.1.1 Faculty are able to view student details to include hobbies, interests, and academic progress.
 * **3.3 Faculty Profile: **
 * **3.4 Performance Reports: **
   *   (CONTINUE)
### 4. Student
* **4.1 Course Work: ** Click **Course Work** from the Student Work Area
  * 4.1.1
  * ## 6. Usage Instructions

### 1. Authentication
* **Accessing Accounts:** Enter your assigned credentials (Username and Password) into the login panel and click **Login**.
* **System Verification:** The application invokes the background `UserAccountDirectory` and `Access Control Layer` validation routines.
* **Access Control:** Incorrect credentials deny system entry. 
* **Dynamic Routing:** Authorized sessions trigger a `CardLayout` update to display the workspace panel dedicated to your specific role.

### 2. Administrator
* **Manage User Accounts:** Click **Manage User Accounts** from the Admin Work Area to open user directory tools.
  * Create, view, and update application credentials and assign role profiles to system users.
* **Manage Personnel:** Click **Manage Persons** to track human resources.
  * Register new physical identities (Students or Faculty Members) directly into the core university registry.

### 3. Faculty
* **3.1 Manage Courses:** Click **Manage Courses** from the Faculty Work Area to add, view, and update class offerings.
  * **3.1.1 Add a Course:** Click **Add Course** and input the *Course Number*, *Course Name*, *Credits*, and *Price*.
    * Mandatory inputs: All fields are required; the system blocks creation if the price is evaluated at $0.
    * Automation: The total price computes automatically based on the entered Price and Credits metrics. 
    * Persistence: Successful entries populate the main Course List data table.
  * **3.1.2 View & Edit Details:** Highlight a course in the table and click **Next >>** to display item specs.
    * Modify fields as needed and click **Update** to save the changes back to the system.
  * **3.1.3 Delete a Course:** Select a record and click **Delete**.
    * Safety confirmation: A popup dialog verifies your decision before altering data.
    * Notification: The system provides a success prompt once deletion completes.
* **3.2 Manage Student Profiles:** Click **Manage Student Profiles** from the Faculty Work Area to inspect student rosters.
  * Gain direct insights into student academic progress, listed hobbies, and personal interests.

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

(To be added)

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
