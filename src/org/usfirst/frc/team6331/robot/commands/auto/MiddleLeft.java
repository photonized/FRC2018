package org.usfirst.frc.team6331.robot.commands.auto;

import org.usfirst.frc.team6331.robot.commands.claw.ClawThrow;
import org.usfirst.frc.team6331.robot.commands.drive.DriveBack;
import org.usfirst.frc.team6331.robot.commands.drive.DriveForward;
import org.usfirst.frc.team6331.robot.commands.drive.DriveStop;
import org.usfirst.frc.team6331.robot.commands.drive.TurnLeft;
import org.usfirst.frc.team6331.robot.commands.drive.TurnRight;
import org.usfirst.frc.team6331.robot.commands.lift.SetLiftSpeed;
import org.usfirst.frc.team6331.robot.commands.lift.StallLift;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleLeft extends CommandGroup {

    public MiddleLeft() {
    	
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
		if(gameData != null && gameData.length() >= 1 && gameData.charAt(0) == 'L') {
			 addSequential(new TurnLeft(0.7));
			  addParallel(new SetLiftSpeed(-0.7, 2.37));
			  addSequential(new DriveForward(1.57));
			  addSequential(new TurnRight(0.3));
			  addSequential(new DriveForward(0.4));
			  addParallel(new StallLift(3));
			  addSequential(new DriveForward(0.5));
			  addParallel(new DriveStop(3));
			  addSequential(new ClawThrow(2));
			  addSequential(new DriveBack(0.5));
		} 
    }
}
