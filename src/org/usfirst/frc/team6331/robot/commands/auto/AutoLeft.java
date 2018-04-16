package org.usfirst.frc.team6331.robot.commands.auto;

import org.usfirst.frc.team6331.robot.Robot;
import org.usfirst.frc.team6331.robot.commands.claw.ClawThrow;
import org.usfirst.frc.team6331.robot.commands.drive.DriveBack;
import org.usfirst.frc.team6331.robot.commands.drive.DriveForward;
import org.usfirst.frc.team6331.robot.commands.drive.DriveStop;
import org.usfirst.frc.team6331.robot.commands.drive.TurnRight;
import org.usfirst.frc.team6331.robot.commands.lift.SetLiftSpeed;
import org.usfirst.frc.team6331.robot.commands.lift.StallLift;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeft extends CommandGroup {
	
	/**
	 * Either forward for 1.5 seconds or drives to the side of the switch and turns left to put it in if it's friendly.
	 */
    public AutoLeft() {
    	
    	String gameData = Robot.GAME_DATA;
    	
		if(gameData != null && gameData.length() >= 1 && gameData.charAt(0) == 'R') {
			  addSequential(new DriveStop(Robot.delay.getSelected()));
			  addSequential(new AutoForward());
		  } else {
			  addSequential(new DriveStop(Robot.delay.getSelected()));
			  addParallel(new SetLiftSpeed(-0.7, 2.5));
			  addSequential(new DriveForward(2.2));
			  addSequential(new DriveStop(0.3));
			  addSequential(new TurnRight(0.8));
			  addParallel(new StallLift(4));
			  addSequential(new DriveForward(0.8));
			  addParallel(new ClawThrow(2));
			  addSequential(new DriveStop(2));
			  addSequential(new DriveBack(0.7));
		}
    }
}
