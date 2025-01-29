
public class VehicleFactory {
	
	Doors doors;
	Engine engine;
	public VehicleFactory(Vehicle v) {
		// TODO Auto-generated constructor stub
		this.doors=v.createCarDoor();
		this.engine=v.insertVehiclEnine();
	}
	
	public void creatCar()
	{
		this.doors.createCarDoor();
		this.engine.insertVehiclEnine();
		System.out.println("Ready for customer");
	}
}
