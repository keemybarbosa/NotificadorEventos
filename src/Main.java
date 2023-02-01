import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidadePessoas;

        imprimirCabecalho();

        do {
            Notificador.getInstance().limparPessoas();

            quantidadePessoas = lerQuantidadePessoas(sc);

            finalizarSeZero(quantidadePessoas);

            lerPessoas(sc, quantidadePessoas);

            lerMensagem(sc);

            exibirNotificacoes();

            System.out.println(Notificador.getInstance().getMensagensComoArray());
        } while(true); //ponto de saída está na função finalizarSeZero

    }

    private static void exibirNotificacoes() {
        for (Pessoa p : Notificador.getInstance().getPessoas()) {
            System.out.printf("[%s] received a message: -> %s%n", p.getNome(), Notificador.getInstance().getMensagem());
        }
    }

    private static void lerMensagem(Scanner sc) {
        sc = new Scanner(System.in);
        System.out.println("Informe a mensagem a ser notificada a todos os usuários: ");
        Notificador.getInstance().setMensagem(sc.nextLine());
    }

    private static void lerPessoas(Scanner sc, int quantidadePessoas) {
        for (int i = 1; i <= quantidadePessoas; i++) {
            System.out.printf("Digite o nome da %da pessoa: \n",i);
            String nome = sc.nextLine();
            Notificador.getInstance().adicionarPessoa(new Pessoa(nome));
        }
    }

    private static void imprimirCabecalho() {
        System.out.println("#####################################################");
        System.out.println("SISTEMA DE NOTIFICAÇÕES");
        System.out.println("#####################################################\n");
    }

    private static void finalizarSeZero(int quantidadePessoas) {
        if (quantidadePessoas == 0) {
            System.out.println("Quantidade de pessoas 0 informada\nEncerrando o sistema!");
            System.exit(0);
        }
    }

    private static int lerQuantidadePessoas(Scanner sc) {
        int quantidadePessoas;
        do {
            sc = new Scanner(System.in);
            System.out.print("Por favor, informe quantas pessoas serão notificadas: ");
            if (sc.hasNextInt()) {
                quantidadePessoas = sc.nextInt();
                break;
            } else {
                System.out.println("Digite um número válido!");
            }
        }while (true); //loop infinito, condição de saída depende de ser informado um valor inteiro.
        return quantidadePessoas;
    }
}