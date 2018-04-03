package org.usfirst.frc.team6331.robot.commands;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClimbDown extends InstantCommand {

    public ClimbDown() {
        requires(Robot.climb);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.climb.down();
    }
}
