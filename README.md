AVLEventScheduler 🌳🕒
AVLEventScheduler é um projeto em Java desenvolvido para gerenciar eventos utilizando uma árvore AVL, garantindo desempenho eficiente e organização sem conflitos de horários. Com uma estrutura de dados autobalanceada, o sistema mantém os eventos organizados e acessíveis de forma otimizada, ideal para aplicações que exigem agendamento preciso.

Funcionalidades
🌿 Estrutura AVL
Utiliza uma árvore AVL para armazenar os eventos, garantindo que a estrutura permaneça balanceada com diferença de altura máxima de 1 entre subárvores. Isso assegura desempenho eficiente nas operações de inserção, remoção e busca.

📅 Gerenciamento de Eventos
Cada evento contém:

ID único

Horário de início

Horário de término

Descrição (ex: “Aula de Computação”, “Reunião”, etc.)

❌ Evita Conflitos de Horário
Antes de inserir um novo evento, o sistema verifica se há sobreposição de horários, evitando agendamentos duplicados ou conflitantes.

Consultas Disponíveis
Impressão ordenada: Exibe todos os eventos ordenados por ID, utilizando percurso in-order.

Consulta por horário específico: Retorna os eventos que iniciam em um horário determinado.

Consulta por intervalo de tempo: Lista os eventos dentro de um intervalo de tempo informado.

Remoção de evento: Remove um evento com base em seu horário de início.

Requisitos
Java JDK 8 ou superior.

IDE como IntelliJ, Eclipse, ou o terminal para execução via linha de comando.

Como Executar
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/your-username/AVLEventScheduler.git
Acesse o diretório do projeto:

bash
Copiar
Editar
cd AVLEventScheduler
Compile os arquivos Java:

bash
Copiar
Editar
javac -d . src/org/example/*.java
Execute a classe principal:

bash
Copiar
Editar
java org.example.Main
Comandos Suportados
Digite comandos diretamente no terminal:

ADD <event_id> <start_time> <end_time> <description>: Adiciona um novo evento.

QUERY_TIME <start_time>: Consulta eventos que iniciam no horário especificado.

QUERY_RANGE <start_time> <end_time>: Consulta eventos dentro de um intervalo de tempo.

PRINT_INORDER: Lista todos os eventos em ordem de ID.

REMOVE <start_time>: Remove o evento com o horário de início indicado.

Exemplo de Uso
Entrada:

sql
Copiar
Editar
3
ADD 1 10 12 Sessão_de_Código
ADD 2 13 15 Descanso
PRINT_INORDER
Saída:

yaml
Copiar
Editar
Evento com ID 1 inserido com sucesso.
Evento com ID 2 inserido com sucesso.
ID: 1, descrição: Sessão_de_Código, Início: 10, Fim: 12  
ID: 2, descrição: Descanso, Início: 13, Fim: 15
Estrutura do Projeto
bash
Copiar
Editar
AVLEventScheduler/
├── src/
│   └── org/
│       └── example/
│           ├── Btree.java       # Gerencia a árvore AVL
│           ├── Bnode.java       # Nó da árvore com lógica de balanceamento
│           ├── Evento.java      # Classe de dados do evento
│           └── Main.java        # Interface de linha de comando
├── README.md                    # Este arquivo
Sobre o Código
Evento.java: Classe de modelo com atributos do evento, construtores, getters e setters.

Bnode.java: Implementa os nós da árvore AVL com lógica de balanceamento, inserção, remoção e busca.

Btree.java: Controla a árvore como um todo e delega operações para os nós.

Main.java: Interface de usuário por terminal, interpretando os comandos recebidos.
