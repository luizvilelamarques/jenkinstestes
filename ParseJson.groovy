import groovy.json.*

def urlTxt
   
@NonCPS
def parse(){
   println '[DEBUG] Lendo arquivo json'
   //return new JsonSlurperClassic().parse(urlTxt.toURL())
   return new JsonSlurper().parse(urlTxt.toURL())
   
}

def instancia(url){
   urlTxt = url
   return this
}

return this
