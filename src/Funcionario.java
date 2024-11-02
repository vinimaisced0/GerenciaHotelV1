import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario {

    private String nome;
    private String cpf;
    private String cargo;
    private double salarioBase;
    private String turnoDeTrabalho;
    private double horasTrabalhadas;
    private ArrayList<Double> historicoHoras;
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Funcionario(String nome, String cpf, String cargo, double salarioBase, String turnoDeTrabalho) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.turnoDeTrabalho = turnoDeTrabalho;
        this.horasTrabalhadas = 0;
        this.historicoHoras = new ArrayList<>();
    }

    // Métodos Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }

    public String getTurnoDeTrabalho() { return turnoDeTrabalho; }
    public void setTurnoDeTrabalho(String turnoDeTrabalho) { this.turnoDeTrabalho = turnoDeTrabalho; }

    public double getHorasTrabalhadas() { return horasTrabalhadas; }
    public void setHorasTrabalhadas(double horasTrabalhadas) { this.horasTrabalhadas = horasTrabalhadas; }

    public ArrayList<Double> getHistoricoHoras() { return historicoHoras; }

    public void adicionarHoras(double horas) {
        if (horas > 0) {
            this.horasTrabalhadas += horas;
            this.historicoHoras.add(horas);
        } else {
            System.out.println("Horas inválidas. Digite um valor positivo.");
        }
    }

    public double calcularSalario() {
        double salario = this.salarioBase * this.horasTrabalhadas;
        this.horasTrabalhadas = 0; // Reset após cálculo
        return salario;
    }

    public void visualizarHistoricoHoras(String cpf) {
        if (historicoHoras.isEmpty()) {
            System.out.println("Nenhum registro de horas.");
        } else {
            System.out.println("Histórico de horas trabalhadas do funcionário " + nome + ":");
            for (Double horas : historicoHoras) {
                System.out.println("Horas registradas: " + horas);
            }
        }
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Novo Funcionário cadastrado com sucesso!");
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    public void editarFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                Scanner scanner = new Scanner(System.in);
                int opcao;

                do {
                    System.out.println("\nEscolha a informação que deseja editar:");
                    System.out.println("1. Nome");
                    System.out.println("2. CPF");
                    System.out.println("3. Cargo");
                    System.out.println("4. Salário Base");
                    System.out.println("5. Turno de Trabalho");
                    System.out.println("0. Sair");
                    System.out.print("Opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.print("Novo nome: ");
                            String novoNome = scanner.nextLine();
                            funcionario.setNome(novoNome);
                            System.out.println("Nome atualizado com sucesso!");
                            break;
                        case 2:
                            System.out.print("Novo CPF: ");
                            String novoCpf = scanner.nextLine();
                            funcionario.setCpf(novoCpf);
                            System.out.println("CPF atualizado com sucesso!");
                            break;
                        case 3:
                            System.out.print("Novo cargo: ");
                            String novoCargo = scanner.nextLine();
                            funcionario.setCargo(novoCargo);
                            System.out.println("Cargo atualizado com sucesso!");
                            break;
                        case 4:
                            System.out.print("Novo salário base: ");
                            double novoSalarioBase = scanner.nextDouble();
                            funcionario.setSalarioBase(novoSalarioBase);
                            System.out.println("Salário base atualizado com sucesso!");
                            break;
                        case 5:
                            System.out.print("Novo turno de trabalho: ");
                            String novoTurno = scanner.nextLine();
                            funcionario.setTurnoDeTrabalho(novoTurno);
                            System.out.println("Turno de trabalho atualizado com sucesso!");
                            break;
                        case 0:
                            System.out.println("Edição finalizada.");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                } while (opcao != 0);

                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void registrarHorasFuncionario(String cpf, double horas) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionario.adicionarHoras(horas);
                System.out.println("Horas registradas com sucesso para o funcionário " + funcionario.getNome());
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void calcularSalarioFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                double salario = funcionario.calcularSalario();
                System.out.println("O salário do funcionário " + funcionario.getNome() + " é: R$" + salario);
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void cadastrarFuncionario(String nome, String cpf, String cargo, double salarioBase, String turnoDeTrabalho) {
        Funcionario novoFuncionario = new Funcionario(nome, cpf, cargo, salarioBase, turnoDeTrabalho);
        adicionarFuncionario(novoFuncionario);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salarioBase=" + salarioBase +
                ", turnoDeTrabalho='" + turnoDeTrabalho + '\'' +
                ", horasTrabalhadas=" + horasTrabalhadas +
                '}';
    }
}
