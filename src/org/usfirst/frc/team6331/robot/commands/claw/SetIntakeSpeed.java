package org.usfirst.frc.team6331.robot.commands.claw;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetIntakeSpeed extends InstantCommand {

	private double m_speed;
	
	/**
	 * Sets intake speed to desired speed.
	 * @param speed
	 */
    public SetIntakeSpeed(double speed) {
       requires(Robot.claw);
       this.m_speed = speed;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.claw.setSpeed(m_speed);
    }

}
