package br.com.reservasalas;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(
                "U001",
                "Aluno Exemplo",
                "aluno@email.com",
                "123456",
                "85999999999",
                "2026001"
        );

        Sala sala = new Sala("S001", "Laboratório 01", 30, "Bloco A");
        sala.adicionarRecurso(new Recurso("R001", "Projetor", "Projetor multimídia", RecursoTipo.PROJETOR));

        ControladorReserva controlador = new ControladorReserva("C001", aluno);
        controlador.adicionarSala(sala);

        Reserva reserva = controlador.realizarReserva(
                "S001",
                LocalDate.now().plusDays(1),
                LocalTime.of(8, 0),
                LocalTime.of(10, 0)
        );

        System.out.println("Reserva criada com sucesso!");
        System.out.println("ID: " + reserva.getId());
        System.out.println("Sala: " + reserva.getSala().getNome());
        System.out.println("Usuário: " + reserva.getUsuario().getNome());
        System.out.println("Status: " + reserva.getStatus());
    }
}
