package YandexSamokat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class СreateOrderValidation {
    WebDriver driver;
    private String name;
    private String surname;
    private String buttonType;
    private String address;
    private String metro;
    private String phone;
    private String rent;
    private String orderDate;
    private String colour;
    private String comment;



    public СreateOrderValidation(String buttonType, String name, String surname,
                                 String address, String metro, String phone, String rent,
                                 String orderDate, String colour, String comment) {
        this.address = address;
        this.buttonType = buttonType;
        this.colour = colour;
        this.orderDate = orderDate;
        this.comment = comment;
        this.rent = rent;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.metro = metro;

    }

    @Parameterized.Parameters
    public static List<Object[]> getOrderInformation() {
        return Arrays.asList(new Object[][]{

                {"headerButton", "Владислав", "Струменский", "Г.Москва, улица Новый Арбат д.6", "Арбатская", "89678004534", "двое суток", "01.10.2024", "серая безысходность", "Подойдите ко второму подъезду!"},
                {"middleButton", "Ян", "Владик", "Г.Москва, улица Новый Арбат д.6", "Арбатская", "89000000000", "сутки", "10.13.2095", "серая безысходность", "Подойдите ко второму подъезду!"},

        });

    }
   @Test
    public void createOrderTest(){
       driver.get("https://qa-scooter.praktikum-services.ru/");

       OrderPageSamokat objPageSamokat = new OrderPageSamokat(driver);

       objPageSamokat.createOrder(buttonType, name, surname,
               address, metro, phone,  rent,
               orderDate, colour, comment);
   }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }
}




