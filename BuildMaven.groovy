def pacote

def instancia(buildInfo){
     pacote = buildInfo.package
     return this
}

def build(){
     evaluate(_jenkinsCommandBuild())
}

/**
 * Comando a ser executado pelo jenkins
 */
def _jenkinsCommandBuild() {
	return  "withEnv( [\"PATH+MAVEN=${tool 'Maven 3.6.3'}/bin\"] ) { sh \" mvn clean install -f ${pacote}\"}"
     //def mvn_version = 'Maven 3.6.3'
     //withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) {
     //   sh " mvn clean install -f ${pacote}"
     //}
}

return this
