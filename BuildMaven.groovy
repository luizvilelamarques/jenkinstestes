def pacote

def instancia(buildInfo){
     pacote = buildInfo.package
     return this
}

def build(){
    sh " mvn clean install -f ${pacote}"
}

return this
