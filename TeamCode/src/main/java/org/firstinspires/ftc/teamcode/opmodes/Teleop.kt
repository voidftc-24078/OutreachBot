package org.firstinspires.ftc.teamcode.opmodes

import org.firstinspires.ftc.teamcode.DriveCommand
import org.firstinspires.ftc.teamcode.OpModeBase

class Teleop: OpModeBase() {
    override fun initialize() {
        commandScheduler.schedule(DriveCommand(driver, robot.drive))
    }

    override fun cycle() {
    }
}