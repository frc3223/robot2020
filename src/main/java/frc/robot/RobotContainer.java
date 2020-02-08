/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;
//subsystems imports
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.IntakeWheel;
import frc.robot.subsystems.ColorWheel;
import edu.wpi.first.wpilibj.Compressor;
// commands imports
import frc.robot.commands.DriveArcade;
import frc.robot.commands.IntakeLower;
import frc.robot.commands.IntakeRaise;
import frc.robot.commands.ClimberArmDown;
import frc.robot.commands.ClimberArmUp;
import frc.robot.commands.ClimberWinchDown;
import frc.robot.commands.ClimberWinchUp;
import frc.robot.commands.IntakeShootOut;
import frc.robot.commands.IntakePullIn;
import frc.robot.commands.ColorWheelLeft;
import frc.robot.commands.ColorWheelRight;
import frc.robot.commands.ColorWheelLower;
import frc.robot.commands.ColorWheelRaise;
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
  int driverPort;
  int manipulatorPort;

  public Joystick driverController;
  public Joystick manipulatorController;

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final DriveTrain m_drivetrain;
  private final DriveArcade m_drivearcade;
  private final IntakeWheel m_intakeWheel;
  private final ColorWheel m_colorWheel;

  private final Climber m_climber;
  private final ClimberArmUp m_climberArmUp;
  private final ClimberArmDown m_climberArmDown;
  private final ClimberWinchDown m_climberWinchDown;
  private final ClimberWinchUp m_climberWinchUp;
  private final Intake m_intake;
  private final IntakeLower m_intakeLower;
  private final IntakeRaise m_intakeRaise;
  private final Compressor m_compressor;
  private final IntakeShootOut m_intakeShootOut;
  private final IntakePullIn m_intakePullIn;
  private final ColorWheelLeft m_colorLeft;
  private final ColorWheelRight m_colorRight;
  private final ColorWheelLower m_colorRetract;
  private final ColorWheelRaise m_colorExtend;
   
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    driverPort = 0;
    manipulatorPort = 1;
    configureButtonBindings();
    m_drivetrain = new DriveTrain();
    m_drivearcade = new DriveArcade(m_drivetrain, driverController, manipulatorController);
    m_intake = new Intake();
    m_intakeRaise = new IntakeRaise(m_intake);
    m_intakeLower = new IntakeLower(m_intake);
    m_compressor = new Compressor(Constants.PNEUMATICS_MODULE);
    m_compressor.setClosedLoopControl(true);
    m_intakeShootOut = new IntakeShootOut(m_intake,driverController);
    m_intakePullIn = new IntakePullIn(m_intake,driverController);
    m_intakeWheel = new IntakeWheel();

    m_colorWheel = new ColorWheel();
    m_colorLeft = new ColorWheelLeft(m_colorWheel,manipulatorController);
    m_colorRight = new ColorWheelRight(m_colorWheel,manipulatorController);
    m_colorExtend = new ColorWheelRaise(m_colorWheel);
    m_colorRetract = new ColorWheelLower(m_colorWheel);

    m_climber = new Climber();
    m_climberArmUp = new ClimberArmUp(m_climber, driverController); 
    m_climberArmDown = new ClimberArmDown(m_climber,driverController); 
    m_climberWinchUp = new ClimberWinchUp(m_climber, driverController); 
    m_climberWinchDown = new ClimberWinchDown(m_climber,driverController); 
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driverController = new Joystick(driverPort);
    manipulatorController = new Joystick(manipulatorPort);
  }

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
  public Command getColorLeft(){
    return m_colorLeft;
  }
  public Command getColorRight(){
    return m_colorRight;
  }
  public Command getColorExtend(){
    return m_colorExtend;
  }
  public Command getColorRetract(){
    return m_colorRetract;
  }
}