package biblioteca.repository;

import biblioteca.model.Livro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {

    private final String ARQUIVO = "livros.txt";

    public List<Livro> carregar() {

        List<Livro> livros = new ArrayList<>();

        File file = new File(ARQUIVO);
        if (!file.exists()) return livros;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] d = linha.split(";");

                livros.add(new Livro(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        Boolean.parseBoolean(d[3])
                ));
            }

        } catch (Exception e) {
            System.out.println("Erro ao carregar livros");
        }

        return livros;
    }

    public void salvar(List<Livro> livros) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {

            for (Livro l : livros) {

                bw.write(
                        l.getId() + ";" +
                                l.getTitulo() + ";" +
                                l.getAutor() + ";" +
                                l.isEmprestado()
                );

                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Erro ao salvar livros");
        }
    }
}