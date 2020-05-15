def test

def instancia(buildInfo, groovyBase){
     if (buildInfo.tipoProjeto == 'maven'){
         test = dynamicLoad(groovyBase + "/", "TestMaven.groovy").instancia(buildInfo)
     }else if (buildInfo.tipoProjeto == 'node'){ 
         test = dynamicLoad(groovyBase + "/", "TestNode.groovy").instancia(buildInfo)
     }
     return this
}

def dynamicLoad(groovyBase, scriptName){
     sh "wget ${groovyBase}${scriptName}"
     code = load "${scriptName}"
     return code
}

return this
