package br.com.reservasalas;

public class Usuario implements Autenticavel {
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private TipoUsuario tipo;
    private boolean ativo;

    public Usuario(String id, String nome, String email, String senha, String telefone, TipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.tipo = tipo;
        this.ativo = true;
    }

    @Override
    public boolean login(String email, String senha) {
        return ativo && this.email.equals(email) && this.senha.equals(senha);
    }

    @Override
    public void recuperarSenha(String email) {
        if (this.email.equals(email)) {
            System.out.println("Solicitação de recuperação de senha enviada para: " + email);
        } else {
            System.out.println("E-mail não encontrado.");
        }
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getTelefone() {
        return telefone;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
