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
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.IntakeWheel;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.IntakeLower;
import frc.robot.commands.IntakeRaise;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ClimberUp;
import frc.robot.commands.IntakeWheelIn;
import frc.robot.commands.IntakeWheelOut;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.Joystick;

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

  private final Climber m_climber;
  private final ClimberUp m_climberUp;
  private final ClimberDown m_climberDown;
  private final Intake m_intake;
  private final IntakeLower m_intakeLower;
  private final IntakeRaise m_intakeRaise;
  private final Compressor m_compressor;
  private final IntakeWheelIn m_intakeForward;
  private final IntakeWheelOut m_intakeBackward;
   
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
    m_intakeForward = new IntakeWheelIn(m_intake,driverController);
    m_intakeBackward = new IntakeWheelOut(m_intake,driverController);
    m_intakeWheel = new IntakeWheel();

    m_climber = new Climber();
    m_climberUp = new ClimberUp(m_climber, driverController); 
    m_climberDown = new ClimberDown(m_climber,driverController); 
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
  public Command getClimbUp(){
    return m_climberUp;
  }
  public Command getClimbDown(){
    return m_climberDown;
  }
  public Command getIntakeForward(){
    return m_intakeForward;
  }
  public Command getIntakeBackward(){
    return m_intakeBackward;
  }
}