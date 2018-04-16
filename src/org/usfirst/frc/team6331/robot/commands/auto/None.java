package org.usfirst.frc.team6331.robot.commands.auto;

import org.usfirst.frc.team6331.robot.commands.drive.DriveStop;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class None extends CommandGroup {

	/**
	 * Doesn't do anything during auto. Keeps the bot stopped.
	 */
    public None() {
    	addSequential(new DriveStop(10));
    }
}
