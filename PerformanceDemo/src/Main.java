import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	private final int NUM_TO_SPAWN=100;
	private final int VELOCITY=-5;
	private int width = 800;
	private int height = 600;
	private long lastUpdate = 0;
	private long frameTimes = 0;
	private long frameCount = 0;
	private double fps = 0;
	private ISpawnable spawner;
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create the Pane
		Pane pane = new Pane();
		
		//create the spawner
//		spawner = new SlowSpawner(pane);
		spawner = new EfficientSpawner(pane);
		
		//create the scene
		Scene scene = new Scene(pane, width, height);
		
		//bind the keys. You can bind keys to any Node, however, since the Scene is the main node, I recommend using it
		scene.setOnKeyPressed(e->{
			HandleKeyBindings(e.getCode());
		});
		
		//place the scene on the stage
		primaryStage.setScene(scene);
		
		//create the Gameloop
		AnimationTimer timer = new AnimationTimer() {
					
					@Override
					public void handle(long now) {
						//inside here, you will place your game methods like CSC1A
						//NOTE: we do not need to pause for input like CSC1A, we achieve it through bindings.
						
						//update your game logic
						update(now);
						//redraw the canvas
						draw(primaryStage);
						
					}
				};
		//start the game loop	
		timer.start();
		
		//and action
		primaryStage.show();
		
	}
	
	/**
	 * Handle all your user input here
	 * @param keyCode The key that was pressed
	 */
	private void HandleKeyBindings(KeyCode keyCode) {
		switch (keyCode) {
		case KeyCode.SPACE: {
			spawner.spawn(NUM_TO_SPAWN);
			break;

		}
		default:
			break;
		}
	}
	
	/**
	 * Place your Game Logic here
	 * @param animationDuration The current time the animation has been running for in nanoseconds
	 */
	private void update(long animationDuration) {
		spawner.update();
		
	calculateFPS(animationDuration);
	}
	
	/**
	 * Place your UI Updates here
	 * @param primaryStage The main stage
	 */
	private void draw(Stage primaryStage) {
		
		dislayFPS(primaryStage);
	}
	
	private void dislayFPS(Stage primaryStage) {
		primaryStage.setTitle(String.format("FPS: %.2f", fps));
	}
	
	private void calculateFPS(long nanoDuration) {
		//only do the calculations when the animation loop has run 1 iteration
		if(lastUpdate>0)
		{
			//get the time difference
			long deltaNanos = nanoDuration - lastUpdate;
			//accumulate the time differences
			frameTimes += deltaNanos;
			//each time this loop runs an iteration it is considered 1 frame
			frameCount++;
			//only calculate the FPS once every 60 frames so we do not tie down processing.
			if(frameCount >= 60)
			{
				// get the frames per second
				fps = 1e9 /(frameTimes / frameCount);
			
				//reset our accumulators for the next 60 frames
				frameCount = 0;
				frameTimes = 0;
			}
		}
		//track the animation time
		lastUpdate = nanoDuration;
	}

}
