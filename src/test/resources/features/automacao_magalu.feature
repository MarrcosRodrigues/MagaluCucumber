# language: pt
Funcionalidade: Interagir Magalu
		Como um usuario
		Eu quero interagir com a categoria
		Para escolher um produto
		
		
Contexto: Deve interagir com categoria
	Dado que estou no site da magalu
	
Esquema do Cenario: Deve interagir com produto
	Quando interagir com a categoria "<categoria>"
	E visualizo os produtos na "<pagina>"
	E rolo a pagina para baixo
	E seleciono o produto
	Entao visualizo a pagina do produto
	E adiciono a sacola
	Então visualizo a pagina de garantia
	E rolo a pagina para baixo
	E clico em ir para sacola
	Então visualizo a pagina da sacola
	
Exemplos:
	|		categoria				| 	pagina 					|
	|	Informática				|	Informática				|
	|	TV e Vídeo				|	TV e Vídeo				|
	|	Eletrodomésticos	|	Eletrodomésticos	|
	|	Móveis						|	Móveis						|
	
	

	
	