/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
// constants is the new RobotMap, meaning that ID numbers,solenoids, and button numbers go here.
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int DRIVER_CONTROLLER = 0;
    public static final int MANIPULATOR_CONTROLLER=0;

    //~~~~~~~~MOTOR CONTROLLER ID NUMBERS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //drive controller can address
    public static final int DRIVETRAIN_LEFT_FRONT_SPARK = 20;
    public static final int DRIVETRAIN_RIGHT_FRONT_SPARK = 15;
    public static final int DRIVETRAIN_LEFT_BACK_SPARK = 1;
    public static final int DRIVETRAIN_RIGHT_BACK_SPARK = 14;
    public static final int PDP_ID_NUMBER = 0;
    //climber talon constants
    public static final int CLIMBER_ARM_TALON = 8;
    public static final int CLIMBER_WINCH_TALON = 13;
    //Intake Motor
    public static final int INTAKE_MOTOR = 10;
    //Shooter Motors
    public static final int SHOOTER_LEFT_MOTOR = 4;
    public static final int SHOOTER_RIGHT_MOTOR = 5;
    //~~~~~~~~~~~~~~~~~~~CONTROLLER BUTTONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //intake controller controls
   // public static final int MANIPULATOR_CONTROLLER_INTAKE_IN = 3;
   // public static final int MANIPULATOR_CONTROLLER_INTAKE_OUT = 4;
    //x-box controller buttons
    public static final int DRIVER_CONTROLLER_LEFT_MOVE_AXIS = 1; //left joystick up down
    public static final int DRIVER_CONTROLLER_LEFT_ROTATE_AXIS = 0; //left joysick left right
    public static final int DRIVER_CONTROLLER_RIGHT_MOVE_AXIS = 5; //right joystick up down
    public static final int DRIVER_CONTROLLER_RIGHT_ROTATE_AXIS = 4; //right joysick left right

    public static final int DRIVER_CONTROLLER_CLIMBER_WINCH_DOWN = 1; // A button
    public static final int DRIVER_CONTROLLER_CLIMBER_ARM_UP = 4;//Y button
    public static final int DRIVER_CONTROLLER_CLIMBER_WINCH_UP = 3; //X button
    public static final int DRIVER_CONTROLLER_CLIMBER_ARM_DOWN = 2; //B button

    public static final int DRIVER_CONTROLLER_INTAKE_IN = 3;//X button
    public static final int DRIVER_CONTROLLER_INTAKE_OUT = 2;//B button

    public static final int DRIVER_CONTROLLER_INTAKE_SHOOT_OUT = 5;//Left Bumper
    public static final int DRIVER_CONTROLLER_INTAKE_PULL_IN = 6;// right bumper

    public static final int DRIVER_CONTROLLER_WHEEL_EXTEND = 9;//left under-button
    public static final int DRIVER_CONTROLLER_WHEEL_RETRACT = 10;//right under-button

    public static final int MANIPULATOR_CONTROLLER_WHEEL_ROTATE_LEFT = 2;//left trigger
    public static final int MANIPULATOR_CONTROLLER_WHEEL_ROTATE_RIGHT = 3;//right trigger
    //public static final int MANIPULATOR_CONTROLLER_LOWSHOTAIM = 1;
    //public static final int MANIPULATOR_CONTROLLER_HIGHSHOTAIM = 2;
    public static final int MANIPULATOR_CONTROLLER_COLORWHEEL_EXTEND = 5;//left bumper
    public static final int MANIPULATOR_CONTROLLER_COLORWHEEL_RETRACT = 6;//right bumber
    //public static final int MANIPULATOR_CONTROLLER_HIGHSHOTSHOOT = ;
    //public static final int MANIPULATOR_CONTROLLER_LOWSHOTSHOOT = ;

    //~~~~~~~~~~~~~~~~~~~~~~~~Solenoids!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static final int PNEUMATICS_MODULE = 21;
    public static final int INTAKE_SOLENOID_FORWARDS = 0;
    public static final int INTAKE_SOLENOID_BACKWARDS = 1;

    public static final int COLORWHEEL_SOLENOID_FORWARDS = 2;
    public static final int COLORWHEEL_SOLENOID_BACKWARDS = 3;

     //~~~~~~~~~~~~~~~~~~~~~~~~ColorWheel!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static final int COLORWHEEL_MOTOR = 7;
    

}