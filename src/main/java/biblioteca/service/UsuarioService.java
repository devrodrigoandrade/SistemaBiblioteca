package biblioteca.service;

import biblioteca.model.Usuario;
import biblioteca.repository.UsuarioRepository;

import java.security.MessageDigest;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios;
    private UsuarioRepository repo = new UsuarioRepository();

    public UsuarioService() {

        usuarios = repo.carregar();

        if (usuarios.isEmpty()) {

            usuarios.add(new Usuario(
                    "admin",
                    hash("123"),
                    "ADMIN"
            ));

            repo.salvar(usuarios);

            System.out.println("Admin criado: admin / 123");
        }
    }

    public Usuario login(String nome, String senha) {

        String hashSenha = hash(senha);

        for (Usuario u : usuarios) {

            if (u.getNome().equals(nome)
                    && u.getSenhaHash().equals(hashSenha)) {

                return u;
            }
        }

        return null;
    }

    public void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
        repo.salvar(usuarios);
    }

    public String hash(String senha) {

        try {

            MessageDigest md =
                    MessageDigest.getInstance("SHA-256");

            byte[] bytes = md.digest(senha.getBytes());

            StringBuilder sb = new StringBuilder();

            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (Exception e) {
            return senha;
        }
    }
}