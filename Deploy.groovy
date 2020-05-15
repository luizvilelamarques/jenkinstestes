def deployRef

def instancia(deployInfoParam, groovyBase){
    deployInfo = deployInfoParam
    if (deployInfoParam.okd!=null) {
      deployRef = dynamicLoad(groovyBase + "/", "DeployOKD.groovy").instancia(deployInfoParam.okd)
    }
    return this
}

def deploy(){
    deployRef.deploy()     
}

def dynamicLoad(groovyBase, scriptName){
     sh "wget ${groovyBase}${scriptName}"
     code = load "${scriptName}"
     return code
}

return this
