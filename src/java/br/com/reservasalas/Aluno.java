package br.com.reservasalas;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private final List<Reserva> reservas = new ArrayList<>();

    public Aluno(String id, String nome, String email, String senha, String telefone, String matricula) {
        super(id, nome, email, senha, telefone, TipoUsuario.ALUNO);
        this.matricula = matricula;
    }

    public List<Reserva> consultarReservas() {
        return new ArrayList<>(reservas);
    }

    public void adicionarReserva(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
