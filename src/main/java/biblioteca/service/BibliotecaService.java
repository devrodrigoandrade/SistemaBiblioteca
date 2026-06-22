package biblioteca.service;

import biblioteca.model.Livro;
import biblioteca.repository.LivroRepository;

import java.util.List;

public class BibliotecaService {

    private List<Livro> livros;
    private LivroRepository repo = new LivroRepository();

    public BibliotecaService() {
        livros = repo.carregar();
    }

    public void adicionar(String titulo, String autor) {

        int id = livros.size() + 1;

        livros.add(new Livro(id, titulo, autor));
        repo.salvar(livros);

        System.out.println("Livro adicionado");
    }

    public void listar() {

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }

        for (Livro l : livros) {
            System.out.println(l);
        }
    }

    public void emprestar(int id) {

        for (Livro l : livros) {

            if (l.getId() == id) {

                if (l.isEmprestado()) {
                    System.out.println("Já emprestado");
                    return;
                }

                l.emprestar();
                repo.salvar(livros);

                System.out.println("Emprestado");
                return;
            }
        }

        System.out.println("Não encontrado");
    }

    public void devolver(int id) {

        for (Livro l : livros) {

            if (l.getId() == id) {

                if (!l.isEmprestado()) {
                    System.out.println("Já disponível");
                    return;
                }

                l.devolver();
                repo.salvar(livros);

                System.out.println("Devolvido");
                return;
            }
        }

        System.out.println("Não encontrado");
    }

    public void buscar(String titulo) {

        for (Livro l : livros) {

            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(l);
                return;
            }
        }

        System.out.println("Não encontrado");
    }

    public void remover(int id) {

        livros.removeIf(l -> l.getId() == id);
        repo.salvar(livros);

        System.out.println("Removido");
    }

    public void estatisticas() {

        long emp = livros.stream()
                .filter(Livro::isEmprestado)
                .count();

        System.out.println("Total: " + livros.size());
        System.out.println("Emprestados: " + emp);
        System.out.println("Disponíveis: " + (livros.size() - emp));
    }
}