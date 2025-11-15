## 💰 Conversor de Moedas 

Um conversor de moedas desenvolvido em **Java**, que utiliza a biblioteca **Gson** e a API pública **ExchangeRate-API** para obter e calcular taxas de câmbio atualizadas.

---

### 🌟 Funcionalidades

* **Menu Interativo:** Oferece 6 opções de conversão predefinidas para facilitar o uso.
* **Consumo de API:** Faz requisições HTTP assíncronas (via `HttpClient`) para a **ExchangeRate-API** (V6).
* **Conversão Direta:** Calcula o valor convertido com base na taxa mais recente.


---

### 🛠️ Tecnologias e Dependências

| Componente | Uso | Versão/Detalhe |
| :--- | :--- | :--- |
| **Linguagem** | Principal | Java 17 |
| **API Externa** | Taxas de Câmbio | [ExchangeRate-API](https://www.exchangerate-api.com/) (V6) |
| **JSON Parser** | Desserialização de dados | **Gson** (Google) |
| **Requisições HTTP** | Módulo nativo do Java | `java.net.http.HttpClient` |


### 🚀 Configuração e Como Rodar o Projeto

Siga estes passos para configurar e executar o conversor.

1.  Obter e Inserir a API Key

O projeto requer uma chave da API para funcionar:

    Acesse o site da ExchangeRate-API e obtenha sua chave de acesso gratuita.

    No  projeto, localize o arquivo ConversorDeMoeda.java (no pacote br.com.alura.conversordemoedas.exchangerateapi).

    Substitua o placeholder SUA API KEY AQUI ! na linha da variável apiKey pela sua chave:

    
