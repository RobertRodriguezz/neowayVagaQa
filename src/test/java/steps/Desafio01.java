package steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class Desafio01 {

	WebDriver driver;

	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rcastrod\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1200, 765));

	}

	@After
	public void after() {
		// driver.quit();
	}

	@Dado("que acesso a pagina https:\\/\\/www.w{int}schools.com\\/howto\\/howto_css_modals.asp")
	public void que_acesso_a_pagina_https_www_w_schools_com_howto_howto_css_modals_asp(Integer int1) {
		driver.get("https://www.w3schools.com/howto/howto_css_modals.asp\r\n" + "");
	}

	@Dado("clico em {string}")
	public void clico_em(String string) {
		driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/button")).click();
	}

	@Entao("valido a abertura do modal")
	public void valido_a_abertura_do_modal() {

		driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/div[3]/div")).getText();
		assertEquals("Modal Footer", "Modal Footer");

	}

	@Entao("fecho o modal e valido o fechamento")
	public void fecho_o_modal_e_valido_o_fechamento() throws InterruptedException {
		
		driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/div[3]/div/header/span")).click();
		
		
	}
}