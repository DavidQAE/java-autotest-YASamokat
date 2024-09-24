package YandexSamokat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class HomePageSamokat {



    private static WebDriver driver;
    // Заголовок ЯндексСамоката
    private By yandexHeader = By.className("Header_Logo__23yGT");
    // Раздел Вопросы о важном
    private By questionsSection = By.className("Home_FourPart__luthg");
    // Вопрос о том, как платить
    private By howToPayQuestion = By.id("accordion__heading-0");
    // Вопрос о количество покупаемых самокатов
    private By plentySamokatsQuestion = By.id("accordion__heading-1");
    // Вопрос о времени аренды
    private By timeOfRentQuestion = By.id("accordion__heading-2");
    // Вопрос о заказе самоката сегодня
    private By tommorowOrderQuestion = By.id("accordion__heading-3");
    // Вопрос о продлении заказа
    private By extendOrderQuestion = By.id("accordion__heading-4");
    // Вопрос о зарядке для самоката
    private By chargerQuestion = By.id("accordion__heading-5");
    // Вопрос о возможности отмены заказа
    private By cancelOrderQuestion = By.id("accordion__heading-6");
    // Вопрос о расстоянии за мкадом
    private By mkadQusetion = By.id("accordion__heading-7");


// кнопка принять куки
    private By CookieButton = By.xpath("//button[@id='rcc-confirm-button']");

    private By listOfQuestions = By.xpath("//div[@class='accordion__item']/parent::div");


    public HomePageSamokat(WebDriver driver) {
        this.driver = driver;
    }
    public By getAnswerLocator(String questionText) {
        return By.xpath("//div[@class='accordion__item' and contains(text(),'" + questionText + "')]/following-sibling::div");
    }
    public void clickCloseCookies() {
        WebElement element = driver.findElement(CookieButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    public List<WebElement> elementList() {
        return driver.findElements(listOfQuestions);

    }
    }

