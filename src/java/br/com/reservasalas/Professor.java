package br.com.reservasalas;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private String departamento;
    private final List<Reserva> reservas = new ArrayList<>();

    public Professor(String id, String nome, String email, String senha, String telefone, String departamento) {
        super(id, nome, email, senha, telefone, TipoUsuario.PROFESSOR);
        this.departamento = departamento;
    }

    public List<Reserva> consultarReservas() {
        return new ArrayList<>(reservas);
    }

    public void adicionarReserva(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
