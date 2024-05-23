package negocio;

import java.util.List;

import dao.SensorTemperaturaDao;
import datos.Dispositivo;

public class SensorTemperaturaAbm {
	private static SensorTemperaturaAbm instancia = null;

	public SensorTemperaturaAbm() {

	}

	public static SensorTemperaturaAbm getInstance() {
		if (instancia == null) {
			instancia = new SensorTemperaturaAbm();
		}

		return instancia;
	}

	public List<Dispositivo> traerTodosLosDispositivosSensorTemperatura() {
		return SensorTemperaturaDao.getInstance().traerTodosLosDispositivosSensorTemperatura();
	}

}
