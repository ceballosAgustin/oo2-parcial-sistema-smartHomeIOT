package dao;

import java.time.LocalDateTime;
import java.util.List;

import datos.Dispositivo;
import datos.Evento;

public class EventoDao extends Dao<Evento> {
	private static EventoDao instancia = null;

	public EventoDao() {

	}

	public static EventoDao getInstance() {
		if (instancia == null) {
			instancia = new EventoDao();
		}
		return instancia;
	}

	// CU3
	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) {
		Evento objeto = null;

		try {
			iniciaOperacion();
			objeto = (Evento) session.createQuery(
					"from Evento e inner join fetch e.dispositivo d where d.idDispositivo = :id AND e.fechaHora = :fechaHora")
					.setParameter("id", dispositivo.getIdDispositivo()).setParameter("fechaHora", fechaHora)
					.uniqueResult();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return objeto;
	}

	// CU5
	public List<Evento> traer() {
		List<Evento> lista = null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from Evento e inner join fetch e.dispositivo", Evento.class).list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return lista;
	}

	// CU6
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta) {
		List<Evento> lista = null;

		try {
			iniciaOperacion();
			lista = session.createQuery(
					"from Evento e inner join fetch e.dispositivo where e.fechaHora >= :fechaHoraDesde AND e.fechaHora <= :fechaHoraHasta",
					Evento.class).setParameter("fechaHoraDesde", fechaHoraDesde)
					.setParameter("fechaHoraHasta", fechaHoraHasta).list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return lista;
	}

	// CU7
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo dispositivo) {
		List<Evento> lista = null;

		try {
			iniciaOperacion();
			lista = session.createQuery(
					"from Evento e inner join fetch e.dispositivo d where e.fechaHora >= :fechaHoraDesde AND e.fechaHora <= :fechaHoraHasta AND d.idDispositivo = :id",
					Evento.class).setParameter("fechaHoraDesde", fechaHoraDesde)
					.setParameter("fechaHoraHasta", fechaHoraHasta).setParameter("id", dispositivo.getIdDispositivo())
					.list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return lista;
	}

}
