package br.com.reservasalas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String id;
    private String nome;
    private int capacidade;
    private String localizacao;
    private StatusSala status;
    private final List<Reserva> reservas;
    private final List<Recurso> recursos;

    public Sala(String id, String nome, int capacidade, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
        this.status = StatusSala.ATIVA;
        this.reservas = new ArrayList<>();
        this.recursos = new ArrayList<>();
    }

    public boolean verificarDisponibilidade(LocalDate data, LocalTime inicio, LocalTime fim) {
        if (status == StatusSala.DESATIVADA || data == null || inicio == null || fim == null || !inicio.isBefore(fim)) {
            return false;
        }

        for (Reserva reserva : reservas) {
            if (reserva.getStatus() != StatusReserva.CANCELADA
                    && reserva.getData().equals(data)
                    && horariosConflitam(inicio, fim, reserva.getHorarioInicio(), reserva.getHorarioFim())) {
                return false;
            }
        }

        return true;
    }

    private boolean horariosConflitam(LocalTime inicio1, LocalTime fim1, LocalTime inicio2, LocalTime fim2) {
        return inicio1.isBefore(fim2) && fim1.isAfter(inicio2);
    }

    public void adicionarReserva(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public void adicionarRecurso(Recurso recurso) {
        if (recurso != null && !recursos.contains(recurso)) {
            recursos.add(recurso);
        }
    }

    public void removerRecurso(Recurso recurso) {
        recursos.remove(recurso);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public StatusSala getStatus() {
        return status;
    }

    public void setStatus(StatusSala status) {
        this.status = status;
    }

    public List<Reserva> getReservas() {
        return new ArrayList<>(reservas);
    }

    public List<Recurso> getRecursos() {
        return new ArrayList<>(recursos);
    }
}
