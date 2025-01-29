
public class Toyota implements Vehicle {

	@Override
	public Doors createCarDoor() {
		// TODO Auto-generated method stub
		return new ToyotaDoors();
	}

	@Override
	public Engine insertVehiclEnine() {
		// TODO Auto-generated method stub
		return new ToyotaEngine();
	}

}
