package org.usfirst.frc.team6331.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeft extends CommandGroup {

    public AutoLeft() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0) {
		  if(gameData.charAt(0) == 'L') {
			  addSequential(new DriveStop());
			  Timer.delay(3);
			  addSequential(new DriveForward());
			  addSequential(new SetLiftSpeed(0.7));
			  Timer.delay(700);
			  addSequential(new TurnRight());
			  Timer.delay(1.1);
			  addSequential(new SetDriveSpeed(0.4));
			  addSequential(new SetLiftSpeed(0.5));
			  Timer.delay(1.4);
			  addSequential(new DriveStop());
			  addSequential(new ThrowCube());
			  addSequential(new LiftStall());
			  Timer.delay(3);
			  addSequential(new StopClaw());
			  addSequential(new SlowBack());
			  addSequential(new LiftStop());
			  Timer.delay(0.5);
			  addSequential(new DriveStop());
		  } else {
			  addSequential(new AutoForward());
		  }
       }
    }
}
