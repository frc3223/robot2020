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

public class ColorwheelAutoSpin extends CommandBase {
  private final ColorWheel m_colorWheel;
  private Color initialColor;
  private String initialColorString;
  private int rotationCount;
  private boolean seesNewColor;
  private boolean isDone;

   //Creates a new ColorwheelAutoSpin.

  public ColorwheelAutoSpin(ColorWheel colorWheel) {
    m_colorWheel = colorWheel;
    addRequirements(colorWheel);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialColor = m_colorWheel.getColor();
    initialColorString = m_colorWheel.getColorString(initialColor);
    rotationCount = 0;
    seesNewColor = false;
    m_colorWheel.wheelSpin(1.0);
    isDone = false;
    System.out.println("auto color spin starting");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Color currentColor = m_colorWheel.getColor();
    String currentColorString = m_colorWheel.getColorString(currentColor); 
    if(currentColorString == "Unknown"){
      end(false);
    }
    if(seesNewColor == false && currentColorString != initialColorString) {
      seesNewColor = true;
    }
    if(seesNewColor == true &&currentColorString == initialColorString) {
      rotationCount += 1;
      seesNewColor = false;
      System.out.println("Current rotation count: " + rotationCount);

    }
    if(rotationCount == 6) {
      m_colorWheel.wheelSpinStop();
      System.out.println("Stopping ColorWheel motor");
      isDone = true;
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
*/