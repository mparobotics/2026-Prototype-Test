// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import java.util.function.DoubleSupplier;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//classes can't run commands but inheriting from the subsystem base allows it to run commands
public class MotorSubsystem extends SubsystemBase { 
  private final SparkMax motor1 = new SparkMax(1, MotorType.kBrushless); 

  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {}

  public Command RunMotors(DoubleSupplier speed){
    return runOnce(
      () -> {
        motor1.set(MathUtil.applyDeadband(speed.getAsDouble(), 0.05) * 0.5);
      }

    );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
