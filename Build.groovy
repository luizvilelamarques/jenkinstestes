def buildRef

def instancia(buildInfo, groovyBase){
     if (buildInfo.tipoProjeto == 'maven'){
         buildRef = dynamicLoad(groovyBase + "/", "BuildMaven.groovy").instancia(buildInfo)
     }else if (buildInfo.tipoProjeto == 'node'){ 
         buildRef = dynamicLoad(groovyBase + "/", "BuildNode.groovy").instancia(buildInfo)
     }
     return this
}

def build(){
    buildRef.build()     
}

def dynamicLoad(groovyBase, scriptName){
     sh "wget ${groovyBase}${scriptName}"
     code = load "${scriptName}"
     return code
}

return this
