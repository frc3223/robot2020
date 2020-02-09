/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Joystick;

public class ShooterShootOut extends CommandBase {
    Joystick driverController;
    Shooter shooter;
    
    /**
     * Creates a new IntakeWheelIN.
     */
    public ShooterShootOut(Shooter shooter, Joystick DriverController) {
      this.driverController = DriverController;
      this.shooter = shooter;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(shooter);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() { 
      double shootSpeed = 1.0;
      shooter.shooterMotorShootOut(shootSpeed);
  
      if(!driverController.getRawButton(Constants.MANIPULATOR_CONTROLLER_SHOOTER_SHOOT_OUT)){
        end(false);
      }
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      this.shooter.shooterMotorsOff();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}