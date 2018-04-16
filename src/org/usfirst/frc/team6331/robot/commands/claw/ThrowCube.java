package org.usfirst.frc.team6331.robot.commands.claw;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ThrowCube extends InstantCommand {

	
	/**
	 * Instant output.
	 */
    public ThrowCube() {
        requires(Robot.claw);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.claw.out();
    }
}
