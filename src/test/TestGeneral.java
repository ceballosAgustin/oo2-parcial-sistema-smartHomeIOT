package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import datos.Dispositivo;
import datos.Evento;
import negocio.DispositivoAbm;
import negocio.EventoAbm;
import negocio.SensorTemperaturaAbm;

public class TestGeneral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\n1) ");
		System.out.println(DispositivoAbm.getInstance().traer());
		System.out.println();

		/*
		 * System.out.println("\nPrueba ");
		 * System.out.println(DispositivoDao.getInstance().traer("cortina pieza"));
		 * System.out.println();
		 */

		System.out.println("\n2) ");

		try {
			EventoAbm.getInstance().agregar("Apertura de la cortina",
					DispositivoAbm.getInstance().traer("cortina pieza"),
					LocalDateTime.of(LocalDate.of(2023, 4, 3), LocalTime.of(9, 10)));

			EventoAbm.getInstance().agregar("Cierre de la cortina", DispositivoAbm.getInstance().traer("cortina pieza"),
					LocalDateTime.of(LocalDate.of(2023, 4, 3), LocalTime.of(19, 05)));

			EventoAbm.getInstance().agregar("Apertura de la cortina",
					DispositivoAbm.getInstance().traer("cortina pieza"),
					LocalDateTime.of(LocalDate.of(2023, 4, 4), LocalTime.of(9, 00)));

			EventoAbm.getInstance().agregar("Cierre de la cortina", DispositivoAbm.getInstance().traer("cortina pieza"),
					LocalDateTime.of(LocalDate.of(2023, 4, 4), LocalTime.of(19, 01)));

			EventoAbm.getInstance().agregar("23 grados. Prender aire acondicionado",
					DispositivoAbm.getInstance().traer("temp pieza"),
					LocalDateTime.of(LocalDate.of(2023, 4, 4), LocalTime.of(11, 30)));

			EventoAbm.getInstance().agregar("20 grados. Apagar aire acondicionado",
					DispositivoAbm.getInstance().traer("cortina pieza"),
					LocalDateTime.of(LocalDate.of(2023, 4, 4), LocalTime.of(12, 00)));

			EventoAbm.getInstance().agregar("Apertura de la cortina",
					DispositivoAbm.getInstance().traer("cortina pieza"),
					LocalDateTime.of(LocalDate.of(2023, 4, 5), LocalTime.of(9, 05)));

			EventoAbm.getInstance().agregar("Cierre de la cortina", DispositivoAbm.getInstance().traer("cortina pieza"),
					LocalDateTime.of(LocalDate.of(2023, 4, 5), LocalTime.of(19, 05)));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Evento e : EventoAbm.getInstance().traer()) {
			System.out.println(e);
		}

		System.out.println();
		System.out.println("\n3) ");
		System.out.println(EventoAbm.getInstance().traer(LocalDateTime.of(2023, 4, 3, 12, 0),
				LocalDateTime.of(2023, 4, 5, 12, 0)));
		System.out.println();

		System.out.println("\n4) ");
		System.out.println(EventoAbm.getInstance().traer(LocalDateTime.of(2023, 4, 3, 12, 00),
				LocalDateTime.of(2023, 4, 5, 12, 00), DispositivoAbm.getInstance().traer("cortina pieza")));
		System.out.println();

		System.out.println("\n5) ");
		for (Dispositivo st : SensorTemperaturaAbm.getInstance().traerTodosLosDispositivosSensorTemperatura()) {
			System.out.println(st);
		}

	}

}
