package org.usfirst.frc.team6331.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import enums.AutoMode;
import enums.Position;

/**
 * Helps with auto selection and decides on the auto type depending on what is chosen on the
 * SmartDashboard.
 * @author Filthy Jew
 *
 */
public class AutoSelect {
	
	/*
	 * Local variables for the game data and the selections from the dashboard.
	 */
	private char[] GAME_DATA;
	private AutoMode AUTO_MODE;
	private Position SWITCH_POSITION;
	private Position START_POSITION;
	
	/**
	 * Gets the game data and the auto mode with the position.
	 * @param gameData
	 * @param autoMode
	 * @param start
	 */
	public AutoSelect(String gameData, AutoMode autoMode, Position start) {
		GAME_DATA = gameData.toCharArray();
		AUTO_MODE = autoMode;
		SWITCH_POSITION = getSwitchPosition();
		START_POSITION = start;
}
	
	/**
	 * Gets the position of our near switch.
	 * @return Left switch or right switch.
	 */
	private Position getSwitchPosition() {
		switch (GAME_DATA[0]) {
		case 'L':
			return Position.LEFT;
		case 'R':
			return Position.RIGHT;
		default:
			return null;
	}
}
	/**
	 * Gets the command based on what position and autoMode is chosen.
	 * @return Auto command.
	 */
	public Command getCommand() {
			if(AUTO_MODE == null) {
				System.out.println("(AutoSelect.java): Auto mode is null");
				return new None();
		}
			if(AUTO_MODE == AutoMode.NONE) {
				System.out.println("(AutoSelect.java): Auto mode is NONE");
				return new None();
		}
			if(SWITCH_POSITION == null) {
				System.out.println("(AutoSelect.java): SWITCH POSITION IS NULL");
				return new None();
		}
			if(AUTO_MODE.equals(AutoMode.CROSS_LINE)) {
				System.out.println("(AutoSelect.java): Driving straight");
				return new AutoForward();
		}
			if(AUTO_MODE.equals(AutoMode.DROP) && START_POSITION.equals(Position.LEFT)) {
				System.out.println("(AutoSelect.java): Dropping cube in side, doing left side auto.");
				return new AutoLeft();
		}
			if(AUTO_MODE.equals(AutoMode.DROP) && START_POSITION.equals(Position.RIGHT)) {
				System.out.println("(AutoSelect.java): Dropping cube in side, doing right side auto.");
				return new AutoRight();
		}
			if(AUTO_MODE.equals(AutoMode.DROP) && START_POSITION.equals(Position.MIDDLE)) {
				System.out.print("(AutoSelect.java): Dropping cube in side, doing middle auto.");
				return new AutoMiddle();
		}
			System.out.print("(AutoSelect.java): Something went wrong!");
			return new None();
	}
}
