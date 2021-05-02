package app

trait Translator[TIn, TOut] {
  def apply(input: TIn): TOut
}
