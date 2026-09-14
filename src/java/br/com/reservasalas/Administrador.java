package br.com.reservasalas;

public class Administrador extends Usuario {
    private String login;

    public Administrador(String id, String nome, String email, String senha, String telefone, String login) {
        super(id, nome, email, senha, telefone, TipoUsuario.ADMINISTRADOR);
        this.login = login;
    }

    public void cadastrarSala() {
        System.out.println("Cadastro de sala solicitado.");
    }

    public void editarSala() {
        System.out.println("Edição de sala solicitada.");
    }

    public void desativarSala() {
        System.out.println("Desativação de sala solicitada.");
    }

    public void gerenciarUsuarios() {
        System.out.println("Gerenciamento de usuários solicitado.");
    }

    public void gerenciarRecursos() {
        System.out.println("Gerenciamento de recursos solicitado.");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
