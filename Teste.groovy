
class Teste {
  def _variavel = 0

  public void example1() {
    _variavel = _variavel + 1
  }

  public String example2() {
   return _variavel
  }
}

def instanceTest(){
   return new  Teste()
}

return this
