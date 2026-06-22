package biblioteca.repository;

import biblioteca.model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private final String ARQUIVO = "usuarios.txt";

    public List<Usuario> carregar() {

        List<Usuario> usuarios = new ArrayList<>();

        File file = new File(ARQUIVO);
        if (!file.exists()) return usuarios;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] d = linha.split(";");

                usuarios.add(new Usuario(
                        d[0],
                        d[1],
                        d[2]
                ));
            }

        } catch (Exception e) {
            System.out.println("Erro ao carregar usuários");
        }

        return usuarios;
    }

    public void salvar(List<Usuario> usuarios) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {

            for (Usuario u : usuarios) {

                bw.write(
                        u.getNome() + ";" +
                                u.getSenhaHash() + ";" +
                                u.getRole()
                );

                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Erro ao salvar usuários");
        }
    }
}