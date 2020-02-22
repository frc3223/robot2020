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
  Joystick driverController;
  Hopper hopper;
  boolean isDone;
  /**
   * Creates a new IntakeWheelOut.
   */
  public HopperShootOut(Hopper hopper, Joystick DriverController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driverController = DriverController;
    this.hopper = hopper;

    addRequirements(hopper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isDone = false;
    hopper.hopperShootOut();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!driverController.getRawButton(Constants.MANIPULATOR_CONTROLLER_HOPPER_OUT)){
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