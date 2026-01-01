# 🚀 DemoQA Automation Testing Project

## 📌 Project Overview

This project automates the **DemoQA web application** using **Selenium WebDriver**, **Java**, **TestNG**, and **Maven**.
It validates major UI functionalities and demonstrates a **scalable, data-driven automation framework** with professional reporting.

---

## 🎯 Objectives

* Automate functional test cases for DemoQA website
* Implement data-driven testing using Excel
* Handle real-world UI challenges such as alerts, frames, windows, and ads
* Generate professional HTML execution reports
* Build an interview-ready Selenium automation framework

---

## 🛠 Technology Stack

| Component            | Tool               |
| -------------------- | ------------------ |
| Programming Language | Java               |
| Automation Tool      | Selenium WebDriver |
| Test Framework       | TestNG             |
| Build Tool           | Maven              |
| Browser              | Mozilla Firefox    |
| Driver Management    | WebDriverManager   |
| Data-Driven Testing  | Apache POI (Excel) |
| Reporting            | Extent Reports     |
| IDE                  | Eclipse            |

---

## 📂 Project Structure

```
DemoQA_Automation
├── src/main/java
│   └── demoqa/utils
│       ├── ExcelUtil.java
│       └── ExtentReportManager.java
│
├── src/test/java
│   └── demoqa/DemoQA_Automation
│       ├── DemoQATitleTest.java
│       ├── DemoQATextBoxTest.java
│       ├── DemoQACheckBoxRadioTest.java
│       ├── DemoQAPracticeFormTest.java
│       ├── DemoQAAlertsFramesWindowsTest.java
│       ├── DemoQAUploadDownloadTest.java
│       ├── DemoQATextBoxDataProviderTest.java
│       └── ExtentTestListener.java
│
├── testdata
│   └── TextBoxData.xlsx
│
├── reports
│   └── ExtentReport.html
│
└── pom.xml
```

---

## ✅ Tasks Implemented

### Task 1 – Project Setup

* Created Maven project
* Added Selenium, TestNG, WebDriverManager dependencies
* Launched DemoQA homepage and validated title

### Task 2 – Text Box Validation

* Automated Text Box form
* Entered user details
* Validated output section

### Task 3 – CheckBox & Radio Button

* Selected multiple checkboxes
* Validated selected values
* Selected radio button and verified result

### Task 4 – Practice Form

* Filled student registration form
* Submitted form
* Validated modal confirmation

### Task 5 – Alerts, Frames & Windows

* Handled simple, confirm, and prompt alerts
* Switched between frames
* Managed multiple browser windows

### Task 6 – Upload & Download

* Uploaded a file and verified filename
* Triggered file download

### Task 7 – Data-Driven Testing

* Implemented Excel-based testing using Apache POI
* Used TestNG `@DataProvider`
* Executed same test with multiple data sets
* Handled ad overlays using JavaScriptExecutor

### Task 8 – Reporting

* Integrated Extent Reports with TestNG
* Generated HTML execution report
* Captured pass/fail status and system information

---

## 📊 Data-Driven Testing

* Test data maintained in Excel
* Each row represents one test iteration
* Improves test reusability and scalability

---

## 📄 Reporting

* Extent Reports generates detailed HTML reports
* Displays:

  * Test name
  * Execution status
  * Failure details
  * System information

📍 Report location:

```
/reports/ExtentReport.html
```

---

## ⚠️ Challenges & Solutions

| Challenge                     | Solution                                        |
| ----------------------------- | ----------------------------------------------- |
| Ads blocking submit button    | Used JavaScriptExecutor                         |
| Excel file path issues        | Used `System.getProperty("user.dir")`           |
| Sheet name mismatch           | Aligned Excel sheet name with code              |
| TestNG not visible in Eclipse | Installed TestNG plugin and added TestNG nature |
| Report generation issues      | Implemented TestNG Listener                     |

---

## 📚 Key Learnings

* Real-world Selenium automation practices
* Handling dynamic UI elements
* Data-driven test execution
* Framework design and reporting

---

## 🏁 Conclusion

This project demonstrates a **complete Selenium automation framework** covering functional testing, data-driven execution, and professional reporting.
The framework is **scalable**, **maintainable**, and suitable for real-world automation testing.

---

## 🔮 Future Enhancements

* Implement Page Object Model (POM)
* Capture screenshots on failure
* Integrate CI/CD using Jenkins
* Enable parallel execution
* Cross-browser testing

---

## 👤 Author

**Syam Mohanan**
Automation Testing Enthusiast


