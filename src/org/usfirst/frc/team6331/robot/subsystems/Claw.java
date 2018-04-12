package org.usfirst.frc.team6331.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {

	
	public static final double input = 1.0;
	public static final double output = -1.0;
	public static final double stop = 0.0;
	
	private SpeedController m_thrower = new Victor(3);
	private DigitalInput m_cubeDetector;

    public Claw() {
    	addChild("Thrower Motor", (Victor) m_thrower);
    }
    
    public void setSpeed(double speed) {
    	m_thrower.set(-speed);
    }
    
    public void in() {
    	m_thrower.set(input);
    }
    public void stop() {
    	m_thrower.set(0);
    }
    
    public void out() {
    	m_thrower.set(output);
    }
    
    public boolean hasCube() {
    	return m_cubeDetector.get();
    }
    
    protected void initDefaultCommand() {
    }
}

