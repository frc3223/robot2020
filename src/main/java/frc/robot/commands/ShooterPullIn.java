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

public class ShooterPullIn extends CommandBase {
    Joystick manipulatorController;
    Shooter shooter;
    int button;
    boolean isDone;
    
    /**
     * Creates a new IntakeWheelIN.
     */
    public ShooterPullIn(Shooter shooter, Joystick  manipulatorController,int button) {
      this.manipulatorController = manipulatorController;
      this.shooter = shooter;
      this.button = button;
      
      // Use addRequirements() here to declare subsystem dependencies.
      //addRequirements(shooter);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      shooter.shooterMotorPullIn();
      isDone = false;
      
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() { 
      if(!manipulatorController.getRawButton(button)){
        isDone = true;
        end(false);
        
      }
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        shooter.shooterMotorsOff();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return isDone;
    }
}