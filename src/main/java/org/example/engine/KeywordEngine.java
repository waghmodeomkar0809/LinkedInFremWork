package org.example.engine;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.example.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class KeywordEngine {
    public WebDriver driver;
    public Properties properties;
    BaseClass baseClass;

    WebElement element;

    public static Workbook workbook;
    public static Sheet sheet;
    public final String scenario_sheet_path = System.getProperty("user.dir") + "/src/main/resources/LinkedinFrameWork.xlsx";

    public void starExecution(String sheetName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(scenario_sheet_path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = workbook.getSheet(sheetName);

        int c = 0;
        for (int r = 0; r < sheet.getLastRowNum(); r++) {

            String locatorType = sheet.getRow(r + 1).getCell(c + 1).toString().trim();
            String locatorValue = sheet.getRow(r + 1).getCell(c + 2).toString().trim();
            String Action = sheet.getRow(r + 1).getCell(c + 3).toString().trim();
            String Value = sheet.getRow(r + 1).getCell(c + 4).toString().trim();

            switch (Action) {
                case "open Browser":
                    baseClass = new BaseClass();
                    properties = baseClass.InitializeProperty();
                    if (Value.isEmpty() || Value.equals("NA")) {
                        driver = baseClass.launchBrowser(properties.getProperty("browser"));
                    } else {
                        driver = baseClass.launchBrowser(Value);
                    }
                    break;
                case "entre url":
                    if (Value.isEmpty() || Value.equals("NA")) {
                        driver.get(properties.getProperty("url"));
                    } else {
                        driver.get(Value);
                    }
                    break;
                case "quit":
                    driver.quit();
                    break;
                default:
                    break;
            }
            switch (locatorType) {
                case "id":
                    element = driver.findElement(By.id(locatorValue));
                    if (Action.equalsIgnoreCase("sendkey")) {
                        element.sendKeys(Value);
                    } else if (Action.equalsIgnoreCase("click")) {
                        element.click();
                    } else if (Action.equalsIgnoreCase("getText")) {
                        String elementText = element.getText();
                        System.out.println("text from element" + elementText);
                    } else if (Action.equalsIgnoreCase("isDisplayed")) {
                        element.isDisplayed();
                    } else if (Action.equalsIgnoreCase("clear")) {
                        element.clear();
                    }
                    break;
                case "name":
                    element = driver.findElement(By.name(locatorValue));
                    if (Action.equalsIgnoreCase("sendkey")) {
                        element.sendKeys(Value);
                    } else if (Action.equalsIgnoreCase("click")) {
                        element.click();
                    } else if (Action.equalsIgnoreCase("getText")) {
                        String elementText = element.getText();
                        System.out.println("text from element" + elementText);
                    } else if (Action.equalsIgnoreCase("isDisplayed")) {
                        element.isDisplayed();
                    } else if (Action.equalsIgnoreCase("clear")) {
                        element.clear();
                    }
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(locatorValue));
                    if (Action.equalsIgnoreCase("sendkey")) {
                        element.sendKeys(Value);
                    } else if (Action.equalsIgnoreCase("click")) {
                        element.click();
                    } else if (Action.equalsIgnoreCase("getText")) {
                        String elementText = element.getText();
                        System.out.println("text from element" + elementText);
                    } else if (Action.equalsIgnoreCase("isDisplayed")) {
                        element.isDisplayed();
                    } else if (Action.equalsIgnoreCase("clear")) {
                        element.clear();
                    }
                    break;
                case "cssSelector":
                    element = driver.findElement(By.cssSelector(locatorValue));
                    if (Action.equalsIgnoreCase("sendkey")) {
                        element.sendKeys(Value);
                    } else if (Action.equalsIgnoreCase("click")) {
                        element.click();
                    } else if (Action.equalsIgnoreCase("getText")) {
                        String elementText = element.getText();
                        System.out.println("text from element" + elementText);
                    } else if (Action.equalsIgnoreCase("isDisplayed")) {
                        element.isDisplayed();
                    } else if (Action.equalsIgnoreCase("clear")) {
                        element.clear();
                    }
                    break;
                case "className":
                    element = driver.findElement(By.className(locatorValue));
                    if (Action.equalsIgnoreCase("sendkeys")) {
                        element.sendKeys(Value);
                    } else if (Action.equalsIgnoreCase("click")) {
                        element.click();
                    } else if (Action.equalsIgnoreCase("getText")) {
                        String elementText = element.getText();
                        System.out.println("text from element" + elementText);
                    } else if (Action.equalsIgnoreCase("isDisplayed")) {
                        element.isDisplayed();
                    } else if (Action.equalsIgnoreCase("clear")) {
                        element.clear();
                    }
                    break;
                case "tagName":
                    element = driver.findElement(By.tagName(locatorValue));
                    if (Action.equalsIgnoreCase("sendkeys")) {
                        element.sendKeys(Value);
                    } else if (Action.equalsIgnoreCase("click")) {
                        element.click();
                    } else if (Action.equalsIgnoreCase("getText")) {
                        String elementText = element.getText();
                        System.out.println("text from element" + elementText);
                    } else if (Action.equalsIgnoreCase("isDisplayed")) {
                        element.isDisplayed();
                    } else if (Action.equalsIgnoreCase("clear")) {
                        element.clear();
                    }
                    break;
                case "linkText":
                    element = driver.findElement(By.linkText(locatorValue));

                    if (Action.equalsIgnoreCase("click")) {
                        element.click();
                    } else if (Action.equalsIgnoreCase("getText")) {
                        String elementText = element.getText();
                        System.out.println("text from element" + elementText);
                    }
                    break;
                case "partiallinkText":
                    element = driver.findElement(By.partialLinkText(locatorValue));
                    if (Action.equalsIgnoreCase("click")) {
                        element.click();
                    } else if (Action.equalsIgnoreCase("getText")) {
                        String elementText = element.getText();
                        System.out.println("text from element" + elementText);
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
