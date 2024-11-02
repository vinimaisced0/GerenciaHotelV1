import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuFuncionario {
    private GerenciaFuncionario gerenciaFuncionario;
    private Scanner scanner;
    private Validar validar;

    public MenuFuncionario() {
        this.gerenciaFuncionario = new GerenciaFuncionario();
        this.scanner = new Scanner(System.in);
        this.validar = new Validar();
    }

    public void exibirMenuFuncionarios() {
        int opcao = -1;
        do {
            System.out.println("\nMenu de Gerenciamento de Funcionários:");
            System.out.println("1. Cadastrar novo funcionário");
            System.out.println("2. Listar todos os funcionários");
            System.out.println("3. Editar informações de um funcionário");
            System.out.println("4. Registrar horas trabalhadas");
            System.out.println("5. Calcular salário de um funcionário");
            System.out.println("6. Visualizar histórico de Horas Trabalhadas");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            try{
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro: insira um valor numérico válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    gerenciaFuncionario.listarFuncionarios();
                    break;
                case 3:
                    editarFuncionario();
                    break;
                case 4:
                    registrarHoras();
                    break;
                case 5:
                    calcularSalario();
                    break;
                case 6:
                    visualizarHistoricoHoras();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void cadastrarFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        String cpf;
        while (true) {
            System.out.print("Digite o CPF do funcionário: ");
            cpf = scanner.nextLine();
            try {
                validar.validaCPF(cpf); // validar cpf
                break; // sai do loop se o CPF for válido
            } catch (CPFException e) {
                System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("CPF inválido: insira apenas números.");
            }
        }

        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        System.out.print("Digite o salário base por hora do funcionário: ");
        double salarioBase;
        try {
            salarioBase = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Digite o turno de trabalho do funcionário: ");
            String turnoDeTrabalho = scanner.nextLine();

            gerenciaFuncionario.cadastrarFuncionario(nome, cpf, cargo, salarioBase, turnoDeTrabalho);
            System.out.println("Funcionário cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Erro: insira um valor numérico válido para o salário.");
            scanner.nextLine();
        }
    }

    private void editarFuncionario() {
        System.out.print("Digite o CPF do funcionário para editar as informações: ");
        String cpf = scanner.nextLine();
        gerenciaFuncionario.editarFuncionario(cpf);
    }

    private void registrarHoras() {
        System.out.print("Digite o CPF do funcionário para registrar horas: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o número de horas trabalhadas: ");
        try {
            double horas = scanner.nextDouble();
            scanner.nextLine();
            gerenciaFuncionario.registrarHorasFuncionario(cpf, horas);
        } catch (InputMismatchException e) {
            System.out.println("Erro: insira um valor numérico válido para as horas.");
            scanner.nextLine();
        }
    }

    private void calcularSalario() {
        System.out.print("Digite o CPF do funcionário para calcular o salário: ");
        String cpf = scanner.nextLine();
        gerenciaFuncionario.calcularSalarioFuncionario(cpf);
    }

    private void visualizarHistoricoHoras() {
        System.out.print("Digite o CPF do funcionário para visualizar o histórico de horas: ");
        String cpf = scanner.nextLine();
        gerenciaFuncionario.visualizarHistoricoHoras(cpf);
    }


}
