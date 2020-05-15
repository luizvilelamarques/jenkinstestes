def _build

def instancia(buildInfo, groovyBase){
     if (buildInfo.tipoProjeto == 'maven'){
         _build = dynamicLoad(groovyBase + "/", "BuildMaven.groovy").instancia(buildInfo)
     }else if (buildInfo.tipoProjeto == 'node'){ 
         _build = dynamicLoad(groovyBase + "/", "BuildNode.groovy").instancia(buildInfo)
     }
     return this
}

def build(){
    _build.build()     
}

def dynamicLoad(groovyBase, scriptName){
     sh "wget ${groovyBase}${scriptName}"
     code = load "${scriptName}"
     return code
}

return this
