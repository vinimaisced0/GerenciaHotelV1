import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuQuarto menuQuarto = new MenuQuarto();
        MenuHospede menuHospede = new MenuHospede();
        GerenciaReserva gerenciaReserva = new GerenciaReserva();
        MenuFuncionario menuFuncionario = new MenuFuncionario();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Gerenciamento de Quartos e Check-in/Out");
            System.out.println("2. Gerenciamento de Hóspedes");
            System.out.println("3. Gerenciamento de Reservas");
            System.out.println("4. Gerenciamento de Funcionários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuQuarto.exibirMenuQuarto();
                    break;
                case 2:
                    menuHospede.exibirMenuHospedes();
                    break;
                case 3:
                    MenuReserva menuReserva = new MenuReserva(gerenciaReserva);
                    menuReserva.exibirMenuReserva();
                    break;
                case 4:
                    menuFuncionario.exibirMenuFuncionarios();
                    break;
                case 0:
                    System.out.println("Saindo.... cuidja...");

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}



