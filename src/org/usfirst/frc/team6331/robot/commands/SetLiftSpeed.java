package org.usfirst.frc.team6331.robot.commands;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetLiftSpeed extends InstantCommand {

	private double m_speed;
	
    public SetLiftSpeed(double speed) {
       requires(Robot.lift);
       this.m_speed = speed;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.lift.setSpeed(m_speed);
    }

}
