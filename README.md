# Selenium Web Automation Test: Dijital Vergi Dairesi

This project is a Java-based Selenium automation script that tests form interaction on the **[Dijital Vergi Dairesi](https://dijital.gib.gov.tr/)** website using **Google Chrome** and **Mozilla Firefox** simultaneously.

## 🧪 Features

- Opens the Dijital Vergi Dairesi site in both Chrome and Firefox.
- Searches for "Pasaport Bedeli" using the search box.
- Clicks on the relevant link in the search results.
- Switches to the newly opened tab for form submission.
- Fills in a sample form with predefined TCKN, name, surname, city, and tax office information.
- Submits the form.

## 🚀 Technologies Used

- Java
- Selenium WebDriver
- ChromeDriver & GeckoDriver (for Firefox)
- Maven (optional for dependency management)

## 🔧 Setup Instructions

1. **Install Java (JDK 8 or higher).**
2. **Install WebDrivers:**
   - [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
   - [GeckoDriver (for Firefox)](https://github.com/mozilla/geckodriver/releases)
3. **Add WebDrivers to your system's PATH.**
4. **Install a build tool (optional):** Maven or Gradle
5. **Clone or download this repository.**
6. **Run the project:**
   - Compile and run the `SeleniumTest.java` file from your IDE (e.g., IntelliJ, Eclipse) or using `javac` and `java` in the terminal.

## ⚠️ Notes

- The script uses hardcoded values (e.g., TCKN, names, cities), which can be adjusted as needed.
- You must have both Chrome and Firefox installed.
- Ensure pop-ups and new tab handling is not blocked in your browser settings.
- The test depends on the stability and availability of the live [https://dijital.gib.gov.tr](https://dijital.gib.gov.tr) site.
- Make sure the website structure (element IDs, names, and XPath expressions) has not changed. Otherwise, update the locators in the code.

## 📄 License

This project is open for educational and demonstration purposes. No warranty is provided for production usage.
