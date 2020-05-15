def build

def instancia(buildInfo, groovyBase){
     if (buildInfo.tipoProjeto == 'maven'){
         build = factory(groovyBase, 'BuildMaven.groovy').instancia(buildInfo)
     }else if (buildInfo.tipoProjeto == 'node'){ 
          build = factory(groovyBase, 'BuildNode.groovy').instancia(buildInfo)
     }
     return this
}

def factory(groovyBase, scriptName){
     sh "wget ${_groovyBase}/${scriptName}"
     return load scriptName
}

return this
