def test

def instancia(buildInfo, groovyBase){
     if (buildInfo.tipoProjeto == 'maven'){
         test = factory(groovyBase, 'TestMaven.groovy').instancia(buildInfo)
     }else if (buildInfo.tipoProjeto == 'node'){ 
         test = factory(groovyBase, 'TestNode.groovy').instancia(buildInfo)
     }
     return this
}

def factory(groovyBase, scriptName){
     sh "wget ${_groovyBase}/${scriptName}"
     return load scriptName
}

return this
