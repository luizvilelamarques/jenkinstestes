def content
def gitScm

def instancia(branch){
     _groovyBase   = 'https://raw.githubusercontent.com/luizvilelamarques/jenkinstestes/master/'
     sh "wget ${_groovyBase}/ParseJson"
     sh "wget ${_groovyBase}/Git"
                    
     codeParseJson = load 'ParseJson'
     codeGit       = load 'Git'
                    
     parseJson  = codeParseJson.instancia("https://raw.githubusercontent.com/luizvilelamarques/jenkinstestes/master/JenkinsConfig.json")
		 content = parseJson.parse()
			        
     gitScm     = codeGit.instancia(content.git, "develop")
     
     return this
}

return this
