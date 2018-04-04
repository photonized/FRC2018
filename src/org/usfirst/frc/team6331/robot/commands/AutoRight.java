package org.usfirst.frc.team6331.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
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
				  try {
			            addSequential(new DriveStop());
			            Thread.sleep(3000);
			            addSequential(new DriveForward());
			            Thread.sleep(1450);
			            addSequential(new SetLiftSpeed(0.7));
			            addSequential(new TurnLeft());
			            Thread.sleep(550);
			            addSequential(new SetDriveSpeed(0.4));
			            addSequential(new SetLiftSpeed(1.0));
			            Thread.sleep(500);
			            addSequential(new DriveStop());
			            addSequential(new LiftStall());
			            addSequential(new ThrowCube());
			            Thread.sleep(3000);
			            addSequential(new StopClaw());
			            addSequential(new SetDriveSpeed(-0.3));
			            Thread.sleep(500);
			            addSequential(new LiftStop());
			            addSequential(new DriveStop());
			    	} catch (InterruptedException e) {
			    		e.printStackTrace();
			    }
		    }
        }
    }
}