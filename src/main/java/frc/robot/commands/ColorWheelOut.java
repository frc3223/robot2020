/*----------------------------------------------------------------------------*/
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

public class ColorWheelOut extends CommandBase {
  private final ColorWheel m_colorWheel;
  private double speed;
  private final Joystick driverController;
  /**
   * Creates a new ColorWheelOut.
   */
  public ColorWheelOut(ColorWheel colorWheel, double Speed, Joystick DriverController) {
    driverController = DriverController;
    m_colorWheel = colorWheel;
    this.speed = Speed;
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
    m_colorWheel.WheelSpin(-speed);

    if(driverController.getRawAxis(Constants.DRIVER_CONTROLLER_TRIGGER_WHEEL_ROTATE_RIGHT) <= 0.05){
      m_colorWheel.WheelSpin(0.0);
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
    return false;
  }
}
