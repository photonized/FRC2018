package org.usfirst.frc.team6331.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
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
	
	private SpeedController m_climb = new Victor(1);
	private DigitalInput m_up = new DigitalInput(3);
	private DigitalInput m_down = new DigitalInput(4);
	
    public Climb() {
    	addChild("Climb Motor", (Victor) m_climb);
    	addChild("Max Up Detector", m_up);
    	addChild("Max Down Detector", m_down);
    }

    public boolean isUp() {
    	return m_up.get();
    }
    
    public boolean isDown() {
    	return m_down.get();
    }
    
    public void stop() {
    	m_climb.set(0);
    }
    
    public void setSpeed(double speed) {
    	m_climb.set(-speed);
    }
    public void initDefaultCommand() {
    }
}

