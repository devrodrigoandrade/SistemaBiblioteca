package biblioteca.view;

import biblioteca.model.Usuario;
import biblioteca.service.BibliotecaService;
import biblioteca.service.UsuarioService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BibliotecaService biblioteca = new BibliotecaService();
        UsuarioService usuarios = new UsuarioService();

        Usuario logado = null;

        while (logado == null) {

            System.out.println("\nLOGIN");

            System.out.print("Usuário: ");
            String u = sc.nextLine();

            System.out.print("Senha: ");
            String s = sc.nextLine();

            logado = usuarios.login(u, s);

            if (logado == null) {
                System.out.println("Inválido");
            }
        }

        System.out.println("Bem-vindo " + logado.getNome());

        int op;

        do {

            System.out.println("\n1 Adicionar");
            System.out.println("2 Listar");
            System.out.println("3 Emprestar");
            System.out.println("4 Devolver");
            System.out.println("5 Buscar");
            System.out.println("6 Estatísticas");
            System.out.println("7 Remover (ADMIN)");
            System.out.println("0 Sair");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Título: ");
                    String t = sc.nextLine();

                    System.out.print("Autor: ");
                    String a = sc.nextLine();

                    biblioteca.adicionar(t, a);
                    break;

                case 2:
                    biblioteca.listar();
                    break;

                case 3:
                    biblioteca.emprestar(sc.nextInt());
                    sc.nextLine();
                    break;

                case 4:
                    biblioteca.devolver(sc.nextInt());
                    sc.nextLine();
                    break;

                case 5:
                    System.out.print("Título: ");
                    biblioteca.buscar(sc.nextLine());
                    break;

                case 6:
                    biblioteca.estatisticas();
                    break;

                case 7:
                    if (logado.getRole().equals("ADMIN")) {
                        biblioteca.remover(sc.nextInt());
                        sc.nextLine();
                    }
                    break;
            }

        } while (op != 0);

        sc.close();
    }
}