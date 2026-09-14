package br.com.reservasalas;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private String id;
    private LocalDate data;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private String motivo;
    private StatusReserva status;
    private Sala sala;
    private Usuario usuario;

    public Reserva(String id, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim,
                   String motivo, Sala sala, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.motivo = motivo;
        this.status = StatusReserva.PENDENTE;
        this.sala = sala;
        this.usuario = usuario;
    }

    public void cancelar() {
        this.status = StatusReserva.CANCELADA;
        if (sala != null) {
            sala.removerReserva(this);
        }
    }

    public boolean verificarConflito() {
        if (sala == null) {
            return false;
        }

        for (Reserva outra : sala.getReservas()) {
            if (outra == this || outra.getStatus() == StatusReserva.CANCELADA) {
                continue;
            }

            boolean mesmaData = data.equals(outra.getData());
            boolean sobreposicao = horarioInicio.isBefore(outra.getHorarioFim())
                    && horarioFim.isAfter(outra.getHorarioInicio());

            if (mesmaData && sobreposicao) {
                return true;
            }
        }

        return false;
    }

    public String getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public String getMotivo() {
        return motivo;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public Sala getSala() {
        return sala;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
