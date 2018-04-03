package org.usfirst.frc.team6331.robot.commands;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class DriveStop extends InstantCommand {

    public DriveStop() {
        requires(Robot.driveTrain);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.driveTrain.stop();
    }

}
