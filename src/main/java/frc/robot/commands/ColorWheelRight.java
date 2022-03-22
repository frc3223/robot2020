/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class ColorWheelRight extends CommandBase {
  private final ColorWheel m_colorWheel;
  private final Joystick manipController;
  public boolean isDone; 
  
   //Creates a new ColorWheelOut.
   
  public ColorWheelRight(ColorWheel colorWheel, Joystick ManipController) {
    manipController = ManipController;
    m_colorWheel = colorWheel;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isDone = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_colorWheel.wheelSpin(-1 *manipController.getRawAxis(Constants.MANIPULATOR_CONTROLLER_WHEEL_ROTATE_RIGHT));
    System.out.println("ColorWheelRight value is: " + -1 *manipController.getRawAxis(Constants.MANIPULATOR_CONTROLLER_WHEEL_ROTATE_RIGHT));
    if(manipController.getRawAxis(Constants.MANIPULATOR_CONTROLLER_WHEEL_ROTATE_RIGHT) <= 0.05){
      System.out.println("stopping Color Wheel");
      end(false);
      isDone = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_colorWheel.wheelSpinStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
*/