def pom
def projectKey
def sources

def instancia(buildInfo, sonarInfo){
    pom = buildInfo.package
    projectKey = sonarInfo.projectKey
    sources= sonarInfo.sources
    return this
}

def analise(){
    scannerHome = tool 'Sonar TJMG'
    
    def pom_version
    def mvn_version = 'Maven 3.6.3'
    withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) {
        pom_version = sh script: "mvn -f ${pom} help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true
    }

    withSonarQubeEnv('SonarQube TJMG'){ 
        sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=${projectKey} -Dsonar.projectVersion=${pom_version} -Dsonar.java.source=1.8 -Dsonar.sources=${sources} -Dsonar.java.binaries=**/target -Dsonar.sourceEncoding=ISO-8859-1"
    }
}

return this
