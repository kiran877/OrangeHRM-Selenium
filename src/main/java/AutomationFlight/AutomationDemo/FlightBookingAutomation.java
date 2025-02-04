package AutomationFlight.AutomationDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class FlightBookingAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D://Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set up an explicit wait
        
        try {
            // Step 1: Navigate to the OrangeHRM login page
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            System.out.println("URL: " + driver.getCurrentUrl());
            System.out.println("Title: " + driver.getTitle());

            // Step 2: Log in with admin credentials
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

            username.sendKeys("Admin");
            password.sendKeys("admin123");

            // Wait for the login button to be clickable and then click it
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));
            loginButton.click();
            Thread.sleep(10);
            
            // Step 3: Wait for the "PIM" tab to be clickable and click
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));
            driver.findElement(By.linkText("PIM")).click();
            
            // Step 4: Wait for the "Add" button to be clickable and click it
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Add')]")));
            driver.findElement(By.xpath("//button[contains(., 'Add')]")).click();

            // Step 5: Fill in employee details
            WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
            firstNameInput.sendKeys("John");

            WebElement middleNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("middleName")));
            middleNameInput.sendKeys("A.");

            WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
            lastNameInput.sendKeys("Doe");
            
            WebElement toggleSpan = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[contains(@class, 'oxd-switch-input')]")));
            toggleSpan.click();
            System.out.println("Toggle switch span clicked.");

            String newUsername = "johnsdoe";
            String newPassword = "admin123";
            
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@autocomplete='off'])[1]")));  
            usernameField.sendKeys(newUsername);
            
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@autocomplete='off'])[2]")));  
            passwordField.sendKeys(newPassword);
            
            WebElement confirmPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@autocomplete='off'])[3]")));  
            confirmPasswordInput.sendKeys(newPassword);

            // Step 6: Submit the form
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // Step 7: Wait for the "Admin" tab to be clickable and click it
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Admin")));
            driver.findElement(By.linkText("Admin")).click();

            // Step 8: Click on "Add" to create a new user
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class, 'oxd-button--secondary')])[2]")));
            driver.findElement(By.xpath("(//button[contains(@class, 'oxd-button--secondary')])[2]")).click();

            // Step 9: Select "Admin" user role
            WebElement selectTextInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-select-text-input']")));
            selectTextInput.click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement dropdownArrow = driver.findElement(By.xpath("(//i[contains(@class, 'bi-caret-down-fill')])[2]"));
            js.executeScript("arguments[0].click();", dropdownArrow);

            WebElement adminOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']//span[contains(text(), 'Admin')]")));
            adminOption.click();

            // Step 10: Select status
            WebElement statusSelectInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='oxd-select-text-input'])[2]")));
            statusSelectInput.click();

            WebElement statusDropdownArrow = driver.findElement(By.xpath("(//i[contains(@class, 'bi-caret-down-fill')])[2]")); 
            js.executeScript("arguments[0].click();", statusDropdownArrow);

            WebElement enabledOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']//span[contains(text(), 'Enabled')]")));
            enabledOption.click();

            // Step 11: Autocomplete for employee name
            WebElement autocompleteInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type for hints...']")));
            autocompleteInput.clear();
            autocompleteInput.click();
            String nameToSelect = "J";  
            autocompleteInput.sendKeys(nameToSelect);

            WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//div[contains(@class, 'oxd-autocomplete-option')][1]")));
            firstOption.click();

            // Step 12: Fill in the username and password for the new admin
            String adminUsername = "admin_jdoe";
            WebElement usernameField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@autocomplete='off'])[1]")));
            usernameField1.clear();
            usernameField1.sendKeys(adminUsername);

            WebElement passwordField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@autocomplete='off'])[2]")));
            passwordField1.clear();
            passwordField1.sendKeys(newPassword);

            WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@autocomplete='off'])[3]")));
            confirmPasswordField.clear();
            confirmPasswordField.sendKeys(newPassword);

            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            submitButton.click();

            // Step 13: Logout and login as new admin
            WebElement userDropdownTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-userdropdown-tab']")));
            userDropdownTab.click();
            
            WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Logout')]")));
            logoutLink.click();

            WebElement usernameField11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField11.sendKeys(adminUsername);

            WebElement passwordField11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField11.sendKeys(newPassword);

            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}