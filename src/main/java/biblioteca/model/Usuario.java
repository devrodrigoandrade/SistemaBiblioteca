package biblioteca.model;

public class Usuario {

    private String nome;
    private String senhaHash;
    private String role;

    public Usuario(String nome, String senhaHash, String role) {
        this.nome = nome;
        this.senhaHash = senhaHash;
        this.role = role.toUpperCase();
    }

    public String getNome() {
        return nome;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public String getRole() {
        return role;
    }
}