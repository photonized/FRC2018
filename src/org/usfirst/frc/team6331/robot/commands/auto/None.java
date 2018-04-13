package org.usfirst.frc.team6331.robot.commands.auto;

import org.usfirst.frc.team6331.robot.commands.drive.DriveStop;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class None extends CommandGroup {

    public None() {
    	addSequential(new DriveStop(10));
    }
}
