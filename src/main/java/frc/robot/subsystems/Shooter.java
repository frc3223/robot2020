/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.AnalogInput;


import frc.robot.RobotContainer;
import frc.robot.Constants;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Shooter extends SubsystemBase {
  public WPI_TalonSRX shooterLeftMotor;
  public WPI_TalonSRX shooterRightMotor;

  private AnalogInput m_wideSonar;
  private AnalogInput m_narrowSonar;
  private NetworkTable table;
  private NetworkTable subTable;

  public DoubleSolenoid shooterSolenoid;

  /**
   * Creates a new Shooter.
   */
  public Shooter(AnalogInput wide, AnalogInput narrow) {
    shooterLeftMotor = new WPI_TalonSRX(Constants.SHOOTER_LEFT_MOTOR);
    shooterRightMotor = new WPI_TalonSRX(Constants.SHOOTER_RIGHT_MOTOR);
    shooterSolenoid = new DoubleSolenoid(Constants.PNEUMATICS_MODULE, Constants.HOPPER_SOLENOID_FORWARDS, Constants.HOPPER_SOLENOID_BACKWARDS);

    table = NetworkTableInstance.getDefault().getTable(Constants.VISION_NETWORK_TABLE_NAME);
    subTable = table.getSubTable(Constants.VISION_NETWORK_TABLE_SUB_NAME);

    m_wideSonar = wide;
    m_wideSonar.setAverageBits(Constants.SONAR_OVERSAMPLE_COUNT);
    m_narrowSonar = narrow;
    m_narrowSonar.setAverageBits(Constants.SONAR_OVERSAMPLE_COUNT);
  }

  public double getWideDistance(){
    double voltage = m_wideSonar.getVoltage();
    double distance = voltage/0.29;
    return distance;
  }
  
  public double getNarrowDistance(){
    double voltage = m_narrowSonar.getVoltage();
    double distance = voltage/0.29;
    System.out.println("our distance is: "+ distance + " feet");
    return distance;
  }
  public boolean getTargetFound(){
    NetworkTableEntry targetFound = subTable.getEntry(Constants.VISION_NETWORK_ENTRY_TARGET_FOUND);
    return targetFound.getBoolean(false);
  }
  public void shooterMotorShootOut(){
    shooterRightMotor.set(1);
    shooterLeftMotor.set(-1);
  }

  public void shooterMotorPullIn(){
    shooterRightMotor.set(-1);
    shooterLeftMotor.set(1);
  }

  public void shooterMotorsOff(){
    shooterLeftMotor.set(0);
    shooterRightMotor.set(0);
  }

  public void shooterRaise(){
  shooterSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void shooterLower(){
  shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
