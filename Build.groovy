def build

def instancia(buildInfo, groovyBase){
     if (buildInfo.tipoProjeto == 'maven'){
         build = dynamicLoad(groovyBase, 'BuildMaven.groovy').instancia(buildInfo)
     }else if (buildInfo.tipoProjeto == 'node'){ 
          build = dynamicLoad(groovyBase, 'BuildNode.groovy').instancia(buildInfo)
     }
     return this
}

def dynamicLoad(groovyBase, scriptName){
     sh "wget ${_groovyBase}/" + scriptName
     return load  scriptName
}

return this
