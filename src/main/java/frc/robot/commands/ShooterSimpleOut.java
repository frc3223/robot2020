/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Hopper;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;

public class ShooterSimpleOut extends CommandBase {
  Joystick manipulatorController;
    Shooter shooter;
    Hopper hopper;
    boolean isDone;
    int button;
  /**
   * Creates a new ShooterSimpleOut.
   */
  public ShooterSimpleOut(Joystick controller,Shooter shooter,Hopper hopper,int button) {
    manipulatorController = controller;
    this.shooter = shooter;
    this.hopper = hopper;
    this.button = button;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.print("shooter out starting");
    isDone = false;
    shooter.shooterRaise();
    shooter.shooterMotorShootOut();
    hopper.hopperShootOut();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!manipulatorController.getRawButton(button)){
        shooter.shooterMotorsOff();
        hopper.hopperMotorOff();
        isDone = true;
        end(false);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
