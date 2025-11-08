// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.DoubleSupplier;

import com.revrobotics.RelativeEncoder; //imports from the REV vendor library 
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants; //imports from other files

//subsystems execute commands and default commands (from subsystem base)
//SubsystemBase is a class and has things that subsystems do built into it 
//you inherit from the SubsystemBase using extends so that MotorSubsystem can use functions from the SubsystemBase 
//defines the class
public class MotorSubsystem extends SubsystemBase { 

  /**subsystems are a collection of robot hardware that work together.
   Subsystems encapsulate the hardware. Subsystems restrict access to the stuff in it and lets you control/define
   the inputs and soley use those to control the subsystem. Subsystems organize the code. */

  private final SparkMax motor1 = new SparkMax(MotorConstants.MOTOR_1_ID, MotorType.kBrushless); 

  /*private= contains things    *if it was public you could access it from RobotContainer.java and mess things up
   * final= this cue word means you can't change it 
   */
 
  public RelativeEncoder encoder = motor1.getEncoder(); //controls inputs. RelativeEncoders get relative distance. 
  public MotorSubsystem() {}
  public Command RunMotors(DoubleSupplier speed){

    /*Commands get executed multiple times. DoubleSupplier= passes a function
    that returns a double.It gets the position of the joystick.
    If it was just a double it would not be able to update based on the position of the joystick
    public= accessable outside of the subsystem and can be used elsewhere */
    
    /** you can find the motorSpeedMultiplier constant under the class MotorConstants in the Constants.java file. */

    return runOnce(
      () -> { //() -> a function that returns a double
        motor1.set(speed.getAsDouble() * MotorConstants.motorSpeedMultiplier); 
      }
      );}
  public Command StopMotors(){
    return runOnce(
      () -> {
        motor1.set(0);
      }
    );
    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
