package org.usfirst.frc.team6331.robot.commands.climb;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClimbStop extends InstantCommand {

	/**
	 * Instant climb stop.
	 */
    public ClimbStop() {
        requires(Robot.climb);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.climb.stop();
    }

}
