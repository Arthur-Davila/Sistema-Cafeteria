
## Mapa de Funcionalidades por Perfil
```mermaid
flowchart TB
    SISTEMA(["☕ SISTEMA DA CAFETERIA"])

    SISTEMA --> CLIENTE
    SISTEMA --> OPERACAO
    SISTEMA --> GESTAO

    subgraph CLIENTE["👤 CLIENTES"]
        direction LR

        subgraph DELIVERY["📱 APP DELIVERY"]
            D1["Gerenciar endereços"]
            D2["Consultar cardápio"]
            D3["Personalizar produtos e adicionais"]
            D4["Calcular frete e aplicar cupons"]
            D5["Realizar pagamento"]
            D6["Acompanhar pedido em tempo real"]
            D7["Cancelar antes do preparo"]
            D8["Acumular e trocar pontos"]

            D1 --> D2 --> D3 --> D4 --> D5 --> D6
            D6 --> D7
            D6 --> D8
        end

        subgraph TOTEM["🖥️ TOTEM"]
            T1["Escolher consumo local ou viagem"]
            T2["Selecionar produtos e adicionais"]
            T3["Informar CPF (opcional)"]
            T4["Realizar pagamento"]
            T5["Receber senha de retirada"]

            T1 --> T2 --> T3 --> T4 --> T5
        end
    end

    subgraph OPERACAO["👨‍🍳 OPERAÇÃO"]
        direction LR
        O1["Registrar entrada e saída"]
        O2["Consultar função e escala"]
        O3["Visualizar fila de pedidos pagos"]
        O4["Assumir pedido"]
        O5["Preparar pedido"]
        O6["Atualizar status"]
        O7["Chamar cliente"]
        O8["Contar inventário"]

        O1 --> O2 --> O3 --> O4 --> O5 --> O6 --> O7
        O6 --> O8
    end

    subgraph GESTAO["👑 GERENCIAMENTO"]
        direction LR
        G1["Cadastrar colaboradores"]
        G2["Definir funções e escalas"]
        G3["Monitorar registro de ponto"]
        G4["Cadastrar insumos e compras"]
        G5["Gerenciar produtos e adicionais"]
        G6["Configurar fichas técnicas"]
        G7["Auditar inventário"]
        G8["Autorizar exceções"]

        G1 --> G2
        G2 --> G3
        G4 --> G5 --> G6
        G6 --> G7 --> G8
    end

    D5 --> O3
    T5 --> PAINEL
    O6 --> PAINEL
    O7 --> NOTIFICACAO

    PAINEL["📺 Painel de senhas da loja"]
    NOTIFICACAO["🔔 Notificação no aplicativo"]

    classDef principal fill:#172554,stroke:#60A5FA,color:#FFFFFF,stroke-width:2px
    classDef cliente fill:#172554,stroke:#60A5FA,color:#DBEAFE
    classDef operacao fill:#422006,stroke:#F59E0B,color:#FEF3C7
    classDef gestao fill:#052E16,stroke:#4ADE80,color:#DCFCE7
    classDef sistema fill:#312E81,stroke:#A78BFA,color:#FFFFFF,stroke-width:3px

    class SISTEMA sistema
    class D1,D2,D3,D4,D5,D6,D7,D8,T1,T2,T3,T4,T5 cliente
    class O1,O2,O3,O4,O5,O6,O7,O8 operacao
    class G1,G2,G3,G4,G5,G6,G7,G8 gestao
    class PAINEL,NOTIFICACAO principal
    ```