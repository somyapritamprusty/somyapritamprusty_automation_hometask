# SauceDemo Automation Project

## Project Overview
This project automates selected functionalities of the SauceDemo website:
- Product Sorting
- Cart Item Removal
- Checkout Overview  

It uses **Selenium WebDriver with Java**, **TestNG**, and the **Page Object Model (POM)** for maintainable and modular code.

---

## Project Structure

saucedemo-automation/
│
├── src/
│ ├── main/java/hometask/ # Page Object classes & BaseTest
│ │ ├── BaseTest.java
│ │ ├── LoginPage.java
│ │ ├── HomePage.java
│ │ ├── CartPage.java
│ │ └── CheckoutPage.java
│ │
│ └── test/java/hometask/ # Test classes
│ ├── SortingTest.java
│ ├── CartRemovalTest.java
│ └── CheckoutOverviewTest.java
│
├── pom.xml # Maven dependencies
├── testng.xml # TestNG suite
└── README.md


---

## Prerequisites
1. Java 17+ installed  
2. Maven installed  
3. Chrome browser installed  
4. ChromeDriver compatible with your Chrome version  
5. Any IDE to run Selenium Java

---

## Setup Instructions

1. **Clone the repository or unzip the project folder:**

```bash
git clone https://github.com/somyapritamprusty/somyapritamprusty_automation_hometask.git
# or unzip the provided ZIP file


Open the project in your IDE (Eclipse/IntelliJ recommended).

Ensure Maven dependencies are downloaded:

Right-click the project → Maven → Update Project (Eclipse)

mvn clean install
Check ChromeDriver path (if needed):

The project uses the default ChromeDriver; update path in BaseTest.java if required.

How to Run the Tests
Each test class is independent and can be run separately.

Option 1: Run from IDE
Open any test file under src/test/java/hometask/

Right-click the file (e.g., SortingTest.java) → Run as TestNG Test

Option 2: Run from Maven CLI
Run a specific test class using:

bash
Copy code
mvn -Dtest=SortingTest test
mvn -Dtest=CartRemovalTest test
mvn -Dtest=CheckoutOverviewTest test

Notes
Chrome password popups are disabled via ChromeOptions.
Tests print success messages in the console.
Each test class uses a single login per class for efficiency.