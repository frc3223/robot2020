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

import frc.robot.RobotContainer;
import frc.robot.Constants;


public class Shooter extends SubsystemBase {
  public WPI_TalonSRX shooterLeftMotor;
  public WPI_TalonSRX shooterRightMotor;
  public WPI_VictorSPX hopperMotor;

  public DoubleSolenoid shooterSolenoid;

  public static double ShootSpeed;

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    shooterLeftMotor = new WPI_TalonSRX(Constants.SHOOTER_LEFT_MOTOR);
    shooterRightMotor = new WPI_TalonSRX(Constants.SHOOTER_RIGHT_MOTOR);
    hopperMotor = new WPI_VictorSPX(Constants.INTAKE_MOTOR);
    ShootSpeed = 1; /* the thing about ShootSpeed is that we are using a button to control the shooter, so by defenition, we cannot have a passed in variable for the motor value.
    If we were to change this, then we need to do a whole makeover of the two shooting commands, robot and robotcontainer,  as well as this subsystem. thanks for your time.  */
    shooterSolenoid = new DoubleSolenoid(Constants.PNEUMATICS_MODULE, Constants.INTAKE_SOLENOID_FORWARDS, Constants.INTAKE_SOLENOID_BACKWARDS);
  }
  //Left and right motors are talons 

  public void shooterMotorShootOut(){
    shooterRightMotor.set(-1);
    shooterLeftMotor.set(1);
  }

  public void shooterMotorPullIn(){
    shooterRightMotor.set(1);
    shooterLeftMotor.set(-1);
  }

  public void shooterRaise(){
  shooterSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void shooterLower(){
  shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void hopperShootOut(){
    hopperMotor.set(1);
  }

  public void hopperPullIn(){
    hopperMotor.set(-1);
  }

  public void shooterMotorsOff(){
    shooterLeftMotor.set(0);
    shooterRightMotor.set(0);
  }

  public void hopperMotorOff(){
    hopperMotor.set(0);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
