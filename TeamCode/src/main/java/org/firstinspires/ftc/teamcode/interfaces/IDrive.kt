package org.firstinspires.ftc.teamcode.interfaces

import org.firstinspires.ftc.teamcode.math.Vector2D

interface IDrive {
    fun drive(movement: Vector2D, turnSpeed: Double)

    fun driveFieldRelative(movement: Vector2D, turnSpeed: Double, angle: Double) {
        val fieldRelative = movement.rotate(angle)

        drive(fieldRelative, turnSpeed)
    }
}
