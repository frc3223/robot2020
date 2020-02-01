/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.*;

public class Climber extends SubsystemBase {
  public WPI_TalonSRX winch;
  public WPI_TalonSRX arm;

  public Constants constants;

  /**
   * Creates a new Climber.
   */
  public Climber() {
    constants = new Constants();
    winch = new WPI_TalonSRX(constants.CLIMBER_WINCH_TALON);
    arm = new WPI_TalonSRX(constants.CLIMBER_ARM_TALON);

  }

  public void extend(){
    arm.set(1);
  }

  public void retract(){
    winch.set(1);
  }
}