def testRef

def instancia(buildInfo, groovyBase){
     if (buildInfo.tipoProjeto == 'maven'){
         testRef = dynamicLoad(groovyBase + "/", "TestMaven.groovy").instancia(buildInfo)
     }else if (buildInfo.tipoProjeto == 'node'){ 
         testRef = dynamicLoad(groovyBase + "/", "TestNode.groovy").instancia(buildInfo)
     }
     return this
}

def test(){
     testRef.test()
}

def dynamicLoad(groovyBase, scriptName){
     sh "wget ${groovyBase}${scriptName}"
     code = load "${scriptName}"
     return code
}

return this
