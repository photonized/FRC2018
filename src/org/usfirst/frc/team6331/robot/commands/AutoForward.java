package org.usfirst.frc.team6331.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoForward extends CommandGroup {

    public AutoForward() {
        addSequential(new DriveStop());
        Timer.delay(3);
        addSequential(new DriveForward());
        Timer.delay(1.5);
        addSequential(new DriveStop());
    }
}
