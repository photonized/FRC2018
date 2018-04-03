package org.usfirst.frc.team6331.robot.commands;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LiftStall extends InstantCommand {

    public LiftStall() {
        requires(Robot.lift);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.lift.stall();
    }

}
