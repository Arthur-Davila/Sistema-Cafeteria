# Protótipos de Alta Fidelidade — Sistema de Cafeteria

* **Link do Protótipo Interativo (Figma):** `[INSERIR LINK PÚBLICO DO FIGMA AQUI]`
* **Identidade Visual:** Paleta baseada em Marrom Café (`#4A2C2A`), Caramelo (`#D97706`) e Creme (`#FAF8F5`), respeitando rigorosamente os termos oficiais definidos na **Linguagem Onipresente** (`docs/01-linguagem-onipresente.md`).

---

## 1. Fluxo App Delivery (Mobile — 390x844)
*Interface voltada para o cliente remoto que realiza pedidos pelo navegador do celular.*

* **Tela 1A — Login e Identificação:** Autenticação do **Cliente** para acesso ao histórico, endereços salvos e pontos de fidelidade.
* **Tela 1B — Home e Endereço de Entrega:** Exibe o endereço selecionado no topo (com validação de área de cobertura), banner com saldo da **Carteira de Fidelidade**, abas de categorias e lista de **Produtos**.
* **Tela 1C — Personalização do Produto (Modal):** Permite selecionar **Adicionais** (ex: *Leite de Aveia*, *Dose Extra*, *Chantilly*) com atualização dinâmica do valor total do **Item de Pedido**.
* **Tela 1D — Checkout Delivery:** Resumo dos itens, campo para aplicar **Cupom de Recompensa**, cálculo da taxa de entrega (frete), escolha de pagamento e botão **Confirmar Pedido**.
* **Tela 1E — Acompanhamento (Rastreio):** Linha do tempo em tempo real (`PAGO` -> `EM_PREPARO` -> `PRONTO` -> `ENTREGUE`) e opção de **Cancelar Pedido** (habilitada apenas antes de entrar em preparo).

---

## 2. Fluxo Totem de Autoatendimento (Tela Vertical da Loja — 1024x1366)
*Interface touch de alto contraste para pedidos rápidos dentro da cafeteria.*

* **Tela 2A — Tela Inicial (Descanso):** Botão de ação principal (*"Toque para iniciar seu pedido"*) e seleção de consumo (*Comer aqui* ou *Para viagem*).
* **Tela 2B — Cardápio Totem:** Menu lateral de categorias, grade visual com fotos dos **Produtos**, modal de **Adicionais** e barra fixa de resumo no rodapé.
* **Tela 2C — Identificação Opcional e Comprovante:** Opção de informar o CPF para pontuar na **Carteira de Fidelidade** e exibição em destaque da **Senha de Retirada** (ex: `A-042`) após o pagamento.

---

## 3. Fluxo Operacional — Barista, Ponto e Painel TV (Desktop — 1440x1024)
*Telas utilizadas pela equipe da cafeteria durante o atendimento no balcão e cozinha.*

* **Tela 3A — Fila de Preparo (KDS) e Registro de Ponto:** 
  * **Cabeçalho Operacional:** Exibe o perfil logado, sua **Função** (`BARISTA`), horário de **Escala**, status do turno (`Turno Ativo`) e botão para **Bater Ponto** (entrada/saída). O painel bloqueia a manipulação de pedidos caso o ponto de entrada não esteja aberto.
  * **Quadro Kanban:** 3 colunas (`A Fazer / Pago`, `Em Preparo`, `Prontos`). Cada cartão exibe a senha/modalidade, os **Produtos** com **Adicionais** em destaque, o nome do **Colaborador** responsável pelo preparo (*"Preparando por: João Silva"*) e botões para avançar o status ou cancelar.
* **Tela 3B — Painel de Chamada (TV da Loja):** Monitor dividido mostrando os pedidos *Em Preparo* à esquerda e a **Senha de Retirada** destacada em fonte grande à direita quando o pedido fica *Pronto*.

---

## 4. Fluxo Administrativo — Gerente (Desktop — 1440x1024)
*Telas de retaguarda para configuração de receitas, estoque e gestão da equipe.*

* **Tela 4A — Produtos e Ficha Técnica:** Cadastro de **Produtos** e **Adicionais** com painel lateral para vincular os **Insumos** e quantidades da **Ficha Técnica** (bloqueando a ativação do produto no cardápio caso não possua receita).
* **Tela 4B — Controle de Estoque e Inventário:** Listagem de **Insumos** com saldo atual, alerta visual para estoque mínimo, botão para registrar entrada de compra e tabela de fechamento para **Auditoria de Inventário** (calculando divergências entre saldo virtual e contagem física para gerar `AJUSTE`).
* **Tela 4C — Quadro de Colaboradores e Folha de Ponto:** Cadastro de **Colaboradores**, definição de **Funções** e **Escalas de Trabalho**, acompanhamento em tempo real de quem está em turno, cálculo automático de horas trabalhadas/atrasos e ação para ajustar/abonar registros de ponto.