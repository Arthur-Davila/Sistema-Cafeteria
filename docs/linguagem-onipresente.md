# Linguagem Onipresente — Sistema de Cafeteria

## 1. Visão Geral do Domínio
Sistema web de gestão para uma cafeteria com atendimento híbrido: presencial (via Totem de autoatendimento na loja) e remoto (via Delivery pelo navegador do celular). O sistema gerencia todo o ciclo operacional, desde a montagem personalizada do pedido pelo cliente, passando pela fila de preparo do barista, até o controle de insumos em estoque e programa de fidelidade.

---

## 2. Dicionário de Termos Oficial

### Perfis (Atores)
* **Cliente:** Pessoa que realiza pedidos (via Totem na loja ou Delivery pelo celular).
* **Barista:** Funcionário responsável por preparar os itens na fila de produção, atualizar o andamento do pedido e chamar o cliente para retirada.
* **Gerente:** Funcionário responsável por cadastrar o cardápio, definir fichas técnicas, auditar o inventário e registrar compras de insumos.

### Vendas e Atendimento (Subdomínio Principal / Core)
* **Produto:** Item vendável cadastrado no cardápio (ex: *Café Expresso*, *Cappuccino*, *Croissant*).
* **Adicional:** Item extra opcional que personaliza um Produto, alterando seu preço final e/ou os insumos consumidos (ex: *Leite de Aveia*, *Dose Extra*, *Chantilly*).
* **Item de Pedido:** Um Produto selecionado pelo Cliente dentro de um Pedido, contendo a quantidade e a lista de Adicionais escolhidos.
* **Pedido:** Solicitação de compra feita pelo Cliente. Possui uma **Modalidade** (`TOTEM` ou `DELIVERY`) e um **Status** (`CRIADO`, `PAGO`, `EM_PREPARO`, `PRONTO`, `ENTREGUE` ou `CANCELADO`).
* **Senha de Retirada:** Identificador curto (ex: `A-015`) gerado automaticamente para pedidos na modalidade `TOTEM` para exibição no painel de chamada da loja.

### Estoque e Produção (Subdomínio de Suporte)
* **Insumo:** Matéria-prima bruta utilizada na cafeteria (ex: *Grão de Café*, *Leite Integral*, *Açúcar*, *Copo Descartável*). Nunca é vendido isoladamente ao cliente.
* **Ficha Técnica:** Receita vinculada a um Produto ou Adicional que define exatamente quais **Insumos** e em qual quantidade são gastos para produzir 1 unidade.
* **Movimentação de Estoque:** Registro histórico de alteração de saldo de um Insumo. Pode ser do tipo `ENTRADA` (compra), `SAIDA` (baixa automática por venda) ou `AJUSTE` (correção por perda/quebra).
* **Inventário:** Rotina de contagem física dos Insumos realizada pelo Barista ou Gerente para confrontar com o saldo registrado no sistema.

### Fidelidade (Subdomínio Genérico)
* **Carteira de Fidelidade:** Conta vinculada ao CPF/cadastro do Cliente que acumula **Pontos** a cada Pedido entregue.
* **Cupom de Recompensa:** Código gerado a partir do resgate de Pontos que concede desconto financeiro em um novo Pedido.

---

## 3. Ações e Eventos do Negócio (Verbos do Domínio)
* **Montar Pedido:** Ato de adicionar Produtos e Adicionais ao carrinho.
* **Confirmar Pedido:** Validação de estoque, pagamento e envio do Pedido para a fila do Barista.
* **Iniciar Preparo:** Ação do Barista ao assumir um Pedido da fila (`PAGO` -> `EM_PREPARO`).
* **Finalizar Preparo / Chamar Cliente:** Ação do Barista ao concluir o Pedido (`EM_PREPARO` -> `PRONTO`), disparando o aviso no painel/celular.
* **Dar Baixa em Insumos:** Desconto automático no saldo do estoque baseado na Ficha Técnica dos itens de um Pedido confirmado.
* **Auditar Inventário:** Lançamento da contagem física que gera registros de `AJUSTE` caso haja divergência.

---

## 4. Padronização (Termos Evitados vs. Termos Oficiais)
Para manter a consistência entre o código Java, banco de dados, telas e testes BDD, a equipe não utilizará sinônimos:

| Não usar (Evitar) | Usar (Termo Oficial) | Motivo |
| :--- | :--- | :--- |
| Lanche, Bebida, Item do Menu | **Produto** | Unifica tudo o que o cliente pode comprar no cardápio. |
| Ingrediente, Matéria-prima, Material | **Insumo** | Diferencia claramente o que vai no estoque do que é vendido. |
| Receita, Composição | **Ficha Técnica** | Termo padrão de gastronomia/cafeterias para consumo de insumos. |
| Comanda, Ordem, Carrinho finalizado | **Pedido** | Representa a entidade única desde a criação até a entrega. |
| Atendente, Cozinheiro, Operador | **Barista** | Unifica o perfil operacional que prepara e chama os pedidos. |