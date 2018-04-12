package org.usfirst.frc.team6331.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climb extends Subsystem {

	public static final double up = -1.0;
	public static final double down = 1.0;
	public static final double stop = 0.0;
	
	private SpeedController m_climb = new Victor(2);
	
	
    public Climb() {
    	addChild("Climb Motor", (Victor) m_climb);
    }
    
    public void down() {
    	m_climb.set(down);
    }
    
    public void up() {
    	m_climb.set(up);
    }
    
    public void stop() {
    	m_climb.set(stop);
    }
    
    public void setSpeed(double speed) {
    	m_climb.set(-speed);
    }
    public void initDefaultCommand() {
    }
}

