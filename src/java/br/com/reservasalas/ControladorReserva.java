package br.com.reservasalas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ControladorReserva {
    private String id;
    private Usuario usuarioLogado;
    private final List<Sala> salas;
    private final List<Reserva> reservas;

    public ControladorReserva(String id, Usuario usuarioLogado) {
        this.id = id;
        this.usuarioLogado = usuarioLogado;
        this.salas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Reserva realizarReserva(String salaId, LocalDate data, LocalTime inicio, LocalTime fim) {
        Sala sala = buscarSalaPorId(salaId);

        if (sala == null) {
            throw new IllegalArgumentException("Sala não encontrada: " + salaId);
        }

        if (usuarioLogado == null) {
            throw new IllegalStateException("Não há usuário logado.");
        }

        if (!sala.verificarDisponibilidade(data, inicio, fim)) {
            throw new IllegalStateException("A sala não está disponível no período informado.");
        }

        Reserva reserva = new Reserva(
                UUID.randomUUID().toString(),
                data,
                inicio,
                fim,
                "Reserva de sala",
                sala,
                usuarioLogado
        );

        reserva.setStatus(StatusReserva.CONFIRMADA);
        sala.adicionarReserva(reserva);
        reservas.add(reserva);

        if (usuarioLogado instanceof Aluno aluno) {
            aluno.adicionarReserva(reserva);
        } else if (usuarioLogado instanceof Professor professor) {
            professor.adicionarReserva(reserva);
        }

        return reserva;
    }

    public void cancelarReserva(String reservaId) {
        Reserva reserva = buscarReservaPorId(reservaId);
        if (reserva != null) {
            reserva.cancelar();
        }
    }

    public List<Reserva> consultarReservas(String usuarioId) {
        List<Reserva> resultado = new ArrayList<>();

        for (Reserva reserva : reservas) {
            if (reserva.getUsuario() != null && reserva.getUsuario().getId().equals(usuarioId)) {
                resultado.add(reserva);
            }
        }

        return resultado;
    }

    public void adicionarSala(Sala sala) {
        if (sala != null && !salas.contains(sala)) {
            salas.add(sala);
        }
    }

    private Sala buscarSalaPorId(String salaId) {
        for (Sala sala : salas) {
            if (sala.getId().equals(salaId)) {
                return sala;
            }
        }
        return null;
    }

    private Reserva buscarReservaPorId(String reservaId) {
        for (Reserva reserva : reservas) {
            if (reserva.getId().equals(reservaId)) {
                return reserva;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
