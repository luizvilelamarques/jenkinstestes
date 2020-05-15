def content
def gitScm
def buildObj
def testObj
def sonar
def dockerBranch
def dockerLatest
def deployOkd

def instancia(branch, _groovyBase){

     sh "wget ${_groovyBase}/ParseJson"
     sh "wget ${_groovyBase}/Build"
     sh "wget ${_groovyBase}/Git"
     sh "wget ${_groovyBase}/Test"
     sh "wget ${_groovyBase}/Sonar"
     sh "wget ${_groovyBase}/DockerBuild"
     sh "wget ${_groovyBase}/DeployOkd"
                    
     codeParseJson = load 'ParseJson'
     codeGit       = load 'Git'
     codeBuild     = load 'Build'
     codeTest      = load 'Test'
     codeSonar     = load 'Sonar'
     codeDocker    = load 'DockerBuild'
     codeDeployOkd = load 'DeployOkd'
                    
     parseJson  = codeParseJson.instancia("https://raw.githubusercontent.com/luizvilelamarques/jenkinstestes/master/JenkinsConfig.json")
     content = parseJson.parse()

     gitScm     = codeGit.instancia(content.git, "develop")
     buildObj   = codeBuild.instancia(content.build, _groovyBase)
     testObj    = codeTest.instancia(content.build)
     sonar      = codeSonar.instancia(content.build, content.codeAnalise.sonar)

     dockerBranch = codeDocker.instancia(
    		    content.docker, 
    		    content.build.dockerImage, 
    		    false, 
    		    branch)

     dockerLatest = codeDocker.instancia(
	    	    content.docker, 
	            content.build.dockerImage, 
	            true, 
	            null)

     deployOkd    = codeDeployOkd.instancia(content.okd)
     
     return this
}

return this
