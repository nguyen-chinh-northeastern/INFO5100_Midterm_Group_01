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

(To be added)

---

## 3. Installation & Setup Instructions

### Prerequisites
- **JDK:** Java Development Kit 21 or higher
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

(To be added)

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

(To be added)

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
