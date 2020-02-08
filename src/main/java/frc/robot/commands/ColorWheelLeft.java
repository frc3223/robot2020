//*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;
import frc.robot.RobotContainer;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.Joystick;

public class ColorWheelLeft extends CommandBase {
  private final ColorWheel m_colorWheel;
  private double speed;
  private final Joystick manipController;

  /**
   * Creates a new ColorWheelIn.
   */
  public ColorWheelLeft(ColorWheel colorWheel, Joystick ManipController) {
    manipController = ManipController;
    m_colorWheel = colorWheel;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_colorWheel.wheelSpin(manipController.getRawAxis(Constants.MANIPULATOR_CONTROLLER_WHEEL_ROTATE_LEFT));

    if(manipController.getRawAxis(Constants.MANIPULATOR_CONTROLLER_WHEEL_ROTATE_LEFT) <= 0.05){
      m_colorWheel.wheelSpin(0.0);
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
    return true;
  }
}