package org.firstinspires.ftc.teamcode.subsystems

import com.qualcomm.robotcore.hardware.DcMotorEx
import org.firstinspires.ftc.teamcode.interfaces.IDrive
import org.firstinspires.ftc.teamcode.math.Vector2D
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

class MecanumDrive(
    val frontLeft: DcMotorEx,
    val frontRight: DcMotorEx,
    val backLeft: DcMotorEx,
    val backRight: DcMotorEx
): IDrive {

    override fun drive(movement: Vector2D, turnSpeed: Double) {
        // inverted because I felt like it (TODO: revert)
        val strafePower = movement.y
        val forwardPower = movement.x

        val r = hypot(-strafePower, forwardPower)
        val robotAngle = atan2(forwardPower, -strafePower) + Math.PI / 4

        val flP = r * cos(robotAngle) + turnSpeed
        val frP = r * sin(robotAngle) - turnSpeed
        val brP = r * cos(robotAngle) - turnSpeed
        val blP = r * sin(robotAngle) + turnSpeed

        frontLeft.power = flP
        frontRight.power = frP
        backLeft.power = blP
        backRight.power = brP
    }
}