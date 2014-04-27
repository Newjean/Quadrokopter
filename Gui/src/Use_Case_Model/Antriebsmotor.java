package Use_Case_Model;

public class Antriebsmotor extends Motor {
	private double frequenz;
	public Flugsteuerung motor_Ost;
	public Flugsteuerung motor_Sued;
	public Flugsteuerung motor_Nord;
	public Flugsteuerung motor_West;

	public double SpeicherFrequenz() {
		throw new UnsupportedOperationException();
	}

	public void StelleFrequenzEin(double aFrequenz) {
		throw new UnsupportedOperationException();
	}

	public void StelleFrequenzWiederher(double aFrequenz) {
		throw new UnsupportedOperationException();
	}
}
