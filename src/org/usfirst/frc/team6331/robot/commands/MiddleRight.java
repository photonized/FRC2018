package org.usfirst.frc.team6331.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleRight extends CommandGroup {

    public MiddleRight() {
        try {
        	addSequential(new DriveStop());
        	Thread.sleep(3000);
        	addSequential(new DriveForward());
        	addSequential(new SetLiftSpeed(0.75));
        	Thread.sleep(1200);
        	addSequential(new TurnLeft());
        	Thread.sleep(220);
        	addSequential(new DriveForward());
        	Thread.sleep(700);
        	addSequential(new DriveStop());
        	addSequential(new LiftStall());
        	addSequential(new ThrowCube());
        	Thread.sleep(1000);
        	addSequential(new StopClaw());
        	addSequential(new SlowBack());
        	Thread.sleep(500);
        	addSequential(new DriveStop());
        } catch (InterruptedException e){
        	e.printStackTrace();
        }
    }
}
