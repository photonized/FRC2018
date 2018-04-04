package org.usfirst.frc.team6331.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
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
			  try {
			  addSequential(new DriveStop());
			  Thread.sleep(3000);
			  addSequential(new DriveForward());
			  addSequential(new SetLiftSpeed(0.7));
			  Thread.sleep(700);
			  addSequential(new TurnRight());
			  Thread.sleep(1100);
			  addSequential(new SetDriveSpeed(0.4));
			  addSequential(new SetLiftSpeed(0.5));
			  Thread.sleep(1400);
			  addSequential(new DriveStop());
			  addSequential(new LiftStall());
			  addSequential(new ThrowCube());
			  Thread.sleep(3000);
			  addSequential(new StopClaw());
			  addSequential(new SetDriveSpeed(-0.3));
			  Thread.sleep(500);
			  addSequential(new DriveStop());
			  } catch (InterruptedException e) {
				  e.printStackTrace();
			  }
		  } else {
			  addSequential(new AutoForward());
		  }
       }
    }
}
