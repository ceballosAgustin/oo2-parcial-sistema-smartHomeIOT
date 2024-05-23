package negocio;

import java.util.List;

import dao.DispositivoDao;
import datos.Dispositivo;

public class DispositivoAbm {

	private static DispositivoAbm instancia = null;

	public DispositivoAbm() {

	}

	public static DispositivoAbm getInstance() {
		if (instancia == null) {
			instancia = new DispositivoAbm();
		}
		return instancia;
	}

	public List<Dispositivo> traer() {
		return DispositivoDao.getInstance().traer();
	}

	public Dispositivo traer(String nombre) {
		return DispositivoDao.getInstance().traer(nombre);
	}

}
