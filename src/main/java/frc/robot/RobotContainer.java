/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// Misc.
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.AnalogInput;

import frc.robot.commands.*;

//buttons imports
// Robot Container is the new OI, which is setting up buttons, using numbers from Constants, and linking controllers and sensors.
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_drivetrain;
  private final DriveTank m_drivetank;
  private final DriveArcade m_drivearcade;
  private final ColorWheel m_colorWheel;

  private final Climber m_climber;
  private final ClimberArmUp m_climberArmUp;
  private final ClimberArmDown m_climberArmDown;
  private final ClimberWinchDown m_climberWinchDown;
  private final ClimberWinchUp m_climberWinchUp;

  private final Intake m_intake;
  private final IntakeLower m_intakeLower;
  private final IntakeRaise m_intakeRaise;
  private final IntakeAuto m_intakeAutoLower;
 
  private final IntakeShootOut m_intakeShootOut;
  private final IntakePullIn m_intakePullIn;

  private final ColorWheelLeft m_colorLeft;
  private final ColorWheelRight m_colorRight;
  private final ColorWheelLower m_colorLower;
  private final ColorWheelRaise m_colorRaise;
  private final ColorwheelAutoSpin m_colorAuto;
  private final ColorWheelFindColor m_findColor;

  private final Shooter m_shooter;
  private final ShooterRaise m_shooterRaise_High;
  private final ShooterRaise m_shooterRaise_Low; 
  private final ShooterLower m_shooterLower;
  private final ShooterPullIn m_shooterPullIn;
  private final ShooterLowAuto m_shooterLowAuto;
  private final ShooterHighAuto m_shooterHighAuto;
  private final ShooterOut m_shooterOut_Low;
  private final ShooterOut m_shooterOut_High;
  private final ShooterAutoDistanceHigh m_shooterDistance_High;
  private final ShooterAutoDistanceLow m_shooterDistance_Low;

  private final Hopper m_hopper;
  private final HopperShootOut m_hopperShootOut_High;
  private final HopperShootOut m_hopperShootOut_Low;
  private final HopperPullIn m_hopperPullIn;
 
 

  private final SequentialCommandGroup m_shooterSupremeHigh;
  private final SequentialCommandGroup m_shooterSupremeLow;

  private final DriveDistance m_driveDistance;
  
  private final TimedAutoDrive m_timedAutoDrive; 

  private final Compressor m_compressor; 
  private final AnalogInput m_wideSonar;
  private final AnalogInput m_narrowSonar;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer(Joystick driverController, Joystick manipulatorController) {
    // Configure the button bindings
    m_drivetrain = new DriveTrain();
    m_drivearcade = new DriveArcade(m_drivetrain, driverController);
    m_drivetank = new DriveTank(m_drivetrain, driverController);
    
    m_compressor = new Compressor(Constants.PNEUMATICS_MODULE);
    m_compressor.setClosedLoopControl(true);

    m_wideSonar = new AnalogInput(Constants.SONAR_WIDE);
    m_narrowSonar = new AnalogInput(Constants.SONAR_NARROW);

    m_intake = new Intake();
    m_intakeRaise = new IntakeRaise(m_intake);
    m_intakeLower = new IntakeLower(m_intake);
    m_intakeShootOut = new IntakeShootOut(m_intake,manipulatorController);
    m_intakePullIn = new IntakePullIn(m_intake,manipulatorController,Constants.MANIPULATOR_CONTROLLER_INTAKE_AUTO_LOWER);
    
    m_colorWheel = new ColorWheel();
    m_colorLeft = new ColorWheelLeft(m_colorWheel,manipulatorController);
    m_colorRight = new ColorWheelRight(m_colorWheel,manipulatorController);
    m_colorRaise = new ColorWheelRaise(m_colorWheel);
    m_colorLower = new ColorWheelLower(m_colorWheel);
    m_colorAuto = new ColorwheelAutoSpin(m_colorWheel);
    m_findColor = new ColorWheelFindColor(m_colorWheel);

    m_climber = new Climber();
    m_climberArmUp = new ClimberArmUp(m_climber, driverController); 
    m_climberArmDown = new ClimberArmDown(m_climber,driverController); 
    m_climberWinchUp = new ClimberWinchUp(m_climber, driverController); 
    m_climberWinchDown = new ClimberWinchDown(m_climber,driverController); 


    m_shooter = new Shooter(m_wideSonar, m_narrowSonar);
    m_shooterRaise_Low = new ShooterRaise(m_shooter);
    m_shooterRaise_High = new ShooterRaise(m_shooter);
    m_shooterOut_High = new ShooterOut(m_shooter, manipulatorController, Constants.MANIPULATOR_CONTROLLER_SHOOTER_HIGH_AUTO);
    m_shooterOut_Low = new ShooterOut(m_shooter, manipulatorController, Constants.MANIPULATOR_CONTROLLER_SHOOTER_LOW_AUTO);
    m_shooterPullIn = new ShooterPullIn(m_shooter, manipulatorController,Constants.MANIPULATOR_CONTROLLER_INTAKE_AUTO_LOWER);
    m_shooterLower = new ShooterLower(m_shooter,manipulatorController);
    m_shooterDistance_High = new ShooterAutoDistanceHigh(m_shooter,m_drivetrain,Constants.HIGH_GOAL_DISTANCE);
    m_shooterDistance_Low = new ShooterAutoDistanceLow(m_shooter,m_drivetrain,Constants.LOW_GOAL_DISTANCE);


    m_hopper = new Hopper();
    m_hopperPullIn = new HopperPullIn(m_hopper, manipulatorController, Constants.MANIPULATOR_CONTROLLER_INTAKE_AUTO_LOWER);
    m_hopperShootOut_High = new HopperShootOut(m_hopper, manipulatorController, Constants.MANIPULATOR_CONTROLLER_SHOOTER_HIGH_AUTO);
    m_hopperShootOut_Low = new HopperShootOut(m_hopper, manipulatorController, Constants.MANIPULATOR_CONTROLLER_SHOOTER_LOW_AUTO);


    m_shooterLowAuto = new ShooterLowAuto(m_shooter, m_shooterRaise_Low, m_hopperShootOut_Low, m_shooterOut_Low);
    m_shooterHighAuto = new ShooterHighAuto(m_shooter, m_shooterRaise_High, m_hopperShootOut_High, m_shooterOut_High);
    m_intakeAutoLower = new IntakeAuto(m_shooter, m_intake, m_hopper, m_shooterLower,m_intakeLower,m_shooterPullIn,m_intakePullIn,m_hopperPullIn);

    m_timedAutoDrive = new TimedAutoDrive(m_drivetrain);

    m_shooterSupremeHigh = new SequentialCommandGroup(m_shooterDistance_High, m_shooterHighAuto);
    m_shooterSupremeLow = new SequentialCommandGroup(m_shooterDistance_Low, m_shooterLowAuto);

    m_driveDistance = new DriveDistance(Constants.DRIVE_AUTO_DISTANCE,m_drivetrain,m_shooter);

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */


  public Command getDriveTank() {
    return m_drivetank;
  }
  public Command getDriveArcade() {
    return m_drivearcade;
  }
  public Command getIntakeRaise() {
    return m_intakeRaise;
  }
  public Command getIntakeLower() {
    return m_intakeLower;
  }
  public Command getClimbArmUp(){
    return m_climberArmUp;
  }
  public Command getClimbArmDown(){
    return m_climberArmDown;
  }
  public Command getClimbWinchUp(){
    return m_climberWinchUp;
  }
  public Command getClimbWinchDown(){
    return m_climberWinchDown;
  }
  public Command getIntakeShootOut(){
    return m_intakeShootOut;
  }
  public Command getIntakePullIn(){
    return m_intakePullIn;
  }
  public Command getIntakeAutoLower(){
    return m_intakeAutoLower;
  }
  public Command getColorLeft(){
    return m_colorLeft;
  }
  public Command getColorRight(){
    return m_colorRight;
  }
  public Command getColorRaise(){
    return m_colorRaise;
  }
  public Command getColorLower(){
    return m_colorLower;
  }
  public Command getColorAuto(){
    return m_colorAuto;
  }
  public Command getFindColor(){
    return m_findColor;
  }
  public Command getShooterPullIn(){
    return m_shooterPullIn;
  }
  public Command getShooterLowAuto(){
    return m_shooterLowAuto;
  }
  public Command getShooterHighAuto(){
    return m_shooterHighAuto;
  }
  public Command getHopperPullIn(){
    return m_hopperPullIn;
  }
  public Command getTimedAutoDrive(){
    return m_timedAutoDrive;
  }
  public Command getShooterLower(){
    return m_shooterLower;
  }
  public Command getHighHopperOut(){
    return m_hopperShootOut_High;
  }
  public Command getLowHopperOut(){
    return m_hopperShootOut_Low;
  }
  public Command getHighShooterOut(){
    return m_shooterOut_High;
  }
  public Command getLowShooterOut(){
    return m_shooterOut_Low;
  }
  public SequentialCommandGroup getHighShooterSupreme(){
    return m_shooterSupremeHigh;
  }
  public SequentialCommandGroup getLowShooterSupreme(){
    return m_shooterSupremeLow;
  }
  public Command getDriveDistance(){
    return m_driveDistance;
  }
}