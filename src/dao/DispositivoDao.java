package dao;

import java.util.List;

import datos.Dispositivo;

public class DispositivoDao extends Dao<Dispositivo> {

	private static DispositivoDao instancia = null;

	public DispositivoDao() {

	}

	public static DispositivoDao getInstance() {
		if (instancia == null) {
			instancia = new DispositivoDao();
		}
		return instancia;
	}

	// CU1
	public List<Dispositivo> traer() {
		List<Dispositivo> lista = null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from Dispositivo", Dispositivo.class).list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return lista;
	}

	// CU2
	public Dispositivo traer(String nombre) {
		Dispositivo objeto = null;

		try {
			iniciaOperacion();
			objeto = (Dispositivo) session.createQuery("from Dispositivo d where d.nombre = :nombre")
					.setParameter("nombre", nombre).uniqueResult();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return objeto;
	}

}
