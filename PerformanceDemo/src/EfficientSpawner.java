import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javafx.scene.layout.Pane;
import patterns.ObjectPool;

public class EfficientSpawner implements ISpawnable{
	//maintain a reference to the pane to update its children
	private Pane pane;
	//maintain a collection of entities for updating logic
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	private int upwardVelocity = -1;
	private final int INITIAL_POOL_SIZE= 1000;
	
	//object pool
	private ObjectPool<Projectile> pool;
	
	private Random rand = new Random();
	
	public EfficientSpawner(Pane pane) {
		this.pane = pane;
		pool = new ObjectPool<Projectile>(Projectile::new, INITIAL_POOL_SIZE);
	}
	

	@Override
	public void spawn(int numToSpawn) {
		double x = pane.getWidth();
		double y = pane.getHeight();
		Projectile projectile;
		for(int i=0; i< numToSpawn; i++) {
			//create the projectile
			projectile = pool.borrow();
			projectile.updateBody(rand.nextDouble(0, x), y);
			projectile.setActive(true);
			//add it to our collection
			projectiles.add(projectile);
			//add it to the pane
			pane.getChildren().add(projectile.getBody());
		}
		
	}

	@Override
	public void update() {
		//We use an iterator so we can safely remove the item from our list when it is no longer active.
		 Iterator<Projectile> iterator = projectiles.iterator();
		    while (iterator.hasNext()) {
		        Projectile p = iterator.next();

		        // Check to see if the projectile is out of view
		        if (p.getBodyY() < 0) {
		            p.setActive(false);
		        }

		        // Update the projectile if it is active
		        if (p.isActive()) {
		            p.moveVertically(upwardVelocity);
		        }

		        // If the projectile is not active, remove it from the list
		        if (!p.isActive()) {
		        	//return the object to the pool
		        	pool.release(p);
		        	//this will remove the item from the iterators underlying list
		            iterator.remove();
		            //remove the projectile from the pane
		            pane.getChildren().remove(p.getBody());
		        }
		    }
	}

}
