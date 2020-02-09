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

import frc.robot.Constants;

public class ColorWheel extends SubsystemBase {

  CANSparkMax colorWheelMotor;
  DoubleSolenoid colorWheelSolenoid;

  /**
   * Creates a new ColorWheel.
   */
  public ColorWheel() {
    colorWheelMotor = new CANSparkMax(Constants.COLORWHEEL_MOTOR, MotorType.kBrushless);
    colorWheelSolenoid = new DoubleSolenoid(Constants.PNEUMATICS_MODULE, Constants.COLORWHEEL_SOLENOID_FORWARDS, Constants.COLORWHEEL_SOLENOID_BACKWARDS);
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
