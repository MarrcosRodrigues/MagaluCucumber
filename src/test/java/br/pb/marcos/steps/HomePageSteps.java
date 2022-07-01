package br.pb.marcos.steps;


import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class HomePageSteps {
	
	private WebDriver driver;
	
	@Dado("que estou no site da magalu")
	public void queEstouNoSiteDaMagalu() {
		driver = new FirefoxDriver();
		driver.get("https://www.magazineluiza.com.br/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Quando("interagir com a categoria {string}")
	public void interagirComACategoria(String string) {
		driver.findElement(By.linkText(string)).click();
	}
	@Quando("visualizo os produtos na {string}")
	public void visualizoOsProdutosNa(String string) {
		String ctg = driver.findElement(By.xpath("//div[@class='sc-brSvTw gBdtaO']//h1")).getText();
		Assert.assertEquals(string, ctg);
	}
	
	@Entao("rolo a pagina para baixo")
	public void roloAPaginaParaBaixo() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	
	@Entao("seleciono o produto")
	public void selecionoOPrimeiroProduto() {
		driver.findElement(By.xpath("//div[@class='sc-brSvTw hIvnfX']//li[1]")).click();
	}
	
	String produto;
	@Entao("visualizo a pagina do produto")
	public void visualizoAPaginaDoProduto() {
		produto = driver.findElement(By.xpath("//div[@class='sc-brSvTw hqZWlj']//h1")).getText();
	}
	
	@Entao("adiciono a sacola")
	public void adicionoASacola() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//div[@class='sc-eCImPb DcfVk']")).click();
	}
	
	@Então("visualizo a pagina de garantia")
	public void visualizoAPaginaDeGarantia() {
		try {
			String garantiaproduto;
			garantiaproduto = driver.findElement(By.xpath("//div[@class='sc-eCImPb dAIaCU']//p")).getText();
			garantiaproduto = garantiaproduto.replace("...","");
			assertTrue(produto.startsWith(garantiaproduto));
		} catch (NoSuchElementException e) {
			System.err.println("O produto não tem pagina de garantia antes de ir para a sacola");
		} 
			
	}

	@Então("clico em ir para sacola")
	public void clicoEmIrParaSacola() {
		try {
			driver.findElement(By.xpath("//label[@class='sc-dJjYzT bMXplM']")).click();
		} catch (NoSuchElementException e) {
			System.err.println("O produto não tem pagina de garantia antes de ir para a sacola");
		}
		
	}
	
	@Então("visualizo a pagina da sacola")
	public void visualizoAPaginaDaSacola() {
		String produtocarrinho;
		produtocarrinho = driver.findElement(By.xpath("//div[@class='BasketItemProduct-info']//p[1]")).getText();
		assertTrue(produtocarrinho.startsWith(produto));
	}

	@After
	public void fecharBrowser() {
		driver.quit();
	}

}
