import Bearing.Bearing

import scala.annotation.tailrec

object Bearing extends Enumeration {
  type Bearing = Value
  val North, South, East, West = Value
}

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {
  def turnLeft = bearing match {
    case Bearing.North => Robot(Bearing.West, coordinates)
    case Bearing.West => Robot(Bearing.South, coordinates)
    case Bearing.South => Robot(Bearing.East, coordinates)
    case Bearing.East => Robot(Bearing.North, coordinates)
  }

  def turnRight = bearing match {
    case Bearing.North => Robot(Bearing.East, coordinates)
    case Bearing.East => Robot(Bearing.South, coordinates)
    case Bearing.South => Robot(Bearing.West, coordinates)
    case Bearing.West => Robot(Bearing.North, coordinates)
  }

  def advance = bearing match {
    case Bearing.North => Robot(Bearing.North, coordinates.copy(_2 = coordinates._2 + 1))
    case Bearing.East => Robot(Bearing.East, coordinates.copy(_1 = coordinates._1 + 1))
    case Bearing.South => Robot(Bearing.South, coordinates.copy(_2 = coordinates._2 - 1))
    case Bearing.West => Robot(Bearing.West, coordinates.copy(_1 = coordinates._1 - 1))
  }

  def simulate(instructions: String): Robot = {
    @tailrec
    def _simulate(i: Int, instructions: String, robot: Robot): Robot = {
      if (i == instructions.length) robot
      else {
        instructions(i) match {
          case 'L' => _simulate(i + 1, instructions, robot.turnLeft)
          case 'R' => _simulate(i + 1, instructions, robot.turnRight)
          case 'A' => _simulate(i + 1, instructions, robot.advance)
          case _   => _simulate(i + 1, instructions, robot)
        }
      }
    }

    _simulate(0, instructions, this)
  }
}
