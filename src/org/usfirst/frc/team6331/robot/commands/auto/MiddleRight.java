package org.usfirst.frc.team6331.robot.commands.auto;

import org.usfirst.frc.team6331.robot.commands.claw.ClawThrow;
import org.usfirst.frc.team6331.robot.commands.drive.DriveBack;
import org.usfirst.frc.team6331.robot.commands.drive.DriveForward;
import org.usfirst.frc.team6331.robot.commands.drive.DriveStop;
import org.usfirst.frc.team6331.robot.commands.drive.TurnLeft;
import org.usfirst.frc.team6331.robot.commands.lift.SetLiftSpeed;
import org.usfirst.frc.team6331.robot.commands.lift.StallLift;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleRight extends CommandGroup {

    public MiddleRight() {
    	
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
		if(gameData != null && gameData.length() >= 1 && gameData.charAt(0) == 'R') {
			  addParallel(new SetLiftSpeed(-0.7, 2.32));
			  addSequential(new DriveForward(1.4));
			  addSequential(new TurnLeft(0.22));
			  addSequential(new DriveForward(0.7));
			  addParallel(new StallLift(2));
			  addParallel(new ClawThrow(2));
			  addSequential(new DriveStop(2));
			  addSequential(new DriveBack(0.7));
		}
    }
}
