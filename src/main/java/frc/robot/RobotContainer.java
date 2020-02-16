/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;
//subsystems imports
//change this to:
//import frc.robot.subsystems;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.Shooter;
// Misc.
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.AnalogInput;
// commands imports
//change this to:
//import frc.robot.commands;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.IntakeLower;
import frc.robot.commands.IntakeRaise;
import frc.robot.commands.ClimberArmDown;
import frc.robot.commands.ClimberArmUp;
import frc.robot.commands.ClimberWinchDown;
import frc.robot.commands.ClimberWinchUp;
import frc.robot.commands.IntakeShootOut;
import frc.robot.commands.IntakePullIn;
import frc.robot.commands.IntakeAutoLower;
import frc.robot.commands.ColorWheelLeft;
import frc.robot.commands.ColorWheelRight;
import frc.robot.commands.ColorWheelLower;
import frc.robot.commands.ColorWheelRaise;
import frc.robot.commands.ShooterLower;
import frc.robot.commands.ShooterRaise;
import frc.robot.commands.ShooterShootOut;
import frc.robot.commands.ShooterPullIn;
import frc.robot.commands.HopperPullIn;
import frc.robot.commands.HopperShootOut;

//buttons imports


//import edu.wpi.first.wpilibj.XboxController; [REDACTED]
// Robot Container is the new OI, which is setting up buttons, using numbers from Constants, and linking controllers and sensors.
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final DriveTrain m_drivetrain;
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
  private final IntakeAutoLower m_intakeAutoLower;
  private final Compressor m_compressor;
  private final IntakeShootOut m_intakeShootOut;
  private final IntakePullIn m_intakePullIn;
  private final ColorWheelLeft m_colorLeft;
  private final ColorWheelRight m_colorRight;
  private final ColorWheelLower m_colorLower;
  private final ColorWheelRaise m_colorRaise;
  private final Shooter m_shooter;
  private final ShooterLower m_shooterLower;
  private final ShooterRaise m_shooterRaise;
  private final ShooterShootOut m_shooterShootOut;
  private final ShooterPullIn m_shooterPullIn;
  private final HopperPullIn m_hopperPullIn;
  private final HopperShootOut m_hopperShootOut;
  private final AnalogInput m_wideSonar;
  private final AnalogInput m_narrowSonar;
  


   
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer(Joystick driverController, Joystick manipulatorController) {
    // Configure the button bindings
    m_drivetrain = new DriveTrain();
    m_drivearcade = new DriveArcade(m_drivetrain, driverController, manipulatorController);
    m_intake = new Intake();
    m_intakeRaise = new IntakeRaise(m_intake);
    m_intakeLower = new IntakeLower(m_intake);
    m_compressor = new Compressor(Constants.PNEUMATICS_MODULE);
    m_compressor.setClosedLoopControl(true);
    m_intakeShootOut = new IntakeShootOut(m_intake,manipulatorController);
    m_intakePullIn = new IntakePullIn(m_intake,manipulatorController);
    m_intakeAutoLower = new IntakeAutoLower(m_intake, manipulatorController);

    m_colorWheel = new ColorWheel();
    m_colorLeft = new ColorWheelLeft(m_colorWheel,manipulatorController);
    m_colorRight = new ColorWheelRight(m_colorWheel,manipulatorController);
    m_colorRaise = new ColorWheelRaise(m_colorWheel);
    m_colorLower = new ColorWheelLower(m_colorWheel);

    m_climber = new Climber();
    m_climberArmUp = new ClimberArmUp(m_climber, driverController); 
    m_climberArmDown = new ClimberArmDown(m_climber,driverController); 
    m_climberWinchUp = new ClimberWinchUp(m_climber, driverController); 
    m_climberWinchDown = new ClimberWinchDown(m_climber,driverController); 

    m_wideSonar = new AnalogInput(Constants.SONAR_WIDE);
    m_narrowSonar = new AnalogInput(Constants.SONAR_NARROW);

    m_shooter = new Shooter(m_wideSonar, m_narrowSonar );
    m_shooterLower = new ShooterLower(m_shooter);
    m_shooterRaise = new ShooterRaise(m_shooter);
    m_shooterShootOut = new ShooterShootOut(m_shooter, driverController);
    m_shooterPullIn = new ShooterPullIn(m_shooter, driverController);
    m_hopperPullIn = new HopperPullIn(m_shooter, driverController);
    m_hopperShootOut = new HopperShootOut(m_shooter, driverController);

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
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
  public Command getShooterLower(){
    return m_shooterLower;
  }
  public Command getShooterRaise(){
    return m_shooterRaise;
  }
  public Command getShooterPullIn(){
    return m_shooterPullIn;
  }
  public Command getShooterShootOut(){
    return m_shooterShootOut;
  }
  public Command getHopperPullIn(){
    return m_hopperPullIn;
  }
  public Command getHopperShootOut(){
    return m_hopperShootOut;
  }
}