import groovy.json.*

class ParseJson{
   
   def urlTxt
   
   @NonCPS
   def parse(){
      println '[DEBUG] Lendo arquivo json'
      return new JsonSlurperClassic().parse(urlTxt.toURL())
   }
}

def instancia(url){
   return new ParseJson(urlTxt: url)
}

return this
