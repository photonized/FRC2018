package org.usfirst.frc.team6331.robot.commands.lift;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StallLift extends Command {

	/**
	 * Stalls lift for the required amount of time.
	 * @param timeout
	 */
    public StallLift(double timeout) {
        requires(Robot.lift);
        this.setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.stall();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
