package strategies

import utility.calculateEmpty

sealed trait Strategy {
  def resolutionMethod()

  def strategy(): Boolean = {
    val elemEmptyInit = calculateEmpty()

    resolutionMethod()

    val elemEmptyEnd = calculateEmpty()
    (elemEmptyEnd - elemEmptyInit) > 0
  }
}

abstract class StrategyImpl extends Strategy {
  def resolutionMethod(): Unit
}