import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuHospede {
    private GerenciaHospedes gerenciaHospedes;
    private Scanner scanner;

    public MenuHospede() {
        this.gerenciaHospedes = new GerenciaHospedes();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuHospedes() {
        int opcao;
        do {
            System.out.println("\nMenu de Gerenciamento de Hóspedes:");
            System.out.println("1. Cadastrar novo hóspede");
            System.out.println("2. Listar todos os hóspedes");
            System.out.println("3. Adicionar Estadia ao hóspede");
            System.out.println("4. Visualizar histórico de estadias de um hóspede");
            System.out.println("5. Editar informações de um hóspede");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarHospede();
                    break;
                case 2:
                    listarHospedes();
                    break;
                case 3:
                    adicionarEstadiaHospede();
                    break;
                case 4:
                    visualizarHistorico();
                    break;
                case 5:
                    editarHospede();
                    break;
                    case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarHospede() {
        System.out.print("Digite o nome do hóspede: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do hóspede: ");
        String cpfInput = scanner.nextLine();

        try {

            Validar validar = new Validar(); // cria instância validar
            validar.validaCPF(cpfInput); // lança CPFException se CPF inválido

            // conversão para inteiro
            String cpf = cpfInput;

            // continuação do cadastro...
            System.out.print("Digite a data de nascimento: ");
            int dataNascimento = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();
            scanner.nextLine();

            gerenciaHospedes.criarEcadastrarHospede(nome, cpf, dataNascimento, endereco, telefone);
            System.out.println("Hóspede cadastrado com sucesso!");

        } catch (CPFException e) {
            System.out.println("Erro ao cadastrar hóspede: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("CPF inválido: insira apenas números.");
        } catch (InputMismatchException e) {
            System.out.println("Erro: insira um valor numérico válido.");
            scanner.nextLine();
        }
    }

    private void visualizarHistorico() {
        System.out.print("Digite o nome do hóspede para visualizar o histórico: ");
        String nome = scanner.nextLine();
        gerenciaHospedes.visualizarHistorico(nome);
    }

    private void editarHospede() {
        System.out.print("Digite o nome do hóspede para editar as informações: ");
        String nome = scanner.nextLine();
        gerenciaHospedes.editarHospede(nome);
    }

    private void listarHospedes() {
        System.out.println("\nLista de Hóspedes Cadastrados:");
        gerenciaHospedes.listarHospedes();
    }

    private void adicionarEstadiaHospede() {
        System.out.print("Digite o nome do hóspede: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data da hospedagem: ");
        String dataHospedagem = scanner.nextLine();

        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();

        System.out.print("Digite a duração da estadia: ");
        int duracao = scanner.nextInt();

        gerenciaHospedes.adicionarEstadiaHospede(nome, dataHospedagem, numeroQuarto, duracao);
    }

}
