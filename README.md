#  Test Automation Framework - SauceDemo

![Java](https://img.shields.io/badge/Java-25-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.27.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.10.2-blue)
![Build](https://img.shields.io/badge/Build-Maven-purple)

## 📌 Project Overview
This project is a robust, modular, and scalable **Test Automation Framework** developed for the [SauceDemo](https://www.saucedemo.com/) e-commerce platform. It demonstrates advanced automation techniques including **Page Object Model (POM)**, **Cross-Browser Testing**, **Parallel Execution**, and **Data-Driven Testing**.

---

##  Key Features (Why this project stands out)

### 1. Advanced Architecture & Design
* **Page Object Model (POM):** Strict separation between test logic (`tests` package) and UI locators/actions (`pages` package) for maintainability.
* **BaseTest Inheritance:** Centralized driver setup (`@BeforeMethod`) and teardown (`@AfterMethod`) logic to keep test classes clean.

### 2. Cross-Browser & Parallel Execution
* **Multi-Browser Support:** Tests run seamlessly on **Google Chrome** and **Microsoft Edge**.
* **Parallel Execution:** Configured via `testng.xml` (`parallel="tests"`) to execute Chrome and Edge tests **simultaneously**, significantly reducing test runtime.
* **Hybrid Driver Management:**
    * **Chrome:** Managed automatically via `WebDriverManager`.
    * **Edge:** Implemented via **local driver injection** (`msedgedriver.exe`) to bypass strict network/firewall restrictions.

### 3. Stability & robustness mechanisms
* **Popup & Security Blocking:** Custom `ChromeOptions` implementation to aggressively block:
    * *"Password found in a data breach"* popups (which typically break automation).
    * Save password bubbles.
    * Notifications and Info-bars.
* **Explicit Waits:** Intelligent synchronization using `WebDriverWait` and `ExpectedConditions` (no `Thread.sleep`).

### 4. Reporting & Error Handling
* **Automatic Screenshots:** Implemented `ITestResult` listener logic to automatically capture and save screenshots to the `screenshots/` directory whenever a test fails.
* **Data-Driven Testing (DDT):** Utilizes TestNG `@DataProvider` to verify login functionality across multiple user personas (`standard_user`, `problem_user`, `visual_user`) in a single test iteration.

---

## 🛠️ Technology Stack

| Component | Technology | Version |
| :--- | :--- | :--- |
| **Language** | Java JDK | 25 |
| **Web Driver** | Selenium WebDriver | 4.27.0 |
| **Test Runner** | TestNG | 7.10.2 |
| **Build Tool** | Maven | 3.x |
| **Browsers** | Chrome, Edge | Latest |

---

## 📂 Project Structure

```text
src/test/java
├── pages               # Page Object Classes
│   ├── LoginPage.java      # Locators & Methods for Login
│   └── InventoryPage.java  # Locators & Methods for Products/Cart
├── tests               # Test Scripts
│   ├── BaseTest.java       # Setup, Teardown, Screenshot logic
│   ├── LoginTest.java      # Login scenarios (Positive, Negative, DDT)
│   └── ShoppingTest.java   # E2E scenarios (Add to cart, Logout)
└── resources           # Test Data & Drivers

---


## Test Scenarios Covered

### ✅ Login Tests (`LoginTest.java`)
1.  **testSuccessfulLogin:** Verifies valid login redirects to inventory.
2.  **testFailedLogin:** Verifies error message appearance for invalid credentials.
3.  **testLoginWithMultipleUsers (Data-Driven):** Runs 3 iterations to test `standard_user`, `problem_user`, and `visual_user`.

### ✅ Shopping & E2E Tests (`ShoppingTest.java`)
1.  **testAddToCart:** Adds an item, verifies cart badge counter updates, and validates UI state change (Add -> Remove).
2.  **testPageTitle:** Verifies the correct page metadata.
3.  **testLogout:** Performs a secure logout and verifies redirection to the login page (waiting for UI elements to stabilize).

---

## 📸 Screenshots
Failed tests are automatically captured and stored in the root `screenshots/` folder for debugging purposes.

---

