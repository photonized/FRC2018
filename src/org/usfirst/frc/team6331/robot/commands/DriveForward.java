package org.usfirst.frc.team6331.robot.commands;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class DriveForward extends InstantCommand {

    public DriveForward() {
        requires(Robot.driveTrain);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.driveTrain.forward();
    }

}
