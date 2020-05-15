def pacote

def instancia(buildInfo){
     pacote = buildInfo.package
     return this
}

def build(){
     def mvn_version = 'Maven 3.6.3'
     withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) {
          sh " mvn clean install -f ${pacote}"
     }
}

return this
