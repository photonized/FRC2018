package org.usfirst.frc.team6331.robot.commands.drive;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBack extends Command {

	/**
	 * Drives back with the time required in timeout.
	 * @param timeout
	 */
    public DriveBack(double timeout) {
        requires(Robot.driveTrain);
        
        this.setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.back();
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
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
