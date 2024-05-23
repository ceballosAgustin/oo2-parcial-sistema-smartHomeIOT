package dao;

import java.util.List;

import datos.Dispositivo;
import datos.SensorTemperatura;

public class SensorTemperaturaDao extends Dao<SensorTemperatura> {
	private static SensorTemperaturaDao instancia = null;

	public SensorTemperaturaDao() {

	}

	public static SensorTemperaturaDao getInstance() {
		if (instancia == null) {
			instancia = new SensorTemperaturaDao();
		}

		return instancia;
	}

	// CU 8
	public List<Dispositivo> traerTodosLosDispositivosSensorTemperatura() {
		List<Dispositivo> lista = null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from SensorTemperatura", Dispositivo.class).list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return lista;
	}

}
