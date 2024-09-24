package YandexSamokat;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

public class OrderPageSamokat {

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void input(By locator, String text){
      driver.findElement(locator).sendKeys(text);
    }

    public By getElementByClassAndText(String className, String text){
        return By.xpath("//div[contains(@class, '" + className + "') and text()='" + text + "']");
    }

    public By getElementByLabel(String className, String text) {
        return By.xpath(".//label[contains(@class, '" + className + "') and text()= '" + text + "']");
    }

    private static WebDriver driver;
    // Кнопка заказать в шапке страницы
    private By headerOrderButton = By.className("Button_Button__ra12g");
    // Кнопка заказать в середине страницы
    private By middleOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    // Поле Имя
    private By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле Фамилия
    private By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле Адрес
    private By fieldAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле Станция Метро
    private By fieldMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    // Список Метро
    private By listOfStations = By.xpath(".//div[@class='select-search__select']");
    // Поле номера телефона
    private By fieldPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");
    // Поле Даты доставки самоката
    private By fieldOrderDate = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    // Поле Срок аренды
    private By fieldRentTime = By.xpath(".//div[@class='Dropdown-placeholder']");
    // Чекбокс  выбора цвета самоката "черный жемчуг"
    private By boxSamokatColorBlack = By.xpath(".//input[@id='black']");
    // Чекбокс выбора цвета самоката "Серая безысходность"
    private By boxSamokatColorGrey = By.xpath(".//input[@id='grey']");
    // Поле "комментарий для курьера"
    private By fieldCommentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");
    // Кнопка "Да"
    private By confirmOrderButton = By.xpath(".//button[contains(text(), 'Да')] ");
    // Кнопка принятия куки
    private By CookieButton = By.xpath("//button[@id='rcc-confirm-button']");




    public OrderPageSamokat(WebDriver driver) {
        this.driver = driver;
    }


    public void createOrder(String buttonType, String name, String surname,
                            String address, String metro, String phone, String rent,
                            String orderDate, String colour, String comment) {
//принимаем куки
     clickElement(CookieButton);
//Нажимаем кнопку заказать
     if(buttonType.equals("headerButton")){
         clickElement(headerOrderButton);
     }
     else if (buttonType.equals("middleButton")){
         clickElement(middleOrderButton);

     }
 //вводим имя
        input(fieldName, name);
 // вводим фамилию
        input(fieldSurname, surname);
 // вводим адрес
        input(fieldAdress, address);
 // Открываем выпадающий список метро
        clickElement(fieldMetroStation);
 //Кликаем на станцию метро
        By metroName = getElementByClassAndText("Order_Text__2broi", metro);
        clickElement(metroName);
 //Вводим номер телефона
        input(fieldPhoneNumber, phone);
 // Нажимаем кнопку Далее
        clickElement(nextButton);
 // Вводим дату доставки
        input(fieldOrderDate, orderDate);
        driver.findElement(fieldOrderDate).sendKeys(Keys.ENTER);
 // Нажимаем на поле срок аренды
        clickElement(fieldRentTime);
 // Выбираем срок аренды
        By rentTime = getElementByClassAndText("Dropdown-option", rent);
        clickElement(rentTime);
 // Выбираем цвет самоката
        By samokatColour = getElementByLabel("Checkbox_Label__3wxSf", colour);
        clickElement(samokatColour);
 // Вводим комментарий для курьера
        input(fieldCommentForCourier, comment);
 // Нажимаем кнопку заказать
        clickElement(orderButton);
// Нажимаем кнопку "Да"
        clickElement(confirmOrderButton);


















    }

























}
