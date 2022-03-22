/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import com.revrobotics.ColorSensorV3;

import frc.robot.Constants;

public class ColorWheel extends SubsystemBase {

  CANSparkMax colorWheelMotor;
  DoubleSolenoid colorWheelSolenoid;
  private final I2C.Port i2cPort;
  private final ColorSensorV3 m_colorSensor;
  private final ColorMatch m_colorMatcher;
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  /**
   * Creates a new ColorWheel.
   */
  public ColorWheel() {
    colorWheelMotor = new CANSparkMax(Constants.COLORWHEEL_MOTOR, MotorType.kBrushless);
    colorWheelSolenoid = new DoubleSolenoid(Constants.PNEUMATICS_MODULE, PneumaticsModuleType.CTREPCM, Constants.COLORWHEEL_SOLENOID_FORWARDS, Constants.COLORWHEEL_SOLENOID_BACKWARDS);
    i2cPort = I2C.Port.kOnboard;
    m_colorSensor = new ColorSensorV3(i2cPort);
    m_colorMatcher = new ColorMatch();
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
 }
 // String 
  public String getColorString(Color detectedColor) {
    String colorString;
     ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
     if (match.color == kBlueTarget) {
      colorString = "Blue";
      System.out.println("color sensor sees blue");
      System.out.println("field sensor sees ???");
    } else if (match.color == kRedTarget) {
      colorString = "Red";
      System.out.println("color sensor sees red");
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
      System.out.println("color sensor sees green");
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
      System.out.println("color sensor sees yellow");
    } else {
      colorString = "Unknown";
    }
    return colorString;
  }
  public Color getColor() {
    return m_colorSensor.getColor();
  }
  public double getIR() {
    return m_colorSensor.getIR();
  } 
  public int getProximity() {
    return m_colorSensor.getProximity();
  }

  public void wheelSpin(double Speed){
    colorWheelMotor.set(Speed);
  }

  public void wheelSpinStop() {
    colorWheelMotor.set(0.0);
  }

  public void wheelOut(){
    colorWheelSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void wheelIn(){
    colorWheelSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
}
