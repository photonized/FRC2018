package org.usfirst.frc.team6331.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoForward extends CommandGroup {

    public AutoForward() {
        try {
        	addSequential(new DriveStop());
        	Thread.sleep(3000);
        	addSequential(new DriveForward());
        	Thread.sleep(1500);
        	addSequential(new DriveStop());
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
    }
}
