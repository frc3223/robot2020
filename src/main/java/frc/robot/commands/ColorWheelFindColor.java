/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.DriverStation;

public class ColorWheelFindColor extends CommandBase {
  private final ColorWheel m_colorWheel;
  private String gameData;
  private Color initialColor;
  private String initialColorString;
  private Color currentColor;
  private String currentColorString;

   //Creates a new ColorWheelFindColor.
   
  public ColorWheelFindColor(ColorWheel colorWheel) {
     m_colorWheel = colorWheel;
    addRequirements(colorWheel);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gameData = DriverStation.getGameSpecificMessage();
    initialColor = m_colorWheel.getColor();
    initialColorString = m_colorWheel.getColorString(initialColor);
    currentColor = initialColor;
    currentColorString = initialColorString;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(initialColorString == gameData || currentColorString == gameData){
      end(false);
    }else{
      m_colorWheel.wheelSpin(0.5);
      currentColorString = m_colorWheel.getColorString(currentColor);
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
    return false;
  }
}
*/