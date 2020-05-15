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
    POM_VERSION = sh script: "mvn -f ${pom} help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true

    withSonarQubeEnv('SonarQube TJMG'){ 
        sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=${projectKey} -Dsonar.projectVersion=${POM_VERSION} -Dsonar.java.source=1.8 -Dsonar.sources=${sources} -Dsonar.java.binaries=**/target -Dsonar.sourceEncoding=ISO-8859-1"
    }
}

return this
