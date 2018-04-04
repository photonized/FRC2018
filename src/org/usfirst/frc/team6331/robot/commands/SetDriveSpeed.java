package org.usfirst.frc.team6331.robot.commands;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetDriveSpeed extends InstantCommand {

	private double m_speed;
	
    public SetDriveSpeed(double speed) {
       requires(Robot.driveTrain);
       this.m_speed = speed;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.driveTrain.setSpeed(m_speed);
    }

}
