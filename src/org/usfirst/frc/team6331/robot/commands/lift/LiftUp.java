package org.usfirst.frc.team6331.robot.commands.lift;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LiftUp extends InstantCommand {

    public LiftUp() {
       requires(Robot.lift);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.lift.up();
    }
}
