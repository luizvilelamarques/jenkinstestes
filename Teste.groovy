
class Teste {
  def variavel = 0

  public void example1() {
    variavel = variavel + 1
  }

  public Integer example2() {
   return variavel
  }
  
  public String example3() {
   return "olá"
  }
}

def instanceTest(){
   return new  Teste()
}

return this
