def pacote

def instancia(buildInfo){
     pacote = buildInfo.package
     return this
}

def build(){
    sh " echo teste maven"
}

return this
