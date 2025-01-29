
public class Ford implements Vehicle
{
	@Override
	public Doors createCarDoor() {
		// TODO Auto-generated method stub
		return new FordDoors();
	}
	@Override
	public Engine insertVehiclEnine() {
		// TODO Auto-generated method stub
		return new FordEngine();
	}

}
