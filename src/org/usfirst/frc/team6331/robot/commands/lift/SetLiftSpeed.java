package org.usfirst.frc.team6331.robot.commands.lift;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetLiftSpeed extends Command {

	private double m_speed;
	
	/**
	 * Sets lift speed to the desired speed for the required amount of time.
	 * @param speed
	 * @param timeout
	 */
    public SetLiftSpeed(double speed, double timeout) {
    	requires(Robot.lift);
    	this.m_speed = speed;
    	
    	this.setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.setSpeed(m_speed);
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
    	Robot.lift.stall();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
