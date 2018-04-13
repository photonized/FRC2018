package org.usfirst.frc.team6331.robot.commands.climb;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClimbUp extends InstantCommand {

    public ClimbUp() {
        requires(Robot.climb);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.climb.up();
    }

}
