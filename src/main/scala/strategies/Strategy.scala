package strategies

sealed trait Strategy {
  def strategy(): Boolean
}

abstract class StrategyImpl extends Strategy {
  def strategy(): Boolean
}