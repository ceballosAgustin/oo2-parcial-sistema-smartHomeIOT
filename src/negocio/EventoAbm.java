package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.EventoDao;
import datos.Dispositivo;
import datos.Evento;

public class EventoAbm {
	private static EventoAbm instancia = null;

	public EventoAbm() {

	}

	public static EventoAbm getInstance() {
		if (instancia == null) {
			instancia = new EventoAbm();
		}
		return instancia;
	}

	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) {
		return EventoDao.getInstance().traer(dispositivo, fechaHora);
	}

	// CU4
	public int agregar(String descripcion, Dispositivo dispositivo, LocalDateTime fechaHora) throws Exception {
		if (EventoDao.getInstance().traer(dispositivo, fechaHora) != null) {
			throw new Exception("ERROR: ya existe un evento para ese dispositivo en la misma fecha y hora.");
		}

		return EventoDao.getInstance().agregar(new Evento(descripcion, dispositivo, fechaHora));
	}

	public List<Evento> traer() {
		return EventoDao.getInstance().traer();
	}

	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta) {
		return EventoDao.getInstance().traer(fechaHoraDesde, fechaHoraHasta);
	}

	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo dispositivo) {
		return EventoDao.getInstance().traer(fechaHoraDesde, fechaHoraHasta, dispositivo);
	}

}

