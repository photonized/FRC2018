package org.usfirst.frc.team6331.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
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
			  try {
		            addSequential(new DriveStop());
		            Thread.sleep(3000);
		            addSequential(new TurnLeft());
		            Thread.sleep(450);
		            addSequential(new DriveForward());
		            addSequential(new SetLiftSpeed(-0.7));
		            Thread.sleep(1300);
		            addSequential(new TurnRight());
		            Thread.sleep(300);
		            addSequential(new DriveForward());
		            Thread.sleep(900);
		            addSequential(new LiftStall());
		            addSequential(new ThrowCube());
		            Thread.sleep(1000);
		            addSequential(new SlowBack());
		            addSequential(new LiftStop());
		            addSequential(new StopClaw());
		            Thread.sleep(500);
		            addSequential(new DriveStop());
		    	} catch (InterruptedException e) {
		    		e.printStackTrace();
		    	}
		  } else {
			  try {
		        	addSequential(new DriveStop());
		        	Thread.sleep(3000);
		        	addSequential(new DriveForward());
		        	addSequential(new SetLiftSpeed(0.75));
		        	Thread.sleep(1200);
		        	addSequential(new TurnLeft());
		        	Thread.sleep(220);
		        	addSequential(new DriveForward());
		        	Thread.sleep(700);
		        	addSequential(new DriveStop());
		        	addSequential(new LiftStall());
		        	addSequential(new ThrowCube());
		        	Thread.sleep(1000);
		        	addSequential(new StopClaw());
		        	addSequential(new SlowBack());
		        	Thread.sleep(500);
		        	addSequential(new DriveStop());
		        } catch (InterruptedException e){
		        	e.printStackTrace();
		        }
		  }
                }
    }
}
