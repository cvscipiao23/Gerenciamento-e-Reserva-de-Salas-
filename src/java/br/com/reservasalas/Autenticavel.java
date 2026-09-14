package br.com.reservasalas;

public interface Autenticavel {
    boolean login(String email, String senha);
    void recuperarSenha(String email);
}
