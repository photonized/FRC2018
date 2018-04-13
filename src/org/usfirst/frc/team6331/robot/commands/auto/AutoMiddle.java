package org.usfirst.frc.team6331.robot.commands.auto;

import org.usfirst.frc.team6331.robot.Robot;
import org.usfirst.frc.team6331.robot.commands.claw.ClawThrow;
import org.usfirst.frc.team6331.robot.commands.drive.DriveBack;
import org.usfirst.frc.team6331.robot.commands.drive.DriveForward;
import org.usfirst.frc.team6331.robot.commands.drive.DriveStop;
import org.usfirst.frc.team6331.robot.commands.drive.TurnLeft;
import org.usfirst.frc.team6331.robot.commands.drive.TurnRight;
import org.usfirst.frc.team6331.robot.commands.lift.SetLiftSpeed;
import org.usfirst.frc.team6331.robot.commands.lift.StallLift;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddle extends CommandGroup {

    public AutoMiddle() {    	
    	
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
		if(gameData != null && gameData.length() >= 1 && gameData.charAt(0) == 'R') {
			addSequential(new DriveStop(Robot.delay.getSelected()));
			 addParallel(new SetLiftSpeed(-0.7, 2.32));
			  addSequential(new DriveForward(1.4));
			  addSequential(new TurnLeft(0.22));
			  addSequential(new DriveForward(0.7));
			  addParallel(new StallLift(2));
			  addParallel(new ClawThrow(2));
			  addSequential(new DriveStop(2));
			  addSequential(new DriveBack(0.7));
		  } else {
			  addSequential(new DriveStop(Robot.delay.getSelected()));
			  addSequential(new TurnLeft(0.7));
			  addParallel(new SetLiftSpeed(-0.7, 2.37));
			  addSequential(new DriveForward(1.33));
			  addSequential(new TurnRight(0.3));
			  addSequential(new DriveForward(0.5));
			  addParallel(new StallLift(3));
			  addSequential(new DriveForward(0.5));
			  addParallel(new DriveStop(3));
			  addSequential(new ClawThrow(2));
			  addSequential(new DriveBack(0.5));
		  }
    }
}

