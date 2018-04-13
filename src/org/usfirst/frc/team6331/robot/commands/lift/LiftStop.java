package org.usfirst.frc.team6331.robot.commands.lift;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LiftStop extends InstantCommand {

    public LiftStop() {
        requires(Robot.lift);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.lift.stop();
    }

}
