// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
//import frc.robot.commands.Autos;
//import frc.robot.commands.ExampleCommand;
import frc.robot.constants.JoysticksConstants;
import frc.robot.humanIO.CommandPS5Controller;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Shooter m_shooter = new Shooter();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandPS5Controller  m_controller =
    new CommandPS5Controller(JoysticksConstants.driverPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }


  private void configureBindings() {
    m_controller.square().whileTrue(Commands.run(() -> m_shooter.shoot()));
    m_controller.square().onFalse(Commands.run(() -> m_shooter.stopShooting()));
    m_shooter.getTrigger().onTrue(Commands.run(() -> m_shooter.feed()));
  }
}
