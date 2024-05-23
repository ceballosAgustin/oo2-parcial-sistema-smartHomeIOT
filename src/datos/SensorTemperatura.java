package datos;

public class SensorTemperatura extends Dispositivo {

	private double valorMaximo;
	private double valorMinimo;

	public SensorTemperatura() {

	}

	public SensorTemperatura(double valorMaximo, double valorMinimo) {
		super();
		this.valorMaximo = valorMaximo;
		this.valorMinimo = valorMinimo;
	}

	public double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	@Override
	public String toString() {
		return "SensorTemperatura " + super.toString() + " [valorMaximo=" + valorMaximo + ", valorMinimo=" + valorMinimo
				+ "] \n";
	}

}
