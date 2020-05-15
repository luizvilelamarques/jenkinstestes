def testRef

def instancia(buildInfo, groovyBase){
      if ("maven" == buildInfo.tipoProjeto){
         testRef = dynamicLoad(groovyBase + "/", "TestMaven.groovy").instancia(buildInfo)
     }else if ("node" == buildInfo.tipoProjeto){ 
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
