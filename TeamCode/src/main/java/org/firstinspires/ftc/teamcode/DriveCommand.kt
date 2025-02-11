package org.firstinspires.ftc.teamcode

import com.arcrobotics.ftclib.command.CommandBase
import com.arcrobotics.ftclib.gamepad.GamepadEx
import org.firstinspires.ftc.teamcode.math.Vector2D
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive

class DriveCommand(val gamepad: GamepadEx, val drive: MecanumDrive): CommandBase() {
    override fun execute() {
        val vector = Vector2D(gamepad.leftY, gamepad.leftX)
        val turn = gamepad.rightX

        drive.drive(vector, turn)
    }
}