
class Teste {
  def variavel = 0

  def example1() {
    variavel = variavel + 1
  }

  def example2() {
   return variavel
  }
  
  def example3() {
   return "olá mundo"
  }
  
  def example4() {
   return "sh echo luizzzz".execute().in.text
  }
}

def instanceTest(){
   return new  Teste()
}

return this
