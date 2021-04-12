import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObject {

    @FindBy(xpath = "//input[@id='vrm-input']")
    WebElement enterReg;

    public void setEnterReg(WebElement enterReg) {
        this.enterReg = enterReg;
    }

    @FindBy(xpath = "//button[contains(text(),'Free Car Check')]")
    WebElement checkBtn;

    public void clickBtn() {
        checkBtn.click();
    }

    @FindBy(xpath = "//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[2]/dd")
    WebElement txtMake;

    public WebElement getTxtMake() {
        return txtMake;
    }

    @FindBy(xpath = "//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[3]/dd")
    WebElement txtModel;

    public void getTxtModel(WebElement txtModel) {
        this.txtModel = txtModel;
    }

    @FindBy(xpath = "//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[1]/dd")
    WebElement txtReg;

    public WebElement getTxtReg() {
        return txtReg;
    }

    @FindBy(xpath = "//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[4]/dd ")
    WebElement txtColor;

    public WebElement getTxtColor() {
        return txtColor;
    }

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[5]/dd")
    WebElement txtYear;

    public WebElement getTxtYear() {
        return txtYear;
    }
}
