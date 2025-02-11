package org.firstinspires.ftc.teamcode.opmodes

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.DriveCommand
import org.firstinspires.ftc.teamcode.OpModeBase

@TeleOp(name = "Teleop")
class Teleop: OpModeBase() {
    override fun initialize() {
        commandScheduler.schedule(DriveCommand(driver, robot.drive))
    }

    override fun cycle() {
    }
}