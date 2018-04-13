package org.usfirst.frc.team6331.robot.commands.auto;

import org.usfirst.frc.team6331.robot.Robot;
import org.usfirst.frc.team6331.robot.commands.drive.DriveForward;
import org.usfirst.frc.team6331.robot.commands.drive.DriveStop;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoForward extends CommandGroup {

    public AutoForward() {
    	addSequential(new DriveStop(Robot.delay.getSelected()));
        addSequential(new DriveForward(1.5));
    }
}
