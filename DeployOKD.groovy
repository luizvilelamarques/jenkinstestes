def clusterName
def serviceName
def deploymentConfig
def rolout

def instancia(deployInfo){
    clusterName = deployInfo.clusterName
    serviceName = deployInfo.service.name
    rolout      = deployInfo.deploymentConfig.rolout 
    deploymentConfig = deployInfo.service.name + '-srv'
    return this
}

def deploy() {
    if (rolout){
        _rolout()
    }else{
        _apply()
    }
}

def _apply() {
    withEnv(["PATH+OC=${tool 'oc_client'}"]) {
        openshift.withCluster(clusterName) {
             openshift.withProject(serviceName) {
                def templateSelector = openshift.selector( "template", "openshift-test-template")
                if (!templateSelector.exists()) {
                    openshift.create(readFile('template-openshift.json'))
                } else {
                    openshift.apply(readFile('template-openshift.json'))
                }
             }
        }
    }
}

def _rolout() {
    withEnv(["PATH+OC=${tool 'oc_client'}"]) {
        openshift.withCluster(clusterName) {
             openshift.withProject(serviceName) {
                openshift.selector("dc", deploymentConfig).rollout().latest()    
             }
        }
    }
}

return this
