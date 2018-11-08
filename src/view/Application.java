/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Pessoa;
import java.util.Scanner;
import dao.CrudAgenda;

public class Application {

    public static void main(String[] args) {
        painelPrincipal();
    }

    private static void painelPrincipal() {
        int match;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("*****************************************");
            System.out.println("[1] - Listar agenda");
            System.out.println("[2] - Inserir pessoa na agenda");
            System.out.println("[3] - Remover pessoa da agenda");
            System.out.println("[4] - Atualizar pessoa da agenda");
            System.out.println("[0] - Sair");
            match = input.nextInt();
        } while (match < 0 || match > 4
                );
        switch (match) {
            case 0: {
                System.exit(1);
                break;
            }
            case 1: {
                painelListagem(input);
            }
            case 2: {
                if (enviarDados(receberDados())) {
                    System.out.println("Registro inserido com sucesso!");
                    painelPrincipal();
                } else {
                    System.out.println("Ocorreu um erro desconhecido, se persistir reporte!");
                    painelPrincipal();

                }
            }
            case 3: {
                input.nextLine();
                System.out.println("\n\n");
                System.out.println("Insira informações para continuar a exclusão");
                System.out.println("Nome: ");
                String nome = input.nextLine();
                System.out.println("E-mail: ");
                String email = input.nextLine();
                System.out.println("Telefone: ");
                String telefone = input.nextLine();
                char resp;
                do {
                    System.out.println("Você tem certeza que deseja excluir?[S/N]");
                    resp = input.next().charAt(0);
                } while (resp != 'S' && resp != 'N');

                if (resp == 'S') {
                    if (CrudAgenda.removerPessoa(nome, email, telefone)) {
                        System.out.println("Registro removido com sucesso!");
                    } else {
                        System.out.println("Ocorreu um erro, se persistir reporte!");
                    }
                    painelPrincipal();
                } else {
                    painelPrincipal();
                }
            }
            case 4: {
                painelAtualizar(input);
            }
        }

    }

    private static void painelListagem(Scanner input) {
        int match;
        input.nextLine();
        do {
            System.out.println("\n\n");
            System.out.println("[1] - Listagem geral");
            System.out.println("[2] - Filtrar por nome");
            System.out.println("[0] - Voltar");
            match = input.nextInt();
            switch (match) {
                case 0: {
                    painelPrincipal();
                }
                case 1: {
                    CrudAgenda.listarAgenda();
                    System.out.println("\n\n\n");
                    System.out.println("Pressione uma tecla para continuar");
                    input.nextLine();
                    painelPrincipal();

                    break;
                }
                case 2: {
                    input.nextLine();
                    System.out.println("Insira o nome desejado: ");
                    CrudAgenda.listarAgenda(input.nextLine());
                    System.out.println("\n");
                    System.out.println("Pressione uma tecla para continuar");
                    input.nextLine();
                    painelPrincipal();
                    break;
                }
            }
        } while (match != 0);
    }

    private static void painelAtualizar(Scanner input) {
        int match;
        input.nextLine();
        System.out.println("\n\n");
        do {
            System.out.println("[1] - Alterar nome");
            System.out.println("[2] - Alterar telefone");
            System.out.println("[3] - Alterar e-mail");
            System.out.println("[0] - Voltar");
            match = input.nextInt();
            String opcao = "";
            switch (match) {
                case 0: {
                    painelPrincipal();
                    break;
                }
                case 1: {
                    opcao = "nome";
                    break;
                }
                case 2: {
                    opcao = "telefone";
                    break;
                }
                case 3:{
                    opcao = "email";
                    break;
                }
                default:{
                    continue;
                }
            }
            input.nextLine();
            System.out.println("Insira o "+opcao+" atual");
            String valorantigo = input.nextLine();
            System.out.println("Insira o "+opcao+" novo");
            String valornovo = input.nextLine();

            System.out.println("Tem certeza que deseja alterar o "+opcao+" " + valorantigo + " para " + valornovo + " ?[S/N]");
            char resp = input.next().charAt(0);
            if (resp == 'S') {
                if (CrudAgenda.atualizarCadastro(valorantigo, valornovo, match)) {
                    System.out.println("Cadastro atualizado com sucesso!");
                } else {
                    System.out.println("Ocorreu um erro, se persisir reporte!");
                }
            } else {
                painelPrincipal();
            }
        } while (match != 0);
        painelPrincipal();
    }

    private static Pessoa receberDados() {
        Scanner input = new Scanner(System.in);
        System.out.println("FORMULARIO DE CADASTRO");
        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("Telefone (xx xxxxxxxxx): ");
        String telefone = input.nextLine();
        System.out.println("email: ");
        String email = input.nextLine();
        System.out.println("logradouro: ");
        String logradouro = input.nextLine();
        System.out.println("Numero: ");
        int numero = input.nextInt();
        input.nextLine();
        System.out.println("Complemento: ");
        String complemento = input.nextLine();
        System.out.println("Cidade: ");
        String cidade = input.nextLine();
        System.out.println("Estado (UF): ");
        String estado = input.nextLine();

        Pessoa pessoa = new Pessoa(nome, telefone, email, logradouro, numero, complemento, cidade, estado);
        return pessoa;
    }

    private static boolean enviarDados(Pessoa pessoa) {
        return CrudAgenda.inserirPessoa(pessoa);
    }
}
