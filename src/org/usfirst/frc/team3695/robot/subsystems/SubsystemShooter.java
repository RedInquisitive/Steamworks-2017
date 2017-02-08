package org.usfirst.frc.team3695.robot.subsystems;

import org.usfirst.frc.team3695.robot.Constants;
import org.usfirst.frc.team3695.robot.commands.CommandShooter;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SubsystemShooter extends Subsystem {
	CANTalon shooterMotor;
	
	public SubsystemShooter(){
		shooterMotor = new CANTalon(Constants.SHOOTER_MOTOR);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new CommandShooter());
    }
    
    public void spin(double speed){
    	shooterMotor.set((Constants.SHOOTER_MOTOR_INVERT ? -1.0 : 1.0) * speed);
    }
    
    public void spin(Joystick joy){
    	if (joy.getRawButton(1))
    		spin(Constants.SHOOTER_SPEED);
    	else
    		spin(0.0);
    }
}