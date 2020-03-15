### Este projeto está hospedado no Heroku, caso queira consumir as APIs, a URL base é [ https://module-holder.herokuapp.com/ ]

## Utilizei o Swagger para gerar a documentação das APIs deste projeto.
###### URL da documentação das APIs deste projeto: https://module-holder.herokuapp.com/swagger-ui.html#/

## APIs
![Abaixo está a representação da documentação das APIs com o SWAGGER](https://github.com/muriloalvesdev/holder/blob/master/src/main/resources/swagger/swagger-documentation.png)

#### Descrição da API accomplishSale
##### Endpoint responsável por enviar uma requisição para o banco emissor do cartão, para que a transação seja debitada da conta do cliente ou do cartão de crédito do mesmo.
![accomplishSale](https://github.com/muriloalvesdev/holder/blob/master/src/main/resources/swagger/swagger-accomplish-sale.png)

#### Descrição da API save
##### Endpoint responsável por salvar uma nova Bandeira no banco de dados deste projeto. A ideia é que somente bandeiras cadastradas podem realizar vendas através deste projeto.
![save](https://github.com/muriloalvesdev/holder/blob/master/src/main/resources/swagger/swagger-save.png)
