package org.usfirst.frc.team6331.robot.commands.claw;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SuckCube extends InstantCommand {

	/**
	 * Instant output.
	 */
    public SuckCube() {
        requires(Robot.claw);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.claw.in();
    }
}
