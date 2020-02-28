/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hopper;

import edu.wpi.first.wpilibj.Joystick;

public class HopperShootOut extends CommandBase {
  Joystick manipulatorController;
  Hopper hopper;
  boolean isDone;
  int button;
  /**
   * Creates a new IntakeWheelOut.
   */
  public HopperShootOut(Hopper hopper, Joystick manipulatorController, int button) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.manipulatorController = manipulatorController;
    this.hopper = hopper;
    this.button = button;

    //addRequirements(hopper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isDone = false;
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    hopper.hopperShootOut();
    if(!manipulatorController.getRawButton(button)){
      end(false);
      isDone = true;
    }

  }

  // Called once the command ends or is interrupted.s
  @Override
  public void end(boolean interrupted) {
    hopper.hopperMotorOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}