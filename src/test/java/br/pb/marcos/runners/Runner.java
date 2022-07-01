package br.pb.marcos.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/automacao_magalu.feature",
		glue = "br.pb.marcos.steps",
		plugin = "pretty",
//		tags = "",
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false
		
		)

public class Runner{

}
