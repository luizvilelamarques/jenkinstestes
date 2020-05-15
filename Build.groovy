def build

def instancia(buildInfo, groovyBase){
     if (buildInfo.tipoProjeto == 'maven'){
         build = factory('BuildMaven.groovy').instancia(buildInfo)
     }else if (buildInfo.tipoProjeto == 'node'){ 
          build = factory('BuildNode.groovy').instancia(buildInfo)
     }
     return this
}

def factory(scriptName){
     sh "wget ${_groovyBase}/${scriptName}"
     return load "${scriptName}"
}

return this
