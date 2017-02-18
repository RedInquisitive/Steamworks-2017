package org.usfirst.frc.team3695.robot;

import org.usfirst.frc.team3695.robot.commands.ButtonCommandBallHopper;
import org.usfirst.frc.team3695.robot.commands.ButtonCommandFlaps;
import org.usfirst.frc.team3695.robot.commands.ButtonCommandKillCompressor;
import org.usfirst.frc.team3695.robot.commands.ButtonCommandShooter;
import org.usfirst.frc.team3695.robot.commands.CommandRotate;
import org.usfirst.frc.team3695.robot.enumeration.Direction;
import org.usfirst.frc.team3695.robot.util.Xbox;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static final Joystick DRIVER = new Joystick(0);
	public static final Joystick OPERATOR = new Joystick(1);
	public OI(){
		
		/**
		 * Ball Loading
		 */
		Button ball = new JoystickButton(OPERATOR, Xbox.X);
		ball.toggleWhenActive(new ButtonCommandBallHopper());
		
		/**
		 * Gear Flapping
		 */
		Button gear = new JoystickButton(OPERATOR, Xbox.RB);
		gear.toggleWhenActive(new ButtonCommandFlaps());
		
		/**
		 * Ball shooting
		 */
		Button shoot = new JoystickButton(OPERATOR, Xbox.A);
		Button unshoot = new JoystickButton(OPERATOR, Xbox.B);
		shoot.toggleWhenActive(new ButtonCommandShooter(Direction.FORWARD));
		unshoot.toggleWhenActive(new ButtonCommandShooter(Direction.BACKWARD));
		
		/**
		 * Open/Closed Funnel
		 */
		SmartDashboard.putBoolean("Funnel is Open", Robot.SUB_FLAPS.getOpen());
				
		/**
		 * To Compress, or Not To Compress. It is now an option.
		 */
		SmartDashboard.putData("Disable Compressor", new ButtonCommandKillCompressor());
		
		SmartDashboard.putData("AutoCamera", new CommandRotate());
	}
}
