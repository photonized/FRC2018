package org.usfirst.frc.team6331.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRight extends CommandGroup {

    public AutoRight() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0) {
		  if(gameData.charAt(0) == 'L') {
			 addSequential(new AutoForward());
			  } else {
				  addSequential(new DriveStop());
				  Timer.delay(3);
				  addSequential(new DriveForward());
				  Timer.delay(1.45);
				  addSequential(new SetLiftSpeed(0.7));
				  addSequential(new TurnLeft());
				  Timer.delay(0.55);
				  addSequential(new SetDriveSpeed(0.4));
				  addSequential(new SetLiftSpeed(1.0));
				  Timer.delay(500);
				  addSequential(new DriveStop());
				  addSequential(new LiftStall());
				  addSequential(new ThrowCube());
				  Timer.delay(3);
				  addSequential(new StopClaw());
				  addSequential(new SlowBack());
				  addSequential(new LiftStop());
				  Timer.delay(0.5);
				  addSequential(new DriveStop());
				  
		    }
        }
    }
}