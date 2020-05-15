def content
def gitScm
def buildObj
def testObj
def sonar
def dockerBranch
def dockerLatest
def deployObj

def instancia(branch, _groovyBase){

     sh "wget ${_groovyBase}/ParseJson.groovy"	
     sh "wget ${_groovyBase}/Build.groovy"
     sh "wget ${_groovyBase}/Git.groovy"
     sh "wget ${_groovyBase}/Test.groovy"
     sh "wget ${_groovyBase}/Sonar.groovy"
     sh "wget ${_groovyBase}/DockerBuild.groovy"
     sh "wget ${_groovyBase}/Deploy.groovy"
            
     codeParseJson = load 'ParseJson.groovy'
     codeGit       = load 'Git.groovy'
     codeBuild     = load 'Build.groovy'
     codeTest      = load 'Test.groovy'
     codeSonar     = load 'Sonar.groovy'
     codeDocker    = load 'DockerBuild.groovy'
     codeDeploy    = load 'Deploy.groovy'

     parseJson  = codeParseJson.instancia("https://raw.githubusercontent.com/luizvilelamarques/jenkinstestes/master/JenkinsConfig.json")
     content    = parseJson.parse()

     gitScm     = codeGit.instancia(content.git, branch)
     buildObj   = codeBuild.instancia(content.build, _groovyBase)
     testObj    = codeTest.instancia(content.build, _groovyBase)
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

     deployObj    = codeDeploy.instancia(content.deploy, _groovyBase)
     
     return this
}

return this
