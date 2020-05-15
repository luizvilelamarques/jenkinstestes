def buildRef

def instancia(buildInfo, groovyBase){
     if ("maven" == buildInfo.tipoProjeto){
         buildRef = dynamicLoad(groovyBase + "/", "BuildMaven.groovy").instancia(buildInfo)
     }else if ("node" == buildInfo.tipoProjeto){ 
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
