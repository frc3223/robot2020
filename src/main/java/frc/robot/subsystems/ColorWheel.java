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

import frc.robot.RobotContainer;
import frc.robot.Constants;

public class ColorWheel extends SubsystemBase {

  CANSparkMax colorWheelMotor;
  DoubleSolenoid colorWheelSolenoid;

  /**
   * Creates a new ColorWheel.
   */
  public ColorWheel() {
    colorWheelMotor = new CANSparkMax(Constants.COLORWHEEL_MOTOR, MotorType.kBrushless);
    colorWheelSolenoid = new DoubleSolenoid(Constants.PNEUMATICS_MODULE, Constants.COLORWHEEL_SOLENOID_FORWARDS, Constants.COLORWHEEL_SOLENOID_BACkWARDS);
  }

  public void WheelSpin(double Speed){
    colorWheelMotor.set(Speed);
  }

  public void WheelOut(){
    colorWheelSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void WheelIn(){
    colorWheelSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
