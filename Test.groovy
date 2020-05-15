def _test

def instancia(buildInfo, groovyBase){
     if (buildInfo.tipoProjeto == 'maven'){
         _test = dynamicLoad(groovyBase + "/", "TestMaven.groovy").instancia(buildInfo)
     }else if (buildInfo.tipoProjeto == 'node'){ 
         _test = dynamicLoad(groovyBase + "/", "TestNode.groovy").instancia(buildInfo)
     }
     return this
}

def test(){
     _test.test()
}

def dynamicLoad(groovyBase, scriptName){
     sh "wget ${groovyBase}${scriptName}"
     code = load "${scriptName}"
     return code
}

return this
