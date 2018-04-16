package org.usfirst.frc.team6331.robot.commands.lift;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LiftStall extends InstantCommand {

	/**
	 * Instant lift stall.
	 */
    public LiftStall() {
        requires(Robot.lift);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.lift.stall();
    }

}
