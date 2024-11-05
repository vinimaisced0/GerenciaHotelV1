# 🏨 ProjetoHotel

![Badge de Versão](https://img.shields.io/badge/vers%C3%A3o-1.0.0-blue)
![Badge Java](https://img.shields.io/badge/Java-17+-brightgreen)

Um sistema de gerenciamento de hotel desenvolvido em Java, capaz de controlar reservas, gerenciar quartos, hóspedes e funcionários, além de registrar check-ins e check-outs.

## 📑 Índice

- [📋 Visão Geral](#-visão-geral)
- [✨ Funcionalidades](#-funcionalidades)
- [🚀 Uso](#-uso)
- [📂 Estrutura do Projeto](#estrutura-do-projeto)
- [🤝 Contribuição](#-contribuição)
- [📜 Licença](#licença)
- [📬 Contato](#contato)

## 📋 Visão Geral

O **ProjetoHotel** é uma aplicação desktop simples, focada em gerenciar operações de um hotel de pequeno porte. Este projeto foi desenvolvido com fins de aprendizado e prática de conceitos de orientação a objetos em Java, envolvendo estruturas de controle, coleções e classes abstratas.

## ✨ Funcionalidades

- **🏠 Cadastro de Quartos:** Adicione, edite e remova quartos com informações de tipo (solteiro, casal, suíte), capacidade e status (disponível, ocupado, em manutenção).
- **👤 Gerenciamento de Hóspedes:** Cadastro com validação de CPF.
- **📅 Reservas e Check-ins/Check-outs:** Controle completo de reservas e ocupação de quartos.
- **📊 Relatórios:** Exiba relatórios de ocupação e disponibilidade de quartos.

## 🚀 Uso
Para rodar o projeto, abra a pasta no seu IDE e execute o método main na classe Main.

Exemplo de Interação
No menu principal, escolha uma das opções:
1️⃣ Gerenciamento de Quartos
2️⃣ Gerenciamento de Hóspedes
3️⃣ Check-In / Check-Out
Siga as instruções para cadastrar ou visualizar quartos e hóspedes.
Utilize a função de validação de CPF para garantir a integridade dos dados.

## 📂 Estrutura do Projeto

```plaintext
ProjetoHotel/
│   ├── CPFException.java             # Exceção personalizada para validação de CPF.
│   ├── DataException.java            # Exceção personalizada para validação de datas.
│   ├── Estadia.java                  # Representa a estadia de um hóspede, incluindo informações sobre o período.
│   ├── GerenciaHospedes.java         # Gerencia o cadastro e informações dos hóspedes.
│   ├── GerenciaQuartos.java          # Controla e verifica a disponibilidade dos quartos.
│   ├── GerenciaReserva.java          # Gerencia a criação, alteração e cancelamento de reservas.
│   ├── Hospedes.java                 # Representa os hóspedes com dados pessoais e contato.
│   ├── Ignorar.java                  # Classe auxiliar para ignorar entradas inválidas.
│   ├── Main.java                     # Classe principal que inicializa a aplicação.
│   ├── MenuHospede.java              # Interface de menu para operações relacionadas aos hóspedes.
│   ├── MenuQuarto.java               # Interface de menu para operações relacionadas aos quartos.
│   ├── MenuReserva.java              # Interface de menu para operações relacionadas às reservas.
│   ├── Quartos.java                  # Representa os quartos do hotel, com tipo, número e status.
│   ├── Reserva.java                  # Representa uma reserva, incluindo detalhes do hóspede e datas.
│   ├── Validar.java                  # Classe de validação para CPF e datas.
├── README.md
└── LICENSE
```
## 🤝 Contribuição
Contribuições são sempre bem-vindas! Se você tiver alguma ideia para melhorar o projeto, siga os passos:

Faça um fork 🍴 do projeto.
Crie uma nova branch: git checkout -b minha-nova-funcionalidade.
Faça suas alterações e commit: git commit -m 'Minha nova funcionalidade'.
Envie para o repositório: git push origin minha-nova-funcionalidade.
Abra um Pull Request 📥.


## 📜 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 📬 Contato
Criado e mantido por vinimaisced0

GitHub: vinimaisced0

### Pré-requisitos

- [Java JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) instalado
- [Git](https://git-scm.com/) para clonar o repositório (opcional)
- Um IDE, como IntelliJ IDEA ou Eclipse


### Clonando o Projeto

```bash
git clone https://github.com/vinimaisced0/GerenciaHotelV1.git
cd ProjetoHotel


