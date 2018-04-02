package org.usfirst.frc.team6331.robot.commands;

import org.usfirst.frc.team6331.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WaitForCube extends Command {

    public WaitForCube() {
        requires(Robot.claw);
    }

    
    protected boolean isFinished() {
        return Robot.claw.hasCube();
    }
}
