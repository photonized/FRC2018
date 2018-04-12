package org.usfirst.frc.team6331.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddle extends CommandGroup {

    public AutoMiddle() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0) {
		  if(gameData.charAt(0) == 'L') {
			  addSequential(new DriveStop());
			  Timer.delay(3);
			  addSequential(new TurnLeft());
			  Timer.delay(0.45);
			  addSequential(new DriveForward());
			  addSequential(new SetLiftSpeed(0.7));
			  Timer.delay(1.3);
			  addSequential(new TurnRight());
			  Timer.delay(0.3);
			  addSequential(new DriveForward());
			  Timer.delay(0.9);
			  addSequential(new LiftStall());
			  addSequential(new ThrowCube());
			  Timer.delay(1);
			  addSequential(new SlowBack());
			  addSequential(new LiftStop());
			  addSequential(new StopClaw());
			  Timer.delay(0.5);
			  addSequential(new DriveStop());
		  } else {
			  addSequential(new DriveStop());
			  Timer.delay(3);
			  addSequential(new DriveForward());
			  addSequential(new SetLiftSpeed(0.75));
			  Timer.delay(1.2);
			  addSequential(new TurnLeft());
			  Timer.delay(0.22);
			  addSequential(new DriveForward());
			  Timer.delay(0.7);
			  addSequential(new DriveStop());
			  addSequential(new LiftStall());
			  addSequential(new ThrowCube());
			  Timer.delay(1);
			  addSequential(new StopClaw());
			  addSequential(new SlowBack());
			  addSequential(new LiftStop());
			  Timer.delay(0.5);
			  addSequential(new DriveStop());
		  }
        }
    }
}
