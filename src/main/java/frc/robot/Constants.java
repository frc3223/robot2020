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
    //drive controller can address
    public static final int DRIVETRAIN_LEFT_FRONT_SPARK = 15;
    public static final int DRIVETRAIN_RIGHT_FRONT_SPARK = 16;
    public static final int DRIVETRAIN_LEFT_BACK_SPARK = 13;
    public static final int DRIVETRAIN_RIGHT_BACK_SPARK = 14;
    
    //intake controller controls
    public static final int MANIPULATOR_CONTROLLER_INTAKE_IN = 3;
    public static final int MANIPULATOR_CONTROLLER_INTAKE_OUT = 4;
    public static final int MANIPULATOR_CONTROLLER_INTAKE_CONTROLLER = 5;
    //x-box controller buttons
    public static final int DRIVER_CONTROLLER_LEFT_MOVE_AXIS = 1; //left joystick up down
    public static final int DRIVER_CONTROLLER_LEFT_ROTATE_AXIS = 0; //left joysick left right
    public static final int DRIVER_CONTROLLER_RIGHT_MOVE_AXIS = 5; //right joystick up down
    public static final int DRIVER_CONTROLLER_RIGHT_ROTATE_AXIS = 4; //right joysick left right

    public static final int MANIPULATOR_CONTROLLER_LOWSHOTAIM = 1;
    public static final int MANIPULATOR_CONTROLLER_HIGHSHOTAIM = 2;
    //public static final int MANIPULATOR_CONTROLLER_HIGHSHOTSHOOT = ;
    //public static final int MANIPULATOR_CONTROLLER_LOWSHOTSHOOT = ;


    //Solenoids!!!
    public static final int INTAKE_SOLENOID = 1;
}   